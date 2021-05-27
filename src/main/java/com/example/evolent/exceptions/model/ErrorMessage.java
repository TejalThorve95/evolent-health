package com.example.evolent.exceptions.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ErrorMessage implements Serializable {

    protected ErrorMessage() {}

    private Date timestamp;

    private Integer status;

    private String error;

    private String code;

    private String message;

    private String path;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static final class ErrorMessageBuilder {

        private Integer status;
        private String error;
        private String code;
        private String message;
        private String path;

        private ErrorMessageBuilder() {}

        public static ErrorMessageBuilder anErrorMessage() {
            return new ErrorMessageBuilder();
        }

        public ErrorMessageBuilder fromIdentifiedError(IdentifiedError identifiedError) {
            this.message = identifiedError.getMessage();
            this.status = identifiedError.getStatus().value();
            this.error = identifiedError.getStatus().getReasonPhrase();
            this.code = identifiedError.getCode();
            return this;
        }

        public ErrorMessageBuilder withStatus(Integer status) {
            this.status = status;
            return this;
        }

        public ErrorMessageBuilder withError(String error) {
            this.error = error;
            return this;
        }

        public ErrorMessageBuilder withCode(String code) {
            this.code = code;
            return this;
        }

        public ErrorMessageBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorMessageBuilder withPath(String path) {
            this.path = path;
            return this;
        }

        public com.example.evolent.exceptions.model.ErrorMessage build() {
            com.example.evolent.exceptions.model.ErrorMessage errorMessage = new com.example.evolent.exceptions.model.ErrorMessage();
            errorMessage.error = this.error;
            errorMessage.message = this.message;
            errorMessage.timestamp = new Date();
            errorMessage.status = this.status;
            errorMessage.path = this.path;
            errorMessage.code = this.code;
            return errorMessage;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        com.example.evolent.exceptions.model.ErrorMessage that = (com.example.evolent.exceptions.model.ErrorMessage) o;
        return timestamp.equals(that.timestamp)
                && status.equals(that.status)
                && error.equals(that.error)
                && code.equals(that.code)
                && message.equals(that.message)
                && path.equals(that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, status, error, code, message, path);
    }
}
