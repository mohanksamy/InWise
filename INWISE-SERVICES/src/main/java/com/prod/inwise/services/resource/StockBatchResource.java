package com.prod.inwise.services.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.StockBatch;
import com.prod.inwise.services.repo.StockBatchRepository;

/**
 * REST Resource exposes operation on Store resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Path("/stockBatch")
@Produces(MediaType.APPLICATION_JSON)
public class StockBatchResource {
	
	@Autowired
	private StockBatchRepository stockBatchRepo;
	
	@POST
	public StockBatch createStockBatch(StockBatch stockBatch) {
		return stockBatchRepo.save(stockBatch);
	}
}