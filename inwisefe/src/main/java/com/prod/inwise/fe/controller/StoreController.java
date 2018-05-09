package com.prod.inwise.fe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prod.inwise.dto.StoreDTO;

import static com.prod.inwise.fe.services.ServicesGateway.getStore;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {

	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

	@GetMapping(value = "/stores")
	public String getStoreList(Model model) throws Exception {
		logger.info("Entering into getStores...");

		// List<StoreDTO> dtos = getStores();

		List<StoreDTO> dtos = new ArrayList<>();

		model.addAttribute("stores", dtos);

		return "store_master";
	}

	@GetMapping(value = "/addStore")
	public String addStore(Model model) throws Exception {

		StoreDTO dto = new StoreDTO();

		model.addAttribute("storeValue", dto);

		return "store_detail";
	}

	@GetMapping(value = "/editStore")
	public String editStore(Model model) throws Exception {

		StoreDTO dto = getStore();

		model.addAttribute("storeValue", dto);

		return "store_detail";
	}

}
