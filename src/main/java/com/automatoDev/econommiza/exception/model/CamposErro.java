package com.automatoDev.econommiza.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Marco Aurélio
 * @date 02/05/2021
 * Classe que representara os campos identificados com erro na api.
 */
@Getter
@Setter
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class CamposErro {

    private String campo;
    private String mensagem;
    
}
