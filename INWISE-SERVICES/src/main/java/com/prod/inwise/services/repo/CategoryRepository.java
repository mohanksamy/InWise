package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Category;

/**
 * Repository class for Category entity
 * 
 * @author mohan_kandasamy
 *
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, BigInteger> {

	/**
	 * Method to find Category by given Trader Id.
	 * 
	 * @param name
	 * @return
	 */
	public List<Category> findByTraderId(BigInteger traderId);
	
	public Category findByTraderIdAndId(BigInteger traderId, BigInteger id);
}