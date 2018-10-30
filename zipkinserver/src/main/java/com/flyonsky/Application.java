package com.flyonsky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class Application {

	public static void main(String[] args) {
		new SpringApplication(Application.class).run(args);
	}

}
