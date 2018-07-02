package com.prod.inwise.fe.services.Impl;

import static com.prod.inwise.fe.services.ServicesGateway.invokeAPI;
import static com.prod.inwise.fe.services.ServicesGateway.removeUnwantedElements;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prod.inwise.dto.TraderDTO;
import com.prod.inwise.fe.services.TraderService;

/**
 * @author Logu
 *
 */

@Service
public class TraderServiceImpl implements TraderService {

	private static Logger logger = LoggerFactory.getLogger(TraderServiceImpl.class);

	@Override
	public List<TraderDTO> findAllTraders() throws Exception {

		List<TraderDTO> traders = new ArrayList<>();

		TraderDTO trader = new TraderDTO();

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/", HttpMethod.GET,
				null);
		JsonNode traderJsons = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		if (traderJsons.isArray()) {

			for (JsonNode traderJson : traderJsons) {

				String traderURI = traderJson.textValue();

				System.out.println("traderURI :" + traderURI);

				ResponseEntity<String> traderResponse = invokeAPI(null, traderURI, HttpMethod.GET, null);

				JsonNode jsonNode = new ObjectMapper().readValue(traderResponse.getBody(),
						new TypeReference<JsonNode>() {
						});

				removeUnwantedElements(jsonNode);

				trader = (new ObjectMapper().treeToValue(jsonNode, TraderDTO.class));

				System.out.println("Trader details received from Server: " + trader);

				traders.add(trader);
			}
		}

		return traders;

	}

	@Override
	public TraderDTO findTraderById(Long id) throws Exception {

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/" + id, HttpMethod.GET,
				null);

		JsonNode traderJson = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		removeUnwantedElements(traderJson);

		TraderDTO trader = (new ObjectMapper().treeToValue(traderJson, TraderDTO.class));

		System.out.println("Trader details received from Server: " + trader);

		return trader;

	}

	@Override
	public TraderDTO findTraderByName(String name) throws Exception {

		logger.debug(String.format("in Traderservice name: [%s]", name));

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/" + name,
				HttpMethod.GET, null);

		JsonNode traderJson = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		removeUnwantedElements(traderJson);

		TraderDTO trader = (new ObjectMapper().treeToValue(traderJson, TraderDTO.class));

		System.out.println("Trader details received from Server: " + trader);

		return trader;

	}

	@Override
	public TraderDTO saveTrader(TraderDTO traderDto) throws Exception {

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/", HttpMethod.POST,
				traderDto);

		// JsonNode traderJson = new ObjectMapper().readValue(response.getBody(), new
		// TypeReference<JsonNode>() {
		// });

		// removeUnwantedElements(traderJson);

		// TraderDTO trader = (new ObjectMapper().treeToValue(traderJson,
		// TraderDTO.class));

		traderDto = findTraderByName(traderDto.getName());

		System.out.println("Trader details received from Server: " + traderDto);

		return traderDto;

	}

}