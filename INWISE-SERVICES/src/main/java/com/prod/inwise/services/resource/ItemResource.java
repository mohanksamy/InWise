package com.prod.inwise.services.resource;

import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.OK;

import java.util.ArrayList;
import java.util.List;

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
import com.prod.inwise.services.repo.ItemRepository;

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
@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Item Service")
public class ItemResource {
	
	@Autowired
	private ItemRepository itemRepo;
	
	@POST
	@ApiOperation(value = "Create item", notes = "Create item model")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error")})
	public Response createItem(Item item) {
		
		itemRepo.save(item);
		
		return status(OK).build();
	}
	
	@GET
	@Path("/id/{id}")
	@ApiOperation(value = "Get item", notes = "Get item model")
	public Response findById(@ApiParam @PathParam("id") Long id) {
		return Response.status(OK).entity(itemRepo.findOne(id)).build();
	}
	
	@GET
	@Path("/{name}")
	@ApiOperation(value = "Get item", notes = "Get item model")
	public Response findByName(@ApiParam @PathParam("name") String name) {
		return Response.status(OK).entity(itemRepo.findByNameIgnoreCase(name)).build();
	}
	
	@GET
	@ApiOperation(value = "Get all items", notes = "Get all item model")
	public Response findAll() {
		return Response.status(OK).entity(itemRepo.findAll()).build();
	}
	
	@GET
	@Path("/store/{id}")
	@ApiOperation(value = "Get item", notes = "Get item model")
	public Response findAllItemsByStore(@Context UriInfo uriInfo, @ApiParam @PathParam("id") Long storeId) {
		
		List<Item> items = itemRepo.findItemsByStore(storeId);
		
		List<String> links = new ArrayList<>();
			
		items.parallelStream().forEach( item -> links.add(uriInfo.getBaseUriBuilder().path(ItemResource.class).path("id").path(Long.toString(item.getId())).build().toString()));
		
		return Response.status(OK).entity(links).build();
	}
}