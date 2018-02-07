package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_VENDOR;
import static org.apache.http.HttpStatus.SC_OK;

import java.math.BigInteger;

import org.junit.Test;

import com.prod.inwise.dto.VendorDTO;

/**
 * @author Logu
 *
 */
public class VendorTests extends AbstractTests {

	@Test
	public void createVendor() {

		VendorDTO vendorDTO = new VendorDTO();

		vendorDTO.setName("EFresh");
		vendorDTO.setCode("1234");
		vendorDTO.setAddress("Bangalore");
		vendorDTO.setPhone(new BigInteger("917760488623"));

		vendorDTO.setActive(true);
		vendorDTO.setCreatedUser("APP-SERVICES");
		vendorDTO.setModifiedUser("APP-SERVICES");

		getRequestSpecificationWithJsonBody(vendorDTO).post(getPath(RESOURCE_PATH_VENDOR)).then().statusCode(SC_OK);
	}
}