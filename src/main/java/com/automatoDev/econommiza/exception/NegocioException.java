package com.automatoDev.econommiza.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Marco Aurélio.
 * @date 02/05/2021
 * Classe primaria que recebera uma mensagem e um status http, a calsse extende de:
 * @RuntimeException: Os erros serão capturados em tempo de execução.
 */
public class NegocioException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    private HttpStatus status;

    public NegocioException(String mensagem){
        super(mensagem);
    }

    public HttpStatus getStatus(){
        return this.status;
    }
    
}
