package com.prod.inwise.fe.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.prod.inwise.fe.utilities.AttributeConstants;

@Controller
public abstract class BusinessController {

	private static final Logger logger = LoggerFactory.getLogger(BusinessController.class);

	protected Boolean isInsert(Map<String, String> requestParams) {
		logger.debug("Mode :" + requestParams.get(AttributeConstants.MODE));
		return AttributeConstants.INSERT.equals(requestParams.get(AttributeConstants.MODE));
	}
}