package com.prod.inwise.fe.controller;

import java.math.BigDecimal;
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

import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.dto.TraderDTO;
import com.prod.inwise.fe.services.TaxService;
import com.prod.inwise.fe.services.TraderService;
import com.prod.inwise.fe.utilities.AttributeConstants;
import com.prod.inwise.fe.utilities.MessageCode;
import com.prod.inwise.fe.utilities.RequestConstants;
import com.prod.inwise.fe.utilities.ViewNames;

@Controller
@RequestMapping("/")
public class TaxController extends BusinessController {

	private static final Logger logger = LoggerFactory.getLogger(TaxController.class);

	@Autowired
	private TraderService traderService;

	@Autowired
	private TaxService taxService;

	@RequestMapping(path = RequestConstants.VIEW_TAXES, method = { RequestMethod.GET, RequestMethod.POST })
	public String getTaxList(Model model, HttpSession session) throws Exception {

		List<TaxDTO> taxes = taxService
				.findAllTaxesByTraderId((BigInteger) session.getAttribute(AttributeConstants.TRADER_ID));

		model.addAttribute(AttributeConstants.TAX_LIST, taxes);

		return ViewNames.TAX_MASTER;
	}

	@RequestMapping(path = RequestConstants.CREATE_TAX, method = { RequestMethod.GET, RequestMethod.POST })
	public String addTax(Model model) throws Exception {

		TaxDTO taxDto = new TaxDTO();

		model.addAttribute(AttributeConstants.TAX, taxDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.INSERT);

		return ViewNames.TAX_DETAIL;
	}

	@RequestMapping(path = RequestConstants.EDIT_TAX, method = { RequestMethod.GET, RequestMethod.POST })
	public String editTax(@RequestParam("id") Long id, Model model, HttpSession session) throws Exception {

		logger.debug("editTax id [" + id + "]");

		TaxDTO taxDto = taxService.findTaxById((BigInteger) session.getAttribute(AttributeConstants.TRADER_ID), id);

		model.addAttribute(AttributeConstants.TAX, taxDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.UPDATE);

		return ViewNames.TAX_DETAIL;
	}

	@RequestMapping(path = RequestConstants.SAVE_TAX, method = { RequestMethod.GET, RequestMethod.POST })
	public String saveTax(@RequestParam Map<String, String> requestParams, Model model, HttpSession session)
			throws Exception {

		TaxDTO taxDto = setData(requestParams, (BigInteger) session.getAttribute(AttributeConstants.TRADER_ID),
				(String) session.getAttribute(AttributeConstants.TRADER_NAME));

		taxDto = taxService.saveTax((BigInteger) session.getAttribute(AttributeConstants.TRADER_ID), taxDto);

		model.addAttribute(AttributeConstants.TAX, taxDto);
		model.addAttribute(AttributeConstants.APPLICATION_STATUS, AttributeConstants.RS_SUCCESS);
		model.addAttribute(AttributeConstants.APPLICATION_MESSAGES, MessageCode.INFO_MSG_1001);

		return ViewNames.TAX_DETAIL;
	}

	private TaxDTO setData(Map<String, String> requestParams, BigInteger traderId, String traderName) throws Exception {

		TaxDTO taxDto = null;
		String taxId = requestParams.get(AttributeConstants.TAX_ID);

		logger.debug("Trader Id [" + traderId + "], Trader Name [" + traderName + "]");
		logger.debug("TaxDTO Mode [" + requestParams.get(AttributeConstants.MODE) + "]");
		if (AttributeConstants.INSERT.equals(requestParams.get(AttributeConstants.MODE))) {

			taxDto = new TaxDTO();

		} else {

			taxDto = taxService.findTaxById(traderId, Long.valueOf(taxId));
		}

		TraderDTO traderDto = traderService.findTraderByName(traderName);

		String cgst = requestParams.get(AttributeConstants.CGST);
		String sgst = requestParams.get(AttributeConstants.SGST);

		taxDto.setCgst(new BigDecimal(cgst));
		taxDto.setSgst(new BigDecimal(sgst));
		taxDto.setTrader(traderDto);
		taxDto.setActive(true);
		taxDto.setCreatedUser("APP-SERVICES");
		taxDto.setModifiedUser("APP-SERVICES");

		return taxDto;
	}
}