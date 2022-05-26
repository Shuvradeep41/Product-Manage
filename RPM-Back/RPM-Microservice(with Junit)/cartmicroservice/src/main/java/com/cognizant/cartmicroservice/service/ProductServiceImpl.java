package com.cognizant.cartmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cartmicroservice.entity.Product;
import com.cognizant.cartmicroservice.feign.ProductClient;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Getter
@Setter
@Data

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductClient productClient;
	
	 @Override
	public Product getProductbyId(Integer productId) {	
		 log.info("call made to product microservice for Product of id:"+productId);
		 //return restTemplate.getForObject("http://PRODUCT-SERVICE/product/searchProductById/"+productId, Product.class);
		 return productClient.searchProductById(productId);
	 } 

}
