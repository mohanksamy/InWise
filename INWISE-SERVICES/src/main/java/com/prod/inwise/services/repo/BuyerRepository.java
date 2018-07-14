package com.prod.inwise.services.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Buyer;

/**
 * Repository class for Buyer entity
 * 
 * @author mohan_kandasamy
 *
 */
@Repository
public interface BuyerRepository extends CrudRepository<Buyer, BigInteger> {
}