package com.prod.inwise.services;

import java.util.logging.Logger;

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
		
		
		packages("com.prod.inwise.services.resource");
        register(new LoggingFilter(logger, Boolean.TRUE)); 
        property(ServerProperties.TRACING, "ALL"); 
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true); 
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
        register(RequestContextFilter.class);
		register(CORSFilter.class);	
		 
    }	
}