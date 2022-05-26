package com.cognizant.apigatewayauthenication;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.netflix.zuul.http.HttpServletResponseWrapper;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.apache.catalina.filters.CorsFilter;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

class SimpleCORSFilterTest {
    @Test
    void testConstructor() {
        // TODO: This test is incomplete.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SimpleCORSFilter.log

        SimpleCORSFilter actualSimpleCORSFilter = new SimpleCORSFilter();
        actualSimpleCORSFilter.destroy();
        actualSimpleCORSFilter.init(new CorsFilter());
    }

    @Test
    void testDoFilter() throws IOException, ServletException {
        SimpleCORSFilter simpleCORSFilter = new SimpleCORSFilter();
        MockHttpServletRequest req = new MockHttpServletRequest();
        HttpServletResponseWrapper httpServletResponseWrapper = mock(HttpServletResponseWrapper.class);
        doNothing().when(httpServletResponseWrapper).setHeader((String) any(), (String) any());
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        simpleCORSFilter.doFilter(req, httpServletResponseWrapper, filterChain);
        verify(httpServletResponseWrapper, atLeast(1)).setHeader((String) any(), (String) any());
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
    }
}

