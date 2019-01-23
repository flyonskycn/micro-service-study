package com.flyonsky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicPropertyFactory;

@RestController
@RequestMapping("apollo")
public class ApolloController {
	
	private DynamicIntProperty poolSize = DynamicPropertyFactory.getInstance()
            .getIntProperty("timeserver.thread.pool.size",2,new Runnable() {
				@Override
				public void run() {
                    System.out.println("timeserver.thread.pool.size changed to:" + poolSize.get());
				}
			});
	
	@GetMapping("size")
	public int size() {
		return poolSize.get();
	}
	
	@GetMapping("flag")
	public boolean flag() {
		return ConfigurationManager.isConfigurationInstalled();
	}
}
