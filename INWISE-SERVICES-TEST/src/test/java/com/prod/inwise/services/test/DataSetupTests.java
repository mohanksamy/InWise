package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.DataUtil.getItem;
import static com.prod.inwise.services.test.DataUtil.getLineItems;
import static com.prod.inwise.services.test.DataUtil.getRandomDate;
import static com.prod.inwise.services.test.DataUtil.getRandomNumberBetween;
import static com.prod.inwise.services.test.DataUtil.getStockHistories;
import static com.prod.inwise.services.test.DataUtil.getStore;
import static com.prod.inwise.services.test.DataUtil.getTax;
import static com.prod.inwise.services.test.DataUtil.getVendor;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_INVOICE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STOCK;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STOCK_BATCH;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STORE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TAX;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_VENDOR;
import static com.prod.inwise.services.test.util.Constants.STRING_EMPTY;
import static org.apache.http.HttpStatus.SC_OK;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.LineItemDTO;
import com.prod.inwise.dto.StockDTO;
import com.prod.inwise.dto.StockHistoryDTO;
import com.prod.inwise.dto.StoreDTO;
import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.dto.VendorDTO;

/**
 * @author mohan_kandasamy
 *
 */
public class DataSetupTests extends AbstractTests {
	
	@Test
	public void createStoreTaxItem() {
		
		int storeCount = 1;
		
		for ( int count = 0; count < storeCount; count++ ) {
			
			// Create Store
			StoreDTO store = getStore();
			
			System.out.println(store);
			
			// Check the Store already exists
			if ( getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, store.getName())).asString().contentEquals(STRING_EMPTY) ) {
				
				// Save Store
				getRequestSpecificationWithJsonBody(store).post(getPath(RESOURCE_PATH_STORE)).then().statusCode(SC_OK);
			}
		
			// Fetch Store
			store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, store.getName())).andReturn().getBody().as(StoreDTO.class);

			
			// Create Tax
			TaxDTO tax = getTax(store);
			
			// Check the Store already exists
			if ( getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_STORE, store.getName())).asString().contentEquals(STRING_EMPTY) ) {
							
				// Save Tax
				getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
			}
			
			// Fetch Tax
			tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_STORE, store.getName())).andReturn().getBody().as(TaxDTO.class);
			
			
			// Create Item
			List<ItemDTO> items = getItem(tax);
			
			for ( ItemDTO item : items ) {
				
				// Save Item
				getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
			}
			
			List<ItemDTO> savedItems = new ArrayList<>(items.size());
			
			// Load all created Items
			for ( ItemDTO item : items ) {
				
				item = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_ITEM, item.getName())).andReturn().getBody().as(ItemDTO.class);
				
				savedItems.add(item);
			}
			
			VendorDTO vendor = getVendor();
			
			// Create Vendor
			
			if ( getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_VENDOR, vendor.getName())).asString().contentEquals(STRING_EMPTY) ) {
				
				getRequestSpecificationWithJsonBody(vendor).post(getPath(RESOURCE_PATH_VENDOR)).then().statusCode(SC_OK);
			}
			
			vendor = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_VENDOR, vendor.getName())).andReturn().getBody().as(VendorDTO.class);
			
			List<StockHistoryDTO> stockHistories = getStockHistories();
			
			// Create Stock
			for ( StockHistoryDTO stockHistory : stockHistories ) {
				stockHistory.setItem(savedItems.get(getRandomNumberBetween(0, savedItems.size()-1)));
				stockHistory.setVendor(vendor);
			}
			
			getRequestSpecificationWithJsonBody(stockHistories).post(getPath(RESOURCE_PATH_STOCK_BATCH)).then().statusCode(SC_OK);
			
			// Create Invoice
			List<LineItemDTO> lineItems = getLineItems();
			
			// Create Invoice
			for ( LineItemDTO lineItem : lineItems ) {
				
				StockHistoryDTO stockHistory = stockHistories.get(getRandomNumberBetween(0, stockHistories.size()-1));
				
				if ( stockHistory.getQuantity() > 1 ) {
					
					// Use the items in Stock
					lineItem.setItem(stockHistory.getItem());
					
					lineItem.setQuantity(getRandomNumberBetween(1, stockHistory.getQuantity()));
					
					// Reduce the quantity in the stock
					stockHistory.setQuantity(stockHistory.getQuantity() - lineItem.getQuantity());
				}
			}
			
			// Remove any Line Item doesn't have a mapping Item
			List<LineItemDTO> consolidatedLineItems = lineItems.parallelStream().filter( lineItem -> null != lineItem.getItem()).collect(Collectors.toList());
			
			getRequestSpecificationWithJsonBody(consolidatedLineItems).post(getPath(RESOURCE_PATH_INVOICE, RESOURCE_PATH_STORE, store.getId().toString())).then().statusCode(SC_OK);
		}
	}
	
	@Test
	public void testCreateInvoices() {
		
		StoreDTO store = new StoreDTO();
		store.setId(1001L);
		
		// Fetched items by Store
		@SuppressWarnings("unchecked")
		Map<String, String> itemsMap = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_ITEM, RESOURCE_PATH_STORE, store.getId().toString())).andReturn().getBody().as(Map.class);
		
		List<ItemDTO> savedItems = new ArrayList<>(itemsMap.size());
		
		Iterator<String> iter = itemsMap.keySet().iterator();
		
		// Load all created Items
		while ( iter.hasNext() ) {
			
			savedItems.add(getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_ITEM, "id", iter.next())).andReturn().getBody().as(ItemDTO.class));
		}
		
		for ( int invoiceIndex = 0; invoiceIndex <= getRandomNumberBetween(0, 10); invoiceIndex++ ) {
			
			// Create Invoice
			List<LineItemDTO> lineItems = new ArrayList<>();
			
			// Set Timestamp
			// Disable triggers in INVOICE & LINE_ITEM
			// If not disabled, trigger will play it's role!
			Timestamp timestamp = new Timestamp(getRandomDate(2016).getTime());
			
			// Create Invoice
			for ( LineItemDTO lineItem : getLineItems() ) {
				
				ItemDTO item = savedItems.get(getRandomNumberBetween(0, savedItems.size()-1));
				
				if ( !getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STOCK, RESOURCE_PATH_ITEM, item.getId().toString())).asString().contentEquals(STRING_EMPTY) ) {
				
					StockDTO stock = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STOCK, RESOURCE_PATH_ITEM, item.getId().toString())).andReturn().getBody().as(StockDTO.class);
				
					lineItem.setItem(item);
				
					// Ignore the LineItem if it's out of stock
					if ( 0 == stock.getQuantity() ) {
						continue;
					}
					
					lineItem.setQuantity(getRandomNumberBetween(1, stock.getQuantity()));
					
					lineItem.setCreatedTS(timestamp);
					lineItem.setModifiedTS(timestamp);
					
					lineItems.add(lineItem);
				}
			}
			
			// Create invoices only if LineItems are available
			if ( !lineItems.isEmpty() ) {
				getRequestSpecificationWithJsonBody(lineItems).post(getPath(RESOURCE_PATH_INVOICE, RESOURCE_PATH_STORE, store.getId().toString())).then().statusCode(SC_OK);
			}
		}
	}
}