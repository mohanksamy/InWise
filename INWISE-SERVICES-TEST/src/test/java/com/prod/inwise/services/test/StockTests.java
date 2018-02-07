package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STOCK;
import static org.apache.http.HttpStatus.SC_OK;

import org.junit.Test;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.StockDTO;

/**
 * @author Logu
 *
 */
public class StockTests extends AbstractTests {

	private static final String ITEM_NAME = "Test Item";

	@Test
	public void createStock() {

		ItemDTO item = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_ITEM, ITEM_NAME)).andReturn()
				.getBody().as(ItemDTO.class);

		StockDTO stockDTO = new StockDTO();

		stockDTO.setItem(item);
		stockDTO.setQuantity(1);

		stockDTO.setActive(true);
		stockDTO.setCreatedUser("APP-SERVICES");
		stockDTO.setModifiedUser("APP-SERVICES");

		getRequestSpecificationWithJsonBody(stockDTO).post(getPath(RESOURCE_PATH_STOCK)).then().statusCode(SC_OK);
	}
}