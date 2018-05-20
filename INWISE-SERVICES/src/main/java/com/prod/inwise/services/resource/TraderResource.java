package com.prod.inwise.services.resource;

import static com.prod.inwise.services.util.Utils.isNull;
import static java.util.stream.StreamSupport.stream;
import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.OK;

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
import com.prod.inwise.services.repo.AddressRepository;
import com.prod.inwise.services.repo.TraderRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST Resource exposes operation on Store resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Path("/traders")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Trader Service")
public class TraderResource {
	
	/*
	 * @Autowired private StoreRepository storeRepo;
	 */
	@Autowired
	private TraderRepository traderRepo;
	
	@Autowired
	private AddressRepository addressRepo;

	/*
	 * @POST public Store createStore(Store store) { return storeRepo.save(store); }
	 */
	@POST
	@ApiOperation(value = "Create store", notes = "Create store model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response createStore(Trader trader) {

		if ( isNull(trader.getAddress().getId()) ) {
			
			trader.setAddress(addressRepo.save(trader.getAddress()));
		}
		
		traderRepo.save(trader);

		return status(OK).build();
	}
	
	@GET
	@ApiOperation(value = "Get All Store", notes = "Get Store URIs")
	public Response findAll(@Context UriInfo uriInfo) {
		
		Iterable<Trader> shops = traderRepo.findAll();
		
		List<Trader> shopsList = stream(shops.spliterator(), false).collect(Collectors.toList());
		
		List<String> links = new ArrayList<>();
			
		shopsList.parallelStream().forEach( shop -> links.add(uriInfo.getBaseUriBuilder().path(TraderResource.class).path(shop.getName()).build().toString()));
		
		return Response.status(OK).entity(links).build();
	}

	/**
	 * Service operation to find resource by name.
	 *
	 * @param name
	 * @return
	 */
	@GET
	@Path("/{name}")
	@ApiOperation(value = "Show Store", notes = "Show store model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response findByName(@ApiParam @PathParam("name") String name) {

		return Response.status(OK).entity(traderRepo.findByNameIgnoreCase(name)).build();
	}
}