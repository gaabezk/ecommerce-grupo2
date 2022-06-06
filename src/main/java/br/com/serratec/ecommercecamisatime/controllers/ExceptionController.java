package br.com.serratec.ecommercecamisatime.controllers;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CategoriaNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CpfExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.NonUniqueResultException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> idNotFoundException(IdNotFoundException e){
        HttpHeaders headers = new HttpHeaders();
        headers.add(e.m1(), e.m2());
        return new ResponseEntity<>(null,headers, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CpfExistentException.class)
    public ResponseEntity<?> cpfExistentException(CpfExistentException e){
        HttpHeaders headers = new HttpHeaders();
        headers.add(e.m1(), e.m2());
        return new ResponseEntity<>(null,headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoriaExistentException.class)
    public ResponseEntity<?> categoriaExistenteException(CategoriaExistentException e){
        HttpHeaders headers = new HttpHeaders();
        headers.add(e.m1(), e.m2());
        return new ResponseEntity<>(null,headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoriaNonexistentException.class)
    public ResponseEntity<?> categoriaInexistenteException(CategoriaNonexistentException e){
        HttpHeaders headers = new HttpHeaders();
        headers.add(e.m1(), e.m2());
        return new ResponseEntity<>(null,headers, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(CpfNonexistentException.class)
    public ResponseEntity<?> cpfNonexistentException(CpfNonexistentException e){
        HttpHeaders headers = new HttpHeaders();
        headers.add(e.m1(), e.m2());
        return new ResponseEntity<>(null,headers, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity<?> nonUniqueResultException(NonUniqueResultException e){
        HttpHeaders headers = new HttpHeaders();
        headers.add("ERRO", "EMAIL OU CPF JA UTILIZADOS");
        return new ResponseEntity<>(null,headers, HttpStatus.BAD_REQUEST);
    }


}
