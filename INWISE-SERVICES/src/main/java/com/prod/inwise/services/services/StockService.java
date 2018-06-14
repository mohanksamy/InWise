package com.prod.inwise.services.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prod.inwise.services.data.StockHistory;
import com.prod.inwise.services.exceptions.UnexpectedItemException;

/**
 * @author mohan_kandasamy
 *
 */
@Service
public interface StockService {

	public void createStock(BigInteger traderId, List<StockHistory> stockHistories) throws UnexpectedItemException;
}