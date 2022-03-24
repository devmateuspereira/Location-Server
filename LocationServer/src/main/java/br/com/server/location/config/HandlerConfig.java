package br.com.server.location.config;

import br.com.server.location.usercases.exceptions.NoRecordFoundException;
import br.com.server.location.usercases.exceptions.ValidationFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerConfig {

    @ExceptionHandler(ValidationFieldException.class)
    public ResponseEntity<?> handlerValidationFieldException(ValidationFieldException validationFieldException) {
        return new ResponseEntity<>(new ValidationFieldException(validationFieldException.getMessage(),
                validationFieldException.getClass().getName()
        ), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity<?> handlerNoRecordFoundException(NoRecordFoundException noRecordFoundException) {
        return new ResponseEntity<>(new ValidationFieldException(noRecordFoundException.getMessage(),
                noRecordFoundException.getClass().getName()
        ), HttpStatus.NO_CONTENT);
    }

}