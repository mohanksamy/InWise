package com.prod.inwise.fe.services;

import java.math.BigInteger;
import java.util.List;

import com.prod.inwise.dto.ItemDTO;

/**
 * @author Logu
 *
 */
public interface ItemService {

	public List<ItemDTO> findAllItemsByTraderId(BigInteger traderId) throws Exception;

	public ItemDTO findItemById(BigInteger traderId, Long id) throws Exception;

	public ItemDTO saveItem(BigInteger traderId, ItemDTO itemDTO) throws Exception;
}