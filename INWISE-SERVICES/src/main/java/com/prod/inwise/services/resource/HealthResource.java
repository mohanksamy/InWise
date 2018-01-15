package com.prod.inwise.services.resource;

import static com.prod.inwise.services.util.Constants.REST_HEALTH_MESSAGE;
import static javax.ws.rs.core.Response.Status.OK;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/health")
@Produces(MediaType.TEXT_PLAIN)
@Api(value = "Application Health Service")
public class HealthResource {
    
	/**
	 * Use : This method is used to check server health
	 */
	@GET
	@ApiOperation(value = "Show Health Status", notes = "Indicates services health status")
	public Response health() {
        return Response.status(OK).entity(REST_HEALTH_MESSAGE).build();
	}
}