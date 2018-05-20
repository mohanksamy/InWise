package com.prod.inwise.fe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@GetMapping(value = "/items")
	public String getItems(Model model) throws Exception {
		logger.debug("Enter into getItems...");

		model.addAttribute("name", "CCTV");

		return "item_master";
	}

	@GetMapping(value = "/addItem")
	public String addItem(Model model) throws Exception {

		model.addAttribute("name", "CCTV");

		return "item_detail";
	}

	@GetMapping(value = "/editItem")
	public String saveItem(Model model) throws Exception {

		model.addAttribute("name", "CCTV");

		return "item_detail";
	}

}
