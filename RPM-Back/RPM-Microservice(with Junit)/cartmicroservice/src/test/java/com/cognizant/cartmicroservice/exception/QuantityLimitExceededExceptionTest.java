package com.cognizant.cartmicroservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class QuantityLimitExceededExceptionTest {
    @Test
    void testConstructor() {
        assertEquals("QuantityLimitExceededException()",
                (new QuantityLimitExceededException("An error occurred")).toString());
    }
}

