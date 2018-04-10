package com.prod.inwise.fe.services;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.ws.rs.core.MediaType;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author mohan_kandasamy
 *
 */
public class ServicesGateway {

	public synchronized static ResponseEntity<String> invokeAPI(Properties headerProperties, String uri, HttpMethod method, Object entity, String tenant) throws Exception {

		ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
		
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		
		// get session
		HttpHeaders headers = new HttpHeaders();
		
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);

		headers.set("token", "token");

		// Populating headers
		if ( null != headerProperties ) {

			for ( Object key : headerProperties.keySet() ) {

				headers.add(key.toString(), headerProperties.getProperty(key.toString()));
			}
		}

		HttpEntity httpEntity = getHttpEntity(entity, headers);

		ResponseEntity<String> response = null;

		long startTime = System.currentTimeMillis();

		response = restTemplate.exchange(uri, method, httpEntity, String.class);
		
//		log.info("API call {} | Time taken(in ms) {}", uri, (System.currentTimeMillis() - startTime) );
		
		return response;
	}
	
	private static ClientHttpRequestFactory getClientHttpRequestFactory() {
//	    int timeout = 50000;
	    
		RequestConfig config = RequestConfig.custom().build();
	    
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
	    
	    return new HttpComponentsClientHttpRequestFactory(client);
	}
	
	private synchronized static HttpEntity getHttpEntity(Object entity, HttpHeaders headers) {
		
		HttpEntity httpEntity = null;
		
		if ( null == entity ) {

			httpEntity = new HttpEntity(headers);

		} else {

			httpEntity = new HttpEntity(entity, headers);
		}
		
		return httpEntity;
	}
}