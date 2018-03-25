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
	public void createStore1() {
		
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
	
	@Test
	public void createStore2() {
		
		StoreDTO storeDTO = new StoreDTO();
		storeDTO.setName("STORE-A");
		storeDTO.setAddress("15/1, Indira Nagar, Bangalore");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser("APP-SERVICES");
		storeDTO.setModifiedUser("APP-SERVICES");
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_STORE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore3() {
		
		StoreDTO storeDTO = new StoreDTO();
		storeDTO.setName("STORE-B");
		storeDTO.setAddress("12-1, Abhibullah Road, Chennai");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser("APP-SERVICES");
		storeDTO.setModifiedUser("APP-SERVICES");
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_STORE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore4() {
		
		StoreDTO storeDTO = new StoreDTO();
		storeDTO.setName("STORE-C");
		storeDTO.setAddress("43, Haddas Road, Chennai");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser("APP-SERVICES");
		storeDTO.setModifiedUser("APP-SERVICES");
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_STORE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore5() {
		
		StoreDTO storeDTO = new StoreDTO();
		storeDTO.setName("STORE-D");
		storeDTO.setAddress("16-3, M G Road, Bangalore");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser("APP-SERVICES");
		storeDTO.setModifiedUser("APP-SERVICES");
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_STORE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore6() {
		
		StoreDTO storeDTO = new StoreDTO();
		storeDTO.setName("STORE-E");
		storeDTO.setAddress("17, Malleshwaram, Bangalore");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser("APP-SERVICES");
		storeDTO.setModifiedUser("APP-SERVICES");
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_STORE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore7() {
		
		StoreDTO storeDTO = new StoreDTO();
		storeDTO.setName("STORE-F");
		storeDTO.setAddress("11, Anna Nagar, Namakkal");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser("APP-SERVICES");
		storeDTO.setModifiedUser("APP-SERVICES");
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_STORE)).then().statusCode(SC_OK);
	}
}