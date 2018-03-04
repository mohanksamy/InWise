package com.prod.inwise.services.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.LineItem;

/**
 * Repository class for LineItem entity
 * 
 * @author Logu
 *
 */
@Repository
public interface LineItemRepository extends CrudRepository<LineItem, Long> {
}