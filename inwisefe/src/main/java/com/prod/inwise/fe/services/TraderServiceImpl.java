package com.prod.inwise.fe.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prod.inwise.dto.TraderDTO;

/**
 * @author Logu
 *
 */

@Service
public class TraderServiceImpl implements TraderService {

	private static Logger log = LoggerFactory.getLogger(TraderServiceImpl.class);

	public TraderDTO findTraderByName(String name) throws Exception {

		log.debug(String.format("in Traderservice name: [%s]", name));

		ResponseEntity<String> response = ServicesGateway.invokeAPI(null,
				"http://localhost:8080/inwise/traders/" + name, HttpMethod.GET, null);

		JsonNode traderJson = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		ServicesGateway.removeUnwantedElements(traderJson);

		TraderDTO trader = (new ObjectMapper().treeToValue(traderJson, TraderDTO.class));

		System.out.println("Trader details received from Server: " + trader);

		return trader;

	}

	public TraderDTO findTraderById(Long id) throws Exception {

		ResponseEntity<String> response = ServicesGateway.invokeAPI(null, "http://localhost:8080/inwise/traders/" + id,
				HttpMethod.GET, null);

		JsonNode traderJson = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		ServicesGateway.removeUnwantedElements(traderJson);

		TraderDTO trader = (new ObjectMapper().treeToValue(traderJson, TraderDTO.class));

		System.out.println("Trader details received from Server: " + trader);

		return trader;

	}

	public TraderDTO createTrader(TraderDTO traderDto) throws Exception {

		ResponseEntity<String> response = ServicesGateway.invokeAPI(null, "http://localhost:8080/inwise/traders/",
				HttpMethod.POST, traderDto);

		JsonNode traderJson = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		ServicesGateway.removeUnwantedElements(traderJson);

		TraderDTO trader = (new ObjectMapper().treeToValue(traderJson, TraderDTO.class));

		System.out.println("Trader details received from Server: " + trader);

		return trader;

	}
}