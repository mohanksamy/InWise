package com.prod.inwise.fe.services;

import java.math.BigInteger;
import java.util.List;

import com.prod.inwise.dto.TaxDTO;

/**
 * @author Logu
 *
 */
public interface TaxService {

	public List<TaxDTO> findAllTaxesByTraderId(BigInteger traderId) throws Exception;

	public TaxDTO findTaxById(BigInteger traderId, Long id) throws Exception;

	public TaxDTO saveTax(BigInteger traderId, TaxDTO taxDto) throws Exception;
}