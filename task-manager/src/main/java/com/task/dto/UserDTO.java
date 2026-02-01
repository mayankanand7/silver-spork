package com.task.dto;

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
    }


    // Methods
    // ------------------------------------------------------------------------

}
