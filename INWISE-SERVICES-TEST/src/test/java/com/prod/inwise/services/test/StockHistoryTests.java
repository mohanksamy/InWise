package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STOCK_HISTORY;
import static org.apache.http.HttpStatus.SC_OK;

import java.math.BigDecimal;

import org.junit.Test;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.StockHistoryDTO;

/**
 * @author Logu
 *
 */
public class StockHistoryTests extends AbstractTests {
	
	private static final String ITEM_NAME = "Test Item";

	@Test
	public void createStockHistory() {


		ItemDTO item = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_ITEM, ITEM_NAME)).andReturn()
				.getBody().as(ItemDTO.class);

		StockHistoryDTO stockHistoryDTO = new StockHistoryDTO();
		
		stockHistoryDTO.setItem(item);
		stockHistoryDTO.setBasePrice(new BigDecimal(1000l));
		stockHistoryDTO.setQuantity(10);
		//stockHistoryDTO.setStockBatch(stockBatch);
		//stockHistoryDTO.setVendor(vendor);
		
		

		stockHistoryDTO.setActive(true);
		stockHistoryDTO.setCreatedUser("APP-SERVICES");
		stockHistoryDTO.setModifiedUser("APP-SERVICES");

		getRequestSpecificationWithJsonBody(stockHistoryDTO).post(getPath(RESOURCE_PATH_STOCK_HISTORY)).then().statusCode(SC_OK);
	}
}