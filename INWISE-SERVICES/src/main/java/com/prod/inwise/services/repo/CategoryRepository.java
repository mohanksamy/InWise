package com.prod.inwise.services.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Category;
import com.prod.inwise.services.data.Tax;

/**
 * Repository class for Category entity
 * 
 * @author mohan_kandasamy
 *
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, BigInteger> {

	/**
	 * Method to find Category by given Trader name.
	 * 
	 * @param name
	 * @return
	 */
	public Tax findByTraderNameIgnoreCase(@Param("name") String name);
}