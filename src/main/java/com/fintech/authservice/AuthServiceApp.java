package com.fintech.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@RestController
public class AuthServiceApp {

    @GetMapping("/message")
	public String message(){
		return " Application has been deployed in Azure" ;
	}
	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApp.class, args);
	}

}
