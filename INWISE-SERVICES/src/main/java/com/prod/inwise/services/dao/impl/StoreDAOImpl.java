package com.prod.inwise.services.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prod.inwise.services.dao.StoreDAO;
import com.prod.inwise.services.model.Store;
import com.prod.inwise.services.repo.StoreRepository;

@Service
public class StoreDAOImpl implements StoreDAO {
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Override
	public Store findByName(String name) {
		return storeRepo.findByName(name);
	}
}