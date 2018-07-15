package com.prod.inwise.services.services.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prod.inwise.services.data.Invoice;
import com.prod.inwise.services.data.LineItem;
import com.prod.inwise.services.data.Stock;
import com.prod.inwise.services.data.Trader;
import com.prod.inwise.services.exceptions.OutOfStockException;
import com.prod.inwise.services.exceptions.UnexpectedItemException;
import com.prod.inwise.services.repo.InvoiceRepository;
import com.prod.inwise.services.repo.LineItemRepository;
import com.prod.inwise.services.repo.StockRepository;
import com.prod.inwise.services.services.InvoiceService;

/**
 * @author mohan_kandasamy
 *
 */
@Service
public class InvoiceServiceImpl extends AbstractService implements InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@Autowired
	private LineItemRepository lineItemRepo;
	
	@Autowired
	private StockRepository stockRepo;
	
	@Override
	public void createInvoice(BigInteger traderId, Invoice invoice, List<LineItem> lineItems) throws OutOfStockException, UnexpectedItemException {
		
		// Check all LineItems belong to this Trader
		checkLineItemsBelongsToTrader(traderId, lineItems);
		
		// Merge line items in case same items are repeated in the invoice
		lineItems = mergeLineItems(lineItems);
		
		List<LineItem> outOfStockLineItems = new ArrayList<>(lineItems);
		
		outOfStockLineItems = checkItemsInStock(outOfStockLineItems);
		
		if ( !outOfStockLineItems.isEmpty() ) {
			
			throw new OutOfStockException(outOfStockLineItems);
		}
		
		// Populate LineItem Tax & Price
		populateLineItemTaxAndPrice(lineItems);
		
		// Create & Save Invoice
		Invoice savedInvoice = invoiceRepo.save(populateInvoiceWithTaxAndPrice(traderId, invoice, lineItems));
		
		// Link Invoice to LineItems and Save
		lineItems.forEach( lineItem -> {
			
			lineItem.setInvoice(savedInvoice);
			lineItemRepo.save(lineItem);
			
			// Deduct quantity in Stock
			Stock stock = stockRepo.findByItemId(lineItem.getItem().getId());
			stock.setQuantity(stock.getQuantity() - lineItem.getQuantity());
			stockRepo.save(stock);
		});
	}
	
	private void populateLineItemTaxAndPrice(List<LineItem> lineItems) {
		
		// Populate LineItems with Tax & Price
		lineItems.forEach( lineItem -> {
			lineItem.setTotalPrice(lineItem.getItem().getPrice().multiply(new BigDecimal(lineItem.getQuantity())));
			BigDecimal cgst = lineItem.getItem().getTax().getCgst();
			BigDecimal sgst = lineItem.getItem().getTax().getSgst();
			BigDecimal gst = cgst.add(sgst);
			lineItem.setTotalTax(gst.multiply(new BigDecimal(lineItem.getQuantity())));
		});
	}
	
	private Invoice populateInvoiceWithTaxAndPrice(BigInteger traderId, Invoice invoice, List<LineItem> lineItems) {
		
		Trader trader = new Trader();
		trader.setId(traderId);
		
		invoice.setTrader(trader);
		invoice.setCreatedUser(lineItems.get(0).getCreatedUser());
		invoice.setModifiedUser(lineItems.get(0).getCreatedUser());
		
		invoice.setTotalTax(BigDecimal.valueOf(lineItems.stream().mapToDouble(i -> i.getTotalTax().doubleValue()).sum()));
		
		invoice.setTotalPrice(BigDecimal.valueOf(lineItems.stream().mapToDouble(i -> i.getTotalPrice().doubleValue()).sum()));
		
		// Setting date time for functional cases when date time triggers are disabled
		// These date time will be ignored when triggers are enabled
		invoice.setCreatedTS(lineItems.get(0).getCreatedTS());
		invoice.setModifiedTS(lineItems.get(0).getModifiedTS());
		
		return invoice;
	}
	
	private List<LineItem> checkItemsInStock(List<LineItem> lineItems) {
		
		lineItems.parallelStream().forEach(lineItem -> lineItem.setQuantityInStock(stockRepo.findByItemId(lineItem.getItem().getId()).getQuantity()));
		
		return lineItems.parallelStream().filter( lineItem -> lineItem.getQuantity() > lineItem.getQuantityInStock()).collect(Collectors.toList());
	}
	
	private List<LineItem> mergeLineItems(List<LineItem> lineItems) {
		
		Map<BigInteger, LineItem> lineItemsMap = new HashMap<BigInteger, LineItem>();
		
		for ( LineItem lineItem : lineItems ) {
		
			if ( null == lineItemsMap.get(lineItem.getItem().getId()) ) {
				
				lineItemsMap.put(lineItem.getItem().getId(), lineItem);
			
			} else {
				
				LineItem existingLineItem = lineItemsMap.get(lineItem.getItem().getId());
				
				existingLineItem.setQuantity(existingLineItem.getQuantity() + lineItem.getQuantity());
			}
		}
		
		return new ArrayList<>(lineItemsMap.values());
	}
}