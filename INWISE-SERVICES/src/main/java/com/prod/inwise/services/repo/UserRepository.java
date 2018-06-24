package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.User;

/**
 * Repository class for User entity
 * 
 * @author mohan_kandasamy
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, BigInteger> {

	public List<User> findByTraderId(BigInteger traderId);
	
	public User findByTraderIdAndId(BigInteger traderId, BigInteger id);
}