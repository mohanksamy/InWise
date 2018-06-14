package com.prod.inwise.services.exceptions;

import java.math.BigInteger;
import java.util.List;

import com.prod.inwise.services.data.Item;

/**
 * @author mohan_kandasamy
 *
 */
public class UnexpectedItemException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnexpectedItemException(BigInteger traderId, List<Item> items) {
		
		super(getExceptionMessage(traderId, items));
	}

	@Override
	public String getMessage() {
		
		return super.getMessage();
	}
	
	private static String getExceptionMessage(BigInteger traderId, List<Item> items) {
		
		StringBuffer buffer = new StringBuffer();
		
		items.stream().parallel().forEach(item -> composeMessage(traderId, item, buffer));
		
		return buffer.toString();
	}
	
	private static void composeMessage(BigInteger traderId, Item item, StringBuffer buffer) {
		
		buffer.append("|Item ").append(item.getName()).append(" doesn't belongs to the Trader: ").append(traderId);
	}
}