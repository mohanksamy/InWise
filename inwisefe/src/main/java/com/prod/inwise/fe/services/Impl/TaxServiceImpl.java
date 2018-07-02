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
import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.fe.services.TaxService;

/**
 * @author Logu
 *
 */

@Service
public class TaxServiceImpl implements TaxService {

	private static Logger logger = LoggerFactory.getLogger(TaxServiceImpl.class);

	@Override
	public List<TaxDTO> findAllTaxes() throws Exception {

		List<TaxDTO> taxes = new ArrayList<>();

		TaxDTO taxDto = new TaxDTO();

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/1/taxes",
				HttpMethod.GET, null);
		JsonNode taxJosons = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		if (taxJosons.isArray()) {

			for (JsonNode taxJson : taxJosons) {

				String uri = taxJson.textValue();

				System.out.println("uri :" + uri);
				logger.debug("uri :" + uri);

				ResponseEntity<String> taxResponse = invokeAPI(null, uri, HttpMethod.GET, null);

				JsonNode jsonNode = new ObjectMapper().readValue(taxResponse.getBody(), new TypeReference<JsonNode>() {
				});

				removeUnwantedElements(jsonNode);

				taxDto = (new ObjectMapper().treeToValue(jsonNode, TaxDTO.class));

				System.out.println("Tax details received from Server: " + taxDto);

				taxes.add(taxDto);
			}
		}

		return taxes;

	}

	@Override
	public TaxDTO findTaxById(Long id) throws Exception {

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/1/taxes/" + id,
				HttpMethod.GET, null);

		JsonNode taxJson = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		removeUnwantedElements(taxJson);

		TaxDTO taxDto = (new ObjectMapper().treeToValue(taxJson, TaxDTO.class));

		System.out.println("Tax details received from Server: " + taxDto);

		return taxDto;

	}

	@Override
	public TaxDTO saveTax(TaxDTO taxDTO) throws Exception {

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/1/taxes",
				HttpMethod.POST, taxDTO);

		// JsonNode traderJson = new ObjectMapper().readValue(response.getBody(), new
		// TypeReference<JsonNode>() {
		// });

		// removeUnwantedElements(traderJson);

		// TaxDTO trader = (new ObjectMapper().treeToValue(traderJson,
		// TaxDTO.class));

		// taxDTO = findTraderByName(taxDTO.getName());

		System.out.println("Tax details received from Server: " + taxDTO);

		return taxDTO;

	}
}