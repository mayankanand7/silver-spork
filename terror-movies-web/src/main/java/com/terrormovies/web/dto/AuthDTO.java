package com.terrormovies.web.dto;

import static java.lang.Boolean.TRUE;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class AuthDTO implements UserDetails {

    private static final long serialVersionUID = 1L;


    // Constructor
    // ------------------------------------------------------------------------

    public AuthDTO() {
        super();
    }


    // UserDetails Methods
    // ------------------------------------------------------------------------

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return "admin";
    }

    @Override
    public String getUsername() {
        return "admin";
    }

    @Override
    public boolean isAccountNonExpired() {
        return TRUE;
    }

    @Override
    public boolean isAccountNonLocked() {
        return TRUE;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return TRUE;
    }

    @Override
    public boolean isEnabled() {
        return TRUE;
    }

}
