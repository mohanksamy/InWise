package com.prod.inwise.services.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Stock;

/**
 * Repository class for Stock entity
 * 
 * @author Logu
 *
 */
@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
	
	/**
	 * Method to find Stock by ItemId.
	 * 
	 * @param name
	 * @return
	 */
	@Query("SELECT s FROM Stock s WHERE s.item.id = :itemId")
	public Stock findByItemId(@Param("itemId") Long itemId);
}