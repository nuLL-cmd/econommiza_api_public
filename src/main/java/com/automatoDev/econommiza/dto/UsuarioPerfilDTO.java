package com.automatoDev.econommiza.dto;

import java.util.List;

import com.automatoDev.econommiza.entity.Perfil;
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
 * Modelo dto para a classe Usuario exibindo os perfis.java.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class UsuarioPerfilDTO {
    
    private Long idUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String uid;
    private List<Perfil> perfis;
}
