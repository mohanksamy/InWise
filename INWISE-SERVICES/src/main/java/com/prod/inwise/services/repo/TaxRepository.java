package com.prod.inwise.services.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Tax;

/**
 * Repository class for Tax entity
 * 
 * @author Logu
 *
 */
@Repository
public interface TaxRepository extends CrudRepository<Tax, BigInteger> {

	/**
	 * Method to find Tax by given Store name.
	 * 
	 * @param name
	 * @return
	 */
	public Tax findByTraderNameIgnoreCase(@Param("name") String name);
	
	public Tax findByTraderId(@Param("storeId") BigInteger storeId);
}