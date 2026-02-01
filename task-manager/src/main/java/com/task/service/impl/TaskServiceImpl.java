package com.task.service.impl;

import com.task.bean.*;
import com.task.dao.*;
import com.task.dto.*;
import com.task.model.*;
import com.task.service.*;


public class TaskServiceImpl implements TaskService {

    // private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);


    // Fields
    private TaskDAO taskDAO;


    // Constructor
    // ------------------------------------------------------------------------

    public TaskServiceImpl(final TaskDAO taskDAO) {
        super();

        this.taskDAO = taskDAO;
    }


    // Task Service Implementation
    // ------------------------------------------------------------------------

    @Override
    public int create(final TaskBean bean) {
        // Sanity check
        if (bean == null) {
            throw new IllegalArgumentException("TaskBean is NULL");
        }

        // Create
        final int id = taskDAO.create(bean);
        return id;
    }

    @Override
    public void update(final int id, final TaskBean bean) {
        // Sanity check
        if (bean == null) {
            throw new IllegalArgumentException("TaskBean is NULL");
        }

        // Update
        taskDAO.update(id, bean);
    }

    @Override
    public void purge(final int id) {
        // Purge
        taskDAO.delete(id);
    }

    @Override
    public TaskDTO read(final int id) {
        // Read
        final Task task = taskDAO.getById(id);

        // Convert to DTO
        final TaskDTO dto = new TaskDTO(task);
        return dto;
    }


    // Methods
    // ------------------------------------------------------------------------

}
