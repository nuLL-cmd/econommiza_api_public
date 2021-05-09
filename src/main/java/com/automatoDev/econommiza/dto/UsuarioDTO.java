package com.automatoDev.econommiza.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Marco Aurélio.
 * @date 09/05/2021
 * 
 * Modelo dto para a classe Usuario.java.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class UsuarioDTO {

    private Long idUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String uid;

}
