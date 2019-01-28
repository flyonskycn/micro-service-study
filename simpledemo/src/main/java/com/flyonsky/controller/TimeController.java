package com.flyonsky.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="时间管理")
@RestController
public class TimeController {
	
	@GetMapping("currentime")
	@ApiOperation("时间函数")
	public String currentime() throws InterruptedException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(Calendar.getInstance().getTime());
	}
}
