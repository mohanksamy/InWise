package com.prod.inwise.services.resource;

import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.OK;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.Invoice;
import com.prod.inwise.services.repo.InvoiceRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
	
	@POST
	@ApiOperation(value = "Create Invoice", notes = "Create invoice model")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error")})
	public Response createInvoice(Invoice invoice) {
		
		invoiceRepo.save(invoice);
		
		return status(OK).build();
	}
}