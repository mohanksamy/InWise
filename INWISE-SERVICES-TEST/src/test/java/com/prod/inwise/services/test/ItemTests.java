package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TAX;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TRADERS;
import static org.apache.http.HttpStatus.SC_OK;

import java.math.BigDecimal;

import org.junit.Test;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.TaxDTO;

/**
 * @author mohan_kandasamy
 *
 */
public class ItemTests extends AbstractTests {
	
	private static String STORE_NAME	= "Vel Stores";

	@Test
	public void createItem1() {
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Test Item");
		item.setPrice(new BigDecimal(213f));
		
//		item.setCategory(Category.BABY_GIRLS);
//		item.setSubCategory(SubCategory.FROCK);
//		item.setBrand(Brand.EFRESH);
//		item.setSize(Size.S_55);
		
		item.setTax(tax);
//		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createItem2() {
		
		STORE_NAME = "STORE-A";
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Item-X7");
		item.setPrice(new BigDecimal(23f));
		
		/*item.setCategory(Category.MENS);
		item.setSubCategory(SubCategory.OUTFITTINGS);
		item.setBrand(Brand.POOMEX);
		item.setSize(Size.XL);*/
		
		item.setTax(tax);
//		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createItem3() {
		
		STORE_NAME = "STORE-B";
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Item-X4");
		item.setPrice(new BigDecimal(26f));
		
		/*item.setCategory(Category.BOYS);
		item.setSubCategory(SubCategory.TOP);
		item.setBrand(Brand.POOMER);
		item.setSize(Size.S_70);*/
		
		item.setTax(tax);
//		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createItem4() {
		
		STORE_NAME = "STORE-C";
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Item-X8");
		item.setPrice(new BigDecimal(118f));
		
		/*item.setCategory(Category.MENS);
		item.setSubCategory(SubCategory.BOTTOM);
		item.setBrand(Brand.GRS);
		item.setSize(Size.L);*/
		
		item.setTax(tax);
//		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createItem5() {
		
		STORE_NAME = "STORE-D";
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Item-X5");
		item.setPrice(new BigDecimal(34f));
		
		/*item.setCategory(Category.BABY_GIRLS);
		item.setSubCategory(SubCategory.OUTFITTINGS);
		item.setBrand(Brand.POOMEX);
		item.setSize(Size.M);*/
		
		item.setTax(tax);
//		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createItem6() {
		
		STORE_NAME = "STORE-E";
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Item-X6");
		item.setPrice(new BigDecimal(31f));
		
		/*item.setCategory(Category.BABY_BOYS);
		item.setSubCategory(SubCategory.OUTFITTINGS);
		item.setBrand(Brand.GRS);
		item.setSize(Size.S_35);*/
		
		item.setTax(tax);
//		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createItem7() {
		
		STORE_NAME = "STORE-F";
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Item-X3");
		item.setPrice(new BigDecimal(13f));
		
		/*item.setCategory(Category.BABY_GIRLS);
		item.setSubCategory(SubCategory.TOP);
		item.setBrand(Brand.EFRESH);
		item.setSize(Size.S_40);*/
		
		item.setTax(tax);
//		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createItem8() {
		
		STORE_NAME = "STORE-A";
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Test Item");
		item.setPrice(new BigDecimal(25f));
		
		/*item.setCategory(Category.GIRLS);
		item.setSubCategory(SubCategory.FROCK);
		item.setBrand(Brand.POOMEX);
		item.setSize(Size.S_30);*/
		
		item.setTax(tax);
//		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createItem9() {
		
		STORE_NAME = "STORE-C";
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Item-X2");
		item.setPrice(new BigDecimal(17f));
		
		/*item.setCategory(Category.WOMENS);
		item.setSubCategory(SubCategory.OUTFITTINGS);
		item.setBrand(Brand.GRS);
		item.setSize(Size.S_50);*/
		
		item.setTax(tax);
//		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
	
	@Test
	public void createItem10() {
		
		STORE_NAME = "STORE-E";
		
		TaxDTO tax = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_TAX, RESOURCE_PATH_TRADERS, STORE_NAME)).andReturn().getBody().as(TaxDTO.class);
		
		ItemDTO item = new ItemDTO();
		item.setName("Item-X1");
		item.setPrice(new BigDecimal(53f));
		
		/*item.setCategory(Category.BOYS);
		item.setSubCategory(SubCategory.INNERS);
		item.setBrand(Brand.POOMER);
		item.setSize(Size.S_55);*/
		
		item.setTax(tax);
//		item.setStore(tax.getStore());
		
		item.setCreatedUser(tax.getCreatedUser());
		item.setModifiedUser(tax.getModifiedUser());
		
		getRequestSpecificationWithJsonBody(item).post(getPath(RESOURCE_PATH_ITEM)).then().statusCode(SC_OK);
	}
}