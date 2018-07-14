package com.prod.inwise.fe.services;

import java.math.BigInteger;
import java.util.List;

import com.prod.inwise.dto.StockDTO;

/**
 * @author Logu
 *
 */
public interface StockService {

	public List<StockDTO> findAllStocksByTraderId(BigInteger traderId) throws Exception;

	public StockDTO findStockById(BigInteger traderId, Long stockId) throws Exception;

	public StockDTO saveStock(BigInteger traderId, StockDTO stockDto) throws Exception;
}