package com.prod.inwise.fe.services;

import java.math.BigInteger;
import java.util.List;

import com.prod.inwise.dto.InvoiceDTO;
import com.prod.inwise.dto.LineItemDTO;

/**
 * @author Logu
 *
 */
public interface InvoiceService {

	public List<InvoiceDTO> findAllInvoicesByTraderId(BigInteger traderId) throws Exception;

	public InvoiceDTO findInvoiceById(Long id) throws Exception;

	public List<LineItemDTO> saveInvoice(BigInteger traderId, List<LineItemDTO> lineItemDtos) throws Exception;

}