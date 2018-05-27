package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_INVOICE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TRADERS;
import static org.apache.http.HttpStatus.SC_OK;

import java.math.BigDecimal;

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

		invoice.setTotalTax(new BigDecimal(18f));
		invoice.setTotalPrice(new BigDecimal(343f));
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

		invoice.setTotalTax(new BigDecimal(13f));
		invoice.setTotalPrice(new BigDecimal(345f));
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

		invoice.setTotalTax(new BigDecimal(17f));
		invoice.setTotalPrice(new BigDecimal(474f));
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

		invoice.setTotalTax(new BigDecimal(74f));
		invoice.setTotalPrice(new BigDecimal(488f));
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

		invoice.setTotalTax(new BigDecimal(475f));
		invoice.setTotalPrice(new BigDecimal(9674f));
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

		invoice.setTotalTax(new BigDecimal(584f));
		invoice.setTotalPrice(new BigDecimal(5758f));
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

		invoice.setTotalTax(new BigDecimal(43f));
		invoice.setTotalPrice(new BigDecimal(6964f));
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

		invoice.setTotalTax(new BigDecimal(5675f));
		invoice.setTotalPrice(new BigDecimal(96853f));
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

		invoice.setTotalTax(new BigDecimal(345f));
		invoice.setTotalPrice(new BigDecimal(5753f));
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

		invoice.setTotalTax(new BigDecimal(45f));
		invoice.setTotalPrice(new BigDecimal(56754f));
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

		invoice.setTotalTax(new BigDecimal(45f));
		invoice.setTotalPrice(new BigDecimal(56758f));
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

		invoice.setTotalTax(new BigDecimal(456f));
		invoice.setTotalPrice(new BigDecimal(56858f));
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

		invoice.setTotalTax(new BigDecimal(45675f));
		invoice.setTotalPrice(new BigDecimal(474452f));
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

		invoice.setTotalTax(new BigDecimal(34f));
		invoice.setTotalPrice(new BigDecimal(45747f));
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

		invoice.setTotalTax(new BigDecimal(57f));
		invoice.setTotalPrice(new BigDecimal(567573f));
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

		invoice.setTotalTax(new BigDecimal(574f));
		invoice.setTotalPrice(new BigDecimal(567559f));
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

		invoice.setTotalTax(new BigDecimal(454f));
		invoice.setTotalPrice(new BigDecimal(34636f));
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

		invoice.setTotalTax(new BigDecimal(371f));
		invoice.setTotalPrice(new BigDecimal(56753f));
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

		invoice.setTotalTax(new BigDecimal(567f));
		invoice.setTotalPrice(new BigDecimal(45747f));
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

		invoice.setTotalTax(new BigDecimal(23f));
		invoice.setTotalPrice(new BigDecimal(346f));
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