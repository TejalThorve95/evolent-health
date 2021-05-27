package com.example.evolent.exceptions.model;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public interface IdentifiedError extends Serializable {

    String getCode();

    String getMessage();

    HttpStatus getStatus();
}
