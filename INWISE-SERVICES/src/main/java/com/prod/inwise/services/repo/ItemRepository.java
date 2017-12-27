package com.prod.inwise.services.repo;

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
public interface ItemRepository extends CrudRepository<Item, Long> {

}