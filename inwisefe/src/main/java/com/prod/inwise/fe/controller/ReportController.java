package com.prod.inwise.fe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

	@GetMapping(value = "/reports")
	public String generateReports(Model model) {
		logger.info("Entering into getStores...");

		model.addAttribute("name", "fwase");

		return "report_master";
	}
}
