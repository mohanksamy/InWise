package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STORE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TAX;
import static org.apache.http.HttpStatus.SC_OK;

import org.junit.Test;

import com.jayway.restassured.response.ResponseBody;
import com.prod.inwise.dto.StoreDTO;
import com.prod.inwise.dto.TaxDTO;

/**
 * @author mohan_kandasamy
 *
 */
public class TaxTests extends AbstractTests {
	
	private static final String STORE_NAME	= "Vel Stores";

	@Test
	public void createTax() {
		
//		System.out.println("ResponseBody: " + getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().asString());
		
		StoreDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().as(StoreDTO.class);
		
//		System.out.println("Store: " + store);
		
//		StoreDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).body().as(StoreDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(2.5f);
		tax.setSgst(2.5f);
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
}