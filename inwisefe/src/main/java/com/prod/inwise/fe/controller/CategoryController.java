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
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@GetMapping(value = "/categories")
	public String findCategories(Model model) throws Exception {
		logger.debug("Enter into findCategories...");

		return "category_master";
	}

	@GetMapping(value = "/createCategory")
	public String addCategory(Model model) throws Exception {

		return "category_detail";
	}

	@PostMapping(value = "/editcategory")
	public String editCategory(Model model) throws Exception {

		return "category_detail";
	}

	@PostMapping(value = "/savecategory")
	public String saveCategory(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		return "category_detail";

	}

}