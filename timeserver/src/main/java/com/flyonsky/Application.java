package com.flyonsky;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;

import com.spring4all.swagger.EnableSwagger2Doc;

@SpringCloudApplication
@EnableSwagger2Doc 
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).run(args);
	}
}
