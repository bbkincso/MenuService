package com.feastplanner.menuservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenuNotFound extends RuntimeException{

    public MenuNotFound(String message){
        super(message);
    }

    public MenuNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
