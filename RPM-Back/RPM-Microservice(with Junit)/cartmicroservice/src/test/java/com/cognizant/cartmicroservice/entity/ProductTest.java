package com.cognizant.cartmicroservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    void testCanEqual() {
        assertFalse((new Product()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        Product product = new Product();
        assertTrue(product.canEqual(new Product()));
    }

    @Test
    void testConstructor() {
        Product actualProduct = new Product();
        actualProduct.setDescription("The characteristics of someone or something");
        actualProduct.setId(1);
        actualProduct.setImageName("Image Name");
        actualProduct.setName("Name");
        actualProduct.setNoOfUsersRated(1);
        actualProduct.setPrice(10.0);
        actualProduct.setRating(10.0f);
        assertEquals("The characteristics of someone or something", actualProduct.getDescription());
        assertEquals(1, actualProduct.getId().intValue());
        assertEquals("Image Name", actualProduct.getImageName());
        assertEquals("Name", actualProduct.getName());
        assertEquals(1, actualProduct.getNoOfUsersRated());
        assertEquals(10.0, actualProduct.getPrice());
        assertEquals(10.0f, actualProduct.getRating());
        assertEquals("Product(id=1, name=Name, price=10.0, description=The characteristics of someone or something,"
                + " imageName=Image Name, rating=10.0, noOfUsersRated=1)", actualProduct.toString());
    }

    @Test
    void testConstructor2() {
        Product actualProduct = new Product(1, "Name", 10.0, "The characteristics of someone or something", "Image Name",
                10.0f, 1);

        assertEquals("The characteristics of someone or something", actualProduct.getDescription());
        assertEquals(10.0f, actualProduct.getRating());
        assertEquals(10.0, actualProduct.getPrice());
        assertEquals(1, actualProduct.getNoOfUsersRated());
        assertEquals("Name", actualProduct.getName());
        assertEquals("Image Name", actualProduct.getImageName());
        assertEquals(1, actualProduct.getId().intValue());
    }

    @Test
    void testEquals() {
        assertFalse((new Product()).equals(null));
        assertFalse((new Product()).equals("Different type to Product"));
    }

    @Test
    void testEquals2() {
        Product product = new Product();
        assertTrue(product.equals(product));
        int expectedHashCodeResult = product.hashCode();
        assertEquals(expectedHashCodeResult, product.hashCode());
    }

    @Test
    void testEquals3() {
        Product product = new Product();
        Product product1 = new Product();
        assertTrue(product.equals(product1));
        int expectedHashCodeResult = product.hashCode();
        assertEquals(expectedHashCodeResult, product1.hashCode());
    }

    @Test
    void testEquals4() {
        Product product = new Product(1, "Name", 10.0, "The characteristics of someone or something", "Image Name", 10.0f,
                1);
        assertFalse(product.equals(new Product()));
    }

    @Test
    void testEquals5() {
        Product product = new Product();
        product.setId(1);
        assertFalse(product.equals(new Product()));
    }

    @Test
    void testEquals6() {
        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        assertFalse(product.equals(new Product()));
    }

    @Test
    void testEquals7() {
        Product product = new Product();
        product.setRating(10.0f);
        assertFalse(product.equals(new Product()));
    }

    @Test
    void testEquals8() {
        Product product = new Product(1, "Name", 10.0, "The characteristics of someone or something", "Image Name", 10.0f,
                1);
        Product product1 = new Product(1, "Name", 10.0, "The characteristics of someone or something", "Image Name", 10.0f,
                1);

        assertTrue(product.equals(product1));
        int expectedHashCodeResult = product.hashCode();
        assertEquals(expectedHashCodeResult, product1.hashCode());
    }

    @Test
    void testEquals9() {
        Product product = new Product();

        Product product1 = new Product();
        product1.setId(1);
        assertFalse(product.equals(product1));
    }

    @Test
    void testEquals10() {
        Product product = new Product();

        Product product1 = new Product();
        product1.setDescription("The characteristics of someone or something");
        assertFalse(product.equals(product1));
    }

    @Test
    void testEquals11() {
        Product product = new Product(1, "The characteristics of someone or something", 10.0,
                "The characteristics of someone or something", "Image Name", 10.0f, 1);
        assertFalse(product
                .equals(new Product(1, "Name", 10.0, "The characteristics of someone or something", "Image Name", 10.0f, 1)));
    }

    @Test
    void testEquals12() {
        Product product = new Product(1, null, 10.0, "The characteristics of someone or something", "Image Name", 10.0f, 1);
        assertFalse(product
                .equals(new Product(1, "Name", 10.0, "The characteristics of someone or something", "Image Name", 10.0f, 1)));
    }

    @Test
    void testEquals13() {
        Product product = new Product(1, "Name", 10.0, "The characteristics of someone or something", "Name", 10.0f, 1);
        assertFalse(product
                .equals(new Product(1, "Name", 10.0, "The characteristics of someone or something", "Image Name", 10.0f, 1)));
    }

    @Test
    void testEquals14() {
        Product product = new Product(1, "Name", 10.0, "The characteristics of someone or something", null, 10.0f, 1);
        assertFalse(product
                .equals(new Product(1, "Name", 10.0, "The characteristics of someone or something", "Image Name", 10.0f, 1)));
    }

    @Test
    void testEquals15() {
        Product product = new Product(1, "Name", 10.0, "The characteristics of someone or something", "Image Name", 10.0f,
                0);
        assertFalse(product
                .equals(new Product(1, "Name", 10.0, "The characteristics of someone or something", "Image Name", 10.0f, 1)));
    }
}

