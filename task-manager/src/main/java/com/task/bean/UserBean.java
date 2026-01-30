package com.task.bean;

public class UserBean {

    // Fields
    private Long id;
    private Long version;

    private String username;

    private String firstName;
    private String lastName;

    private String email;
    private String phoneNumber;


    // Constructor
    // ------------------------------------------------------------------------

    public UserBean() {
        super();
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


    // Object Methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return "UserBean [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
                + email + ", phoneNumber=" + phoneNumber + "]";
    }


}
