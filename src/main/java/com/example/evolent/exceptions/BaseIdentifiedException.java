package com.example.evolent.exceptions;


import com.example.evolent.exceptions.model.ErrorMessage;
import com.example.evolent.exceptions.model.ErrorMessage.ErrorMessageBuilder;
import com.example.evolent.exceptions.model.IdentifiedCustomError;
import com.example.evolent.exceptions.model.IdentifiedError;

public class BaseIdentifiedException extends RuntimeException {

    private final IdentifiedError error;

    public BaseIdentifiedException(IdentifiedError error) {
        super(error.getMessage());
        this.error = error;
    }

    public BaseIdentifiedException(IdentifiedError error, String customMessageReplacement) {
        super(error.getMessage());
        this.error = error;
        if (error instanceof IdentifiedCustomError) {
            ((IdentifiedCustomError) error).customizeMessage(customMessageReplacement);
        }
    }

    public IdentifiedError getError() {
        return error;
    }

    public ErrorMessage getErrorMessageForPath(String path) {
        return ErrorMessageBuilder.anErrorMessage().fromIdentifiedError(getError()).withPath(path).build();
    }
}
