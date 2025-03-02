package com.terrormovies.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


public class ServerErrorFailureHandler implements AuthenticationFailureHandler {


    // AuthenticationFailureHandler Method
    // ------------------------------------------------------------------------

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        // Set Error Code
        response.sendError(500, "Server failed to authenticate you!");
    }

}
