package com.prod.inwise.fe.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prod.inwise.dto.AddressDTO;
import com.prod.inwise.dto.TraderDTO;
import com.prod.inwise.fe.services.TraderService;
import com.prod.inwise.fe.utilities.AttributeConstants;
import com.prod.inwise.fe.utilities.MessageCode;
import com.prod.inwise.fe.utilities.RequestConstants;
import com.prod.inwise.fe.utilities.ViewNames;

@Controller
@RequestMapping("/")
public class TraderController extends BusinessController {

	private static final Logger logger = LoggerFactory.getLogger(TraderController.class);

	@Autowired
	private TraderService traderService;

	@RequestMapping(path = RequestConstants.VIEW_TRADERS, method = { RequestMethod.GET, RequestMethod.POST })
	public String getTraderList(Model model) throws Exception {

		List<TraderDTO> traders = traderService.findAllTraders();

		model.addAttribute(AttributeConstants.TRADER_LIST, traders);

		return ViewNames.TRADER_MASTER;
	}

	@RequestMapping(path = RequestConstants.CREATE_TRADER, method = { RequestMethod.GET, RequestMethod.POST })
	public String addTrader(Model model) throws Exception {

		TraderDTO traderDto = new TraderDTO();

		model.addAttribute(AttributeConstants.TRADER, traderDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.INSERT);

		return ViewNames.TRADER_DETAIL;
	}

	@RequestMapping(path = RequestConstants.EDIT_TRADER, method = { RequestMethod.GET, RequestMethod.POST })
	public String editTrader(@RequestParam("name") String name, Model model) throws Exception {

		logger.debug("editTrader Name [" + name + "]");

		TraderDTO traderDto = traderService.findTraderByName(name);

		model.addAttribute(AttributeConstants.TRADER, traderDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.UPDATE);

		return ViewNames.TRADER_DETAIL;
	}

	@RequestMapping(path = RequestConstants.SAVE_TRADER, method = { RequestMethod.GET, RequestMethod.POST })
	public String saveTrader(@RequestParam Map<String, String> requestParams, Model model, HttpSession session) throws Exception {

		TraderDTO traderDto = setData(requestParams);

		traderDto = traderService.saveTrader(traderDto);

		model.addAttribute(AttributeConstants.TRADER, traderDto);
		model.addAttribute(AttributeConstants.APPLICATION_STATUS, AttributeConstants.RS_SUCCESS);
		model.addAttribute(AttributeConstants.APPLICATION_MESSAGES, MessageCode.INFO_MSG_1001);
		session.setAttribute(AttributeConstants.TRADER_ID, traderDto.getId());
		session.setAttribute(AttributeConstants.TRADER_NAME, traderDto.getName());
		
		return ViewNames.TRADER_DETAIL;
	}

	private TraderDTO setData(Map<String, String> requestParams) throws Exception {

		TraderDTO traderDto = null;
		AddressDTO addressDto = new AddressDTO();

		String name = requestParams.get(AttributeConstants.NAME);

		logger.debug("Mode :" + requestParams.get(AttributeConstants.MODE));
		if (AttributeConstants.INSERT.equals(requestParams.get(AttributeConstants.MODE))) {

			traderDto = new TraderDTO();
			addressDto = new AddressDTO();

		} else {

			traderDto = traderService.findTraderByName(name);
			addressDto = traderDto.getAddress();

			logger.debug("Trader Id " + traderDto.getId());
			logger.debug("address Id " + addressDto.getId());

		}

		String code = requestParams.get(AttributeConstants.CODE);
		String uin = requestParams.get(AttributeConstants.UIN);
		String phone = requestParams.get(AttributeConstants.PHONE);

		String street1 = requestParams.get(AttributeConstants.STREET1);
		String street2 = requestParams.get(AttributeConstants.STREET2);
		String city = requestParams.get(AttributeConstants.CITY);
		String region = requestParams.get(AttributeConstants.REGION);
		String state = requestParams.get(AttributeConstants.STATE);
		String country = requestParams.get(AttributeConstants.COUNTRY);
		String postalCode = requestParams.get(AttributeConstants.POSTALCODE);

		traderDto.setName(name);
		traderDto.setCode(code);
		traderDto.setUin(uin);
		traderDto.setPhone(phone != null ? new BigInteger(phone) : null);
		traderDto.setActive(true);
		traderDto.setCreatedUser("APP-SERVICES");
		traderDto.setModifiedUser("APP-SERVICES");

		addressDto.setStreet1(street1);
		addressDto.setStreet2(street2);
		addressDto.setCity(city);
		addressDto.setRegion(region);
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