package com.flyonsky.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flyonsky.service.TimeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"时间管理"})
@RestController
public class TimeController {

	private TimeService timeService;
	
	@GetMapping("currentime")
	@ApiOperation("时间函数")
	public String currentime(){
		return this.getTimeService().currentTime();
	}
	
	@GetMapping("jsontime")
	@ApiOperation("时间函数")
	public Date jsonTime(){
		return Calendar.getInstance().getTime();
	}
	
	@PostMapping("totime")
	@ApiOperation("时间函数")
	public String toTime(@RequestBody Date time) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(time);
	}

	public TimeService getTimeService() {
		return timeService;
	}

	@Autowired
	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}
}
