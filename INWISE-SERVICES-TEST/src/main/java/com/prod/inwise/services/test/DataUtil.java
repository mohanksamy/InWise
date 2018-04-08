package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.APP_USER;
import static com.prod.inwise.services.test.util.Constants.DATA_DELIMITER;
import static com.prod.inwise.services.test.util.Constants.STRING_SPACE;
import static com.prod.inwise.services.test.util.Constants.number;
import static com.prod.inwise.services.test.util.Constants.random;
import static java.lang.Float.parseFloat;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.LineItemDTO;
import com.prod.inwise.dto.StockHistoryDTO;
import com.prod.inwise.dto.StoreDTO;
import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.dto.VendorDTO;
import com.prod.inwise.enums.Brand;
import com.prod.inwise.enums.Category;
import com.prod.inwise.enums.Size;
import com.prod.inwise.enums.SubCategory;

public final class DataUtil {
	
	private static final DataFactory dataFactory = new DataFactory();
	
	private static final float minTax 			= 2.5f;
	
	private static final float maxTax 			= 15.0f;
	
	private static final float minPrice 			= 35.0f;
	
	private static final float maxPrice 			= 750.0f;

	public static StoreDTO getStore() {
		
		StoreDTO store = new StoreDTO();
		store.setName(dataFactory.getBusinessName());
		store.setAddress(getString(dataFactory.getAddress(), DATA_DELIMITER, STRING_SPACE, dataFactory.getCity()));
		store.setUin(getString(dataFactory.getRandomChars(3).toUpperCase(), dataFactory.getNumberText(10)));
		store.setPhone(new BigInteger(dataFactory.getNumberText(10)));
		
		store.setActive(true);
		store.setCreatedUser(APP_USER);
		store.setModifiedUser(APP_USER);
		
		return store;
	}
	
	public static TaxDTO getTax(StoreDTO store) {
		
		number.setMaximumFractionDigits(2);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(parseFloat(number.format(random.nextFloat() * (maxTax - minTax) + minTax)));
		tax.setSgst(parseFloat(number.format(random.nextFloat() * (maxTax - minTax) + minTax)));
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
			item.setName(getString(dataFactory.getRandomChars(15).toUpperCase(), Integer.toString(random.nextInt(1000))/*, STRING_SPACE, ITEM_SUFFIX*/));
			item.setPrice(parseFloat(number.format(random.nextFloat() * (maxPrice - minPrice) + minPrice)));
			
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
	
	public static VendorDTO getVendor() {
		
		VendorDTO vendor = new VendorDTO();
		vendor.setName(dataFactory.getBusinessName());
		vendor.setCode(vendor.getName().toUpperCase());
		vendor.setAddress(getString(dataFactory.getAddress(), DATA_DELIMITER, STRING_SPACE, dataFactory.getCity()));
		vendor.setPhone(new BigInteger(dataFactory.getNumberText(10)));
		
		vendor.setActive(true);
		vendor.setCreatedUser(APP_USER);
		vendor.setModifiedUser(APP_USER);
		
		return vendor;
	}
	
	public static List<StockHistoryDTO> getStockHistories() {
		
		List<StockHistoryDTO> stockHistories = new ArrayList<>();
		
		for ( int index = 0; index <= dataFactory.getNumberBetween(3, 15); index++ ) {
			
			StockHistoryDTO stockHistory = new StockHistoryDTO();
			stockHistory.setBasePrice(Integer.valueOf(dataFactory.getNumberBetween(10, 100)).longValue());
			stockHistory.setQuantity(Integer.valueOf(dataFactory.getNumberBetween(3, 20)));
			
			stockHistory.setActive(true);
			stockHistory.setCreatedUser(APP_USER);
			stockHistory.setModifiedUser(APP_USER);
			
			stockHistories.add(stockHistory);
		}
		
		return stockHistories;
	}
	
	public static List<LineItemDTO> getLineItems() {
		
		List<LineItemDTO> lineItems = new ArrayList<>();
		
		for ( int index = 0; index <= dataFactory.getNumberBetween(3, 10); index++ ) {
			
			LineItemDTO lineItem = new LineItemDTO();
			lineItem.setQuantity(Integer.valueOf(dataFactory.getNumberBetween(3, 20)));
			
			lineItem.setActive(true);
			lineItem.setCreatedUser(APP_USER);
			lineItem.setModifiedUser(APP_USER);
			
			lineItems.add(lineItem);
		}
		
		return lineItems;
	}
	
	public static int getRandomNumberBetween(int min, int max) {
		
		return dataFactory.getNumberBetween(min, max);
	}
	
	private static String getString(String... v1) {
		
		StringBuffer stringBuffer = new StringBuffer();
		
		for ( Object obj : v1 ) {
			stringBuffer.append(obj.toString());
		}
		
		return stringBuffer.toString();
	}
}