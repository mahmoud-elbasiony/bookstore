package com.example.BookStore.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PatronBusinessLogicException extends RuntimeException{

    public PatronBusinessLogicException(String s) {
        super(s);
    }
}
