package com.flyonsky.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flyonsky.filter.AccessFilter;
import com.netflix.zuul.ZuulFilter;

@Configuration
public class FilterConfig {

	@Bean
	public ZuulFilter accessTokenFilter() {
		return new AccessFilter();
	}
}
