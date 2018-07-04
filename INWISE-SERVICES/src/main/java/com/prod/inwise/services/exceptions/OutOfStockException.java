package com.prod.inwise.services.exceptions;

import java.util.List;

import com.prod.inwise.services.data.LineItem;

/**
 * @author mohan_kandasamy
 *
 */
public class OutOfStockException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OutOfStockException(List<LineItem> lineItems) {
		
		super(getExceptionMessage(lineItems));
	}

	@Override
	public String getMessage() {
		
		return super.getMessage();
	}
	
	private static String getExceptionMessage(List<LineItem> lineItems) {
		
		StringBuffer buffer = new StringBuffer();
		
		lineItems.stream().parallel().forEach(lineItem -> composeMessage(lineItem, buffer));
//		lineItems.stream().parallel().filter( lineItem -> lineItem.getQuantity() > lineItem.getQuantityInStock()).forEach(lineItem -> composeMessage(lineItem, buffer));
		
		return buffer.toString();
	}
	
	private static void composeMessage(LineItem lineItem, StringBuffer buffer) {
		
		buffer.append("|LineItem ").append(lineItem.getItem().getName()).append(" available quantity: ").append(lineItem.getQuantityInStock()).append(" but expected quantity: ").append(lineItem.getQuantity());
	}
}