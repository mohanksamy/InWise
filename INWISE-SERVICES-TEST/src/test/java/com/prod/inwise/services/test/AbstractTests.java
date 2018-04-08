package com.prod.inwise.services.test;

import static com.jayway.restassured.RestAssured.given;
import static com.prod.inwise.services.test.util.Constants.BASE_PATH;
import static com.prod.inwise.services.test.util.Constants.BASE_URI;
import static com.prod.inwise.services.test.util.Constants.PORT;
import static com.prod.inwise.services.test.util.Constants.URL_DELIMITER;
import static com.prod.inwise.services.test.util.Constants.gson;

import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * Abstract class contains most of the common methods for test classes. 
 * 
 * @author mohan_kandasamy
 *
 */
public class AbstractTests {

	@BeforeClass
	public static void setUp() {
		
		RestAssured.baseURI 		= BASE_URI;
		RestAssured.port 		= PORT;
		RestAssured.basePath 	= BASE_PATH;
	}
	
	/**
	 * Method creates default request specification
	 * 
	 * @return
	 */
	protected RequestSpecification  getDefaultRequestSpecification() {
		
		return given()
				.contentType(ContentType.JSON)
				.when();
	}
	
	/**
	 * Method creates default request specification with Session Header
	 * 
	 * @return
	 */
	protected RequestSpecification getRequestSpecificationWithSessionHeader() {
		
		return getDefaultRequestSpecification().header("header-key", "header-value");
	}
	
	/**
	 * Method creates default request specification with JSON body
	 * 
	 * @param object
	 * @return
	 */
	protected RequestSpecification  getRequestSpecificationWithJsonBody(Object object) {
		
		return getDefaultRequestSpecification().body(gson.toJson(object));
	}
	
	/**
	 * Method composes the URI path with delimiter
	 * 
	 * @param v1
	 * @return
	 */
	protected String getPath(String... v1) {
		
		StringBuffer pathBuffer = new StringBuffer();
		
		for ( Object obj : v1 ) {
			pathBuffer.append(URL_DELIMITER).append(obj.toString());
		}
		
		return pathBuffer.toString();
	}
}