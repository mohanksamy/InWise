package com.prod.inwise.services.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prod.inwise.services.data.Invoice;
import com.prod.inwise.services.data.LineItem;
import com.prod.inwise.services.data.Store;
import com.prod.inwise.services.repo.InvoiceRepository;
import com.prod.inwise.services.repo.LineItemRepository;
import com.prod.inwise.services.services.InvoiceService;

/**
 * @author mohan_kandasamy
 *
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@Autowired
	private LineItemRepository lineItemRepo;
	
	@Override
	public void createInvoice(Long storeId, List<LineItem> lineItems) {
		
		// Populate LineItem Tax & Price
		populateLineItemTaxAndPrice(lineItems);
		
		// Create & Save Invoice
		Invoice invoice = invoiceRepo.save(populateInvoiceWithTaxAndPrice(storeId, lineItems));
		
		// Link Invoice to LineItems and Save
		lineItems.forEach( lineItem -> {
			lineItem.setInvoice(invoice);
			lineItemRepo.save(lineItem);
		});
	}
	
	private void populateLineItemTaxAndPrice(List<LineItem> lineItems) {
		
		// Populate LineItems with Tax & Price
		lineItems.forEach( lineItem -> {
			lineItem.setTotalPrice(lineItem.getQuantity()*lineItem.getItem().getPrice());
			Float cgst = lineItem.getItem().getTax().getCgst();
			Float sgst = lineItem.getItem().getTax().getSgst();
			Float gst = cgst + sgst;
			lineItem.setTotalTax(gst*lineItem.getQuantity());
		});
	}
	
	private Invoice populateInvoiceWithTaxAndPrice(Long storeId, List<LineItem> lineItems) {
		
		Invoice invoice = new Invoice();
		
		Store store = new Store();
		store.setId(storeId);
		
		invoice.setStore(store);
		invoice.setCreatedUser(lineItems.get(0).getCreatedUser());
		invoice.setModifiedUser(lineItems.get(0).getCreatedUser());
		
		invoice.setTotalTax(Double.valueOf(lineItems.stream().mapToDouble(i -> i.getTotalTax()).sum()).floatValue());
		
		invoice.setTotalPrice(Double.valueOf(lineItems.stream().mapToDouble(i -> i.getTotalPrice()).sum()).floatValue());
		
		return invoice;
	}
}