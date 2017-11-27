package com.prod.inwise.services.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.dao.StoreDAO;
import com.prod.inwise.services.data.Store;

/**
 * REST Resource exposes operation on Store resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
@Path("/store")
@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
public class StoreResource {
	
	@Autowired
	private StoreDAO storeDAO;
    
	/**
	 * Service operation to find resource by name.
	 * 
	 * @param name
	 * @return
	 */
	@GET
	@Path("/{name}")
	public Store findByName(@PathParam("name") String name) {
		return storeDAO.findByName(name);
	}
}