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
import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.fe.services.ItemService;

/**
 * @author Logu
 *
 */

@Service
public class ItemServiceImpl implements ItemService {

	private static Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Override
	public List<ItemDTO> findAllItemsByTraderId(Long traderId) throws Exception {

		List<ItemDTO> itemDtos = new ArrayList<>();

		ItemDTO itemDto = new ItemDTO();

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/"+traderId+"/items",
				HttpMethod.GET, null);
		JsonNode itemDtoJsons = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		if (itemDtoJsons.isArray()) {

			for (JsonNode itemJson : itemDtoJsons) {

				String uri = itemJson.textValue();

				System.out.println("uri :[" + uri + "]");
				logger.debug("uri :[" + uri + "]");

				ResponseEntity<String> itemResponse = invokeAPI(null, uri, HttpMethod.GET, null);

				JsonNode jsonNode = new ObjectMapper().readValue(itemResponse.getBody(), new TypeReference<JsonNode>() {
				});

			//	removeUnwantedElements(jsonNode);

				itemDto = (new ObjectMapper().treeToValue(jsonNode, ItemDTO.class));

				System.out.println("Item details received from Server: " + itemDto);

				itemDtos.add(itemDto);
			}
		}

		return itemDtos;

	}

	@Override
	public ItemDTO findItemById(Long id) throws Exception {

		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/1/items/" + id,
				HttpMethod.GET, null);

		JsonNode itemDtoJson = new ObjectMapper().readValue(response.getBody(), new TypeReference<JsonNode>() {
		});

		removeUnwantedElements(itemDtoJson);

		ItemDTO itemDto = (new ObjectMapper().treeToValue(itemDtoJson, ItemDTO.class));

		System.out.println("Item details received from Server: " + itemDto);

		return itemDto;

	}

	@Override
	public ItemDTO saveItem(ItemDTO itemDto) throws Exception {

		@SuppressWarnings("unused")
		ResponseEntity<String> response = invokeAPI(null, "http://localhost:8080/inwise/traders/1/items",
				HttpMethod.POST, itemDto);

		// JsonNode itemDtoJson = new ObjectMapper().readValue(response.getBody(), new
		// TypeReference<JsonNode>() {
		// });

		// removeUnwantedElements(itemDtoJson);

		// ItemDTO itemDto = (new ObjectMapper().treeToValue(itemDtoJson,
		// ItemDTO.class));

		// itemDto = findItemById(Long.valueOf(itemDto.getId()));

		System.out.println("Item details received from Server: " + itemDto);

		return itemDto;

	}
}