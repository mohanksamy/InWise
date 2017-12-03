package com.prod.inwise.services;

import java.util.logging.Logger;

import static com.prod.inwise.services.util.Constants.REST_TRACING_TYPE;
import static com.prod.inwise.services.util.Constants.REST_LOGGING;
import static com.prod.inwise.services.util.Constants.REST_BASE_PACKAGE;
import static com.prod.inwise.services.util.Constants.REST_BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK;
import static com.prod.inwise.services.util.Constants.REST_BV_SEND_ERROR_IN_RESPONSE;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {  
	
	private static Logger logger = Logger.getLogger(JerseyConfig.class.getName());
    
	/**
	 * Jersey Configurations Details 
	 */
	public JerseyConfig() {               
        
		/*packages(AppConfig.JERSEY_RESOURCES_PACKAGE_PATH);
		register(new LoggingFilter(logger, AppConfig.JERSEY_LOGGING_FILTER)); 
        property(ServerProperties.TRACING, AppConfig.JERSEY_SERVER_PROPERTIES);*/
		
		
		packages(REST_BASE_PACKAGE);
        register(new LoggingFilter(logger, REST_LOGGING)); 
        property(ServerProperties.TRACING, REST_TRACING_TYPE); 
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, REST_BV_SEND_ERROR_IN_RESPONSE); 
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, REST_BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK);
        register(RequestContextFilter.class);
		register(CORSFilter.class);
    }	
}