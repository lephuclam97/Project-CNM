package com.letsstartcoding.springbootrestapiexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.letsstartcoding.springbootrestapiexample.dao.DriverDAO;
import com.letsstartcoding.springbootrestapiexample.model.Driver;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"realtime"})
@ComponentScan(basePackages = {"com.letsstartcoding.springbootrestapiexample.controller"})
public class restApiRun {
	
	public static void main(String[] args) {
		SpringApplication.run(restApiRun.class, args);
	}

}
