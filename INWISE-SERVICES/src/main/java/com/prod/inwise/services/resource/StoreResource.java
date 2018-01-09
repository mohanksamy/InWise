package com.prod.inwise.services.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.Shop;
import com.prod.inwise.services.data.Store;
import com.prod.inwise.services.repo.ShopRepository;
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
	
	/*@Autowired
	private StoreRepository storeRepo;*/
	
	@Autowired
	private ShopRepository shopRepo;
	
	/*@POST
	public Store createStore(Store store) {
	  return storeRepo.save(store);
	}*/
	
	@POST
	public Response createStore(Shop shop) {
		
		shopRepo.save(shop);
		
		return status(OK).build();
	}
	
	/**
	 * Service operation to find resource by name.
	 * 
	 * @param name
	 * @return
	 */
	/*@GET
	@Path("/{name}")
	public Store findByName(@PathParam("name") String name) {
		return storeRepo.findByName(name);
	}*/
    
	/**
	 * Service operation to find resource by name.
	 *
	 * @param name
	 * @return
	 */
	@GET
	@Path("/{name}")
	public Shop findByName(@PathParam("name") String name) {
		return shopRepo.findByName(name);
	}
}