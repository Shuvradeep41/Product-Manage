package com.cognizant.cartmicroservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CustomerWishlistTest {
    @Test
    void testConstructor() {
        CustomerWishlist actualCustomerWishlist = new CustomerWishlist(123, 1, null, 123);

        assertNull(actualCustomerWishlist.getAddedToWishlistDate());
        assertEquals(
                "CustomerWishlist(wishListId=null, productId=123, quantity=1, addedToWishlistDate=null," + " customerId=123)",
                actualCustomerWishlist.toString());
        assertNull(actualCustomerWishlist.getWishListId());
        assertEquals(1, actualCustomerWishlist.getQuantity());
        assertEquals(123, actualCustomerWishlist.getProductId().intValue());
        assertEquals(123, actualCustomerWishlist.getCustomerId().intValue());
        assertNull(null);
    }
}

