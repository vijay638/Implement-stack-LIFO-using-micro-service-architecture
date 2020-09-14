package com.Nokia.Stack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.Nokia.Stack")
//@EnableDiscoveryClient
public class StackImplementationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackImplementationServiceApplication.class, args);
	}

}
