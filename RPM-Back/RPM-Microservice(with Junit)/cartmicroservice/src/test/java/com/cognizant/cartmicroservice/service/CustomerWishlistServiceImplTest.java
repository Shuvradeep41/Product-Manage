package com.cognizant.cartmicroservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.cartmicroservice.Repository.CustomerWishlistRepository;
import com.cognizant.cartmicroservice.dao.CustomerWishlistDAO;
import com.cognizant.cartmicroservice.dto.CustomerWishlistRequestDTO;
import com.cognizant.cartmicroservice.entity.CustomerWishlist;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerWishlistServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CustomerWishlistServiceImplTest {
    @MockBean
    private CustomerWishlistDAO customerWishlistDAO;

    @MockBean
    private CustomerWishlistRepository customerWishlistRepository;

    @Autowired
    private CustomerWishlistServiceImpl customerWishlistServiceImpl;

    @MockBean
    private ProductService productService;

    @Test
    void testSaveCustomerWishlist() {
        doNothing().when(this.customerWishlistDAO).saveCustomerWishlistDao((CustomerWishlist) any());

        CustomerWishlist customerWishlist = new CustomerWishlist();
        customerWishlist.setAddedToWishlistDate(null);
        customerWishlist.setWishListId(123);
        customerWishlist.setCustomerId(123);
        customerWishlist.setProductId(123);
        customerWishlist.setQuantity(1);
        this.customerWishlistServiceImpl.saveCustomerWishlist(customerWishlist);
        verify(this.customerWishlistDAO).saveCustomerWishlistDao((CustomerWishlist) any());
        assertEquals(
                "CustomerWishlistServiceImpl(customerWishlistDAOImpl=com.cognizant.cartmicroservice.dao.CustomerWishlistDAO#0"
                        + " bean, productServiceImpl=com.cognizant.cartmicroservice.service.ProductService#0 bean, customerWish"
                        + "listRepository=com.cognizant.cartmicroservice.Repository.CustomerWishlistRepository#0 bean)",
                this.customerWishlistServiceImpl.toString());
    }

    @Test
    void testExistsCustomerWishlist() {
        CustomerWishlist customerWishlist = new CustomerWishlist();
        customerWishlist.setAddedToWishlistDate(null);
        customerWishlist.setWishListId(123);
        customerWishlist.setCustomerId(123);
        customerWishlist.setProductId(123);
        customerWishlist.setQuantity(1);
        when(this.customerWishlistDAO.existsCustomerWishlistDao((Integer) any(), (Integer) any()))
                .thenReturn(customerWishlist);
        assertSame(customerWishlist, this.customerWishlistServiceImpl.existsCustomerWishlist(123, 123));
        verify(this.customerWishlistDAO).existsCustomerWishlistDao((Integer) any(), (Integer) any());
        assertEquals(
                "CustomerWishlistServiceImpl(customerWishlistDAOImpl=com.cognizant.cartmicroservice.dao.CustomerWishlistDAO#0"
                        + " bean, productServiceImpl=com.cognizant.cartmicroservice.service.ProductService#0 bean, customerWish"
                        + "listRepository=com.cognizant.cartmicroservice.Repository.CustomerWishlistRepository#0 bean)",
                this.customerWishlistServiceImpl.toString());
    }

    @Test
    void testGetCustomerWishlistById() {
        when(this.customerWishlistDAO.getCustomerWishlistByIdDao((Integer) any())).thenReturn(null);
        assertNull(this.customerWishlistServiceImpl.getCustomerWishlistById(123));
        verify(this.customerWishlistDAO).getCustomerWishlistByIdDao((Integer) any());
        assertEquals(
                "CustomerWishlistServiceImpl(customerWishlistDAOImpl=com.cognizant.cartmicroservice.dao.CustomerWishlistDAO#0"
                        + " bean, productServiceImpl=com.cognizant.cartmicroservice.service.ProductService#0 bean, customerWish"
                        + "listRepository=com.cognizant.cartmicroservice.Repository.CustomerWishlistRepository#0 bean)",
                this.customerWishlistServiceImpl.toString());
    }

    @Test
    void testAddToCustomerWishList() {
        CustomerWishlist customerWishlist = new CustomerWishlist();
        customerWishlist.setAddedToWishlistDate(null);
        customerWishlist.setWishListId(123);
        customerWishlist.setCustomerId(123);
        customerWishlist.setProductId(123);
        customerWishlist.setQuantity(1);
        doNothing().when(this.customerWishlistDAO).saveCustomerWishlistDao((CustomerWishlist) any());
        when(this.customerWishlistDAO.existsCustomerWishlistDao((Integer) any(), (Integer) any()))
                .thenReturn(customerWishlist);
        assertEquals("SuccessFully Added to WishList",
                this.customerWishlistServiceImpl.addToCustomerWishList(new CustomerWishlistRequestDTO()).getMessage());
        verify(this.customerWishlistDAO).existsCustomerWishlistDao((Integer) any(), (Integer) any());
        verify(this.customerWishlistDAO).saveCustomerWishlistDao((CustomerWishlist) any());
        assertEquals(
                "CustomerWishlistServiceImpl(customerWishlistDAOImpl=com.cognizant.cartmicroservice.dao.CustomerWishlistDAO#0"
                        + " bean, productServiceImpl=com.cognizant.cartmicroservice.service.ProductService#0 bean, customerWish"
                        + "listRepository=com.cognizant.cartmicroservice.Repository.CustomerWishlistRepository#0 bean)",
                this.customerWishlistServiceImpl.toString());
    }

    @Test
    void testAddToCustomerWishList2() {
        CustomerWishlist customerWishlist = new CustomerWishlist();
        customerWishlist.setAddedToWishlistDate(null);
        customerWishlist.setWishListId(123);
        customerWishlist.setCustomerId(123);
        customerWishlist.setProductId(123);
        customerWishlist.setQuantity(1);
        doNothing().when(this.customerWishlistDAO).saveCustomerWishlistDao((CustomerWishlist) any());
        when(this.customerWishlistDAO.existsCustomerWishlistDao((Integer) any(), (Integer) any()))
                .thenReturn(customerWishlist);
        CustomerWishlistRequestDTO customerWishlistRequestDTO = mock(CustomerWishlistRequestDTO.class);
        when(customerWishlistRequestDTO.getCustomerId()).thenReturn(123);
        when(customerWishlistRequestDTO.getQuantity()).thenReturn(1);
        when(customerWishlistRequestDTO.getProductId()).thenReturn(123);
        assertEquals("SuccessFully Added to WishList",
                this.customerWishlistServiceImpl.addToCustomerWishList(customerWishlistRequestDTO).getMessage());
        verify(this.customerWishlistDAO).existsCustomerWishlistDao((Integer) any(), (Integer) any());
        verify(this.customerWishlistDAO).saveCustomerWishlistDao((CustomerWishlist) any());
        verify(customerWishlistRequestDTO, atLeast(1)).getCustomerId();
        verify(customerWishlistRequestDTO, atLeast(1)).getProductId();
        verify(customerWishlistRequestDTO, atLeast(1)).getQuantity();
        assertEquals(
                "CustomerWishlistServiceImpl(customerWishlistDAOImpl=com.cognizant.cartmicroservice.dao.CustomerWishlistDAO#0"
                        + " bean, productServiceImpl=com.cognizant.cartmicroservice.service.ProductService#0 bean, customerWish"
                        + "listRepository=com.cognizant.cartmicroservice.Repository.CustomerWishlistRepository#0 bean)",
                this.customerWishlistServiceImpl.toString());
    }

    @Test
    void testRemoveProductFromWishlist() {
        doNothing().when(this.customerWishlistRepository).deleteById((Integer) any());
        assertEquals("Item Added Successfully to Cart", this.customerWishlistServiceImpl.removeProductFromWishlist(123));
        verify(this.customerWishlistRepository).deleteById((Integer) any());
        assertEquals(
                "CustomerWishlistServiceImpl(customerWishlistDAOImpl=com.cognizant.cartmicroservice.dao.CustomerWishlistDAO#0"
                        + " bean, productServiceImpl=com.cognizant.cartmicroservice.service.ProductService#0 bean, customerWish"
                        + "listRepository=com.cognizant.cartmicroservice.Repository.CustomerWishlistRepository#0 bean)",
                this.customerWishlistServiceImpl.toString());
    }

    @Test
    void testRemoveWishlist() {
        doNothing().when(this.customerWishlistDAO).saveCustomerWishlistDao((CustomerWishlist) any());

        CustomerWishlist customerWishlist = new CustomerWishlist();
        customerWishlist.setAddedToWishlistDate(null);
        customerWishlist.setWishListId(123);
        customerWishlist.setCustomerId(123);
        customerWishlist.setProductId(123);
        customerWishlist.setQuantity(1);
        this.customerWishlistServiceImpl.removeWishlist(customerWishlist);
        verify(this.customerWishlistDAO).saveCustomerWishlistDao((CustomerWishlist) any());
        assertEquals(
                "CustomerWishlistServiceImpl(customerWishlistDAOImpl=com.cognizant.cartmicroservice.dao.CustomerWishlistDAO#0"
                        + " bean, productServiceImpl=com.cognizant.cartmicroservice.service.ProductService#0 bean, customerWish"
                        + "listRepository=com.cognizant.cartmicroservice.Repository.CustomerWishlistRepository#0 bean)",
                this.customerWishlistServiceImpl.toString());
    }
}

