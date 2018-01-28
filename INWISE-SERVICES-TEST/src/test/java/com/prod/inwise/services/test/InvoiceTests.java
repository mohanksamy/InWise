package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_INVOICE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STORE;
import static org.apache.http.HttpStatus.SC_OK;

import org.junit.Test;

import com.prod.inwise.dto.InvoiceDTO;
import com.prod.inwise.dto.StoreDTO;

/**
 * @author Logu
 *
 */
public class InvoiceTests extends AbstractTests {

	private static final String STORE_NAME = "Vel Stores";

	@Test
	public void createInvoice() {

		StoreDTO store = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STORE, STORE_NAME)).andReturn()
				.getBody().as(StoreDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(18f);
		invoice.setTotalPrice(1000f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setStore(store);

		invoice.setCreatedUser(store.getCreatedUser());
		invoice.setModifiedUser(store.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
}