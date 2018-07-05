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
import com.prod.inwise.dto.InvoiceDTO;
import com.prod.inwise.fe.services.InvoiceService;

/**
 * @author Logu
 *
 */

@Service
public class InvoiceServiceImpl implements InvoiceService {

	private static Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

	@Override
	public List<InvoiceDTO> findAllInvoices() throws Exception {

		List<InvoiceDTO> invoices = new ArrayList<>();

		InvoiceDTO invoiceDto = new InvoiceDTO();

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/1/invoices",
				HttpMethod.GET, null);
		JsonNode invoiceJosons = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		if (invoiceJosons.isArray()) {

			for (JsonNode invoiceJson : invoiceJosons) {

				String uri = invoiceJson.textValue();

				System.out.println("uri :" + uri);
				logger.debug("uri :" + uri);

				ResponseEntity<String> invoiceResponse = invokeAPI(null, uri, HttpMethod.GET, null);

				JsonNode jsonNode = new ObjectMapper().readValue(invoiceResponse.getBody(),
						new TypeReference<JsonNode>() {
						});

				// removeUnwantedElements(jsonNode);

				invoiceDto = (new ObjectMapper().treeToValue(jsonNode, InvoiceDTO.class));

				System.out.println("Invoice details received from Server: " + invoiceDto);

				invoices.add(invoiceDto);
			}
		}

		return invoices;
	}

	@Override
	public InvoiceDTO findInvoiceById(Long id) throws Exception {

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/1/invoices/" + id,
				HttpMethod.GET, null);

		JsonNode invoiceJson = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		removeUnwantedElements(invoiceJson);

		InvoiceDTO invoiceDto = (new ObjectMapper().treeToValue(invoiceJson, InvoiceDTO.class));

		System.out.println("Invoice details received from Server: " + invoiceDto);

		return invoiceDto;
	}

	@Override
	public InvoiceDTO saveInvoice(InvoiceDTO invoiceDto) throws Exception {

		@SuppressWarnings("unused")
		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/1/invoices",
				HttpMethod.POST, invoiceDto);

		// JsonNode traderJson = new ObjectMapper().readValue(response.getBody(), new
		// TypeReference<JsonNode>() {
		// });

		// removeUnwantedElements(traderJson);

		// InvoiceDTO trader = (new ObjectMapper().treeToValue(traderJson,
		// InvoiceDTO.class));

		// taxDTO = findTraderByName(taxDTO.getName());

		System.out.println("Invoice details received from Server: " + invoiceDto);

		return invoiceDto;
	}
}