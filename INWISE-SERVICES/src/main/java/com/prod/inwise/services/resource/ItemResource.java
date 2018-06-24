package com.prod.inwise.services.resource;

import static com.prod.inwise.util.Constants.PARAM_ID;
import static com.prod.inwise.util.Constants.PARAM_TRADER_ID;
import static com.prod.inwise.util.Constants.RESOURCE_PATH_ITEM;
import static java.util.stream.StreamSupport.stream;
import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.Status.OK;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import com.prod.inwise.services.data.Trader;
import com.prod.inwise.services.repo.ItemRepository;
import com.prod.inwise.services.repo.TraderRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST Resource exposes operation on Item resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Item Service")
public class ItemResource {
	
	@Autowired
	private TraderRepository traderRepo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	@POST
	@ApiOperation(value = "Create item", notes = "Create item model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response createItem(@ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId, Item item) {
		
		Response response = null;
		
		// Look up Trader using Id
		Trader trader = traderRepo.findOne(traderId);
		
		if ( null == trader ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId).build();
		
		} else {
			
			item.setTrader(trader);
			
			itemRepo.save(item);
			
			response = status(OK).entity(item.getId()).build();
		}

		return response;
	}
	
	@GET
	@ApiOperation(value = "Get All Items", notes = "Get Item URIs")
	public Response findAllItems(@Context UriInfo uriInfo, @ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId) {
		
		Iterable<Item> items = itemRepo.findByTraderId(traderId);
		
		List<Item> itemsList = stream(items.spliterator(), false).collect(Collectors.toList());
		
		List<String> links = new ArrayList<>();
		
		itemsList.stream().forEach( item -> links.add(uriInfo.getBaseUriBuilder().path(TraderResource.class).path(traderId.toString()).path(RESOURCE_PATH_ITEM).path(item.getId().toString()).build().toString()));
		
		return Response.status(OK).entity(links).build();
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Get item", notes = "Get item model")
	public Response getItem(@ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId, @ApiParam @PathParam(PARAM_ID) BigInteger id) {

		Response response = null;
		
		// Look up Trader using Id
		Item item = itemRepo.findByTraderIdAndId(traderId, id);
		
		if ( null == item ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId + " and tax " + id).build();
		
		} else {
			
			response = status(OK).entity(item).build();
		}
		
		return response;
	}
}