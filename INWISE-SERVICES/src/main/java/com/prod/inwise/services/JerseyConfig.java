package com.prod.inwise.services;

import static com.prod.inwise.util.Constants.REST_BASE_PACKAGE;
import static com.prod.inwise.util.Constants.REST_BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK;
import static com.prod.inwise.util.Constants.REST_BV_SEND_ERROR_IN_RESPONSE;
import static com.prod.inwise.util.Constants.REST_LOGGING;
import static com.prod.inwise.util.Constants.REST_TRACING_TYPE;

import java.util.logging.Logger;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
public class JerseyConfig extends ResourceConfig {  
	
	private static Logger logger = Logger.getLogger(JerseyConfig.class.getName());
    
	/**
	 * Jersey Configurations Details 
	 */
	@SuppressWarnings("deprecation")
	public JerseyConfig() {               
		
		// Enable base packages instead of registering every resource
		// Disable this and register the individual resources to be exposed
		packages(REST_BASE_PACKAGE);
		 
        property(ServerProperties.TRACING, REST_TRACING_TYPE); 
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, REST_BV_SEND_ERROR_IN_RESPONSE); 
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, REST_BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK);
        
        register(new LoggingFilter(logger, REST_LOGGING));
        register(RequestContextFilter.class);
		register(CORSFilter.class);
		
		// Exposes API Resources to Swagger
		// If disabled swagger.json is not accessible
		register(ApiListingResource.class);
		
		// Enables Swagger UI to extract documents
		// If disabled swagger.json is not accessible from Swagger UI
		register(SwaggerSerializers.class);
    }
}