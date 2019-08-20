package com.joaomedeiros.workshopmongo.resources.exception;

import java.io.Serializable;

/**
 * Standard error that will be used to show errors without throwing exceptions directly.
 */
public class StandardError implements Serializable {

    private Long timestamp;

    private Integer status;

    private String error;

    private String message;

    private String path;

    public StandardError() {

    }

    public StandardError(final Long timestamp, final Integer status, final String error,
                         final String message, final String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(final String path) {
        this.path = path;
    }
}
