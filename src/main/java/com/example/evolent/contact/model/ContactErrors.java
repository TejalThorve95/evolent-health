package com.example.evolent.contact.model;


import com.example.evolent.exceptions.model.IdentifiedError;
import org.springframework.http.HttpStatus;

public enum ContactErrors implements IdentifiedError {
    ECON001("Contact does not exist", HttpStatus.NOT_FOUND),
    ECON002("Contact already exists", HttpStatus.CONFLICT);

    private String message;
    private HttpStatus status;

    ContactErrors(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}
