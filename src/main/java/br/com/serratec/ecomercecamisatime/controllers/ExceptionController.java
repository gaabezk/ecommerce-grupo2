package br.com.serratec.ecomercecamisatime.controllers;

import br.com.serratec.ecomercecamisatime.exceptions.IdNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> idNotFoundException(IdNotFoundException e){
        HttpHeaders headers = new HttpHeaders();
        headers.add(e.m1(), e.m2());
        return new ResponseEntity<>(null,headers, HttpStatus.BAD_REQUEST);
    }
}
