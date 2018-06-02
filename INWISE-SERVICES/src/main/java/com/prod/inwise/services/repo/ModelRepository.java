package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Model;

/**
 * Repository class for Model entity
 * 
 * @author mohan_kandasamy
 *
 */
@Repository
public interface ModelRepository extends CrudRepository<Model, BigInteger> {

	/**
	 * Method to find Model by given Trader Id.
	 * 
	 * @param name
	 * @return
	 */
	public List<Model> findByTraderId(@Param("traderId") BigInteger traderId);
	
	public Model findByTraderIdAndId(@Param("traderId") BigInteger traderId, @Param("id") BigInteger id);
}