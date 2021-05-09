package com.automatoDev.econommiza.builder;

import com.automatoDev.econommiza.dto.UsuarioDTO;


/**
 * @author Marco Aurélio.
 * @date 07/05/2021
 * 
 * Classe que segue o padrão Builder para a classe UsuarioDTO.
 */
public class UsuarioDTOBuilder {


    private Long idUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String uid;

    public UsuarioDTO build(){
        return new UsuarioDTO(this.idUsuario, this.nome, this.sobrenome, this.email, this.uid);
    }

    public UsuarioDTOBuilder idUsuario(Long idUsuario){
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioDTOBuilder nome(String nome){
        this.nome = nome;
        return this;
    }

    public UsuarioDTOBuilder sobrenome(String sobrenome){
        this.sobrenome = sobrenome;
        return this;
    }

    public UsuarioDTOBuilder email(String email){
        this.email = email;
        return this;
    }
    public UsuarioDTOBuilder uid(String uid){
        this.uid = uid;
        return this;
    }
}
