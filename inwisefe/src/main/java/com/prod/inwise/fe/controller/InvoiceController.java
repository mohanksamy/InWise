package com.prod.inwise.fe.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prod.inwise.dto.InvoiceDTO;
import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.LineItemDTO;
import com.prod.inwise.fe.services.InvoiceService;
import com.prod.inwise.fe.services.ItemService;
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
	private ItemService itemService;

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(path = RequestConstants.VIEW_INVOICES, method = { RequestMethod.GET, RequestMethod.POST })
	public String getInvoiceList(Model model) throws Exception {

		List<InvoiceDTO> invoices = invoiceService.findAllInvoices();

		model.addAttribute(AttributeConstants.INVOICE_LIST, invoices);

		return ViewNames.INVOICE_MASTER;
	}

	@RequestMapping(path = RequestConstants.CREATE_INVOICE, method = { RequestMethod.GET, RequestMethod.POST })
	public String addInvoice(Model model, HttpSession session) throws Exception {

		InvoiceDTO invoiceDto = new InvoiceDTO();
		List<ItemDTO> itemDtos = itemService
				.findAllItemsByTraderId((BigInteger) session.getAttribute(AttributeConstants.TRADER_ID));

		model.addAttribute(AttributeConstants.ITEM_LIST, itemDtos);
		model.addAttribute(AttributeConstants.INVOICE_DTO, invoiceDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.INSERT);

		return ViewNames.INVOICE_DETAIL;
	}

	@RequestMapping(path = RequestConstants.EDIT_INVOICE, method = { RequestMethod.GET, RequestMethod.POST })
	public String editInvoice(@RequestParam("id") Long id, Model model, HttpSession session) throws Exception {

		logger.debug("editInvoice id [" + id + "]");

		InvoiceDTO invoiceDto = invoiceService.findInvoiceById(id);
		List<ItemDTO> itemDtos = itemService
				.findAllItemsByTraderId((BigInteger) session.getAttribute(AttributeConstants.TRADER_ID));

		model.addAttribute(AttributeConstants.ITEM_LIST, itemDtos);
		model.addAttribute(AttributeConstants.LINE_ITEM_LIST, invoiceDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.UPDATE);

		return ViewNames.INVOICE_DETAIL;
	}

	@RequestMapping(path = RequestConstants.SAVE_INVOICE, method = { RequestMethod.GET, RequestMethod.POST })
	public String saveInvoice(@RequestParam Map<String, String> requestParams, Model model, HttpSession session)
			throws Exception {

		List<LineItemDTO> lineItemDtos = setData(requestParams,
				(BigInteger) session.getAttribute(AttributeConstants.TRADER_ID));

		lineItemDtos = invoiceService.saveInvoice(Long.valueOf(1), lineItemDtos);

		List<ItemDTO> itemDtos = itemService
				.findAllItemsByTraderId((BigInteger) session.getAttribute(AttributeConstants.TRADER_ID));

		model.addAttribute(AttributeConstants.ITEM_LIST, itemDtos);
		model.addAttribute(AttributeConstants.LINE_ITEM_LIST, lineItemDtos);
		model.addAttribute(AttributeConstants.APPLICATION_STATUS, AttributeConstants.RS_SUCCESS);
		model.addAttribute(AttributeConstants.APPLICATION_MESSAGES, MessageCode.INFO_MSG_1001);

		return ViewNames.INVOICE_DETAIL;
	}

	private List<LineItemDTO> setData(Map<String, String> requestParams, BigInteger traderId) throws Exception {

		InvoiceDTO invoiceDto = null;
		String invoiceId = requestParams.get(AttributeConstants.INVOICE_ID);

		logger.debug("InvoiceDTO Mode [" + requestParams.get(AttributeConstants.MODE) + "]");
		if (AttributeConstants.INSERT.equals(requestParams.get(AttributeConstants.MODE))) {

			invoiceDto = new InvoiceDTO();

		} else {

			invoiceDto = invoiceService.findInvoiceById(Long.valueOf(invoiceId));
		}

		String quantity = requestParams.get(AttributeConstants.QUANTITY);
		String itemId = requestParams.get(AttributeConstants.ITEM_NAME);
		List<LineItemDTO> dtos = new ArrayList<>();

		LineItemDTO dto = new LineItemDTO();

		dto.setItem(itemService.findItemById(traderId, Long.valueOf(itemId)));
		dto.setQuantity(quantity != null ? Integer.valueOf(quantity) : 0);
		dto.setInvoice(invoiceDto);
		dto.setCreatedUser("APP-SERVICES");
		dto.setModifiedUser("APP-SERVICES");
		dto.setActive(true);

		dtos.add(dto);

		return dtos;
	}
}