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

import com.prod.inwise.services.data.Stock;
import com.prod.inwise.services.repo.StockRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST Resource exposes operation on Stock resource
 * 
 * @author Logu
 *
 */
@Component
@Path("/stock")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Stock Service")
public class StockResource {

	@Autowired
	private StockRepository stockRepo;

	@POST
	@ApiOperation(value = "Create stock", notes = "Create stock model")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error")})
	public Response createStock(Stock stock) {

		stockRepo.save(stock);

		return status(OK).build();
	}
	
	@GET
	@Path("/item/{id}")
	@ApiOperation(value = "Get stock", notes = "Get stock model")
	public Response findByItem(@ApiParam @PathParam("id") Long itemId) {
		
		Stock stock = stockRepo.findByItemId(itemId);
		
		return Response.status(OK).entity(stock).build();
	}
}