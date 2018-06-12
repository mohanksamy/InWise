package com.prod.inwise.fe.controller;

import java.math.BigInteger;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.dto.TraderDTO;

@Controller
public class ItemController {

	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@GetMapping(value = "/items")
	public String getItems(Model model) throws Exception {
		logger.debug("Enter into getItems...");

		model.addAttribute("name", "CCTV");

		return "item_master";
	}

	@GetMapping(value = "/createItem")
	public String addItem(Model model) throws Exception {

		model.addAttribute("name", "CCTV");

		return "item_detail";
	}

	@GetMapping(value = "/editItem")
	public String editItem(Model model) throws Exception {

		model.addAttribute("name", "CCTV");

		return "item_detail";
	}

	@PostMapping(value = "/saveItem")
	public String saveItem(@RequestParam Map<String, String> requestParams, Model model) throws Exception {
		String name = requestParams.get("name");
		// BigInteger partNo = (BigInteger)requestParams.get("partNo");

		ItemDTO itemDto = new ItemDTO();

		TraderDTO trader = new TraderDTO();
		trader.setId(new BigInteger("1001"));

		TaxDTO tax = new TaxDTO();
		tax.setId(new BigInteger("1001"));

		itemDto.setName(name);
		itemDto.setStore(trader);
		itemDto.setTax(tax);

//		itemDto = createItem(itemDto);

		model.addAttribute("items", itemDto);

		return "item_detail";

	}

}
