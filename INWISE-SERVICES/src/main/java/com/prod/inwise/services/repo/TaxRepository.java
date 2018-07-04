package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

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

	public List<Tax> findByTraderId(@Param("traderId") BigInteger traderId);
	
	public Tax findByTraderIdAndId(@Param("traderId") BigInteger traderId, @Param("id") BigInteger id);
}