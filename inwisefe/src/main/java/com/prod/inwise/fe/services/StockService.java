package com.prod.inwise.fe.services;

import java.util.List;

import com.prod.inwise.dto.StockDTO;

/**
 * @author Logu
 *
 */
public interface StockService {

	public List<StockDTO> findAllStocksByTraderId(Long traderId) throws Exception;

	public StockDTO findStockById(Long traderId, Long stockId) throws Exception;

	public StockDTO saveStock(StockDTO stockDto) throws Exception;
}