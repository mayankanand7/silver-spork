package com.task.dto;

import com.task.model.*;


public class OrgDTO {

    // Fields
    private final int id;
    private final long version;

    private final String name;
    private final String description;

    private final String addressLine1;
    private final String addressLine2;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String country;

    private final String phoneNumber;
    private final String email;

    private final long createdAt;
    private final long updatedAt;

    private final boolean isActive;


    // Constructor
    // ------------------------------------------------------------------------

    public OrgDTO(Org org) {
        super();

        this.id = org.getId();
        this.version = org.getVersion();

        this.name = org.getName();
        this.description = org.getDescription();
        this.addressLine1 = org.getAddressLine1();
        this.addressLine2 = org.getAddressLine2();
        this.city = org.getCity();
        this.state = org.getState();
        this.zipCode = org.getZipCode();
        this.country = org.getCountry();

        this.phoneNumber = org.getPhoneNumber();
        this.email = org.getEmail();

        this.createdAt = org.getCreatedAt();
        this.updatedAt = org.getUpdatedAt();

        this.isActive = org.getIsActive();
    }


    // Getters
    // ------------------------------------------------------------------------

    public int getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public boolean getIsActive() {
        return isActive;
    }


    // Object Methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return "OrgDTO [id=" + id + ", version=" + version + ", name=" + name + ", phoneNumber=" + phoneNumber
                + ", email=" + email + ", isActive=" + isActive + "]";
    }


}
