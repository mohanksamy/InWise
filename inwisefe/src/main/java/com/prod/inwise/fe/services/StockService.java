package com.prod.inwise.fe.services;

import java.util.List;

import com.prod.inwise.dto.StockDTO;

/**
 * @author Logu
 *
 */
public interface StockService {

	public List<StockDTO> findAllStocks() throws Exception;

	public StockDTO findStockById(Long id) throws Exception;

	public StockDTO saveStock(StockDTO stockDto) throws Exception;

}
