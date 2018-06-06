package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Vendor;

/**
 * Repository class for Vendor entity
 * 
 * @author Logu
 *
 */
@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {
	
	public List<Vendor> findByTraderId(@Param("traderId") BigInteger traderId);
	
	public Vendor findByTraderIdAndId(@Param("traderId") BigInteger traderId, @Param("id") BigInteger id);
}