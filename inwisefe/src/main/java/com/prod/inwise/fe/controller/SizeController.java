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
public class SizeController {

	private static final Logger logger = LoggerFactory.getLogger(SizeController.class);

	@GetMapping(value = "/sizes")
	public String findSizes(Model model) throws Exception {
		logger.debug("Enter into findSizes...");

		return "size_master";
	}

	@GetMapping(value = "/createSize")
	public String addSize(Model model) throws Exception {

		return "size_detail";
	}

	@PostMapping(value = "/editSize")
	public String editSize(Model model) throws Exception {

		return "size_detail";
	}

	@PostMapping(value = "/saveSize")
	public String saveSize(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		return "size_detail";

	}
}