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
public class SubCategoryController {

	private static final Logger logger = LoggerFactory.getLogger(SubCategoryController.class);

	@GetMapping(value = "/subCategories")
	public String findSubCategories(Model model) throws Exception {
		logger.debug("Enter into findSubCategories...");

		return "subcategory_master";
	}

	@GetMapping(value = "/createSubCategory")
	public String addSubCategory(Model model) throws Exception {

		return "subcategory_detail";
	}

	@PostMapping(value = "/editSubCategory")
	public String editSubCategory(Model model) throws Exception {

		return "subcategory_detail";
	}

	@PostMapping(value = "/saveSubCategory")
	public String saveSubCategory(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		return "subcategory_detail";

	}
}