package com.cognizant.cartmicroservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.cartmicroservice.entity.Product;
import com.cognizant.cartmicroservice.feign.ProductClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @MockBean
    private ProductClient productClient;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Test
    void testGetProductbyId() {
        Product product = new Product();
        when(this.productClient.searchProductById((Integer) any())).thenReturn(product);
        assertSame(product, this.productServiceImpl.getProductbyId(123));
        verify(this.productClient).searchProductById((Integer) any());
        assertEquals("ProductServiceImpl(productClient=com.cognizant.cartmicroservice.feign.ProductClient#0 bean)",
                this.productServiceImpl.toString());
    }
}

