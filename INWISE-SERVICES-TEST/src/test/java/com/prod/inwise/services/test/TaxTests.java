package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TAX;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TRADERS;
import static org.apache.http.HttpStatus.SC_OK;

import java.math.BigDecimal;

import org.junit.Test;

import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.dto.TraderDTO;

/**
 * @author mohan_kandasamy
 *
 */
public class TaxTests extends AbstractTests {
	
	private static String STORE_NAME	= "Vel Stores";

	@Test
	public void createTax1() {
		
		TraderDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TraderDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(new BigDecimal(2.5f));
		tax.setSgst(new BigDecimal(2.5f));
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
//		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax2() {
		
		STORE_NAME = "STORE-A";
		
		TraderDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TraderDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(new BigDecimal(1.5f));
		tax.setSgst(new BigDecimal(4.5f));
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
//		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax3() {
		
		STORE_NAME = "STORE-B";
		
		TraderDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TraderDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(new BigDecimal(3.5f));
		tax.setSgst(new BigDecimal(4.5f));
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
//		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax4() {
		
		STORE_NAME = "STORE-C";
		
		TraderDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TraderDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(new BigDecimal(3.5f));
		tax.setSgst(new BigDecimal(1.5f));
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
//		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax5() {
		
		STORE_NAME = "STORE-D";
		
		TraderDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TraderDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(new BigDecimal(2.5f));
		tax.setSgst(new BigDecimal(3.5f));
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
//		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax6() {
		
		STORE_NAME = "STORE-E";
		
		TraderDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TraderDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(new BigDecimal(2.5f));
		tax.setSgst(new BigDecimal(3.5f));
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
//		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createTax7() {
		
		STORE_NAME = "STORE-F";
		
		TraderDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TraderDTO.class);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(new BigDecimal(2.5f));
		tax.setSgst(new BigDecimal(2.5f));
		tax.setCreatedUser(store.getCreatedUser());
		tax.setModifiedUser(store.getCreatedUser());
//		tax.setStore(store);
		
		getRequestSpecificationWithJsonBody(tax).post(getPath(RESOURCE_PATH_TAX)).then().statusCode(SC_OK);
	}
}