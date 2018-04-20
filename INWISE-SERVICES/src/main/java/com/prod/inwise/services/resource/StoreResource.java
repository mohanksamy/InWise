package com.prod.inwise.services.resource;

import static java.util.stream.StreamSupport.stream;
import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.OK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.prod.inwise.services.data.Shop;
import com.prod.inwise.services.repo.ShopRepository;

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
@Path("/store")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Store Service")
public class StoreResource {

	/*
	 * @Autowired private StoreRepository storeRepo;
	 */

	@Autowired
	private ShopRepository shopRepo;

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
	public Response createStore(Shop shop) {

		shopRepo.save(shop);

		return status(OK).build();
	}
	
	@GET
	@ApiOperation(value = "Get All Store", notes = "Get Store URIs")
	public Response findAllStore(@Context UriInfo uriInfo) {
		
		Iterable<Shop> shops = shopRepo.findAll();
		
		List<Shop> shopsList = stream(shops.spliterator(), false).collect(Collectors.toList());
		
		Map<String, String> shopsMap = new HashMap<>();
			
		shopsList.parallelStream().forEach( shop -> shopsMap.put(shop.getName(), uriInfo.getBaseUriBuilder().path(StoreResource.class).path(shop.getName()).build().toString()));
		
		return Response.status(OK).entity(shopsMap).build();
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

		return Response.status(OK).entity(shopRepo.findByNameIgnoreCase(name)).build();
	}
}