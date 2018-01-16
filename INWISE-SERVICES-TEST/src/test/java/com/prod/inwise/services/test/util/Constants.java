package com.prod.inwise.services.test.util;

import com.google.gson.Gson;

/**
 * @author mohan_kandasamy
 *
 */
public interface Constants {
	
	Gson gson 					= new Gson();

	String BASE_URI				= "http://localhost";
	
	int PORT						= 8080;
	
	String BASE_PATH				= "inwise";
	
	String URL_DELIMITER			= "/";
	
	// Resources
	String RESOURCE_PATH_HEALTH	= "health";
	
	String RESOURCE_PATH_STORE 	= "store";
	
	String RESOURCE_PATH_TAX 	= "tax";
	
	String RESOURCE_PATH_ITEM 	= "item";
	
	/*String RESOURCE_HEALTH 	= "health";
	
	String RESOURCE_HEALTH 	= "health";
	
	String RESOURCE_HEALTH 	= "health";
	
	String RESOURCE_HEALTH 	= "health";
	
	String RESOURCE_HEALTH 	= "health";
	
	String RESOURCE_HEALTH 	= "health";
	
	String RESOURCE_HEALTH 	= "health";
	
	String RESOURCE_HEALTH 	= "health";*/
}