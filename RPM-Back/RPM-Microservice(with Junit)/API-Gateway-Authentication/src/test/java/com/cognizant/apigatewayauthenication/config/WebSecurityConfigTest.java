package com.cognizant.apigatewayauthenication.config;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.accept.ContentNegotiationStrategy;

@ContextConfiguration(classes = {WebSecurityConfig.class, AuthenticationManagerBuilder.class,
        AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
class WebSecurityConfigTest {
    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private AuthenticationTrustResolver authenticationTrustResolver;

    @MockBean
    private ContentNegotiationStrategy contentNegotiationStrategy;

    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @MockBean
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private ObjectPostProcessor<Object> objectPostProcessor;

    @MockBean
    private UserDetailsService userDetailsService;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @Test
    void testPasswordEncoder() {
        assertTrue(this.webSecurityConfig
                .passwordEncoder() instanceof org.springframework.security.crypto.password.NoOpPasswordEncoder);
    }


}

