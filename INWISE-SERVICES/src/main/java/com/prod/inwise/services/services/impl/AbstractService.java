package com.prod.inwise.services.services.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import com.prod.inwise.services.data.Item;
import com.prod.inwise.services.data.LineItem;
import com.prod.inwise.services.data.StockHistory;
import com.prod.inwise.services.exceptions.UnexpectedItemException;

/**
 * @author mohan_kandasamy
 *
 */
public abstract class AbstractService {
	
	/**
	 * Check LineItem belongs to Trader
	 * 
	 * @param traderId
	 * @param lineItems
	 * @throws UnexpectedItemException
	 */
	protected void checkLineItemsBelongsToTrader(BigInteger traderId, List<LineItem> lineItems) throws UnexpectedItemException {
		
		/*List<Item> unexpectedItems = new ArrayList<>();
		
		for ( LineItem lineItem : lineItems ) {
			
			if ( !traderId.equals(lineItem.getItem().getTrader().getId()) ) {
				unexpectedItems.add(lineItem.getItem());
			}
		}*/
		
		List<LineItem> unexpectedStockLineItems = lineItems.parallelStream().filter( lineItem -> !lineItem.getItem().getTrader().getId().equals(traderId) ).collect(Collectors.toList());
		
		List<Item> unexpectedItems = unexpectedStockLineItems.stream().map( lineItem -> lineItem.getItem()).collect(Collectors.toList());
		
		checkAndThrowException(traderId, unexpectedItems);
	}
	
	/**
	 * Check StockHistory belongs to Trader
	 * 
	 * @param traderId
	 * @param stockHistories
	 * @throws UnexpectedItemException
	 */
	protected void checkStockHistoriesBelongsToTrader(BigInteger traderId, List<StockHistory> stockHistories) throws UnexpectedItemException {
		
		List<StockHistory> unexpectedStockHistories = stockHistories.parallelStream().filter( stockHistory -> !stockHistory.getItem().getTrader().getId().equals(traderId) ).collect(Collectors.toList());
		
		List<Item> unexpectedItems = unexpectedStockHistories.stream().map( stockHistory -> stockHistory.getItem()).collect(Collectors.toList());
		
		checkAndThrowException(traderId, unexpectedItems);
	}
	
	/**
	 * Check and throw UnexpectedItemException
	 * 
	 * @param traderId
	 * @param unexpectedItems
	 * @throws UnexpectedItemException
	 */
	private void checkAndThrowException(BigInteger traderId, List<Item> unexpectedItems) throws UnexpectedItemException {
		
		if ( !unexpectedItems.isEmpty() ) {
			
			throw new UnexpectedItemException(traderId, unexpectedItems);
		}
	}
}