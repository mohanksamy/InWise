package com.prod.inwise.services.resource;

import static com.prod.inwise.services.util.Constants.REST_HEALTH_MESSAGE;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/health")
@Api(value = "Application Health Service")
public class HealthResource {
    
	/**
	 * Use : This method is used to check server health
	 */
	@GET
	@ApiOperation(value = "Show Health Status", notes = "Indicates services health status")
	public String health() {
        return REST_HEALTH_MESSAGE; 
	}
}