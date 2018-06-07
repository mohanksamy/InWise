package com.prod.inwise.fe.services;

import com.prod.inwise.dto.TraderDTO;

/**
 * @author Logu
 *
 */
public interface TraderService {

	public TraderDTO findTraderByName(String name) throws Exception;

	public TraderDTO findTraderById(Long id) throws Exception;

	public TraderDTO createTrader(TraderDTO traderDto) throws Exception;
}
