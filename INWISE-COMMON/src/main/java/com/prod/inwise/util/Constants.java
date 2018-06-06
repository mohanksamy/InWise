package com.prod.inwise.util;

public interface Constants {

	public static final String KEY_CREATEDTS 											= "createdTS";
	
	public static final String KEY_MODIFIEDTS 											= "modifiedTS";
	
	public static final String REST_BASE_PACKAGE											= "com.prod.inwise.services.resource";
	
	public static final String REST_TRACING_TYPE											= "ALL";
	
	public static final boolean REST_LOGGING												= true;
	
	public static final boolean REST_BV_SEND_ERROR_IN_RESPONSE							= true;
	
	public static final boolean REST_BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK	= true;
	
	public static final String RESOURCE_PATH_TAX 										= "taxes";
	
	public static final String RESOURCE_PATH_CATEGORIES 									= "categories";
	
	public static final String RESOURCE_PATH_SUBCATEGORIES 								= "subcategories";
	
	public static final String RESOURCE_PATH_BRANDS 										= "brands";
	
	public static final String RESOURCE_PATH_MODELS 										= "models";

	public static final String RESOURCE_PATH_ITEM 										= "items";

	public static final String RESOURCE_PATH_INVOICE 									= "invoices";

//	public static final String RESOURCE_PATH_LINEITEM 									= "lineItems";

//	public static final String RESOURCE_PATH_STOCK 										= "stocks";

//	public static final String RESOURCE_PATH_STOCK_BATCH									= "stockBatches";

//	public static final String RESOURCE_PATH_STOCK_HISTORY								= "stockHistories";

	public static final String RESOURCE_PATH_VENDOR										= "vendors";
	
	public static final String RESOURCE_PATH_USER										= "users";

	
	// RESOURCE URI CONSTANTS
	public static final String REST_HEALTH_MESSAGE 										= "InWise REST Services Up and Running!";
}