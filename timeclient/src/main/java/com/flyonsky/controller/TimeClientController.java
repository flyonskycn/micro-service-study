package com.flyonsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flyonsky.TimeService;
import com.flyonsky.service.TimeClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"时间管理"})
@RestController
public class TimeClientController {

	private TimeClientService timeService;
	
	private TimeService timeFeignService;
	
	@ApiOperation("当前时间")
	@GetMapping("currentime")
	public String currentime() {
		return this.getTimeService().currentTime();
	}
	
	@ApiOperation("feign 获取当前时间")
	@GetMapping("feigntime")
	public String feignTime() {
		return this.getTimeFeignService().currentime();
	}

	public TimeClientService getTimeService() {
		return timeService;
	}

	@Autowired
	public void setTimeService(TimeClientService timeService) {
		this.timeService = timeService;
	}

	public TimeService getTimeFeignService() {
		return timeFeignService;
	}

	@Autowired
	public void setTimeFeignService(TimeService timeFeignService) {
		this.timeFeignService = timeFeignService;
	}
}
