package com.prod.inwise.services.resource;

import static com.prod.inwise.util.Constants.PARAM_TRADER_ID;
import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.Status.OK;

import java.math.BigInteger;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.StockHistory;
import com.prod.inwise.services.exceptions.UnexpectedItemException;
import com.prod.inwise.services.services.StockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST Resource exposes operation on Store resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Stock Batch Service")
public class StockBatchResource {
	
	@Autowired
	private StockService stockService;
	
	@POST
	@ApiOperation(value = "Create Stock Batch", notes = "Create stock batch model")
	public Response createStockBatch(@ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId, List<StockHistory> stockHistories) {

		Response response = null;
		
		try {
			
			stockService.createStock(traderId, stockHistories);
			
			response = status(OK).build();
		
		} catch (UnexpectedItemException uie) {
			
			response = Response.status(INTERNAL_SERVER_ERROR).entity(uie.getMessage()).build();
		}
		
		return response;
	}
}