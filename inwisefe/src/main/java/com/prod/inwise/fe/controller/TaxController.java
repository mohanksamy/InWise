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
public class TaxController {

	private static final Logger logger = LoggerFactory.getLogger(TaxController.class);

	@GetMapping(value = "/taxs")
	public String findTaxs(Model model) throws Exception {
		logger.debug("Enter into findTaxs...");

		return "tax_master";
	}

	@GetMapping(value = "/createTax")
	public String addTax(Model model) throws Exception {

		return "tax_detail";
	}

	@PostMapping(value = "/editTax")
	public String editTax(Model model) throws Exception {

		return "tax_detail";
	}

	@PostMapping(value = "/saveTax")
	public String saveTax(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		return "tax_detail";

	}

}