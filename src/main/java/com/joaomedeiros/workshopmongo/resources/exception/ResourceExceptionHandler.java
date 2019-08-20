package com.joaomedeiros.workshopmongo.resources.exception;

import com.joaomedeiros.workshopmongo.services.exception.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(final ObjectNotFoundException e,
                                                        final HttpServletRequest request) {
        final HttpStatus status = HttpStatus.NOT_FOUND;
        final StandardError err = new StandardError(System.currentTimeMillis(), status.value(),
                "Not Found", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
