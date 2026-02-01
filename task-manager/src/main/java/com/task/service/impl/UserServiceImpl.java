package com.task.service.impl;

import java.util.*;

import com.task.bean.*;
import com.task.dao.*;
import com.task.dto.*;
import com.task.model.*;
import com.task.service.*;


public class UserServiceImpl implements UserService {

    // private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    // Fields
    private UserDAO userDAO;


    // Constructor
    // ------------------------------------------------------------------------

    public UserServiceImpl(final UserDAO userDAO) {
        super();

        this.userDAO = userDAO;
    }


    // User Service Implementation
    // ------------------------------------------------------------------------

    @Override
    public int create(final UserBean bean) {
        // Sanity check
        if (Objects.isNull(bean)) {
            throw new IllegalArgumentException("UserBean is NULL");
        }

        // Create
        final int id = userDAO.create(bean);
        return id;
    }

    @Override
    public void update(final int id, final UserBean bean) {
        // Sanity check
        if (Objects.isNull(bean)) {
            throw new IllegalArgumentException("UserBean is NULL");
        }

        // Update
        userDAO.update(id, bean);
    }

    @Override
    public void purge(final int id) {
        // Purge
        userDAO.delete(id);
    }

    @Override
    public UserDTO read(final int id) {
        // Read
        final User user = userDAO.getById(id);

        // Convert to DTO
        final UserDTO dto = new UserDTO(user);
        return dto;
    }


    // Methods
    // ------------------------------------------------------------------------

}
