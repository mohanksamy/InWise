package com.prod.inwise.services.repo;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Address;

/**
 * Repository class for Address entity
 * 
 * @author mohan.kandasamy
 *
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, BigInteger> {
}