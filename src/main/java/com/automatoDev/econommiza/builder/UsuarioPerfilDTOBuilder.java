package com.automatoDev.econommiza.builder;

import java.util.List;

import com.automatoDev.econommiza.dto.UsuarioPerfilDTO;
import com.automatoDev.econommiza.entity.Perfil;

/**
 * @author Marco Aurélio.
 * @date 07/05/2021
 * 
 * Classe que segue o padrão Builder para a classe UsuarioPerfilDTO.
 */
public class UsuarioPerfilDTOBuilder {
    
    private Long idUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String uid;

    private List<Perfil> perfis;

    public UsuarioPerfilDTO build(){
        return new UsuarioPerfilDTO(this.idUsuario, this.nome, this.sobrenome, this.email, this.uid, this.perfis);
    }

    public UsuarioPerfilDTOBuilder idUsuario(Long idUsuario){
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioPerfilDTOBuilder nome(String nome){
        this.nome = nome;
        return this;
    }

    public UsuarioPerfilDTOBuilder sobrenome(String sobrenome){
        this.sobrenome = sobrenome;
        return this;
    }

    public UsuarioPerfilDTOBuilder email(String email){
        this.email = email;
        return this;
    }
    public UsuarioPerfilDTOBuilder uid(String uid){
        this.uid = uid;
        return this;
    }
    public UsuarioPerfilDTOBuilder perfis(List<Perfil> perfis){
        this.perfis = perfis;
        return this;
    }
}
