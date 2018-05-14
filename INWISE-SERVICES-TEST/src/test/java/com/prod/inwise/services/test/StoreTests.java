package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.APP_USER;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TRADERS;
import static org.apache.http.HttpStatus.SC_OK;

import java.math.BigInteger;

import org.junit.Test;

import com.prod.inwise.dto.TraderDTO;

/**
 * @author mohan_kandasamy
 *
 */
public class StoreTests extends AbstractTests {
	
	@Test
	public void createStore1() {
		
		TraderDTO storeDTO = new TraderDTO();
		storeDTO.setName("Vel Stores");
//		storeDTO.setAddress("37, Chickpet, Bangalore");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser(APP_USER);
		storeDTO.setModifiedUser(APP_USER);
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_TRADERS)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore2() {
		
		TraderDTO storeDTO = new TraderDTO();
		storeDTO.setName("STORE-A");
//		storeDTO.setAddress("15/1, Indira Nagar, Bangalore");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser(APP_USER);
		storeDTO.setModifiedUser(APP_USER);
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_TRADERS)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore3() {
		
		TraderDTO storeDTO = new TraderDTO();
		storeDTO.setName("STORE-B");
//		storeDTO.setAddress("12-1, Abhibullah Road, Chennai");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser(APP_USER);
		storeDTO.setModifiedUser(APP_USER);
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_TRADERS)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore4() {
		
		TraderDTO storeDTO = new TraderDTO();
		storeDTO.setName("STORE-C");
//		storeDTO.setAddress("43, Haddas Road, Chennai");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser(APP_USER);
		storeDTO.setModifiedUser(APP_USER);
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_TRADERS)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore5() {
		
		TraderDTO storeDTO = new TraderDTO();
		storeDTO.setName("STORE-D");
//		storeDTO.setAddress("16-3, M G Road, Bangalore");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser(APP_USER);
		storeDTO.setModifiedUser(APP_USER);
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_TRADERS)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore6() {
		
		TraderDTO storeDTO = new TraderDTO();
		storeDTO.setName("STORE-E");
//		storeDTO.setAddress("17, Malleshwaram, Bangalore");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser(APP_USER);
		storeDTO.setModifiedUser(APP_USER);
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_TRADERS)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createStore7() {
		
		TraderDTO storeDTO = new TraderDTO();
		storeDTO.setName("STORE-F");
//		storeDTO.setAddress("11, Anna Nagar, Namakkal");
		storeDTO.setUin("BLR919448107285");
		storeDTO.setPhone(new  BigInteger("919448107285"));
		
		storeDTO.setActive(true);
		storeDTO.setCreatedUser(APP_USER);
		storeDTO.setModifiedUser(APP_USER);
		
		getRequestSpecificationWithJsonBody(storeDTO).post(getPath(RESOURCE_PATH_TRADERS)).then().statusCode(SC_OK);
	}
}