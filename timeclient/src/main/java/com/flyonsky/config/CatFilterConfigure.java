package com.flyonsky.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dianping.cat.servlet.CatFilter;

@Configuration
public class CatFilterConfigure {
	
    @Bean
    public FilterRegistrationBean<CatFilter> catFilter() {
        FilterRegistrationBean<CatFilter> registration = new FilterRegistrationBean<CatFilter>();
        CatFilter filter = new CatFilter();
        registration.setFilter(filter);
        registration.addUrlPatterns("/*");
        registration.setName("cat-filter");
        registration.setOrder(1);
        return registration;
    }
}
