package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.util.Constants.APP_USER;
import static com.prod.inwise.services.test.util.Constants.DATA_DELIMITER;
import static com.prod.inwise.services.test.util.Constants.STRING_SPACE;
import static com.prod.inwise.services.test.util.Constants.number;
import static com.prod.inwise.services.test.util.Constants.random;
import static java.lang.Float.parseFloat;
import static org.apache.commons.lang3.StringUtils.upperCase;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;

import com.prod.inwise.dto.AddressDTO;
import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.LineItemDTO;
import com.prod.inwise.dto.StockHistoryDTO;
import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.dto.TraderDTO;
import com.prod.inwise.dto.VendorDTO;

public final class DataUtil {
	
	private static final DataFactory dataFactory = new DataFactory();
	
	private static final float minTax 			= 2.5f;
	
	private static final float maxTax 			= 15.0f;
	
	private static final float minPrice 			= 35.0f;
	
	private static final float maxPrice 			= 750.0f;
	
	private static final String[] US_STATES 		= {"California", "Alabama", "Arkansas", "Arizona", "Alaska", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };
	
//	private static final String[] INDIA_STATES 	= {"Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telengana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
	
	private static final String COUNTRY			= "USA";
	
	public static AddressDTO getAddress() {
		
		AddressDTO address = new AddressDTO();
		address.setStreet1(dataFactory.getAddress());
		address.setStreet2(dataFactory.getAddressLine2());
		address.setCity(dataFactory.getCity());
		address.setRegion(dataFactory.getCity());
		address.setState(US_STATES[dataFactory.getNumberBetween(0, 50)]);
		address.setCountry(COUNTRY);
		address.setPostalCode(getString(dataFactory.getRandomChars(1).toUpperCase(), dataFactory.getNumberText(4)));
		
		address.setActive(true);
		address.setCreatedUser(APP_USER);
		address.setModifiedUser(APP_USER);
		
		return address;
	}

	public static TraderDTO getTrader() {
		
		TraderDTO trader = new TraderDTO();
		trader.setName(dataFactory.getBusinessName());
		trader.setCode(upperCase(trader.getName()));
		trader.setAddress(getAddress());
		trader.setUin(getString(dataFactory.getRandomChars(3).toUpperCase(), dataFactory.getNumberText(10)));
		trader.setPhone(new BigInteger(dataFactory.getNumberText(10)));
		
		trader.setActive(true);
		trader.setCreatedUser(APP_USER);
		trader.setModifiedUser(APP_USER);
		
		return trader;
	}
	
	public static TaxDTO getTax(TraderDTO trader) {
		
		number.setMaximumFractionDigits(2);
		
		TaxDTO tax = new TaxDTO();
		tax.setCgst(new BigDecimal(parseFloat(number.format(random.nextFloat() * (maxTax - minTax) + minTax))));
		tax.setSgst(new BigDecimal(parseFloat(number.format(random.nextFloat() * (maxTax - minTax) + minTax))));
		tax.setActive(true);
		tax.setCreatedUser(APP_USER);
		tax.setModifiedUser(APP_USER);
		
		tax.setTrader(trader);
		
		return tax;
	}
	
	public static List<ItemDTO> getItem(TaxDTO tax) {
		
		number.setMaximumFractionDigits(2);
		
		List<ItemDTO> items = new ArrayList<>(0);
		
		for ( int index = 0; index <= dataFactory.getNumberUpTo(30); index++ ) {
		
			ItemDTO item = new ItemDTO();
			item.setName(getString(dataFactory.getRandomChars(15).toUpperCase(), Integer.toString(random.nextInt(1000))/*, STRING_SPACE, ITEM_SUFFIX*/));
			item.setCode(upperCase(item.getName()));
			item.setPrice(new BigDecimal(parseFloat(number.format(random.nextFloat() * (maxPrice - minPrice) + minPrice))));
			
//			item.setCategory(dataFactory.getItem(Category.values()));
//			item.setSubCategory(dataFactory.getItem(SubCategory.values()));
//			item.setBrand(dataFactory.getItem(Brand.values()));
//			item.setSize(dataFactory.getItem(Size.values()));
			
			if ( null != tax ) {
				item.setTax(tax);
				item.setTrader(tax.getTrader());
			}
			
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
		vendor.setAddress(getAddress());
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
			stockHistory.setBasePrice(BigDecimal.valueOf(dataFactory.getNumberBetween(10, 100)));
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
	
	public static int getRandomObjectIndex(List<String> objectLinks) {
		
		return getRandomNumberBetween(0, objectLinks.size());
	}
	
	public static Date getRandomDate(int startingYear) {
		
		Calendar baseDate = Calendar.getInstance();
		baseDate.set(Calendar.MONTH, getRandomNumberBetween(Calendar.JANUARY, Calendar.DECEMBER));
		baseDate.set(Calendar.YEAR, getRandomNumberBetween(startingYear, 2018));
		
		return dataFactory.getDate(baseDate.getTime(), 01, 30);
	}
	
	private static String getString(String... v1) {
		
		StringBuffer stringBuffer = new StringBuffer();
		
		for ( Object obj : v1 ) {
			stringBuffer.append(obj.toString());
		}
		
		return stringBuffer.toString();
	}
}