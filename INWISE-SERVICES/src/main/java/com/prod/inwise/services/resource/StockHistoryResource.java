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

import com.prod.inwise.services.data.StockHistory;
import com.prod.inwise.services.repo.StockHistoryRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST Resource exposes operation on StockHistory resource
 * 
 * @author Logu
 *
 */
@Component
@Path("/stockHistory")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "StockHistory Service")
public class StockHistoryResource {

	@Autowired
	private StockHistoryRepository stockHistoryRepo;

	@POST
	@ApiOperation(value = "Create stock history", notes = "Create stockHistory model")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error")})
	public Response createStockHistory(StockHistory stockHistory) {

		stockHistoryRepo.save(stockHistory);

		return status(OK).build();
	}
}