package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_INVOICE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_LINEITEM;
import static org.apache.http.HttpStatus.SC_OK;

import org.junit.Test;

import com.prod.inwise.dto.InvoiceDTO;
import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.LineItemDTO;

/**
 * @author Logu
 *
 */
public class LineItemTests extends AbstractTests {

	private static String ITEM_NAME = "Test Item";

	private static String INVOICE_ID = "1002";

	@Test
	public void createLineItem1() {

		ItemDTO item = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_ITEM, ITEM_NAME)).andReturn()
				.getBody().as(ItemDTO.class);

		InvoiceDTO invoice = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_INVOICE, INVOICE_ID))
				.andReturn().getBody().as(InvoiceDTO.class);

		LineItemDTO lineItem = new LineItemDTO();

		lineItem.setQuantity(100);
		lineItem.setTotalTax(18f);
		lineItem.setTotalPrice(10000f);

		lineItem.setItem(item);
		lineItem.setInvoice(invoice);

		lineItem.setCreatedUser(item.getCreatedUser());
		lineItem.setModifiedUser(item.getModifiedUser());

		getRequestSpecificationWithJsonBody(lineItem).post(getPath(RESOURCE_PATH_LINEITEM)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createLineItem2() {
		
		ITEM_NAME = "";
		
		INVOICE_ID = "";

		ItemDTO item = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_ITEM, ITEM_NAME)).andReturn()
				.getBody().as(ItemDTO.class);

		InvoiceDTO invoice = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_INVOICE, INVOICE_ID))
				.andReturn().getBody().as(InvoiceDTO.class);

		LineItemDTO lineItem = new LineItemDTO();

		lineItem.setQuantity(100);
		lineItem.setTotalTax(18f);
		lineItem.setTotalPrice(10000f);

		lineItem.setItem(item);
		lineItem.setInvoice(invoice);

		lineItem.setCreatedUser(item.getCreatedUser());
		lineItem.setModifiedUser(item.getModifiedUser());

		getRequestSpecificationWithJsonBody(lineItem).post(getPath(RESOURCE_PATH_LINEITEM)).then().statusCode(SC_OK);
	}
}