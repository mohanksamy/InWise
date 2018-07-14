package com.prod.inwise.services.services;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.prod.inwise.services.data.Invoice;
import com.prod.inwise.services.exceptions.OutOfStockException;
import com.prod.inwise.services.exceptions.UnexpectedItemException;

/**
 * @author mohan_kandasamy
 *
 */
@Service
public interface InvoiceService {

	public void createInvoice(BigInteger traderId, Invoice invoice) throws OutOfStockException, UnexpectedItemException;
}