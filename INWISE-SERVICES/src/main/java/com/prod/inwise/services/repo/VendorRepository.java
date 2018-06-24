package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
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
	
	public List<Vendor> findByTraderId(BigInteger traderId);
	
	public Vendor findByTraderIdAndId(BigInteger traderId, BigInteger id);
}