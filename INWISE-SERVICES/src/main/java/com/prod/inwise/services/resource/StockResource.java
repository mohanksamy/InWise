package com.prod.inwise.services.resource;

import static com.prod.inwise.util.Constants.PARAM_ID;
import static com.prod.inwise.util.Constants.PARAM_TRADER_ID;
import static com.prod.inwise.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.util.Constants.RESOURCE_PATH_STOCK;
import static java.util.stream.StreamSupport.stream;
import static javax.ws.rs.core.Response.Status.OK;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.Item;
import com.prod.inwise.services.data.Stock;
import com.prod.inwise.services.repo.ItemRepository;
import com.prod.inwise.services.repo.StockRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * REST Resource exposes operation on Stock resource
 * 
 * @author Logu
 *
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Stock Service")
public class StockResource {

	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	@GET
	@ApiOperation(value = "Get All Stocks", notes = "Get Stock URIs")
	public Response findAllStocks(@Context UriInfo uriInfo, @ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId) {
		
		Iterable<Stock> stocks = stockRepo.findByItemTraderId(traderId);
		
		List<Stock> stocksList = stream(stocks.spliterator(), false).collect(Collectors.toList());
		
		List<String> links = new ArrayList<>();
		
		stocksList.stream().forEach( stock -> links.add(uriInfo.getBaseUriBuilder().path(TraderResource.class).path(traderId.toString()).path(RESOURCE_PATH_STOCK).path(RESOURCE_PATH_ITEM).path(stock.getItem().getId().toString()).build().toString()));
		
		return Response.status(OK).entity(links).build();
	}
	
	@GET
	@Path("/items/{id}")
	@ApiOperation(value = "Get stock", notes = "Get stock model")
	public Response findByItem(@ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId, @ApiParam @PathParam(PARAM_ID) BigInteger itemId) {
		
		Response response = null;
		
		Item item = itemRepo.findOne(itemId);
		
		if ( traderId.equals(item.getTrader().getId()) ) {
		
			Stock stock = stockRepo.findByItemId(itemId);
			
			response = Response.status(OK).entity(stock).build();
		
		} else {
			
			response = Response.status(OK).entity("Item " + item.getName() + " doesn't belongs to the Trader: " + traderId).build();
		}
		
		return response;
	}
}