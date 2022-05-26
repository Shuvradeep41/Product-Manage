package com.cognizant.apigatewayauthenication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@RestController
public class FallbackController {
	
	@GetMapping("productServiceFallback")
	public String productServiceFallbackMethod() {
		return "Product Service failed";
	}
	 
	@GetMapping("cartServiceFallback")
	public String cartServiceFallbackMethod() {
		return "Cart Service failed";
	}
	
	@GetMapping("vendorServiceFallback")
	public String vendorServiceFallbackMethod() {
		return "Vendor Service failed";
	}
	
	
	@GetMapping("ecommerceportalServiceFallback")
	public String eCommercePortalServiceFallbackMethod() {
		return "E-Commerce Portal Service failed";
	}
}
