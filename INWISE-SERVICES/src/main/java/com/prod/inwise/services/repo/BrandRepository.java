package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Brand;

/**
 * Repository class for Brand entity
 * 
 * @author mohan_kandasamy
 *
 */
@Repository
public interface BrandRepository extends CrudRepository<Brand, BigInteger> {

	/**
	 * Method to find Brand by given Trader Id.
	 * 
	 * @param name
	 * @return
	 */
	public List<Brand> findByTraderId(@Param("traderId") BigInteger traderId);
	
	public Brand findByTraderIdAndId(@Param("traderId") BigInteger traderId, @Param("id") BigInteger id);
}