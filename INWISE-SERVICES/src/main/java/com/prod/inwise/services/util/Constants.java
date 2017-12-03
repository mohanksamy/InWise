package com.prod.inwise.services.util;

/**
 * Interface holds all the constants used in the application
 * 
 * @author mohan.kandasamy
 *
 */
public interface Constants {

	String REST_BASE_PACKAGE										= "com.prod.inwise.services.resource";
	
	String REST_TRACING_TYPE										= "ALL";
	
	boolean REST_LOGGING											= true;
	
	boolean REST_BV_SEND_ERROR_IN_RESPONSE							= true;
	
	boolean REST_BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK 	= true;
}