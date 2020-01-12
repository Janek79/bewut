package com.micro.bewut.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.micro.bewut")
@EnableMongoRepositories(basePackages = "com.micro.bewut.repository")
@EnableAspectJAutoProxy
public class AppConfig {

}
