package com.example.evolent.exceptions;


import com.example.evolent.exceptions.model.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {

    static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);


    @ExceptionHandler(BaseIdentifiedException.class)
    public @ResponseBody
    ResponseEntity<ErrorMessage> handleIdentifiedException(
            HttpServletRequest req, BaseIdentifiedException ex) {
        return new ResponseEntity<>(ex.getErrorMessageForPath(req.getRequestURL().toString()), ex.getError().getStatus());
    }

}
