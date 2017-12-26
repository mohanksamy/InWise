/**
 * 
 */
package com.prod.inwise.services.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Vendor;

/**
 * Repository class for Vendor entity
 * 
 * @author Logu
 *
 */
@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {

}
