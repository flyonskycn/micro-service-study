package com.flyonsky.config;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Bean
	@LoadBalanced
	public RestTemplate createRestTemplate() {
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(2000);
		clientHttpRequestFactory.setReadTimeout(3000);
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		
		// 保存和传递调用链上下文
		restTemplate.setInterceptors(Collections.singletonList(new CatRestInterceptor()));
		
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
			@Override 
			public boolean hasError(ClientHttpResponse response)
					throws IOException {
				try {
					return super.hasError(response);
				} catch (Exception e) {
					return true;
				}
			}

			@Override 
			public void handleError(ClientHttpResponse response)
					throws IOException {
				try {
					super.handleError(response);
				} catch (Exception e) {
					log.error("Exception [" + e.getMessage() + "] occurred while trying to send the request", e);
					throw e;
				}
			}
		});
		return restTemplate;
	}
}
