package br.com.devsuperior.desafio03.controllers.handlers;

import br.com.devsuperior.desafio03.dto.CustomError;
import br.com.devsuperior.desafio03.dto.ValidationError;
import br.com.devsuperior.desafio03.services.exceptions.DatabaseException;
import br.com.devsuperior.desafio03.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    /*retorna 404*/
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    /*retorna codigo 400*/
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> databaseNotFound(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    /* trata erro de validação de dados e retorna 422*/
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationError> validationError(ConstraintViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados inválidos", request.getRequestURI());
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            String field = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            err.addError(field, message);
        }

        return ResponseEntity.status(status).body(err);
    }

}