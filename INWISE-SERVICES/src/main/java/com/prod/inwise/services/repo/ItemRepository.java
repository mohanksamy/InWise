package com.prod.inwise.services.repo;

import org.springframework.data.jpa.repository.Query;
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
public interface ItemRepository extends CrudRepository<Item, Long> {

	/**
	 * Method to find Item by given Item name.
	 * 
	 * @param name
	 * @return
	 */
	@Query("SELECT item FROM Item item WHERE UPPER(item.name) = UPPER(:name)")
	public Item findByName(@Param("name") String name);
}
