package com.terrormovies.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    //

    @RequestMapping(value = "/custom_login", method = RequestMethod.GET)
    public String showLogin() {
        LOGGER.info("Login is requested");

        // Logical view name
        return "login";
    }

}
