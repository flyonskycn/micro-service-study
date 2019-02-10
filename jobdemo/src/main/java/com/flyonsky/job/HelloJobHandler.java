package com.flyonsky.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@Component
@JobHandler("helloJob")
public class HelloJobHandler extends IJobHandler{
	
	private static final Logger LOG = LoggerFactory.getLogger(HelloJobHandler.class);

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		LOG.info("hello job");
		return ReturnT.SUCCESS;
	}

}
