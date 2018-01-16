package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STORE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TAX;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static org.apache.http.HttpStatus.SC_OK;

import org.junit.Test;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.TaxDTO;

/**
 * @author mohan_kandasamy
 *
 */
public class ItemTests extends AbstractTests {
	
	private static final String STORE_NAME	= "Vel Stores";

	@Test
	public void createItem() {
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Test Item");
		item.setPrice(213f);
		
		item.setTax(tax);
		item.setStore(tax.getStore());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
}