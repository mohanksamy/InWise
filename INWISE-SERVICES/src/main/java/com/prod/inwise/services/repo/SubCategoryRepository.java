package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.SubCategory;

/**
 * Repository class for SubCategory entity
 * 
 * @author mohan_kandasamy
 *
 */
@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, BigInteger> {

	/**
	 * Method to find SubCategory by given Trader Id.
	 * 
	 * @param name
	 * @return
	 */
	public List<SubCategory> findByTraderId(@Param("traderId") BigInteger traderId);
	
	public SubCategory findByTraderIdAndId(@Param("traderId") BigInteger traderId, @Param("id") BigInteger id);
}