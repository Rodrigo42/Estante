package org.drogo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(LivroJaExisteException.class)
    public ResponseEntity<Map<String, String>> handlerLivroJaExiste(LivroJaExisteException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Erro: ", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BodyVazioException.class)
    public ResponseEntity<Map<String, String>> handlerBodyVazio(BodyVazioException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Erro: ", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FutureDateException.class)
    public ResponseEntity<Map<String, String>> handlerFutureDate(FutureDateException exception){
        Map<String, String> response = new HashMap<>();
        response.put("Erro: ", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
