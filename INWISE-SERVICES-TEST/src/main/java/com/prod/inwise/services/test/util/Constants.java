package com.prod.inwise.services.test.util;

import java.text.NumberFormat;
import java.util.Random;

import com.google.gson.Gson;

/**
 * @author mohan_kandasamy
 *
 */
public interface Constants {

	public static final Gson gson 							= new Gson();

	public static final String BASE_URI 						= "http://localhost";

	public static final int PORT 							= 8080;

	public static final String BASE_PATH 					= "inwise";

	public static final String URL_DELIMITER 				= "/";

	// Resources
	public static final String RESOURCE_PATH_HEALTH 			= "health";

	public static final String RESOURCE_PATH_STORE 			= "store";

	public static final String RESOURCE_PATH_TAX 			= "tax";

	public static final String RESOURCE_PATH_ITEM 			= "item";

	public static final String RESOURCE_PATH_INVOICE 		= "invoice";

	public static final String RESOURCE_PATH_LINEITEM 		= "lineItem";

	public static final String RESOURCE_PATH_STOCK 			= "stock";

	public static final String RESOURCE_PATH_STOCK_BATCH 	= "stockBatch";

	public static final String RESOURCE_PATH_STOCK_HISTORY 	= "stockHistory";

	public static final String RESOURCE_PATH_VENDOR 			= "vendor";
	
	// APP Properties
	public static final String APP_USER						= "APP-SERVICES";
	
	public static final String DATA_DELIMITER				= ",";
	
	public static final String STRING_EMPTY					= "";
	
	public static final String STRING_SPACE					= " ";
	
	public static final String ITEM_SUFFIX					= "item";
	
	public static final Random random 						= new Random();
	
	public static final NumberFormat number 					= NumberFormat.getNumberInstance();
}