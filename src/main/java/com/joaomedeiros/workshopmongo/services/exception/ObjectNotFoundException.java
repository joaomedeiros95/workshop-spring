package com.joaomedeiros.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(final String msg) {
        super(msg);
    }

}
