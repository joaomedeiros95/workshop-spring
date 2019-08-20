package com.joaomedeiros.workshopmongo.dto;

import com.joaomedeiros.workshopmongo.domain.User;
import java.io.Serializable;

/**
 * DTO to filter user data from a User.
 *
 * @see User
 */
public class UserDTO implements Serializable {

    private String id;

    private String name;

    private String email;

    public UserDTO() {
    }

    public UserDTO(final User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
