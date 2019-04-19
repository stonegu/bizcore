package com.bizislife.rest.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class HttpUtils {
	public static ClientHttpRequestFactory getClientHttpRequestFactory(int timeout) {
//		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		clientHttpRequestFactory.setConnectTimeout(timeout);
//		return clientHttpRequestFactory;

	    RequestConfig config = RequestConfig.custom()
	    	      .setConnectTimeout(timeout)
	    	      .setConnectionRequestTimeout(timeout)
	    	      .setSocketTimeout(timeout)
	    	      .build();
	    	    CloseableHttpClient client = HttpClientBuilder
	    	      .create()
	    	      .setDefaultRequestConfig(config)
	    	      .build();
	    	    return new HttpComponentsClientHttpRequestFactory(client);	
	
	}

}
