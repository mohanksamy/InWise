package com.prod.inwise.fe.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.fe.services.ItemService;
import com.prod.inwise.fe.services.TaxService;
import com.prod.inwise.fe.services.TraderService;
import com.prod.inwise.fe.utilities.AttributeConstants;
import com.prod.inwise.fe.utilities.MessageCode;
import com.prod.inwise.fe.utilities.RequestConstants;
import com.prod.inwise.fe.utilities.ViewNames;

@Controller
@RequestMapping("/")
public class ItemController extends BusinessController {

	private static final Logger logger = LoggerFactory.getLogger(TraderController.class);

	@Autowired
	private TraderService traderService;

	@Autowired
	private TaxService taxService;

	@Autowired
	private ItemService itemService;

	@RequestMapping(path = RequestConstants.VIEW_ITEMS, method = { RequestMethod.GET, RequestMethod.POST })
	public String getItemList(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		List<ItemDTO> items = itemService.findAllItems();

		model.addAttribute(AttributeConstants.ITEM_LIST, items);

		return ViewNames.ITEM_MASTER;
	}

	@RequestMapping(path = RequestConstants.CREATE_ITEM, method = { RequestMethod.GET, RequestMethod.POST })
	public String addItem(Model model) throws Exception {

		ItemDTO itemDto = new ItemDTO();

		model.addAttribute(AttributeConstants.ITEM_DTO, itemDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.INSERT);

		return ViewNames.ITEM_DETAIL;
	}

	@RequestMapping(path = RequestConstants.EDIT_ITEM, method = { RequestMethod.GET, RequestMethod.POST })
	public String editItem(@RequestParam("id") String id, Model model) throws Exception {

		ItemDTO itemDto = itemService.findItemById(Long.valueOf(id));

		model.addAttribute(AttributeConstants.ITEM_DTO, itemDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.UPDATE);

		return ViewNames.ITEM_DETAIL;
	}

	@RequestMapping(path = RequestConstants.SAVE_ITEM, method = { RequestMethod.GET, RequestMethod.POST })
	public String saveItem(@RequestParam Map<String, String> requestParams, Model model) throws Exception {

		ItemDTO itemDto = setData(requestParams);

		itemDto = itemService.saveItem(itemDto);

		model.addAttribute(AttributeConstants.TRADER, itemDto);
		model.addAttribute(AttributeConstants.APPLICATION_STATUS, AttributeConstants.RS_SUCCESS);
		model.addAttribute(AttributeConstants.APPLICATION_MESSAGES, MessageCode.INFO_MSG_1001);

		return ViewNames.ITEM_DETAIL;
	}

	private ItemDTO setData(Map<String, String> requestParams) throws Exception {

		ItemDTO itemDto = null;

		// String traderId = requestParams.get(AttributeConstants.TRADER_ID);
		// String taxId = requestParams.get(AttributeConstants.TAX_ID);
		String itemId = requestParams.get(AttributeConstants.ITEM_ID);

		logger.debug("TaxDTO Mode [" + requestParams.get(AttributeConstants.MODE) + "]");
		if (AttributeConstants.INSERT.equals(requestParams.get(AttributeConstants.MODE))) {

			itemDto = new ItemDTO();

		} else {

			itemDto = itemService.findItemById(Long.valueOf(itemId));
		}

		String name = requestParams.get(AttributeConstants.NAME);
		String code = requestParams.get(AttributeConstants.CODE);
		String partNo = requestParams.get(AttributeConstants.PART_NO);
		String price = requestParams.get(AttributeConstants.PRICE);

		itemDto.setName(name);
		itemDto.setCode(code);
		itemDto.setPartNo(new BigInteger(partNo));
		itemDto.setPrice(new BigDecimal(price));
		itemDto.setTrader(traderService.findTraderByName("VELSTORES"));
		itemDto.setTax(taxService.findTaxById(Long.valueOf(1)));
		itemDto.setActive(true);
		itemDto.setCreatedUser("APP-SERVICES");
		itemDto.setModifiedUser("APP-SERVICES");

		return itemDto;
	}
}