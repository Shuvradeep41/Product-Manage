package com.cognizant.apigatewayauthenication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
@EnableEurekaServer
@EnableZuulProxy
@EnableWebSecurity
public class APIGatewayAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(APIGatewayAuthenticationApplication.class, args);
	}
	
}
