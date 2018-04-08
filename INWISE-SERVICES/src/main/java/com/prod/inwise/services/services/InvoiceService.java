package com.prod.inwise.services.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prod.inwise.services.data.LineItem;

/**
 * @author mohan_kandasamy
 *
 */
@Service
public interface InvoiceService {

	public void createInvoice(Long storeId, List<LineItem> lineItems);
}