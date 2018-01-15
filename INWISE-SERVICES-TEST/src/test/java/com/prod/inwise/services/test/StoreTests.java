package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STORE;
import static org.apache.http.HttpStatus.SC_OK;

import java.math.BigInteger;

import org.junit.Test;

import com.prod.inwise.dto.StoreDTO;

/**
 * @author mohan_kandasamy
 *
 */
public class StoreTests extends AbstractTests {

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
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_STORE)).then().statusCode(SC_OK);
	}
}