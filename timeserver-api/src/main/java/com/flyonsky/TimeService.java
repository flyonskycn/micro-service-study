package com.flyonsky;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="${servers.timeserver:timeserver}",fallback = TimeService.TimeServiceFallBack.class)
public interface TimeService {
	
	@GetMapping("currentime")
	String currentime();

	@Component
	public static class TimeServiceFallBack implements TimeService{
		@Override
		public String currentime() {
			return "ERROR";
		}
	}
}
