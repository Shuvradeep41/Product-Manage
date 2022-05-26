package com.cognizant.cartmicroservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CartEmptyExceptionTest {
    @Test
    void testConstructor() {
        assertEquals("CartEmptyException()", (new CartEmptyException()).toString());
        assertEquals("CartEmptyException()", (new CartEmptyException("An error occurred")).toString());
    }
}

