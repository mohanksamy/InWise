package com.prod.inwise.services.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

	/**
	 * Method to find Item by given Item name.
	 * 
	 * @param name
	 * @return
	 */
//	public Item findByNameIgnoreCase(@Param("name") String name);
	
//	@Query("SELECT item FROM Item item WHERE item.trader.id = :id")
//	public List<Item> findItemsByTrader(@Param("id") BigInteger traderId);
	
	public List<Item> findByTraderId(@Param("traderId") BigInteger traderId);
	
	public Item findByTraderIdAndId(@Param("traderId") BigInteger traderId, @Param("id") BigInteger id);
}