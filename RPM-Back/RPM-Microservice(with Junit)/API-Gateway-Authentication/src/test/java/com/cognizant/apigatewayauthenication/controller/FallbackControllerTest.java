package com.cognizant.apigatewayauthenication.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FallbackController.class})
@ExtendWith(SpringExtension.class)
class FallbackControllerTest {
    @Autowired
    private FallbackController fallbackController;

    @Test
    void testCartServiceFallbackMethod() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cartServiceFallback");
        MockMvcBuilders.standaloneSetup(this.fallbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Cart Service failed"));
    }

    @Test
    void testCartServiceFallbackMethod2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cartServiceFallback", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.fallbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Cart Service failed"));
    }

    @Test
    void testECommercePortalServiceFallbackMethod() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ecommerceportalServiceFallback");
        MockMvcBuilders.standaloneSetup(this.fallbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("E-Commerce Portal Service failed"));
    }

    @Test
    void testECommercePortalServiceFallbackMethod2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/ecommerceportalServiceFallback");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.fallbackController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("E-Commerce Portal Service failed"));
    }

    @Test
    void testProductServiceFallbackMethod() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/productServiceFallback");
        MockMvcBuilders.standaloneSetup(this.fallbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Product Service failed"));
    }

    @Test
    void testProductServiceFallbackMethod2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/productServiceFallback");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.fallbackController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Product Service failed"));
    }

    @Test
    void testVendorServiceFallbackMethod() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vendorServiceFallback");
        MockMvcBuilders.standaloneSetup(this.fallbackController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Vendor Service failed"));
    }

    @Test
    void testVendorServiceFallbackMethod2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/vendorServiceFallback");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.fallbackController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Vendor Service failed"));
    }
}

