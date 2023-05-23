package br.com.jean.controlefinanceiro.error;

import br.com.jean.controlefinanceiro.exceptions.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class TratarErros {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity elementoNaoEncontrado(NoSuchElementException e){

        return ResponseEntity.ok().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity errosFormulario(MethodArgumentNotValidException e){
        List<FieldError> error = e.getFieldErrors();
        return ResponseEntity.ok().body(error.stream().map(ErrosDTO::new));
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity errosValidacao(ValidacaoException e){
        String error = e.getMessage();
        return ResponseEntity.ok().body(error);
    }

    private record ErrosDTO(String campo, String mensagem){
        public ErrosDTO(FieldError e){
            this(e.getField(), e.getDefaultMessage());
        }
    }

}
