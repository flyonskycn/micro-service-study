package com.flyonsky.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.flyonsky.mapper"})
public class RepositoryConfig {
}
