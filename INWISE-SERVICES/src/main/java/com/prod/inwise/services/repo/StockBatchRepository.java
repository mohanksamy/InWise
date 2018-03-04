package com.prod.inwise.services.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.StockBatch;

/**
 * Repository class for StockBatch entity
 * 
 * @author Logu
 *
 */
@Repository
public interface StockBatchRepository extends CrudRepository<StockBatch, Long> {
}