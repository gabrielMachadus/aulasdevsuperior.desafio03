package br.com.devsuperior.desafio03.services.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String msg) {
        super(msg);
    }
}
