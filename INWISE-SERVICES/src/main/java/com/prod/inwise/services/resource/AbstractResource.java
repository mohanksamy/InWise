package com.prod.inwise.services.resource;

import static java.util.stream.StreamSupport.stream;
import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.Status.OK;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.prod.inwise.services.data.Trader;
import com.prod.inwise.services.repo.TraderRepository;

/**
 * REST Resource exposes operation on Item resource
 * 
 * @author mohan.kandasamy
 *
 */
@Component
public abstract class AbstractResource<E> {
	
//	private E e;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private TraderRepository traderRepo;
	
	public Response createEntityWithTrader(Class repoClass, BigInteger traderId, E entity) {
		
		Response response = null;
		
		// Look up Trader using Id
		Trader trader = traderRepo.findOne(traderId);
		
		BigInteger id = null;
		
		if ( null == trader ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId).build();
		
		} else {

//			entity.getClass().getDeclaredMethod("setTrader", Trader.class).invoke(trader);
			
//				System.out.println("Trader found: " + trader.getName());
				
//				PropertyUtils.setProperty(entity, "trader", trader);
				
				setProperty(entity, "trader", trader);
				
//				repo.save(entity);
				
				invokeMethod(repoClass, "save", entity);
				
//				id = (BigInteger) PropertyUtils.getProperty(entity, "getId");
				
				id = (BigInteger) getProperty(entity, "getId");
			
			response = status(OK).entity(id).build();
		}

		return response;
	}
	
	public Response findAllEntitiesWithTraderAndId(UriInfo uriInfo, Class repoClass, Object entityRepo, BigInteger traderId, String path) {
		
		Iterable<E> entities = (Iterable<E>)invokeMethod(repoClass, "findByTraderId", traderId);
		
		List<E> entitiesList = stream(entities.spliterator(), false).collect(Collectors.toList());
		
		List<String> links = new ArrayList<>();
		
		entitiesList.stream().forEach( e -> links.add(uriInfo.getBaseUriBuilder().path(TraderResource.class).path(traderId.toString()).path(path).path(getProperty(e, "getId").toString()).build().toString()));
		
		return Response.status(OK).entity(links).build();
	}

	public Response getEntity(Class repoClass, Object entityRepo, BigInteger traderId, BigInteger id) {

		Response response = null;
		
		// Look up Trader using Id
//		T user = userRepo.findByTraderIdAndId(traderId, id);
		
		E entity = (E) invokeMethod(repoClass, "findByTraderIdAndId", traderId, id);
		
		if ( null == entity ) {
			
			response = status(NO_CONTENT).entity("Unable to locate the trader " + traderId + " and tax " + id).build();
		
		} else {
			
			response = status(OK).entity(entity).build();
		}
		
		return response;
	}
	
	private void setProperty(E entity, String property, Object setObject) {
		
		try {
			
			PropertyUtils.setProperty(entity, property, setObject);
		
		} catch (NoSuchMethodException nsme) {
			
			System.out.println("setProperty NoSuchMethodException: " + nsme.getMessage());
		
		} catch (Exception ex) {
			
			System.out.println("setProperty Exception: " + ex.getMessage());
		}
	}
	
	private Object getProperty(E entity, String property) {
		
		Object object = null;

		try {
			
			object = PropertyUtils.getProperty(entity, property);
		
		} catch (NoSuchMethodException nsme) {
			
			System.out.println("getProperty NoSuchMethodException: " + nsme.getMessage());
		
		} catch (Exception ex) {
			
			System.out.println("getProperty Exception: " + ex.getMessage());
		}
		
		return object;
	}
	
	private Object invokeMethod(Class repoClass, String methodName, Object...args) {
		
		Object object = null;
		
		System.out.println("Repo class: " + repoClass);
		
		System.out.println("Entity Class: " + args[0].getClass());
		
		System.out.println("MethodName: " + methodName);
		
		try {
			
			Object lookupObject = applicationContext.getBean(repoClass);
			
			Method method = repoClass.getMethod(methodName, args[0].getClass());
		    
			Proxy.getInvocationHandler(lookupObject).invoke(lookupObject, method, args);
			
//			object = entityRepo.getClass().getDeclaredMethod(methodName).invoke(args);
		
		} catch (NoSuchMethodException nsme) {
			
			System.out.println("invokeMethod NoSuchMethodException: " + nsme.getMessage());
		
		} catch (Exception ex) {
			
			System.out.println("invokeMethod Exception: " + ex.getMessage());
		
		} catch (Throwable t) {
			
			System.out.println("invokeMethod Throwable: " + t.getMessage());
		}
		
		return object;
	}
}