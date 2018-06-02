package com.prod.inwise.services.util;

/**
 * Interface holds all the constants used in the application
 * 
 * @author mohan.kandasamy
 *
 */
public interface Constants {

	String REST_BASE_PACKAGE											= "com.prod.inwise.services.resource";
	
	String REST_TRACING_TYPE											= "ALL";
	
	boolean REST_LOGGING												= true;
	
	boolean REST_BV_SEND_ERROR_IN_RESPONSE							= true;
	
	boolean REST_BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK 	= true;
	
	public static final String RESOURCE_PATH_TAX 					= "taxes";
	
	public static final String RESOURCE_PATH_CATEGORIES 				= "categories";
	
	public static final String RESOURCE_PATH_SUBCATEGORIES 			= "subcategories";
	
	public static final String RESOURCE_PATH_BRANDS 					= "brands";
	
	public static final String RESOURCE_PATH_MODELS 					= "models";

//	public static final String RESOURCE_PATH_ITEM 					= "items";

//	public static final String RESOURCE_PATH_INVOICE 				= "invoices";

//	public static final String RESOURCE_PATH_LINEITEM 				= "lineItems";

//	public static final String RESOURCE_PATH_STOCK 					= "stocks";

//	public static final String RESOURCE_PATH_STOCK_BATCH				= "stockBatches";

//	public static final String RESOURCE_PATH_STOCK_HISTORY			= "stockHistories";

//	public static final String RESOURCE_PATH_VENDOR					= "vendors";

	
	// RESOURCE URI CONSTANTS
	String REST_HEALTH_MESSAGE 										= "InWise REST Services Up and Running!";
}