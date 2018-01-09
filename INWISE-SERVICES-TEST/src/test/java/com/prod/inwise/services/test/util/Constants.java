package com.prod.inwise.services.test.util;

import com.google.gson.Gson;

/**
 * @author mohan_kandasamy
 *
 */
public interface Constants {
	
	Gson gson 				= new Gson();

	String BASE_URI			= "http://localhost";
	
	int PORT					= 8080;
	
	String BASE_PATH			= "inwise";
	
	String URL_DELIMITER		= "/";
}