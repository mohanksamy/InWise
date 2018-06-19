package com.prod.inwise.fe.services;

import com.prod.inwise.dto.ItemDTO;

/**
 * @author Logu
 *
 */
public interface ItemService {

	public ItemDTO findAllItems() throws Exception;
	
	public ItemDTO findItemId(Long id) throws Exception;

	public ItemDTO saveItem(ItemDTO ItemDTO) throws Exception;
}
