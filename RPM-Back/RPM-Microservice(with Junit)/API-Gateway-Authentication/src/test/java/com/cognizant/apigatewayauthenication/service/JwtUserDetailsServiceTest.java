package com.cognizant.apigatewayauthenication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.apigatewayauthenication.entity.User;
import com.cognizant.apigatewayauthenication.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtUserDetailsService.class})
@ExtendWith(SpringExtension.class)
class JwtUserDetailsServiceTest {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User();
        user.setPassword("iloveyou");
        user.setUsername("janedoe");
        user.setUserid(1);
        when(this.userRepository.findByUsername((String) any())).thenReturn(user);
        UserDetails actualLoadUserByUsernameResult = this.jwtUserDetailsService.loadUserByUsername("janedoe");
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepository).findByUsername((String) any());
    }

    @Test
    void testGetUserId() {
        when(this.userRepository.getUserID((String) any())).thenReturn(1);
        assertEquals(1, this.jwtUserDetailsService.getUserId("janedoe"));
        verify(this.userRepository).getUserID((String) any());
    }
}

