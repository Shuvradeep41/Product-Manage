package com.cognizant.cartmicroservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VendorTest {
    @Test
    void testCanEqual() {
        assertFalse((new Vendor()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        Vendor vendor = new Vendor();
        assertTrue(vendor.canEqual(new Vendor()));
    }

    @Test
    void testConstructor() {
        Vendor actualVendor = new Vendor();
        actualVendor.setDeliveryCharge(10.0);
        actualVendor.setRating(10.0f);
        actualVendor.setVendorId(3);
        actualVendor.setVendorName("Vendor Name");
        assertEquals(10.0, actualVendor.getDeliveryCharge());
        assertEquals(10.0f, actualVendor.getRating());
        assertEquals(3, actualVendor.getVendorId().intValue());
        assertEquals("Vendor Name", actualVendor.getVendorName());
        assertEquals("Vendor(vendorId=3, vendorName=Vendor Name, deliveryCharge=10.0, rating=10.0)",
                actualVendor.toString());
    }

    @Test
    void testConstructor2() {
        Vendor actualVendor = new Vendor(3, "Vendor Name", 10.0, 10.0f);

        assertEquals(10.0, actualVendor.getDeliveryCharge());
        assertEquals("Vendor Name", actualVendor.getVendorName());
        assertEquals(3, actualVendor.getVendorId().intValue());
        assertEquals(10.0f, actualVendor.getRating());
    }

    @Test
    void testEquals() {
        assertFalse((new Vendor()).equals(null));
        assertFalse((new Vendor()).equals("Different type to Vendor"));
    }

    @Test
    void testEquals2() {
        Vendor vendor = new Vendor();
        assertTrue(vendor.equals(vendor));
        int expectedHashCodeResult = vendor.hashCode();
        assertEquals(expectedHashCodeResult, vendor.hashCode());
    }

    @Test
    void testEquals3() {
        Vendor vendor = new Vendor();
        Vendor vendor1 = new Vendor();
        assertTrue(vendor.equals(vendor1));
        int expectedHashCodeResult = vendor.hashCode();
        assertEquals(expectedHashCodeResult, vendor1.hashCode());
    }

    @Test
    void testEquals4() {
        Vendor vendor = new Vendor(3, "Vendor Name", 10.0, 10.0f);
        assertFalse(vendor.equals(new Vendor()));
    }

    @Test
    void testEquals5() {
        Vendor vendor = new Vendor();
        vendor.setVendorId(3);
        assertFalse(vendor.equals(new Vendor()));
    }

    @Test
    void testEquals6() {
        Vendor vendor = new Vendor();
        vendor.setRating(10.0f);
        assertFalse(vendor.equals(new Vendor()));
    }

    @Test
    void testEquals7() {
        Vendor vendor = new Vendor();

        Vendor vendor1 = new Vendor();
        vendor1.setVendorId(3);
        assertFalse(vendor.equals(vendor1));
    }

    @Test
    void testEquals8() {
        Vendor vendor = new Vendor();
        vendor.setVendorId(3);

        Vendor vendor1 = new Vendor();
        vendor1.setVendorId(3);
        assertTrue(vendor.equals(vendor1));
        int expectedHashCodeResult = vendor.hashCode();
        assertEquals(expectedHashCodeResult, vendor1.hashCode());
    }

    @Test
    void testEquals9() {
        Vendor vendor = new Vendor();
        vendor.setVendorName("Vendor Name");
        assertFalse(vendor.equals(new Vendor()));
    }
}

