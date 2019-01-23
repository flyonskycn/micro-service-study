package com.flyonsky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flyonsky.service.TimeService;

@RestController
public class TimeController {

	private TimeService timeService;
	
	@GetMapping("currentime")
	public String currentime() throws InterruptedException {
		return this.getTimeService().currentTime();
	}

	public TimeService getTimeService() {
		return timeService;
	}

	@Autowired
	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}
}
