package com.example.evolent.exceptions.model;

public interface IdentifiedCustomError extends IdentifiedError {
    void customizeMessage(String customMessageReplacement);
}
