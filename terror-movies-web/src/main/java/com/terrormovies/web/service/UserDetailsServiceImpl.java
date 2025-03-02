package com.terrormovies.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.terrormovies.web.dto.AuthDTO;


public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    // Constructor
    // ------------------------------------------------------------------------

    public UserDetailsServiceImpl() {
        super();
    }


    // Methods
    // ------------------------------------------------------------------------

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // User Details
        final AuthDTO userDetails = new AuthDTO();

        LOGGER.info("Loading user details :: {}", userDetails);
        return userDetails;
    }


}
