package com.task.service.impl;

import java.util.*;

import com.task.bean.*;
import com.task.dao.*;
import com.task.dto.*;
import com.task.model.*;
import com.task.service.*;


public class OrgServiceImpl implements OrgService {

    // private static final Logger LOGGER = LoggerFactory.getLogger(OrgServiceImpl.class);


    // Fields
    private OrgDAO orgDAO;


    // Constructor
    // ------------------------------------------------------------------------

    public OrgServiceImpl(final OrgDAO orgDAO) {
        super();

        this.orgDAO = orgDAO;
    }


    // Org Service Implementation
    // ------------------------------------------------------------------------

    @Override
    public int create(final OrgBean bean) {
        // Sanity check
        if (Objects.isNull(bean)) {
            throw new IllegalArgumentException("OrgBean is NULL");
        }

        // Create
        final int id = orgDAO.create(bean);
        return id;
    }

    @Override
    public void update(final int id, final OrgBean bean) {
        // Sanity check
        if (Objects.isNull(bean)) {
            throw new IllegalArgumentException("OrgBean is NULL");
        }

        // Update
        orgDAO.update(id, bean);
    }

    @Override
    public void purge(final int id) {
        // Purge
        orgDAO.delete(id);
    }

    @Override
    public OrgDTO read(final int id) {
        // Read
        final Org org = orgDAO.getById(id);

        // Convert to DTO
        final OrgDTO dto = new OrgDTO(org);
        return dto;
    }


    // Methods
    // ------------------------------------------------------------------------

}
