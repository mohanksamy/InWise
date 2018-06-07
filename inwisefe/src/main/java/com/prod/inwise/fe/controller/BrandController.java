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
public class BrandController {

	private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

	@GetMapping(value = "/brands")
	public String findBrands(Model model) throws Exception {
		logger.debug("Enter into findBrands...");

		return "brand_master";
	}

	@GetMapping(value = "/createBrand")
	public String addBrand(Model model) throws Exception {

		return "brand_detail";
	}

	@PostMapping(value = "/editBrand")
	public String editBrand(Model model) throws Exception {

		return "brand_detail";
	}

	@PostMapping(value = "/saveBrand")
	public String saveBrand(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		return "brand_detail";

	}

}