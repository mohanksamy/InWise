package com.prod.inwise.services.resource;

import static com.prod.inwise.services.util.Constants.RESOURCE_PATH_CATEGORIES;
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

import com.prod.inwise.services.data.Category;
import com.prod.inwise.services.data.Trader;
import com.prod.inwise.services.repo.CategoryRepository;
import com.prod.inwise.services.repo.TraderRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * REST Resource exposes operation on Category resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Category Service")
public class CategoryResource {

	@Autowired
	private TraderRepository traderRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@POST
	@ApiOperation(value = "Create Category", notes = "Create category model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response createCategory(@ApiParam @PathParam("traderId") BigInteger traderId, Category category) {
		
		Response response = null;
		
		// Look up Trader using Id
		Trader trader = traderRepo.findOne(traderId);
		
		if ( null == trader ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId).build();
		
		} else {
			
			category.setTrader(trader);
			
			categoryRepo.save(category);
			
			response = status(OK).entity(category.getId()).build();
		}

		return response;
	}
	
	@GET
	@ApiOperation(value = "Get All Categories", notes = "Get Category URIs")
	public Response findAllCategories(@Context UriInfo uriInfo, @ApiParam @PathParam("traderId") BigInteger traderId) {
		
		Iterable<Category> category = categoryRepo.findByTraderId(traderId);
		
		List<Category> categoriesList = stream(category.spliterator(), false).collect(Collectors.toList());
		
		List<String> links = new ArrayList<>();
		
		categoriesList.parallelStream().forEach( tax -> links.add(uriInfo.getBaseUriBuilder().path(TraderResource.class).path(traderId.toString()).path(RESOURCE_PATH_CATEGORIES).path(tax.getId().toString()).build().toString()));
		
		return Response.status(OK).entity(links).build();
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Get Category", notes = "Get category model")
	public Response getCategory(@ApiParam @PathParam("traderId") BigInteger traderId, @ApiParam @PathParam("id") BigInteger id) {

		Response response = null;
		
		// Look up Trader using Id
		Category category = categoryRepo.findByTraderIdAndId(traderId, id);
		
		if ( null == category ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId + " and tax " + id).build();
		
		} else {
			
			response = status(OK).entity(category).build();
		}
		
		return response;
	}
}