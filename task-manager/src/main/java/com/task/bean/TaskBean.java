package com.task.bean;

public class TaskBean {

    private Integer id;
    private Long version;

    private Integer userId;
    private Integer parentId;

    private String title;
    private String description;

    private Boolean isCompleted;
    private Boolean isActive;

    private Long createdAt;
    private Long updatedAt;


    // Constructor
    // ------------------------------------------------------------------------

    public TaskBean() {
        super();
    }


    // Getters and Setters
    // ------------------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }


    // Object Methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Task [id=" + id + ", version=" + version + ", userId=" + userId + ", parentId=" + parentId + ", title="
                + title + ", isCompleted=" + isCompleted + ", isActive=" + isActive + "]";
    }

}
