package com.cognizant.apigatewayauthenication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.apigatewayauthenication.controller.FallbackController;
import com.cognizant.apigatewayauthenication.entity.JwtResponse;

@SpringBootTest
public class APIGatewayAuthenticationApplicationTests {
	@Autowired
	APIGatewayAuthenticationApplication apiGeteWay;
	@Test
	public void main() {
		apiGeteWay.main(new String[] {});
	}
	
	@Test
	void abc() {
		JwtResponse jwtResponse=new JwtResponse("sdf", 12);
		jwtResponse.setCustomerId(345);
		jwtResponse.setJwttoken("ghj");
		assertEquals(345, jwtResponse.getCustomerId());
		assertEquals("ghj", jwtResponse.getJwttoken());
	}


	
}
