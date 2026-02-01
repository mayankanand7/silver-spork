package com.task.dto;

import com.task.model.*;


public class UserDTO {

    // Fields
    private final int id;
    private final long version;

    private final String username;

    private final String firstName;
    private final String lastName;

    private final String email;
    private final String phoneNumber;

    private final Long createdAt;
    private final Long updatedAt;

    private final Boolean isActive;


    // Constructor
    // ------------------------------------------------------------------------

    public UserDTO(final User user) {
        super();

        this.id = user.getId();
        this.version = user.getVersion();

        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();

        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();

        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.isActive = user.getIsActive();
    }

    // Getters
    // ------------------------------------------------------------------------

    public int getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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


    // Object Methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return "UserDTO [id=" + id + ", version=" + version + ", username=" + username + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", isActive=" + isActive + "]";
    }


}
