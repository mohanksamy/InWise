package com.prod.inwise.services.resource;

import static com.prod.inwise.services.util.Constants.RESOURCE_PATH_USER;
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
import com.prod.inwise.services.data.User;
import com.prod.inwise.services.repo.TraderRepository;
import com.prod.inwise.services.repo.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST Resource exposes operation on User resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "User Service")
public class UserResource {
	
	@Autowired
	private TraderRepository traderRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@POST
	@ApiOperation(value = "Create user", notes = "Create user model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response createUser(@ApiParam @PathParam("traderId") BigInteger traderId, User user) {
		
		Response response = null;
		
		// Look up Trader using Id
		Trader trader = traderRepo.findOne(traderId);
		
		if ( null == trader ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId).build();
		
		} else {
			
			user.setTrader(trader);
			
			userRepo.save(user);
			
			response = status(OK).entity(user.getId()).build();
		}

		return response;
	}
	
	@GET
	@ApiOperation(value = "Get All Users", notes = "Get User URIs")
	public Response findAllUsers(@Context UriInfo uriInfo, @ApiParam @PathParam("traderId") BigInteger traderId) {
		
		Iterable<User> users = userRepo.findByTraderId(traderId);
		
		List<User> usersList = stream(users.spliterator(), false).collect(Collectors.toList());
		
		List<String> links = new ArrayList<>();
		
		usersList.stream().forEach( item -> links.add(uriInfo.getBaseUriBuilder().path(TraderResource.class).path(traderId.toString()).path(RESOURCE_PATH_USER).path(item.getId().toString()).build().toString()));
		
		return Response.status(OK).entity(links).build();
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Get user", notes = "Get user model")
	public Response getUser(@ApiParam @PathParam("traderId") BigInteger traderId, @ApiParam @PathParam("id") BigInteger id) {

		Response response = null;
		
		// Look up Trader using Id
		User user = userRepo.findByTraderIdAndId(traderId, id);
		
		if ( null == user ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId + " and tax " + id).build();
		
		} else {
			
			response = status(OK).entity(user).build();
		}
		
		return response;
	}
}