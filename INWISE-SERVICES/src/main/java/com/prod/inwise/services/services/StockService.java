package com.prod.inwise.services.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prod.inwise.services.data.StockHistory;

/**
 * @author mohan_kandasamy
 *
 */
@Service
public interface StockService {

	public void createStock(List<StockHistory> stockHistories);
}