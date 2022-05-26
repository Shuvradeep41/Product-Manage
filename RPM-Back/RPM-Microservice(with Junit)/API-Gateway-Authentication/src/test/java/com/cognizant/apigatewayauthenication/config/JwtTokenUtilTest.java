package com.cognizant.apigatewayauthenication.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JwtTokenUtilTest {

	@Test
	void test() {
		JwtTokenUtil jwt=new JwtTokenUtil();
		jwt.setSecret("Hello");
		assertEquals("Hello",jwt.getSecret());
	}

}
