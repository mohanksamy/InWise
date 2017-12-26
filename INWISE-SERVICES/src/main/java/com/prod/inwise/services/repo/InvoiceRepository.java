package com.prod.inwise.services.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prod.inwise.services.data.Invoice;

/**
 * Repository class for Invoice entity
 * 
 * @author Logu
 *
 */
@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
