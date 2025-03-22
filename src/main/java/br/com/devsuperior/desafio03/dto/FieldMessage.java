package br.com.devsuperior.desafio03.dto;

public class FieldMessage {
    private String fieldName;
    private String message;

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

    public FieldMessage() {
    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
