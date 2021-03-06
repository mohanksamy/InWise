package com.prod.inwise.services.resource;

import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.OK;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.LineItem;
import com.prod.inwise.services.repo.LineItemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST Resource exposes operation on LineItem resource
 * 
 * @author Logu
 *
 */
@Component
@Path("/lineItem")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "LineItem Service")
public class LineItemResource {

	@Autowired
	private LineItemRepository lineItemRepo;

	@POST
	@ApiOperation(value = "Create lineitem", notes = "Create lineitem model")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error")})
	public Response createLineItem(LineItem lineItem) {

		lineItemRepo.save(lineItem);

		return status(OK).build();
	}
}