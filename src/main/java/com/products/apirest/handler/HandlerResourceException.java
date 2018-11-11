package com.products.apirest.handler;

import com.products.apirest.exception.DataIntegrityException;
import com.products.apirest.exception.ObjectNotFoundException;
import com.products.apirest.response.ResourceError;
import com.products.apirest.response.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class HandlerResourceException {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ResourceError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        ResourceError error = new ResourceError(HttpStatus.NOT_FOUND.value(), e.getMessage(), new Date(System.currentTimeMillis()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<ResourceError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
        ResourceError error = new ResourceError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), new Date(System.currentTimeMillis()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResourceError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", new Date(System.currentTimeMillis()));
        for(FieldError x : e.getBindingResult().getFieldErrors()){
            error.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResourceError> validation2(HttpMessageNotReadableException e, HttpServletRequest request) {
        ResourceError error = new ResourceError(HttpStatus.BAD_REQUEST.value(), "Corpo da requisição vazio.", new Date(System.currentTimeMillis()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
