package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.DataUtil.getItem;
import static com.prod.inwise.services.test.DataUtil.getStockHistories;
import static com.prod.inwise.services.test.DataUtil.getStore;
import static com.prod.inwise.services.test.DataUtil.getTax;
import static com.prod.inwise.services.test.DataUtil.getVendor;
import static com.prod.inwise.services.test.DataUtil.getLineItems;
import static com.prod.inwise.services.test.DataUtil.getRandomNumberBetween;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STOCK_BATCH;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STORE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TAX;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_VENDOR;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_INVOICE;
import static com.prod.inwise.services.test.util.Constants.STRING_EMPTY;
import static org.apache.http.HttpStatus.SC_OK;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.LineItemDTO;
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
				
				ItemDTO item = savedItems.get(getRandomNumberBetween(0, savedItems.size()-1));
				
				System.out.println(item);
				
				lineItem.setItem(item);
			}
			
			getRequestSpecificationWithJsonBody(lineItems).post(getPath(RESOURCE_PATH_INVOICE, RESOURCE_PATH_STORE, store.getId().toString())).then().statusCode(SC_OK);
		}
	}
}