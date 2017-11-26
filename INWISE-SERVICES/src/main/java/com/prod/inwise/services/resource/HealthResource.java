package com.prod.inwise.services.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Component
@Path("/health")
public class HealthResource {
    
	/**
	 * Use : This method is used to check server health
	 */
	@GET
	public String health() {
        return "InWise Services: Up and Running!"; 
	}
}