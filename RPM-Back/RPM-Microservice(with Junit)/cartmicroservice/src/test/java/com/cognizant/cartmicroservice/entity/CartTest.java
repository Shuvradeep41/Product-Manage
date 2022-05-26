package com.cognizant.cartmicroservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CartTest {
    @Test
    void testConstructor() {
        Cart actualCart = new Cart(123, "21654", null, 3, 123, 1);

        assertNull(actualCart.getCartId());
        assertEquals("Cart(cartId=null, productId=123, zipcode=21654, deliveryDate=null, vendorId=3, customerId=123,"
                + " quantity=1)", actualCart.toString());
        assertEquals("21654", actualCart.getZipcode());
        assertEquals(3, actualCart.getVendorId().intValue());
        assertEquals(1, actualCart.getQuantity());
        assertEquals(123, actualCart.getProductId().intValue());
        assertNull(actualCart.getDeliveryDate());
        assertEquals(123, actualCart.getCustomerId().intValue());
        assertNull(null);
    }
}

