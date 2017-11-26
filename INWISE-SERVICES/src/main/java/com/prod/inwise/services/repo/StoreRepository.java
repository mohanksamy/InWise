package com.prod.inwise.services.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.model.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

	@Query("SELECT s FROM Store s WHERE UPPER(s.name) = UPPER(:name)")
	public Store findByName(@Param("name") String name);
}