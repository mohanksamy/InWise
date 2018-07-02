package com.prod.inwise.fe.services;

import java.util.List;

import com.prod.inwise.dto.ItemDTO;

/**
 * @author Logu
 *
 */
public interface ItemService {

	public List<ItemDTO> findAllItems() throws Exception;

	public ItemDTO findItemById(Long id) throws Exception;

	public ItemDTO saveItem(ItemDTO itemDTO) throws Exception;
}
