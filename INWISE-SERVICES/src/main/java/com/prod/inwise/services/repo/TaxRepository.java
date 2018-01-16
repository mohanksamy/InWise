package com.prod.inwise.services.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Tax;

/**
 * Repository class for Tax entity
 * 
 * @author Logu
 *
 */
@Repository
public interface TaxRepository extends CrudRepository<Tax, Long> {

	/**
	 * Method to find Tax by given Store name.
	 * 
	 * @param name
	 * @return
	 */
	@Query("SELECT tax FROM Tax tax WHERE UPPER(tax.store.name) = UPPER(:name)")
	public Tax findByStoreName(@Param("name") String name);
}