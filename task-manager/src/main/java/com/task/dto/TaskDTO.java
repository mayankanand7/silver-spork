package com.task.dto;

import com.task.model.*;


public class TaskDTO {

    // Fields
    private final Integer id;
    private final Long version;

    private final Integer userId;
    private final Integer parentId;

    private final String title;
    private final String description;

    private final Boolean isCompleted;

    private final Long createdAt;
    private final Long updatedAt;

    private final Boolean isActive;


    // Constructor
    // ------------------------------------------------------------------------

    public TaskDTO(final Task task) {
        super();

        this.id = task.getId();
        this.version = task.getVersion();

        this.userId = task.getUserId();
        this.parentId = task.getParentId();

        this.title = task.getTitle();
        this.description = task.getDescription();

        this.isCompleted = task.getIsCompleted();

        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();

        this.isActive = task.getIsActive();
    }


    // Getters
    // ------------------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }


    // Methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return "TaskDTO [id=" + id + ", version=" + version + ", userId=" + userId + ", parentId=" + parentId
                + ", isActive=" + isActive + "]";
    }


}
