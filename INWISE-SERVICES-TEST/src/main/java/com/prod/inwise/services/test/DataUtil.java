package com.prod.inwise.services.test;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.StoreDTO;
import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.enums.Brand;
import com.prod.inwise.enums.Category;
import com.prod.inwise.enums.Size;
import com.prod.inwise.enums.SubCategory;

public class DataUtil {
	
	private static final DataFactory dataFactory = new DataFactory();
	
	private static final float minTax 			= 2.5f;
	
	private static final float maxTax 			= 15.0f;
	
	private static final float minPrice 			= 35.0f;
	
	private static final float maxPrice 			= 750.0f;
	
	private static final Random random 			= new Random();
	
	private static final NumberFormat number 	= NumberFormat.getNumberInstance();
	
	private static final String DATA_DELIMITER	= ",";
	
	private static final String STRING_SPACE		= " ";
	
	private static final String APP_USER			= "APP-SERVICES";

	public static StoreDTO getStore() {
		
		StoreDTO store = new StoreDTO();
		store.setName(dataFactory.getBusinessName());
		store.setAddress(dataFactory.getAddress() + DATA_DELIMITER + STRING_SPACE + dataFactory.getCity());
		store.setUin(dataFactory.getRandomChars(3).toUpperCase() + dataFactory.getNumberText(10));
		store.setPhone(new  BigInteger(dataFactory.getNumberText(10)));
		
		store.setActive(true);
		store.setCreatedUser(APP_USER);
		store.setModifiedUser(APP_USER);
		
		return store;
	}
	
	public static TaxDTO getTax(StoreDTO store) {
		
		number.setMaximumFractionDigits(2);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(Float.parseFloat(number.format(random.nextFloat() * (maxTax - minTax) + minTax)));
		tax.setSgst(Float.parseFloat(number.format(random.nextFloat() * (maxTax - minTax) + minTax)));
		tax.setCreatedUser(APP_USER);
		tax.setModifiedUser(APP_USER);
		
		tax.setStore(store);
		
		return tax;
	}
	
	public static List<ItemDTO> getItem(TaxDTO tax) {
		
		number.setMaximumFractionDigits(2);
		
		List<ItemDTO> items = new ArrayList<>(0);
		
		for ( int index = 0; index <= dataFactory.getNumberUpTo(30); index++ ) {
		
			ItemDTO item = new ItemDTO();
			item.setName(dataFactory.getRandomWord() + " item");
			item.setPrice(Float.parseFloat(number.format(random.nextFloat() * (maxPrice - minPrice) + minPrice)));
			
			item.setCategory(dataFactory.getItem(Category.values()));
			item.setSubCategory(dataFactory.getItem(SubCategory.values()));
			item.setBrand(dataFactory.getItem(Brand.values()));
			item.setSize(dataFactory.getItem(Size.values()));
			
			item.setTax(tax);
			item.setStore(tax.getStore());
			
			item.setCreatedUser(APP_USER);
			item.setModifiedUser(APP_USER);
			
			items.add(item);
		}
		
		return items;
	}
}