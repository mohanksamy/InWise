package com.prod.inwise.services.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prod.inwise.services.data.LineItem;
import com.prod.inwise.services.exceptions.OutOfStockException;
import com.prod.inwise.services.exceptions.UnexpectedItemException;

/**
 * @author mohan_kandasamy
 *
 */
@Service
public interface InvoiceService {

	public void createInvoice(BigInteger storeId, List<LineItem> lineItems) throws OutOfStockException, UnexpectedItemException;
}