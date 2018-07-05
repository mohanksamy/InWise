package com.prod.inwise.fe.services;

import java.util.List;

import com.prod.inwise.dto.InvoiceDTO;

/**
 * @author Logu
 *
 */
public interface InvoiceService {

	public List<InvoiceDTO> findAllInvoices() throws Exception;

	public InvoiceDTO findInvoiceById(Long id) throws Exception;

	public InvoiceDTO saveInvoice(InvoiceDTO invoiceDto) throws Exception;
}