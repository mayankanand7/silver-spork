package com.terrormovies.web.security;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.terrormovies.web.model.User;


public class CustomInMemoryUserDetailsManager implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomInMemoryUserDetailsManager.class);

    private Map<String, User> users = new HashMap<>();


    // Constructor
    // ------------------------------------------------------------------------

    public CustomInMemoryUserDetailsManager() {
        super();
    }

    public CustomInMemoryUserDetailsManager(Collection<User> users) {
        for (User user : users) {
            this.users.put(user.getUsername().toLowerCase(), user);
        }
    }


    // Methods
    // ------------------------------------------------------------------------

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // User
        final User user = users.get(username.toLowerCase());
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(username);
        }

        final User userNew =
                new User(user.getUsername(), user.getPassword(), user.getAuthorities(), user.getLastname());
        return userNew;
    }

}
