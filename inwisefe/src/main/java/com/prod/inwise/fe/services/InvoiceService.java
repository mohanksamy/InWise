package com.prod.inwise.fe.services;

import java.util.List;

import com.prod.inwise.dto.InvoiceDTO;
import com.prod.inwise.dto.LineItemDTO;

/**
 * @author Logu
 *
 */
public interface InvoiceService {

	public List<InvoiceDTO> findAllInvoices() throws Exception;

	public InvoiceDTO findInvoiceById(Long id) throws Exception;

	public List<LineItemDTO> saveInvoice(Long traderId, List<LineItemDTO> lineItemDtos) throws Exception;

}