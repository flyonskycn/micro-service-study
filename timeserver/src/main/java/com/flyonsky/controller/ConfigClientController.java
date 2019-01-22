package com.flyonsky.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@RestController
public class ConfigClientController {

	@Value("${time.server.version:}")
	private String version;
	
	@GetMapping
	public String version() {
		return version;
	}
}
