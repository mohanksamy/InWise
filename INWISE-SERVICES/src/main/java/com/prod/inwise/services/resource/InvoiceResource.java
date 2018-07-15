package com.prod.inwise.services.resource;

import static com.prod.inwise.util.Constants.RESOURCE_PATH_INVOICE;
import static com.prod.inwise.util.Utils.isNull;
import static java.util.stream.StreamSupport.stream;
import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
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

import com.prod.inwise.services.data.Address;
import com.prod.inwise.services.data.Buyer;
import com.prod.inwise.services.data.Invoice;
import com.prod.inwise.services.data.LineItem;
import com.prod.inwise.services.exceptions.OutOfStockException;
import com.prod.inwise.services.exceptions.UnexpectedItemException;
import com.prod.inwise.services.repo.AddressRepository;
import com.prod.inwise.services.repo.BuyerRepository;
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
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Invoice Service")
public class InvoiceResource {

	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private BuyerRepository buyerRepo;

	@POST
	@ApiOperation(value = "Create Invoice", notes = "Create invoice model")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Invalid tenant specified"),
			@ApiResponse(code = 401, message = "Invalid user specified"),
			@ApiResponse(code = 401, message = "No permission to access model"),
			@ApiResponse(code = 401, message = "No privilege to access model"),
			@ApiResponse(code = 440, message = "invalid session or access-token specified"),
			@ApiResponse(code = 500, message = "Server Internal error") })
	public Response createInvoice(@ApiParam @PathParam("traderId") BigInteger traderId, List<LineItem> lineItems) {

		Response response = null;
		
		try {
			
			if ( null != lineItems && !lineItems.isEmpty() ) {
				
				Invoice invoice = lineItems.get(0).getInvoice();
			
				if ( !isNull(invoice.getBuyer()) && isNull(invoice.getBuyer().getId()) ) {
					
					if ( !isNull(invoice.getBuyer().getAddress()) && isNull(invoice.getBuyer().getAddress().getId()) ) {
						
						Address address = addressRepo.save(invoice.getBuyer().getAddress());
						
						invoice.getBuyer().setAddress(address);
					}
					
					Buyer buyer = buyerRepo.save(invoice.getBuyer());
					
					invoice.setBuyer(buyer);
				}
			
				invoiceService.createInvoice(traderId, invoice, lineItems);
				
				response = status(OK).build();
			}
		
		} catch (UnexpectedItemException uie) {
			
			response = Response.status(INTERNAL_SERVER_ERROR).entity(uie.getMessage()).build();
		
		} catch (OutOfStockException ofs) {
			
			response = Response.status(INTERNAL_SERVER_ERROR).entity(ofs.getMessage()).build();
		}

		return response;
	}
	
	@GET
	@ApiOperation(value = "Get All Invoices", notes = "Get invoice URIs")
	public Response findAllInvoices(@Context UriInfo uriInfo, @ApiParam @PathParam("traderId") BigInteger traderId) {
		
		Iterable<Invoice> invoices = invoiceRepo.findByTraderId(traderId);
		
		List<Invoice> invoicesList = stream(invoices.spliterator(), false).collect(Collectors.toList());
		
		List<String> links = new ArrayList<>();
		
		invoicesList.stream().forEach( invoice -> links.add(uriInfo.getBaseUriBuilder().path(TraderResource.class).path(traderId.toString()).path(RESOURCE_PATH_INVOICE).path(invoice.getId().toString()).build().toString()));
		
		return Response.status(OK).entity(links).build();
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Get Invoice", notes = "Get invoice model")
	public Response getInvoice(@ApiParam @PathParam("traderId") BigInteger traderId, @ApiParam @PathParam("id") BigInteger id) {

		Response response = null;
		
		// Look up Trader using Id
		Invoice invoice = invoiceRepo.findByTraderIdAndId(traderId, id);
		
		if ( null == invoice ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId + " and tax " + id).build();
		
		} else {
			
			response = status(OK).entity(invoice).build();
		}
		
		return response;
	}
}