package com.flyonsky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;

import javax.annotation.Resource;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplication(Application.class).run(args);
	}

}
