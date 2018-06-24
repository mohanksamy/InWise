package com.prod.inwise.services.resource;

import static com.prod.inwise.util.Constants.PARAM_ID;
import static com.prod.inwise.util.Constants.PARAM_TRADER_ID;
import static com.prod.inwise.util.Constants.RESOURCE_PATH_TAX;
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

import com.prod.inwise.services.data.Tax;
import com.prod.inwise.services.data.Trader;
import com.prod.inwise.services.repo.TaxRepository;
import com.prod.inwise.services.repo.TraderRepository;

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
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Tax Service")
public class TaxResource {

	@Autowired
	private TraderRepository traderRepo;

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
	public Response createTax(@ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId, Tax tax) {
		
		Response response = null;
		
		// Look up Trader using Id
		Trader trader = traderRepo.findOne(traderId);
		
		if ( null == trader ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId).build();
		
		} else {
			
			tax.setTrader(trader);
			
			taxRepo.save(tax);
			
			response = status(OK).entity(tax.getId()).build();
		}

		return response;
	}
	
	@GET
	@ApiOperation(value = "Get All Taxes", notes = "Get Tax URIs")
	public Response findAllTaxes(@Context UriInfo uriInfo, @ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId) {
		
		Iterable<Tax> taxes = taxRepo.findByTraderId(traderId);
		
		List<Tax> taxesList = stream(taxes.spliterator(), false).collect(Collectors.toList());
		
		List<String> links = new ArrayList<>();
		
		taxesList.stream().forEach( tax -> links.add(uriInfo.getBaseUriBuilder().path(TraderResource.class).path(traderId.toString()).path(RESOURCE_PATH_TAX).path(tax.getId().toString()).build().toString()));
		
		return Response.status(OK).entity(links).build();
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Get tax", notes = "Get tax model")
	public Response getTax(@ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId, @ApiParam @PathParam(PARAM_ID) BigInteger id) {

		Response response = null;
		
		// Look up Trader using Id
		Tax tax = taxRepo.findByTraderIdAndId(traderId, id);
		
		if ( null == tax ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId + " and tax " + id).build();
		
		} else {
			
			response = status(OK).entity(tax).build();
		}
		
		return response;
	}
}