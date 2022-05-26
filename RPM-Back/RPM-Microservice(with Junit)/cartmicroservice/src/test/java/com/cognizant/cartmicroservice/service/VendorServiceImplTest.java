package com.cognizant.cartmicroservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.cartmicroservice.entity.Vendor;
import com.cognizant.cartmicroservice.feign.VendorClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {VendorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class VendorServiceImplTest {
    @MockBean
    private VendorClient vendorClient;

    @Autowired
    private VendorServiceImpl vendorServiceImpl;

    @Test
    void testGetVendorById() {
        Vendor vendor = new Vendor();
        when(this.vendorClient.getVendorDetails((Integer) any())).thenReturn(vendor);
        assertSame(vendor, this.vendorServiceImpl.getVendorById(3));
        verify(this.vendorClient).getVendorDetails((Integer) any());
        assertEquals("VendorServiceImpl(vendorClient=com.cognizant.cartmicroservice.feign.VendorClient#0 bean)",
                this.vendorServiceImpl.toString());
    }

    @Test
    void testGetVendorDetails() {
        Vendor vendor = new Vendor();
        when(this.vendorClient.getBestVendor((Integer) any(), (Integer) any())).thenReturn(vendor);
        assertSame(vendor, this.vendorServiceImpl.getVendorDetails(123, 1));
        verify(this.vendorClient).getBestVendor((Integer) any(), (Integer) any());
        assertEquals("VendorServiceImpl(vendorClient=com.cognizant.cartmicroservice.feign.VendorClient#0 bean)",
                this.vendorServiceImpl.toString());
    }
}

