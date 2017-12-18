package com.prod.inwise.services.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.Store;
import com.prod.inwise.services.repo.StoreRepository;

/**
 * REST Resource exposes operation on Store resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Path("/store")
@Produces(MediaType.APPLICATION_JSON)
public class StoreResource {
	
	@Autowired
	private StoreRepository storeRepo;
    
	/**
	 * Service operation to find resource by name.
	 * 
	 * @param name
	 * @return
	 */
	@GET
	@Path("/{name}")
	public Store findByName(@PathParam("name") String name) {
		return storeRepo.findByName(name);
	}
}