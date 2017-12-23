/**
 * 
 */
package com.prod.inwise.services.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.StockHistory;

/**
 * Repository class for StockHistory entity
 * 
 * @author Logu
 *
 */
@Repository
public interface StockHistoryRepository extends CrudRepository<StockHistory, Long> {

}
