package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STORE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TAX;
import static org.apache.http.HttpStatus.SC_OK;

import org.junit.Test;

import com.prod.inwise.dto.StoreDTO;
import com.prod.inwise.dto.TaxDTO;

/**
 * @author mohan_kandasamy
 *
 */
public class TaxTests extends AbstractTests {
	
	private static String STORE_NAME	= "Vel Stores";

	@Test
	public void createTax1() {
		
		StoreDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().as(StoreDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(2.5f);
		tax.setSgst(2.5f);
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax2() {
		
		STORE_NAME = "STORE-A";
		
		StoreDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().as(StoreDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(1.5f);
		tax.setSgst(4.5f);
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax3() {
		
		STORE_NAME = "STORE-B";
		
		StoreDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().as(StoreDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(3.5f);
		tax.setSgst(4.5f);
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax4() {
		
		STORE_NAME = "STORE-C";
		
		StoreDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().as(StoreDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(3.5f);
		tax.setSgst(1.5f);
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax5() {
		
		STORE_NAME = "STORE-D";
		
		StoreDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().as(StoreDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(2.5f);
		tax.setSgst(3.5f);
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax6() {
		
		STORE_NAME = "STORE-E";
		
		StoreDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().as(StoreDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(2.5f);
		tax.setSgst(3.5f);
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax7() {
		
		STORE_NAME = "STORE-F";
		
		StoreDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().as(StoreDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(2.5f);
		tax.setSgst(2.5f);
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
}