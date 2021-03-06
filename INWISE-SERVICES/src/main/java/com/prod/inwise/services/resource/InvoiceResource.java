package com.prod.inwise.services.resource;

import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.Status.OK;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.LineItem;
import com.prod.inwise.services.exceptions.OutOfStockException;
import com.prod.inwise.services.repo.InvoiceRepository;
import com.prod.inwise.services.services.InvoiceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * REST Resource exposes operation on Invoice resource
 * 
 * @author Logu
 *
 */
@Component
@Path("/invoice")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Invoice Service")
public class InvoiceResource {

	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@Autowired
	private InvoiceService invoiceService;

	@POST
	@Path("/store/{id}")
	@ApiOperation(value = "Create Invoice", notes = "Create invoice model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response createInvoice(@PathParam("id") Long storeId, List<LineItem> lineItems) {

		Response response = null;
		
		try {
			
			invoiceService.createInvoice(storeId, lineItems);
			
			response = status(OK).build();
		
		} catch (OutOfStockException ofs) {
			
			response = Response.status(INTERNAL_SERVER_ERROR).entity(ofs.getMessage()).build();
		}

		return response;
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Show Invoice", notes = "Show invoice model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response getInvoice(@ApiParam @PathParam("id") Long id) {

		return status(OK).entity(invoiceRepo.findOne(id)).build();
	}
}