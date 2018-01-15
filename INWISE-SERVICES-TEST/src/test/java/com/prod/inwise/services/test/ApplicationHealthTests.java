package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_HEALTH;
import static org.apache.http.HttpStatus.SC_OK;

import org.junit.Test;

/**
 * @author mohan_kandasamy
 *
 */
public class ApplicationHealthTests extends AbstractTests {

	@Test
	public void createStore() {
		getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_HEALTH)).then().statusCode(SC_OK);
	}
}