package com.prod.inwise.services.resource;

import static com.prod.inwise.util.Constants.RESOURCE_PATH_BRANDS;
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

import com.prod.inwise.services.data.Brand;
import com.prod.inwise.services.data.Trader;
import com.prod.inwise.services.repo.BrandRepository;
import com.prod.inwise.services.repo.TraderRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST Resource exposes operation on Brand resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Brand Service")
public class BrandResource {

	@Autowired
	private TraderRepository traderRepo;

	@Autowired
	private BrandRepository brandRepo;

	@POST
	@ApiOperation(value = "Create Brand", notes = "Create brand model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response createBrand(@ApiParam @PathParam("traderId") BigInteger traderId, Brand brand) {

		Response response = null;

		// Look up Trader using Id
		Trader trader = traderRepo.findOne(traderId);

		if (null == trader) {

			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId).build();

		} else {

			brand.setTrader(trader);

			brandRepo.save(brand);

			response = status(OK).entity(brand.getId()).build();
		}

		return response;
	}

	@GET
	@ApiOperation(value = "Get All Brands", notes = "Get Brand URIs")
	public Response findAllBrands(@Context UriInfo uriInfo, @ApiParam @PathParam("traderId") BigInteger traderId) {

		Iterable<Brand> brands = brandRepo.findByTraderId(traderId);

		List<Brand> brandList = stream(brands.spliterator(), false).collect(Collectors.toList());

		List<String> links = new ArrayList<>();

		brandList.stream().forEach(
				brand -> links.add(uriInfo.getBaseUriBuilder().path(TraderResource.class).path(traderId.toString())
						.path(RESOURCE_PATH_BRANDS).path(brand.getId().toString()).build().toString()));

		return Response.status(OK).entity(links).build();
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Get Brand", notes = "Get brand model")
	public Response getBrand(@ApiParam @PathParam("traderId") BigInteger traderId,
			@ApiParam @PathParam("id") BigInteger id) {

		Response response = null;

		// Look up Trader using Id
		Brand brand = brandRepo.findByTraderIdAndId(traderId, id);

		if (null == brand) {

			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId + " and tax " + id).build();

		} else {

			response = status(OK).entity(brand).build();
		}

		return response;
	}
}