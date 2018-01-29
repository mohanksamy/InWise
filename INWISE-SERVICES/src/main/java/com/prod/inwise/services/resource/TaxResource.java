package com.prod.inwise.services.resource;

import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.OK;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.Tax;
import com.prod.inwise.services.repo.TaxRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST Resource exposes operation on Tax resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Path("/tax")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Tax Service")
public class TaxResource {

	@Autowired
	private TaxRepository taxRepo;

	@POST
	@ApiOperation(value = "Create tax", notes = "Create tax model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response createTax(Tax tax) {

		taxRepo.save(tax);

		return status(OK).build();
	}

	@GET
	@Path("/store/{name}")
	@ApiOperation(value = "Get tax", notes = "Get tax model")
	public Response getTax(@ApiParam @PathParam("name") String name) {

		return status(OK).entity(taxRepo.findByStoreNameIgnoreCase(name)).build();
	}
}