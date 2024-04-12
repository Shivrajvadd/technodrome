package com.technodrome.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.technodrome.demo.controller.EmployeeController;

@SpringBootApplication
public class TechnodromeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnodromeApplication.class, args);
	}

}
