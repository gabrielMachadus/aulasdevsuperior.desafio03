package br.com.devsuperior.desafio03.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
    private List<FieldMessage>  errors = new ArrayList<>();

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
        this.errors = errors;
    }

    public void addError(String fieldName, String message ) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
