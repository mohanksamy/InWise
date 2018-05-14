package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_INVOICE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TRADERS;
import static org.apache.http.HttpStatus.SC_OK;

import org.junit.Test;

import com.prod.inwise.dto.InvoiceDTO;
import com.prod.inwise.dto.TraderDTO;

/**
 * @author Logu
 *
 */
public class InvoiceTests extends AbstractTests {

	private static String STORE_NAME = "Vel Stores";

	@Test
	public void createInvoice1() {

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(18f);
		invoice.setTotalPrice(343f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice2() {
		
		STORE_NAME = "STORE-A";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(13f);
		invoice.setTotalPrice(345f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice3() {
		
		STORE_NAME = "STORE-B";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(17f);
		invoice.setTotalPrice(474f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice4() {
		
		STORE_NAME = "STORE-C";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(74f);
		invoice.setTotalPrice(488f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice5() {
		
		STORE_NAME = "STORE-D";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(475f);
		invoice.setTotalPrice(9674f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice6() {
		
		STORE_NAME = "STORE-E";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(584f);
		invoice.setTotalPrice(5758f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice7() {
		
		STORE_NAME = "STORE-F";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(43f);
		invoice.setTotalPrice(6964f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice8() {
		
		STORE_NAME = "STORE-F";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(5675f);
		invoice.setTotalPrice(96853f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice9() {
		
		STORE_NAME = "STORE-E";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(345f);
		invoice.setTotalPrice(5753f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice10() {
		
		STORE_NAME = "STORE-D";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(45f);
		invoice.setTotalPrice(56754f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice11() {
		
		STORE_NAME = "STORE-C";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(45f);
		invoice.setTotalPrice(56758f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice12() {
		
		STORE_NAME = "STORE-B";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(456f);
		invoice.setTotalPrice(56858f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice13() {
		
		STORE_NAME = "STORE-A";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(45675f);
		invoice.setTotalPrice(474452f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice14() {
		
		STORE_NAME = "STORE-A";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(34f);
		invoice.setTotalPrice(45747f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice15() {
		
		STORE_NAME = "STORE-C";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(57f);
		invoice.setTotalPrice(567573f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice16() {
		
		STORE_NAME = "STORE-E";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(574f);
		invoice.setTotalPrice(567559f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice17() {
		
		STORE_NAME = "STORE-F";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(454f);
		invoice.setTotalPrice(34636f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice18() {
		
		STORE_NAME = "STORE-F";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(371f);
		invoice.setTotalPrice(56753f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice19() {
		
		STORE_NAME = "STORE-F";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(567f);
		invoice.setTotalPrice(45747f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createInvoice20() {
		
		STORE_NAME = "STORE-B";

		TraderDTO trader = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn()
				.getBody().as(TraderDTO.class);

		InvoiceDTO invoice = new InvoiceDTO();

		invoice.setTotalTax(23f);
		invoice.setTotalPrice(346f);
		invoice.setBuyerName("eFresh");
		invoice.setDispatchedThrough("Courier");
		invoice.setDispatchedDocumentNo("12345");
		invoice.setDestination("Tirupur");
		invoice.setModeOfPayment("Cash");
		invoice.setSupplierReference("123");
		invoice.setTrader(trader);

		invoice.setCreatedUser(trader.getCreatedUser());
		invoice.setModifiedUser(trader.getModifiedUser());

		getRequestSpecificationWithJsonBody(invoice).post(getPath(RESOURCE_PATH_INVOICE)).then().statusCode(SC_OK);
	}
}