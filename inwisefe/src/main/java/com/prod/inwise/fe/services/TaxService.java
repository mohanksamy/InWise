package com.prod.inwise.fe.services;

import java.util.List;

import com.prod.inwise.dto.TaxDTO;

/**
 * @author Logu
 *
 */
public interface TaxService {

	public List<TaxDTO> findAllTaxes() throws Exception;

	public TaxDTO findTaxById(Long id) throws Exception;

	public TaxDTO saveTax(TaxDTO taxDto) throws Exception;

}
