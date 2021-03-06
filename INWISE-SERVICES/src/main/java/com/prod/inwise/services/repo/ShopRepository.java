package com.prod.inwise.services.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Shop;

/**
 * Repository class for Shop entity
 * 
 * @author mohan.kandasamy
 *
 */
@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {

	/**
	 * Method find Shop by given name
	 * 
	 * @param name
	 * @return
	 */
	public Shop findByNameIgnoreCase(@Param("name") String name);
}