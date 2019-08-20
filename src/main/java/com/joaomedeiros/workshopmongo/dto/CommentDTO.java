package com.joaomedeiros.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO to represent Comments, we don't store comments on a separate document on database so we just
 * have a DTO here.
 */
public class CommentDTO implements Serializable {

    private String text;

    private Date date;

    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(final String text, final Date date, final AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(final AuthorDTO author) {
        this.author = author;
    }
}
