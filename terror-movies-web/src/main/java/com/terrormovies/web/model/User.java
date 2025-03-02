package com.terrormovies.web.model;

import static java.lang.Boolean.TRUE;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;


public class User extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = -1204517834265855380L;

    private String lastname;


    // Constructor
    // ------------------------------------------------------------------------

    public User(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
            String lastname) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

        this.lastname = lastname;
    }

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities, String lastname) {
        this(username, password, TRUE, TRUE, TRUE, TRUE, authorities, lastname);
    }


    // Getters
    // ------------------------------------------------------------------------

    public String getLastname() {
        return lastname;
    }

}
