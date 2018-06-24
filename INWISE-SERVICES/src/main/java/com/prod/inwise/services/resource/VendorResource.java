package com.prod.inwise.services.resource;

import static com.prod.inwise.util.Constants.PARAM_ID;
import static com.prod.inwise.util.Constants.PARAM_TRADER_ID;
import static com.prod.inwise.util.Constants.RESOURCE_PATH_VENDOR;
import static com.prod.inwise.util.Utils.isNull;
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

import com.prod.inwise.services.data.Trader;
import com.prod.inwise.services.data.Vendor;
import com.prod.inwise.services.repo.AddressRepository;
import com.prod.inwise.services.repo.TraderRepository;
import com.prod.inwise.services.repo.VendorRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST Resource exposes operation on Vendor resource
 * 
 * @author Logu
 *
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Vendor Service")
public class VendorResource {
	
	@Autowired
	private TraderRepository traderRepo;
	
	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private VendorRepository vendorRepo;
	
	@POST
	@ApiOperation(value = "Create Vendor", notes = "Create vendor model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response createVendor(@ApiParam @PathParam("traderId") BigInteger traderId, Vendor vendor) {
		
		Response response = null;
		
		// Look up Trader using Id
		Trader trader = traderRepo.findOne(traderId);
		
		if ( null == trader ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId).build();
		
		} else {
			
			// Set Trader
			vendor.setTrader(trader);
			
			// Save Vendor Address
			if ( isNull(vendor.getAddress().getId()) ) {
				
				vendor.setAddress(addressRepo.save(vendor.getAddress()));
			}
			
			vendorRepo.save(vendor);
			
			response = status(OK).entity(vendor.getId()).build();
		}

		return response;
	}
	
	@GET
	@ApiOperation(value = "Get All Vendor", notes = "Get Vendor URIs")
	public Response findAllVendors(@Context UriInfo uriInfo, @ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId) {
		
		Iterable<Vendor> vendors = vendorRepo.findByTraderId(traderId);
		
		List<Vendor> vendorsList = stream(vendors.spliterator(), false).collect(Collectors.toList());
		
		List<String> links = new ArrayList<>();
		
		vendorsList.stream().forEach( vendor -> links.add(uriInfo.getBaseUriBuilder().path(TraderResource.class).path(traderId.toString()).path(RESOURCE_PATH_VENDOR).path(vendor.getId().toString()).build().toString()));
		
		return Response.status(OK).entity(links).build();
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Get Vendor", notes = "Get vendor model")
	public Response getVendor(@ApiParam @PathParam(PARAM_TRADER_ID) BigInteger traderId, @ApiParam @PathParam(PARAM_ID) BigInteger id) {

		Response response = null;
		
		// Look up Trader using Id
		Vendor vendor = vendorRepo.findByTraderIdAndId(traderId, id);
		
		if ( null == vendor ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId + " and tax " + id).build();
		
		} else {
			
			response = status(OK).entity(vendor).build();
		}
		
		return response;
	}
}