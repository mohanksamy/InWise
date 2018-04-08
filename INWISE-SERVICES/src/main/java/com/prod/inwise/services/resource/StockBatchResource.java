package com.prod.inwise.services.resource;

import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.OK;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.StockHistory;
import com.prod.inwise.services.services.StockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * REST Resource exposes operation on Store resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Path("/stockBatch")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Stock Batch Service")
public class StockBatchResource {
	
	/*@Autowired
	private StockBatchRepository stockBatchRepo;*/
	
	@Autowired
	private StockService stockService;
	
	/*@POST
	@ApiOperation(value = "Create Stock Batch", notes = "Create stock batch model")
	public StockBatch createStockBatch(StockBatch stockBatch) {
		return stockBatchRepo.save(stockBatch);
	}*/
	
	@POST
	@ApiOperation(value = "Create Stock Batch", notes = "Create stock batch model")
	public Response createStockBatch(List<StockHistory> stockHistories) {
		
		stockService.createStock(stockHistories);
		
		return status(OK).build();
	}
}