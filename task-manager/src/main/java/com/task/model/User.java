package com.task.model;

import java.util.Objects;


public class User {

    // Fields
    private Long id;
    private Long version;

    private String username;

    private String firstName;
    private String lastName;

    private String email;
    private String phoneNumber;

    private Long createdAt;
    private Long updatedAt;

    private Boolean isActive;


    // Constructor
    // ------------------------------------------------------------------------

    public User() {
        super();
    }


    // Methods
    // ------------------------------------------------------------------------

    public void validate() {
        if (Objects.isNull(username) || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be BLANK");
        }

        if (Objects.isNull(email) || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be BLANK");
        }

        if (Objects.isNull(createdAt)) {
            throw new IllegalArgumentException("Created At timestamp cannot be NULL");
        }
    }


    // Getters and Setters
    // ------------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }


    // Object Methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", isActive=" + isActive + "]";
    }

}
