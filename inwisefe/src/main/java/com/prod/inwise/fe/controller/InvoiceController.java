package com.prod.inwise.fe.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prod.inwise.dto.InvoiceDTO;
import com.prod.inwise.fe.services.InvoiceService;
import com.prod.inwise.fe.utilities.AttributeConstants;
import com.prod.inwise.fe.utilities.MessageCode;
import com.prod.inwise.fe.utilities.RequestConstants;
import com.prod.inwise.fe.utilities.ViewNames;

@Controller
public class InvoiceController {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	// @Autowired
	// private TraderService traderService;

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(path = RequestConstants.VIEW_INVOICES, method = { RequestMethod.GET, RequestMethod.POST })
	public String getInvoiceList(Model model) throws Exception {

		List<InvoiceDTO> invoices = invoiceService.findAllInvoices();

		model.addAttribute(AttributeConstants.INVOICE_LIST, invoices);

		return ViewNames.INVOICE_MASTER;
	}

	@RequestMapping(path = RequestConstants.CREATE_INVOICE, method = { RequestMethod.GET, RequestMethod.POST })
	public String addInvoice(Model model) throws Exception {

		InvoiceDTO invoiceDto = new InvoiceDTO();

		model.addAttribute(AttributeConstants.INVOICE_DTO, invoiceDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.INSERT);

		return ViewNames.INVOICE_DETAIL;
	}

	@RequestMapping(path = RequestConstants.EDIT_INVOICE, method = { RequestMethod.GET, RequestMethod.POST })
	public String editInvoice(@RequestParam("id") Long id, Model model) throws Exception {

		logger.debug("editInvoice id [" + id + "]");

		InvoiceDTO invoiceDto = invoiceService.findInvoiceById(id);

		model.addAttribute(AttributeConstants.INVOICE_DTO, invoiceDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.UPDATE);

		return ViewNames.INVOICE_DETAIL;
	}

	@RequestMapping(path = RequestConstants.SAVE_INVOICE, method = { RequestMethod.GET, RequestMethod.POST })
	public String saveInvoice(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		InvoiceDTO invoiceDto = setData(requestParams);

		invoiceDto = invoiceService.saveInvoice(invoiceDto);

		model.addAttribute(AttributeConstants.INVOICE_DTO, invoiceDto);
		model.addAttribute(AttributeConstants.APPLICATION_STATUS, AttributeConstants.RS_SUCCESS);
		model.addAttribute(AttributeConstants.APPLICATION_MESSAGES, MessageCode.INFO_MSG_1001);

		return ViewNames.INVOICE_DETAIL;
	}

	private InvoiceDTO setData(Map<String, String> requestParams) throws Exception {

		InvoiceDTO invoiceDto = null;
		String invoiceId = requestParams.get(AttributeConstants.INVOICE_ID);
		// String traderId = requestParams.get(AttributeConstants.TRADER_ID);

		logger.debug("InvoiceDTO Mode [" + requestParams.get(AttributeConstants.MODE) + "]");
		if (AttributeConstants.INSERT.equals(requestParams.get(AttributeConstants.MODE))) {

			invoiceDto = new InvoiceDTO();

		} else {

			invoiceDto = invoiceService.findInvoiceById(Long.valueOf(invoiceId));
		}

		// private BigDecimal totalTax;
		//
		// private BigDecimal totalPrice;
		//
		// private String buyerName;
		//
		// private String dispatchedThrough;
		//
		// private String dispatchedDocumentNo;
		//
		// private String destination;
		//
		// private String modeOfPayment;
		//
		// private String supplierReference;

		// String cgst = requestParams.get(AttributeConstants.CGST);
		// String sgst = requestParams.get(AttributeConstants.SGST);
		//
		// taxDto.setCgst(new BigDecimal(cgst));
		// taxDto.setSgst(new BigDecimal(sgst));
		// taxDto.setTrader(traderService.findTraderByName("VELSTORES"));
		// taxDto.setActive(true);
		// taxDto.setCreatedUser("APP-SERVICES");
		// taxDto.setModifiedUser("APP-SERVICES");

		return invoiceDto;
	}
}