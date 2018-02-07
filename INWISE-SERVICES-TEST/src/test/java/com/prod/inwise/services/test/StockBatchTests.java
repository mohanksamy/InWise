package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STOCK_BATCH;
import static org.apache.http.HttpStatus.SC_OK;

import org.junit.Test;

import com.prod.inwise.dto.StockBatchDTO;

/**
 * @author Logu
 *
 */
public class StockBatchTests extends AbstractTests {

	@Test
	public void createStockBatch() {

		StockBatchDTO stockBatchDTO = new StockBatchDTO();

		stockBatchDTO.setActive(true);
		stockBatchDTO.setCreatedUser("APP-SERVICES");
		stockBatchDTO.setModifiedUser("APP-SERVICES");

		getRequestSpecificationWithJsonBody(stockBatchDTO).post(getPath(RESOURCE_PATH_STOCK_BATCH)).then().statusCode(SC_OK);
	}
}