package com.prod.inwise.fe.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prod.inwise.fe.utilities.RequestConstants;

@Controller
@RequestMapping("/")
public class BrandController {

	private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

	@RequestMapping(path = RequestConstants.VIEW_BRANDS, method = { RequestMethod.GET, RequestMethod.POST })
	public String findBrands(Model model) throws Exception {
		logger.debug("Enter into findBrands...");

		return "brand_master";
	}

	@RequestMapping(path = RequestConstants.CREATE_BRAND, method = { RequestMethod.GET, RequestMethod.POST })
	public String addBrand(Model model) throws Exception {

		return "brand_detail";
	}

	@RequestMapping(path = RequestConstants.EDIT_BRAND, method = { RequestMethod.GET, RequestMethod.POST })
	public String editBrand(Model model) throws Exception {

		return "brand_detail";
	}

	@RequestMapping(path = RequestConstants.SAVE_BRAND, method = { RequestMethod.GET, RequestMethod.POST })
	public String saveBrand(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		return "brand_detail";

	}
}