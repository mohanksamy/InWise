package com.prod.inwise.services.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Store;

/**
 * Repository class for Store entity
 * 
 * @author mohan.kandasamy
 *
 */
@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

	/**
	 * Method find Store by given name
	 * 
	 * @param name
	 * @return
	 */
	@Query("SELECT s FROM Store s WHERE UPPER(s.name) = UPPER(:name)")
	public Store findByName(@Param("name") String name);
}