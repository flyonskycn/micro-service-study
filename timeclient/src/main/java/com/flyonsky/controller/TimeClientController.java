package com.flyonsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flyonsky.service.TimeClientService;

@RestController
public class TimeClientController {

	private TimeClientService timeService;
	
	@GetMapping("currentime")
	public String currentime() {
		return this.getTimeService().currentTime();
	}

	public TimeClientService getTimeService() {
		return timeService;
	}

	@Autowired
	public void setTimeService(TimeClientService timeService) {
		this.timeService = timeService;
	}
}
