package com.flyonsky.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flyonsky.service.TimeClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TimeClientServiceImp implements TimeClientService{
	
	private RestTemplate restTemplate;

//	@HystrixCommand(fallbackMethod="error")
	@Override
	public String currentTime() {
		String data = this.getRestTemplate().getForObject("http://timeserver/currentime", String.class);
		return data;
	}
	
	public String error() {
		return "ERROR";
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
