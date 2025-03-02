package com.terrormovies.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);


    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    @ResponseBody
    public String createMovie(@RequestBody String movie) {
        LOGGER.info("Adding movie :: {}", movie);

        return "created";
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ResponseBody
    public String getMovie() {
        // User Info
        final UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOGGER.info("User info :: {}", user);

        LOGGER.info("Getting movie");
        return String.format("User %s, is accessing the movie ABC", user.getUsername());
    }

}
