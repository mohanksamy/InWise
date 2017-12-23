/**
 * 
 */
package com.prod.inwise.services.repo;

import org.springframework.data.repository.CrudRepository;
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

}
