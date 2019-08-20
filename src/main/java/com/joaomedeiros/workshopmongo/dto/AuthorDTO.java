package com.joaomedeiros.workshopmongo.dto;

import com.joaomedeiros.workshopmongo.domain.User;
import java.io.Serializable;

/**
 * DTO to filter author data from a User.
 *
 * @see User
 */
public class AuthorDTO implements Serializable {

    private String id;

    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(final User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
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
}
