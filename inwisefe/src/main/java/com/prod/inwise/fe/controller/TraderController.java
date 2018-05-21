package com.prod.inwise.fe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import static com.prod.inwise.fe.services.ServicesGateway.getTrader;

import com.prod.inwise.dto.TraderDTO;



import java.util.ArrayList;
import java.util.List;

@Controller
public class TraderController {

	private static final Logger logger = LoggerFactory.getLogger(TraderController.class);

	@GetMapping(value = "/traders")
	public String getTraderList(Model model) throws Exception {
		logger.info("Entering into getTraderList...");

		// List<TraderDTO> dtos = getTrader();

		List<TraderDTO> dtos = new ArrayList<>();

		model.addAttribute("traders", dtos);

		return "trader_master";
	}

	@GetMapping(value = "/addTrader")
	public String addTrader(Model model) throws Exception {

		TraderDTO dto = new TraderDTO();

		model.addAttribute("trader", dto);

		return "trader_detail";
	}

	@GetMapping(value = "/editTrader")
	public String editTrader(Model model) throws Exception {

		TraderDTO dto = getTrader();	

		model.addAttribute("trader", dto);

		return "trader_detail";
	}


}
