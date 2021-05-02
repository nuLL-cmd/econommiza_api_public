package com.automatoDev.econommiza.exception;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.automatoDev.econommiza.builder.ErroBuilder;
import com.automatoDev.econommiza.exception.model.CamposErro;
import com.automatoDev.econommiza.exception.model.Erro;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Marco Aurélio.
 * @date 02/05/2021
 * Calsse que ira capturar e manipular os erros das requisições em tempo de execução, anotada com:
 * @ControllerAdvice informa ao spring que essa é uma classe para tratamento de erros da api. 
 */
@ControllerAdvice
public class ManipulaException extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> preocessaException(NegocioException ex, WebRequest request){

        HttpStatus status = ex.getStatus();
        Erro erro = new ErroBuilder()
            .status(status.value())
            .message(ex.getMessage())
            .timestamp(OffsetDateTime.now().toEpochSecond()).builder();

        return handleExceptionInternal(ex, erro, new HttpHeaders(), ex.getStatus(), request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request){
        Erro erro = new ErroBuilder().status(400)
            .message("Atenção para violação de constraint na tabela.")
            .timestamp(OffsetDateTime.now().toEpochSecond())
            .campo(ex.getConstraintName()).builder();

            return new ResponseEntity<>(erro, new HttpHeaders(), erro.getStatus());

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request){

        Erro erro = new ErroBuilder().status(400)
            .message(ex.getLocalizedMessage())
            .timestamp(OffsetDateTime.now().toEpochSecond()).builder();

        return new ResponseEntity<Object>(erro, new HttpHeaders(), erro.getStatus());

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
            
            List<CamposErro> campos = new ArrayList<>();

            for(ObjectError error: ex.getBindingResult().getAllErrors()){
                campos.add(new CamposErro(((FieldError)error).getField(), error.getDefaultMessage()));
            }

            Erro erro = new ErroBuilder().status(status.value())
                .message("Um ou mais campos são inválidos")
                .timestamp(OffsetDateTime.now().toEpochSecond())
                .campos(campos).builder();

        return super.handleExceptionInternal(ex, erro, headers, status, request);
    }
}
