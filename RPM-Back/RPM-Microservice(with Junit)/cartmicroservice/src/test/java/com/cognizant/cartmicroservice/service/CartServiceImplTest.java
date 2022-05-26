package com.cognizant.cartmicroservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.cartmicroservice.Repository.CartRepository;
import com.cognizant.cartmicroservice.dao.CartDAO;
import com.cognizant.cartmicroservice.dto.CartRequestDTO;
import com.cognizant.cartmicroservice.entity.Cart;
import com.cognizant.cartmicroservice.entity.Vendor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CartServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CartServiceImplTest {
    @MockBean
    private CartDAO cartDAO;

    @MockBean
    private CartRepository cartRepository;

    @Autowired
    private CartServiceImpl cartServiceImpl;

    @MockBean
    private ProductService productService;

    @MockBean
    private VendorService vendorService;

    @Test
    void testExists() {
        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setCustomerId(123);
        cart.setProductId(123);
        cart.setDeliveryDate(null);
        cart.setVendorId(3);
        cart.setQuantity(1);
        cart.setZipcode("21654");
        when(this.cartDAO.existsDao((Integer) any(), (Integer) any())).thenReturn(cart);
        assertSame(cart, this.cartServiceImpl.exists(123, 123));
        verify(this.cartDAO).existsDao((Integer) any(), (Integer) any());
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testSaveCart() {
        doNothing().when(this.cartDAO).saveCartDao((Cart) any());

        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setCustomerId(123);
        cart.setProductId(123);
        cart.setDeliveryDate(null);
        cart.setVendorId(3);
        cart.setQuantity(1);
        cart.setZipcode("21654");
        this.cartServiceImpl.saveCart(cart);
        verify(this.cartDAO).saveCartDao((Cart) any());
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testAddProductToCart() {
        Vendor vendor = new Vendor();
        vendor.setVendorId(3);
        when(this.vendorService.getVendorDetails((Integer) any(), (Integer) any())).thenReturn(vendor);

        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setCustomerId(123);
        cart.setProductId(123);
        cart.setDeliveryDate(null);
        cart.setVendorId(3);
        cart.setQuantity(1);
        cart.setZipcode("21654");
        doNothing().when(this.cartDAO).saveCartDao((Cart) any());
        when(this.cartDAO.existsDao((Integer) any(), (Integer) any())).thenReturn(cart);

        CartRequestDTO cartRequestDTO = new CartRequestDTO();
        cartRequestDTO.setQuantity(0);
        assertEquals("Item Added Successfully to Cart", this.cartServiceImpl.addProductToCart(cartRequestDTO));
        verify(this.vendorService).getVendorDetails((Integer) any(), (Integer) any());
        verify(this.cartDAO).existsDao((Integer) any(), (Integer) any());
        verify(this.cartDAO).saveCartDao((Cart) any());
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testAddProductToCart2() {
        Vendor vendor = new Vendor(3, "Vendor Name", 10.0, 10.0f);
        vendor.setVendorId(3);
        when(this.vendorService.getVendorDetails((Integer) any(), (Integer) any())).thenReturn(vendor);

        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setCustomerId(123);
        cart.setProductId(123);
        cart.setDeliveryDate(null);
        cart.setVendorId(3);
        cart.setQuantity(1);
        cart.setZipcode("21654");
        doNothing().when(this.cartDAO).saveCartDao((Cart) any());
        when(this.cartDAO.existsDao((Integer) any(), (Integer) any())).thenReturn(cart);

        CartRequestDTO cartRequestDTO = new CartRequestDTO();
        cartRequestDTO.setQuantity(0);
        assertEquals("Item Added Successfully to Cart", this.cartServiceImpl.addProductToCart(cartRequestDTO));
        verify(this.vendorService).getVendorDetails((Integer) any(), (Integer) any());
        verify(this.cartDAO).existsDao((Integer) any(), (Integer) any());
        verify(this.cartDAO).saveCartDao((Cart) any());
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testAddProductToCart3() {
        Vendor vendor = new Vendor();
        vendor.setVendorId(123);
        when(this.vendorService.getVendorDetails((Integer) any(), (Integer) any())).thenReturn(vendor);

        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setCustomerId(123);
        cart.setProductId(123);
        cart.setDeliveryDate(null);
        cart.setVendorId(3);
        cart.setQuantity(1);
        cart.setZipcode("21654");
        doNothing().when(this.cartDAO).saveCartDao((Cart) any());
        when(this.cartDAO.existsDao((Integer) any(), (Integer) any())).thenReturn(cart);

        CartRequestDTO cartRequestDTO = new CartRequestDTO();
        cartRequestDTO.setQuantity(0);
        assertEquals("Item Added Successfully to Cart", this.cartServiceImpl.addProductToCart(cartRequestDTO));
        verify(this.vendorService).getVendorDetails((Integer) any(), (Integer) any());
        verify(this.cartDAO).existsDao((Integer) any(), (Integer) any());
        verify(this.cartDAO).saveCartDao((Cart) any());
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testAddProductToCart4() {
        Vendor vendor = new Vendor();
        vendor.setVendorId(0);
        when(this.vendorService.getVendorDetails((Integer) any(), (Integer) any())).thenReturn(vendor);

        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setCustomerId(123);
        cart.setProductId(123);
        cart.setDeliveryDate(null);
        cart.setVendorId(3);
        cart.setQuantity(1);
        cart.setZipcode("21654");
        doNothing().when(this.cartDAO).saveCartDao((Cart) any());
        when(this.cartDAO.existsDao((Integer) any(), (Integer) any())).thenReturn(cart);

        CartRequestDTO cartRequestDTO = new CartRequestDTO();
        cartRequestDTO.setQuantity(0);
        assertEquals("Not Enough Stock", this.cartServiceImpl.addProductToCart(cartRequestDTO));
        verify(this.vendorService).getVendorDetails((Integer) any(), (Integer) any());
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testAddProductToCart5() {
        Vendor vendor = new Vendor(3, "Vendor Name", 10.0, 10.0f);
        vendor.setVendorId(0);
        when(this.vendorService.getVendorDetails((Integer) any(), (Integer) any())).thenReturn(vendor);

        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setCustomerId(123);
        cart.setProductId(123);
        cart.setDeliveryDate(null);
        cart.setVendorId(3);
        cart.setQuantity(1);
        cart.setZipcode("21654");
        doNothing().when(this.cartDAO).saveCartDao((Cart) any());
        when(this.cartDAO.existsDao((Integer) any(), (Integer) any())).thenReturn(cart);

        CartRequestDTO cartRequestDTO = new CartRequestDTO();
        cartRequestDTO.setQuantity(0);
        assertEquals("Item Added Successfully to Cart", this.cartServiceImpl.addProductToCart(cartRequestDTO));
        verify(this.vendorService).getVendorDetails((Integer) any(), (Integer) any());
        verify(this.cartDAO).existsDao((Integer) any(), (Integer) any());
        verify(this.cartDAO).saveCartDao((Cart) any());
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testIsVendorEmpty() {
        Vendor vendor = new Vendor();
        vendor.setVendorId(3);
        assertFalse(this.cartServiceImpl.isVendorEmpty(vendor));
    }

    @Test
    void testIsVendorEmpty2() {
        Vendor vendor = mock(Vendor.class);
        when(vendor.getVendorId()).thenReturn(3);
        assertFalse(this.cartServiceImpl.isVendorEmpty(vendor));
        verify(vendor).getVendorId();
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testIsVendorEmpty3() {
        Vendor vendor = mock(Vendor.class);
        when(vendor.getDeliveryCharge()).thenReturn(10.0);
        when(vendor.getVendorId()).thenReturn(0);
        assertFalse(this.cartServiceImpl.isVendorEmpty(vendor));
        verify(vendor).getDeliveryCharge();
        verify(vendor).getVendorId();
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testIsVendorEmpty4() {
        Vendor vendor = mock(Vendor.class);
        when(vendor.getRating()).thenReturn(10.0f);
        when(vendor.getDeliveryCharge()).thenReturn(0.0);
        when(vendor.getVendorId()).thenReturn(0);
        assertFalse(this.cartServiceImpl.isVendorEmpty(vendor));
        verify(vendor).getDeliveryCharge();
        verify(vendor).getRating();
        verify(vendor).getVendorId();
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testIsVendorEmpty5() {
        Vendor vendor = mock(Vendor.class);
        when(vendor.getRating()).thenReturn(0.0f);
        when(vendor.getDeliveryCharge()).thenReturn(0.0);
        when(vendor.getVendorId()).thenReturn(0);
        assertTrue(this.cartServiceImpl.isVendorEmpty(vendor));
        verify(vendor).getDeliveryCharge();
        verify(vendor).getRating();
        verify(vendor).getVendorId();
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testRemoveProductFromCart() {
        doNothing().when(this.cartRepository).deleteById((Integer) any());
        assertEquals("Item Added Successfully to Cart", this.cartServiceImpl.removeProductFromCart(123));
        verify(this.cartRepository).deleteById((Integer) any());
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }

    @Test
    void testRemoveCart() {
        doNothing().when(this.cartDAO).saveCartDao((Cart) any());

        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setCustomerId(123);
        cart.setProductId(123);
        cart.setDeliveryDate(null);
        cart.setVendorId(3);
        cart.setQuantity(1);
        cart.setZipcode("21654");
        this.cartServiceImpl.removeCart(cart);
        verify(this.cartDAO).saveCartDao((Cart) any());
        assertEquals("CartServiceImpl(cartDAOImpl=com.cognizant.cartmicroservice.dao.CartDAO#0 bean, cartRepository=com"
                + ".cognizant.cartmicroservice.Repository.CartRepository#0 bean, productServiceImpl=com.cognizant"
                + ".cartmicroservice.service.ProductService#0 bean, vendorServiceImpl=com.cognizant.cartmicroservice"
                + ".service.VendorService#0 bean)", this.cartServiceImpl.toString());
    }
}

