package com.programacion4.unidad3ej3.config.exceptions;

import org.springframework.http.HttpStatus;


public class NotFoundException extends CustomException {

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
