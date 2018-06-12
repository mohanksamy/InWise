package com.prod.inwise.fe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prod.inwise.dto.AddressDTO;
import com.prod.inwise.dto.TraderDTO;
import com.prod.inwise.fe.services.TraderService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TraderController {

	private static final Logger logger = LoggerFactory.getLogger(TraderController.class);

	@Autowired
	private TraderService traderService;

	@GetMapping(value = "/traders")
	public String getTraderList(Model model) throws Exception {
		logger.info("Entering into getTraderList...");

		// List<TraderDTO> dtos = traderService.findAllTraders();

		List<TraderDTO> dtos = new ArrayList<>();

		model.addAttribute("traders", dtos);

		return "trader_master";
	}

	@GetMapping(value = "/createTrader")
	public String addTrader(Model model) throws Exception {

		TraderDTO dto = new TraderDTO();

		model.addAttribute("trader", dto);

		return "trader_detail";
	}

	@GetMapping(value = "/editTrader")
	public String editTrader(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		String id = requestParams.get("id");
		Long traderId = Long.valueOf(id);

		TraderDTO dto = traderService.findTraderById(traderId);

		model.addAttribute("trader", dto);

		return "trader_detail";
	}

	@PostMapping(value = "/saveTrader")
	public String saveTrader(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		TraderDTO traderDto = setData(requestParams);

		traderDto = traderService.createTrader(traderDto);

		model.addAttribute("trader", traderDto);

		return "trader_detail";
	}

	private TraderDTO setData(Map<String, String> requestParams) {
		TraderDTO traderDto = new TraderDTO();
		AddressDTO addressDto = new AddressDTO();

		String name = requestParams.get("name");
		String code = requestParams.get("code");
		String uin = requestParams.get("uin");
		String phone = requestParams.get("phone");

		String street1 = requestParams.get("street1");
		String street2 = requestParams.get("street2");
		String city = requestParams.get("city");
		String state = requestParams.get("state");
		String country = requestParams.get("country");
		String postalCode = requestParams.get("postalCode");

		traderDto.setName(name);
		traderDto.setCode(code);
		traderDto.setUin(uin);
		traderDto.setPhone(new BigInteger(phone));
		traderDto.setActive(true);
		traderDto.setCreatedUser("APP-SERVICES");
		traderDto.setModifiedUser("APP-SERVICES");
		// traderDto.setCreatedTS(new Timestamp());

		addressDto.setStreet1(street1);
		addressDto.setStreet2(street2);
		addressDto.setCity(city);
		addressDto.setState(state);
		addressDto.setCountry(country);
		addressDto.setPostalCode(postalCode);
		addressDto.setActive(true);
		addressDto.setCreatedUser("APP-SERVICES");
		addressDto.setModifiedUser("APP-SERVICES");

		traderDto.setAddress(addressDto);

		return traderDto;
	}
}