package com.prod.inwise.fe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	@GetMapping(value = "/invoices")
	public String getInvoices(Model model) {
		logger.info("Entering into getInvoices");

		model.addAttribute("name", "fwase");

		return "invoice_master";
	}

	@GetMapping(value = "/editInvoice")
	public String saveInvoice(Model model) throws Exception {

		return "invoice_detail";
	}

	@GetMapping(value = "/addInvoice")
	public String addInvoice(Model model) throws Exception {

		return "invoice_detail";
	}

}