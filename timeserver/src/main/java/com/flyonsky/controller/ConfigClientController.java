package com.flyonsky.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"配置刷新"})
@RefreshScope
@RestController
public class ConfigClientController {

	@Value("${time.server.version:}")
	private String version;
	
	@ApiOperation("版本")
	@GetMapping("version")
	public String version() {
		return version;
	}
}
