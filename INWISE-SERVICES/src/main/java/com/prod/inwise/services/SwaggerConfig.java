package com.prod.inwise.services;

import static com.prod.inwise.services.util.Constants.REST_BASE_PACKAGE;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * Swagger configuration class to customize the documentation page
 * 
 * @author mohan_kandasamy
 *
 */
@Component
public class SwaggerConfig {

    @PostConstruct
    public void configure() {

    		BeanConfig config = new BeanConfig();
		config.setConfigId("InWise Product Documentation");
		config.setTitle("InWise Product Documentation");
		config.setVersion("v1");
		config.setContact("Inwise Contributors");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath("/inwise");
		config.setResourcePackage(REST_BASE_PACKAGE);
		config.setPrettyPrint(true);
		config.setScan(true);
    }
}