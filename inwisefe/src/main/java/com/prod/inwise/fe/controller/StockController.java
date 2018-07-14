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

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.StockDTO;
import com.prod.inwise.fe.services.ItemService;
import com.prod.inwise.fe.services.StockService;
import com.prod.inwise.fe.utilities.AttributeConstants;
import com.prod.inwise.fe.utilities.MessageCode;
import com.prod.inwise.fe.utilities.RequestConstants;
import com.prod.inwise.fe.utilities.ViewNames;

@Controller
@RequestMapping("/")
public class StockController extends BusinessController {

	private static final Logger logger = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private ItemService itemService;

	@Autowired
	private StockService stockService;

	@RequestMapping(path = RequestConstants.VIEW_STOCKS, method = { RequestMethod.GET, RequestMethod.POST })
	public String getStockList(Model model, HttpSession session) throws Exception {

		List<StockDTO> stocks = stockService
				.findAllStocksByTraderId((BigInteger) session.getAttribute(AttributeConstants.TRADER_ID));

		model.addAttribute(AttributeConstants.STOCK_LIST, stocks);

		return ViewNames.STOCK_MASTER;
	}

	@RequestMapping(path = RequestConstants.CREATE_STOCK, method = { RequestMethod.GET, RequestMethod.POST })
	public String addStock(Model model, HttpSession session) throws Exception {

		StockDTO stockDto = new StockDTO();

		List<ItemDTO> itemDtos = itemService
				.findAllItemsByTraderId((BigInteger) session.getAttribute(AttributeConstants.TRADER_ID));

		model.addAttribute(AttributeConstants.ITEM_LIST, itemDtos);
		model.addAttribute(AttributeConstants.STOCK, stockDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.INSERT);

		return ViewNames.STOCK_DETAIL;
	}

	@RequestMapping(path = RequestConstants.EDIT_STOCK, method = { RequestMethod.GET, RequestMethod.POST })
	public String editStock(@RequestParam("id") Long id, Model model, HttpSession session) throws Exception {

		logger.debug("editStock id [" + id + "]");

		StockDTO stockDto = stockService.findStockById((BigInteger) session.getAttribute(AttributeConstants.TRADER_ID),
				id);

		model.addAttribute(AttributeConstants.STOCK, stockDto);
		model.addAttribute(AttributeConstants.MODE, AttributeConstants.UPDATE);

		return ViewNames.STOCK_DETAIL;
	}

	@RequestMapping(path = RequestConstants.SAVE_STOCK, method = { RequestMethod.GET, RequestMethod.POST })
	public String saveStock(@RequestParam Map<String, String> requestParams, Model model, HttpSession session)
			throws Exception {

		StockDTO stockDto = setData(requestParams, (BigInteger) session.getAttribute(AttributeConstants.TRADER_ID));

		stockDto = stockService.saveStock((BigInteger) session.getAttribute(AttributeConstants.TRADER_ID), stockDto);

		model.addAttribute(AttributeConstants.STOCK, stockDto);
		model.addAttribute(AttributeConstants.APPLICATION_STATUS, AttributeConstants.RS_SUCCESS);
		model.addAttribute(AttributeConstants.APPLICATION_MESSAGES, MessageCode.INFO_MSG_1001);

		return ViewNames.STOCK_DETAIL;
	}

	private StockDTO setData(Map<String, String> requestParams, BigInteger traderId) throws Exception {

		StockDTO stockDto = null;
		String stockId = requestParams.get(AttributeConstants.STOCK_ID);
		String itemId = requestParams.get(AttributeConstants.ITEM_NAME);

		logger.debug(" Trader Id [ " + traderId + "], ItemId [" + itemId + "], StockId [" + stockId + "]");

		logger.debug("StockDTO Mode [" + requestParams.get(AttributeConstants.MODE) + "]");
		if (AttributeConstants.INSERT.equals(requestParams.get(AttributeConstants.MODE))) {

			stockDto = new StockDTO();
			stockDto.setItem(itemService.findItemById(traderId, Long.valueOf(itemId)));
		} else {

			stockDto = stockService.findStockById(traderId, Long.valueOf(stockId));
		}

		String quantity = requestParams.get(AttributeConstants.QUANTITY);
		stockDto.setQuantity(Integer.valueOf(quantity));
		stockDto.setActive(true);
		stockDto.setCreatedUser("APP-SERVICES");
		stockDto.setModifiedUser("APP-SERVICES");

		return stockDto;
	}
}