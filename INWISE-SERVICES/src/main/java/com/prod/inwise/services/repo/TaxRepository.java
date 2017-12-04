/**
 * 
 */
package com.prod.inwise.services.repo;

import org.springframework.data.repository.CrudRepository;
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

}
