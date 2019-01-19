package com.flyonsky.service;

import org.flyonsky.boot.autoconfigure.cat.CatAnnotation;

public interface TimeService {

	@CatAnnotation
	String currentTime();
}
