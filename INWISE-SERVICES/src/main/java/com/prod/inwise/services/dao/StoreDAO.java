package com.prod.inwise.services.dao;

import com.prod.inwise.services.model.Store;

/**
 * Interface declares CRUD operation on Store Entity
 * 
 * @author mohan.kandasamy
 *
 */
public interface StoreDAO {

	/**
	 * Declares method to find Store by name
	 * 
	 * @param name
	 * @return
	 */
	public Store findByName(String name);  
}