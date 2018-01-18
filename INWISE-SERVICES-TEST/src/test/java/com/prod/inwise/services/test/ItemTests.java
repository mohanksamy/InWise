package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STORE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TAX;
import static org.apache.http.HttpStatus.SC_OK;

import org.junit.Test;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.enums.Brand;
import com.prod.inwise.enums.Category;
import com.prod.inwise.enums.Size;
import com.prod.inwise.enums.SubCategory;

/**
 * @author mohan_kandasamy
 *
 */
public class ItemTests extends AbstractTests {
	
	private static final String STORE_NAME	= "Vel Stores";

	@Test
	public void createItem() {
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_STORE, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Test Item");
		item.setPrice(213f);
		
		item.setCategory(Category.BABY_GIRLS);
		item.setSubCategory(SubCategory.FROCK);
		item.setBrand(Brand.EFRESH);
		item.setSize(Size.S_55);
		
		item.setTax(tax);
		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
}