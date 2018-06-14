package com.prod.inwise.services.services.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prod.inwise.services.data.Stock;
import com.prod.inwise.services.data.StockBatch;
import com.prod.inwise.services.data.StockHistory;
import com.prod.inwise.services.data.Trader;
import com.prod.inwise.services.exceptions.UnexpectedItemException;
import com.prod.inwise.services.repo.StockBatchRepository;
import com.prod.inwise.services.repo.StockHistoryRepository;
import com.prod.inwise.services.repo.StockRepository;
import com.prod.inwise.services.services.StockService;

/**
 * @author mohan_kandasamy
 *
 */
@Service
public class StockServiceImpl extends AbstractService implements StockService {
	
	@Autowired
	private StockBatchRepository stockBatchRepo;
	
	@Autowired
	private StockHistoryRepository stockHistoryRepo;
	
	@Autowired
	private StockRepository stockRepo;

	@Override
	public void createStock(BigInteger traderId, List<StockHistory> stockHistories) throws UnexpectedItemException {
		
		// Check all items in the history belongs to the Trader
		checkStockHistoriesBelongsToTrader(traderId, stockHistories);
		
		Trader trader = new Trader();
		trader.setId(traderId);
		
		// Create Stock
		StockBatch stockBatch = new StockBatch();
		stockBatch.setCreatedUser(stockHistories.get(0).getCreatedUser());
		stockBatch.setModifiedUser(stockHistories.get(0).getCreatedUser());
		stockBatch.setTrader(trader);
		
		stockBatch = stockBatchRepo.save(stockBatch);
		
		// Update stock
		for ( StockHistory stockHistory : stockHistories ) {
			
			stockHistory.setStockBatch(stockBatch);
			
			stockHistoryRepo.save(stockHistory);

			Stock stock = stockRepo.findByItemId(stockHistory.getItem().getId());
			
			// No items exist in Stock
			if ( null == stock ) {
				
				stock = new Stock();
				stock.setItem(stockHistory.getItem());
				stock.setQuantity(stockHistory.getQuantity());
				
				stock.setCreatedUser(stockHistory.getCreatedUser());
				stock.setModifiedUser(stockHistory.getCreatedUser());
			
			// Update existing item quantity in Stock
			} else {
				
				stock.setQuantity(stock.getQuantity() + stockHistory.getQuantity());
			}
			
			stockRepo.save(stock);
		}
	}
}