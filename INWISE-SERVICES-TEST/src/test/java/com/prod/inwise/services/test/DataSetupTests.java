package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.DataUtil.getItem;
import static com.prod.inwise.services.test.DataUtil.getStore;
import static com.prod.inwise.services.test.DataUtil.getTax;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STORE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TAX;
import static com.prod.inwise.services.test.util.Constants.STRING_EMPTY;
import static org.apache.http.HttpStatus.SC_OK;

import java.util.List;

import org.junit.Test;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.StoreDTO;
import com.prod.inwise.dto.TaxDTO;

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
				
				System.out.println(item);
				
				// Save Item
				getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
			}
		}
	}
}