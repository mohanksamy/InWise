package com.prod.inwise.services.test;

import static com.prod.inwise.services.test.DataUtil.getLineItems;
import static com.prod.inwise.services.test.DataUtil.getRandomDate;
import static com.prod.inwise.services.test.DataUtil.getRandomNumberBetween;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_INVOICE;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_ITEM;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_STOCK;
import static com.prod.inwise.services.test.util.Constants.RESOURCE_PATH_TRADERS;
import static com.prod.inwise.services.test.util.Constants.STRING_EMPTY;
import static org.apache.http.HttpStatus.SC_OK;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.prod.inwise.dto.ItemDTO;
import com.prod.inwise.dto.LineItemDTO;
import com.prod.inwise.dto.StockDTO;
import com.prod.inwise.dto.TaxDTO;
import com.prod.inwise.dto.TraderDTO;
import com.prod.inwise.dto.VendorDTO;

/**
 * @author mohan_kandasamy
 *
 */
public class DataSetupTests extends ServicesTests {
	
	@Test
	public void createInvoices() {
		
		int tradersCount = 1;
		
		for ( int traderIndex = 0; traderIndex < tradersCount; traderIndex++ ) {
			
			// Create Trader
			TraderDTO trader = createTrader();

			// Create Tax
			TaxDTO tax = createTax(trader.getId());
			
			// Create Items
			List<ItemDTO> items = createItems(trader.getId(), tax);
			
			// Create Vendors
			VendorDTO vendor = createVendors(trader.getId());
			
			// Create Stock Batches
			createStockBatches(trader.getId(), items, vendor);
			
			// Create Invoices
			createInvoices(trader.getId());
		}
	}
	
	@Test
	public void testCreateInvoices() {
		
		TraderDTO store = new TraderDTO();
		store.setId(new BigInteger("1001"));
		
		// Fetched items by Store
		@SuppressWarnings("unchecked")
		Map<String, String> itemsMap = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_ITEM, RESOURCE_PATH_TRADERS, store.getId().toString())).andReturn().getBody().as(Map.class);
		
		List<ItemDTO> savedItems = new ArrayList<>(itemsMap.size());
		
		Iterator<String> iter = itemsMap.keySet().iterator();
		
		// Load all created Items
		while ( iter.hasNext() ) {
			
			savedItems.add(getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_ITEM, "id", iter.next())).andReturn().getBody().as(ItemDTO.class));
		}
		
		for ( int invoiceIndex = 0; invoiceIndex <= getRandomNumberBetween(0, 10); invoiceIndex++ ) {
			
			// Create Invoice
			List<LineItemDTO> lineItems = new ArrayList<>();
			
			// Set Timestamp
			// Disable triggers in INVOICE & LINE_ITEM
			// If not disabled, trigger will play it's role!
			Timestamp timestamp = new Timestamp(getRandomDate(2016).getTime());
			
			// Create Invoice
			for ( LineItemDTO lineItem : getLineItems() ) {
				
				ItemDTO item = savedItems.get(getRandomNumberBetween(0, savedItems.size()-1));
				
				if ( !getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STOCK, RESOURCE_PATH_ITEM, item.getId().toString())).asString().contentEquals(STRING_EMPTY) ) {
				
					StockDTO stock = getDefaultRequestSpecification().get(getPath(RESOURCE_PATH_STOCK, RESOURCE_PATH_ITEM, item.getId().toString())).andReturn().getBody().as(StockDTO.class);
				
					lineItem.setItem(item);
				
					// Ignore the LineItem if it's out of stock
					if ( 0 == stock.getQuantity() ) {
						continue;
					}
					
					lineItem.setQuantity(getRandomNumberBetween(1, stock.getQuantity()));
					
					lineItem.setCreatedTS(timestamp);
					lineItem.setModifiedTS(timestamp);
					
					lineItems.add(lineItem);
				}
			}
			
			// Create invoices only if LineItems are available
			if ( !lineItems.isEmpty() ) {
				
				getRequestSpecificationWithJsonBody(lineItems).post(getPath(RESOURCE_PATH_INVOICE, RESOURCE_PATH_TRADERS, store.getId().toString())).then().statusCode(SC_OK);
			}
		}
	}
}