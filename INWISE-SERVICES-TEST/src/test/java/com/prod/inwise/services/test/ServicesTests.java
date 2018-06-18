package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.DataUtil.getItem;
import static com.prod.inwise.services.test.DataUtil.getLineItems;
import static com.prod.inwise.services.test.DataUtil.getRandomNumberBetween;
import static com.prod.inwise.services.test.DataUtil.getRandomObjectIndex;
import static com.prod.inwise.services.test.DataUtil.getStockHistories;
import static com.prod.inwise.services.test.DataUtil.getTax;
import static com.prod.inwise.services.test.DataUtil.getTrader;
import static com.prod.inwise.services.test.DataUtil.getVendor;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_INVOICE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STOCK;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STOCK_BATCH;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TAX;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TRADERS;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_VENDOR;
import static com.prod.inwise.services.test.util.Constants.STRING_EMPTY;
import static org.apache.http.HttpStatus.SC_OK;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.LineItemDTO;
import com.prod.inwise.dto.StockDTO;
import com.prod.inwise.dto.StockHistoryDTO;
import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.dto.TraderDTO;
import com.prod.inwise.dto.VendorDTO;

/**
 * Abstract class contains most of the common methods for test classes. 
 * 
 * @author mohan_kandasamy
 *
 */
public abstract class ServicesTests extends AbstractTests {
	
	private static final int invoiceCount = 1;

	protected TraderDTO createTrader() {
		
		TraderDTO trader = getTrader();
		
		// Check the Trader already exists
		if ( getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, trader.getName())).asString().contentEquals(STRING_EMPTY) ) {
			
			// Save Trader
			getRequestSpecificationWithJsonBody(trader).post(getPath(RESOURCE_PATH_TRADERS)).then().statusCode(SC_OK);
		}
	
		// Fetch Trader
		return getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, trader.getName())).andReturn().getBody().as(TraderDTO.class);
	}
	
	protected TaxDTO createTax(BigInteger traderId) {
		
		// Create Tax
		TaxDTO tax = getTax();
		
		// Check the Trader already exists
		if ( !resourceExist(traderId, RESOURCE_PATH_TAX) ) {
						
			// Save Tax
			getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TRADERS, traderId.toString(), RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
		}
		
		// Fetch Tax
		return (TaxDTO) fetcResource(traderId, RESOURCE_PATH_TAX, TaxDTO.class);
	}
	
	protected List<ItemDTO> createItems(BigInteger traderId, TaxDTO tax) {
		
		// Create Item
		List<ItemDTO> items = getItem(tax);
		
		for ( ItemDTO item : items ) {
			
			// Save Item
			item.setId(getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_TRADERS, traderId.toString(), RESOURCE_PATH_ITEM)).andReturn().getBody().as(BigInteger.class));
		}
		
		return items;
	}
	
	protected VendorDTO createVendors(BigInteger traderId) {
		
		VendorDTO vendor = getVendor();
		
		// Create Vendor
		if ( !resourceExist(traderId, RESOURCE_PATH_VENDOR) ) {
			
			getRequestSpecificationWithJsonBody(vendor).post(getPath(RESOURCE_PATH_TRADERS, traderId.toString(), RESOURCE_PATH_VENDOR)).then().statusCode(SC_OK);
		}
		
		return (VendorDTO) fetcResource(traderId, RESOURCE_PATH_VENDOR, VendorDTO.class);
	}
	
	protected void createStockBatches(BigInteger traderId, List<ItemDTO> items, VendorDTO vendor) {
		
		List<StockHistoryDTO> stockHistories = getStockHistories();
		
		// Create Stock
		for ( StockHistoryDTO stockHistory : stockHistories ) {
			
			stockHistory.setItem(items.get(getRandomNumberBetween(0, items.size()-1)));
			
			stockHistory.setVendor(vendor);
		}
		
		getRequestSpecificationWithJsonBody(stockHistories).post(getPath(RESOURCE_PATH_TRADERS, traderId.toString(), RESOURCE_PATH_STOCK_BATCH)).then().statusCode(SC_OK);
	}
	
	protected void createInvoices(BigInteger traderId) {
		
		List<StockDTO> stocks = new ArrayList<>();
		
		fetcResources(traderId, RESOURCE_PATH_STOCK, StockDTO.class, stocks);
		
		for ( int invoiceIndex = 0; invoiceIndex < invoiceCount; invoiceIndex++ ) {
			
			// Create Invoice
			List<LineItemDTO> lineItems = getLineItems();
			
			// Create Invoice
			for ( LineItemDTO lineItem : lineItems ) {
				
				StockDTO stock = stocks.get(getRandomNumberBetween(0, stocks.size()-1));
				
				if ( stock.getQuantity() > 1 ) {
					
					// Use the items in Stock
					lineItem.setItem(stock.getItem());
					
					lineItem.setQuantity(getRandomNumberBetween(1, stock.getQuantity()));
					
					// Reduce the quantity in the stock
					stock.setQuantity(stock.getQuantity() - lineItem.getQuantity());
				}
			}
			
			// Remove any Line Item doesn't have a mapping Item
			List<LineItemDTO> consolidatedLineItems = lineItems.parallelStream().filter( lineItem -> null != lineItem.getItem()).collect(Collectors.toList());
			
			if ( consolidatedLineItems.isEmpty() ) {
				
				System.out.println("No valid line items to create invoice");
			
			} else {
				
				getRequestSpecificationWithJsonBody(consolidatedLineItems).post(getPath(RESOURCE_PATH_TRADERS, traderId.toString(), RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
				
				System.out.println("Invoice created");
			}
		}
	}
	
	private List<String> fetchURIs(String... path) {
		
		return getDefaultRequestSpecification().get(getPath(path)).andReturn().getBody().as(List.class);
	}
	
	private boolean resourceExist(BigInteger traderId, String subresource) {
		
		return (fetchURIs(RESOURCE_PATH_TRADERS, traderId.toString(), subresource).size() > 0);
	}
	
	private Object fetchResource(String resourceURI, Class clazz) {
		
		return getDefaultRequestSpecification().get(resourceURI).andReturn().getBody().as(clazz);
	}
	
	private Object fetcResource(BigInteger traderId, String subresource, Class clazz) {
		
		List<String> links = fetchURIs(RESOURCE_PATH_TRADERS, traderId.toString(), subresource);
		
		return fetchResource(links.get(getRandomObjectIndex(links)), clazz);
	}
	
	private void fetcResources(BigInteger traderId, String subresource, Class clazz, List resources) {
		
		List<String> links = fetchURIs(RESOURCE_PATH_TRADERS, traderId.toString(), subresource);
		
		for ( String link : links ) {
			
			resources.add(fetchResource(link, clazz));
		}
	}
}