package com.prod.inwise.fe.services.Impl;

import static com.prod.inwise.fe.services.ServicesGateway.invokeAPI;
import static com.prod.inwise.fe.services.ServicesGateway.removeUnwantedElements;

import java.math.BigInteger;
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
import com.prod.inwise.dto.StockDTO;
import com.prod.inwise.fe.services.StockService;

/**
 * @author Logu
 *
 */

@Service
public class StockServiceImpl implements StockService {

	private static Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

	@Override
	public List<StockDTO> findAllStocksByTraderId(BigInteger traderId) throws Exception {

		List<StockDTO> stocks = new ArrayList<>();

		StockDTO stockDto = new StockDTO();

		ResponseEntity<String> response = invokeAPI(null,
				"http://localhost:8080/inwise/traders/" + traderId + "/stocks", HttpMethod.GET, null);
		JsonNode stockJosons = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		if (stockJosons.isArray()) {

			for (JsonNode stockJson : stockJosons) {

				String uri = stockJson.textValue();

				System.out.println("uri :" + uri);
				logger.debug("uri :" + uri);

				ResponseEntity<String> stockResponse = invokeAPI(null, uri, HttpMethod.GET, null);

				JsonNode jsonNode = new ObjectMapper().readValue(stockResponse.getBody(),
						new TypeReference<JsonNode>() {
						});

				// removeUnwantedElements(jsonNode);

				stockDto = (new ObjectMapper().treeToValue(jsonNode, StockDTO.class));

				System.out.println("Stock details received from Server: " + stockDto);

				stocks.add(stockDto);
			}
		}

		return stocks;
	}

	@Override
	public StockDTO findStockById(BigInteger traderId, Long stockId) throws Exception {

		ResponseEntity<String> response = invokeAPI(null,
				"http://localhost:8080/inwise/traders/" + traderId + "/stocks/" + stockId, HttpMethod.GET, null);

		JsonNode stockJson = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		removeUnwantedElements(stockJson);

		StockDTO stockDto = (new ObjectMapper().treeToValue(stockJson, StockDTO.class));

		System.out.println("Stock details received from Server: " + stockDto);

		return stockDto;
	}

	@Override
	public StockDTO saveStock(BigInteger traderId, StockDTO stockDto) throws Exception {

		@SuppressWarnings("unused")
		ResponseEntity<String> response = invokeAPI(null,
				"http://localhost:8080/inwise/traders/" + traderId + "/stocks", HttpMethod.POST, stockDto);

		// JsonNode traderJson = new ObjectMapper().readValue(response.getBody(), new
		// TypeReference<JsonNode>() {
		// });

		// removeUnwantedElements(traderJson);

		// TaxDTO trader = (new ObjectMapper().treeToValue(traderJson,
		// TaxDTO.class));

		// taxDTO = findTraderByName(taxDTO.getName());

		System.out.println("Stock details received from Server: " + stockDto);

		return stockDto;
	}
}