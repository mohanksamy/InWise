package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Stock;

/**
 * Repository class for Stock entity
 * 
 * @author Logu
 *
 */
@Repository
public interface StockRepository extends CrudRepository<Stock, BigInteger> {
	
	/**
	 * Method to find Stock by ItemId.
	 * 
	 * @param name
	 * @return
	 */
	public Stock findByItemId(BigInteger itemId);
	
	public List<Stock> findByItemTraderId(BigInteger traderId);
}