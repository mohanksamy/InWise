package com.prod.inwise.services.dao;

import com.prod.inwise.services.model.Store;

public interface StoreDAO {

	public Store findByName(String name);  
}