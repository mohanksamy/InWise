package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Item;

/**
 * Repository class for Item entity
 * 
 * @author Logu
 *
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, BigInteger> {

	public List<Item> findByTraderId(BigInteger traderId);
	
	public Item findByTraderIdAndId(BigInteger traderId, BigInteger id);
}