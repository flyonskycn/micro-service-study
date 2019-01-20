package com.flyonsky.service.imp;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.flyonsky.boot.autoconfigure.cat.CatAnnotation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flyonsky.service.TimeService;

@Service
public class TimeServiceImp implements TimeService{
	
	@Value("${server.port}")
	private int port;

	@Override
	@CatAnnotation
	public String currentTime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = Calendar.getInstance().getTime();
		return MessageFormat.format("{0} port : {1}", sf.format(now), port);
	}

}
