package com.prod.inwise.services.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prod.inwise.services.dao.StoreDAO;
import com.prod.inwise.services.data.Store;
import com.prod.inwise.services.repo.StoreRepository;

/**
 * Implementation class for CRUD operation on Store entity
 * 
 * @author mohan.kandasamy
 *
 */
@Service
public class StoreDAOImpl implements StoreDAO {
	
	@Autowired
	private StoreRepository storeRepo;
	
	/**
	 * Method find Store entity by name
	 */
	@Override
	public Store findByName(String name) {
		return storeRepo.findByName(name);
	}
}