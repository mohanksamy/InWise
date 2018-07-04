package com.prod.inwise.fe.services;

import java.util.List;

import com.prod.inwise.dto.TraderDTO;

/**
 * @author Logu
 *
 */
public interface TraderService {

	public List<TraderDTO> findAllTraders() throws Exception;

	public TraderDTO findTraderById(Long id) throws Exception;

	public TraderDTO findTraderByName(String name) throws Exception;

	public TraderDTO saveTrader(TraderDTO traderDto) throws Exception;
}