package com.prod.inwise.services.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Trader;

/**
 * Repository class for Merchant entity
 * 
 * @author mohan.kandasamy
 *
 */
@Repository
public interface TraderRepository extends CrudRepository<Trader, BigInteger> {

	/**
	 * Method to find Trader by given name
	 * 
	 * @param name
	 * @return
	 */
	public Trader findByNameIgnoreCase(String name);
}