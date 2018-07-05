package com.prod.inwise.fe.services;

import static com.prod.inwise.util.Constants.KEY_CREATEDTS;
import static com.prod.inwise.util.Constants.KEY_MODIFIEDTS;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

import javax.ws.rs.core.MediaType;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author mohan_kandasamy
 *
 */
public class ServicesGateway {

	private static Logger log = LoggerFactory.getLogger(ServicesGateway.class);

	public static ResponseEntity<String> invokeAPI(Properties headerProperties, String uri, HttpMethod method,
			Object entity) throws Exception {

		// In case URI needs to be decoded if it's already encoded
		uri = URLDecoder.decode(uri, StandardCharsets.UTF_8.toString());

		ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();

		RestTemplate restTemplate = new RestTemplate(requestFactory);

		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

		// get session
		HttpHeaders headers = new HttpHeaders();

		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
		
		headers.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));

		// Populating headers
		if (null != headerProperties) {

			for (Object key : headerProperties.keySet()) {

				headers.add(key.toString(), headerProperties.getProperty(key.toString()));
			}
		}

		@SuppressWarnings("rawtypes")
		HttpEntity httpEntity = getHttpEntity(entity, headers);

		ResponseEntity<String> response = null;

		long startTime = System.currentTimeMillis();

		response = restTemplate.exchange(uri, method, httpEntity, String.class);

		log.info("API call {} | Time taken(in ms) {}", uri, (System.currentTimeMillis() - startTime));

		return response;
	}

	public static ClientHttpRequestFactory getClientHttpRequestFactory() {
		// int timeout = 50000;

		RequestConfig config = RequestConfig.custom().build();

		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

		return new HttpComponentsClientHttpRequestFactory(client);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static HttpEntity getHttpEntity(Object entity, HttpHeaders headers) {

		HttpEntity httpEntity = null;

		if (null == entity) {

			httpEntity = new HttpEntity(headers);

		} else {

			httpEntity = new HttpEntity(entity, headers);
		}

		return httpEntity;
	}

	public static void removeUnwantedElements(JsonNode jsonNode) {

		// Removing unwanted elements
		removeElementIfExists(jsonNode, KEY_CREATEDTS);
		removeElementIfExists(jsonNode, KEY_MODIFIEDTS);
	}

	public static void removeElementIfExists(JsonNode jsonNode, String elementName) {

		if (jsonNode.has(elementName) & jsonNode instanceof ObjectNode) {

			((ObjectNode) jsonNode).remove(elementName);
		}
	}

	public static String encodeValue(String value) throws Exception {
		return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
	}

	public static String decodeValue(String value) throws Exception {
		return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
	}
}