package com.prod.inwise.fe.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvoiceController {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	@GetMapping(value = "/invoices")
	public String getInvoices(Model model) {
		logger.info("Entering into getInvoices");

		model.addAttribute("name", "fwase");

		return "invoice_master";
	}

	@GetMapping(value = "/createInvoice")
	public String addInvoice(Model model) throws Exception {

		return "invoice_detail";
	}

	@GetMapping(value = "/editInvoice")
	public String saveInvoice(Model model) throws Exception {

		return "invoice_detail";
	}

	@PostMapping(value = "/saveInvoice")
	public String saveInvoice(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		return "invoice_detail";

	}
}