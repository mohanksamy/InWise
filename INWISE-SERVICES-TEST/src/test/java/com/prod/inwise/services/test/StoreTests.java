package com.prod.inwise.services.test;

import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;

import java.math.BigInteger;

import com.prod.inwise.dto.StoreDTO;

/**
 * @author mohan_kandasamy
 *
 */
public class StoreTests extends AbstractTests {

	private static final String resourcePath 	= "store";
	
	@Test
	public void createStore() {
		
		StoreDTO storeDTO = new StoreDTO();
		storeDTO.setName("Vel Stores");
		storeDTO.setAddress("37, Chickpet, Bangalore");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser("APP-SERVICES");
		storeDTO.setModifiedUser("APP-SERVICES");
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(resourcePath)).then().statusCode(SC_OK);
	}
}