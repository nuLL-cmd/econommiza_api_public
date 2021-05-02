package com.automatoDev.econommiza.exception.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Marco Aurélio
 * @date 02/05/2021
 * Classe que representara o erro manipulado pela classe ManipulaException.java
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Erro {

    private Integer status;
    private String message;
    private Long timestamp;

    private List<CamposErro> campos;
    private String campo;

    
    
}
