package com.automatoDev.econommiza.adapter;

import java.util.ArrayList;
import java.util.List;

import com.automatoDev.econommiza.builder.UsuarioDTOBuilder;
import com.automatoDev.econommiza.builder.UsuarioPerfilDTOBuilder;
import com.automatoDev.econommiza.dto.UsuarioDTO;
import com.automatoDev.econommiza.dto.UsuarioPerfilDTO;
import com.automatoDev.econommiza.entity.Usuario;


/**
 * @author Marco Aurélio.
 * @date 07/05/2021
 * 
 * Classe que segue o padrão Adapter para a classe UsuarioDTO e suas variantes.
 */
public class UsuarioDTOAdapter{

   
    private Usuario usuario;
   
    private List<Usuario> usuarios;



    public UsuarioDTOAdapter(Usuario user) {
        this.usuario = user;
    }


    public UsuarioDTOAdapter(List<Usuario> users) {
        this.usuarios = users;
    }


    public UsuarioDTO getUsuarioDTO(){
        if(this.usuario != null){

            return new UsuarioDTOBuilder()
            .idUsuario(this.usuario.getIdUsuario())
            .nome(this.usuario.getNome())
            .sobrenome(this.usuario.getSobrenome())
            .email(this.usuario.getEmail())
            .uid(this.usuario.getUid())
            .build();
        }

        return null;

    }

    
    public UsuarioPerfilDTO getUsuarioPerfilDTO(){

        if(usuario != null){

            return new UsuarioPerfilDTOBuilder()
            .idUsuario(this.usuario.getIdUsuario())
            .nome(this.usuario.getNome())
            .uid(this.usuario.getUid())
            .email(this.usuario.getEmail())
            .sobrenome(this.usuario.getSobrenome())
            .perfis(this.usuario.getPerfis()).build();
        }

        return null;

    }
    

    public List<UsuarioPerfilDTO> getUsuarioPerfilListDTO(){
    
        if(this.usuarios != null){
            List<UsuarioPerfilDTO> usuariosDTOList = new ArrayList<>();
            this.usuarios.forEach(u ->{
                usuariosDTOList.add(new UsuarioPerfilDTOBuilder()
                .idUsuario(u.getIdUsuario())
                .uid(u.getUid())
                .nome(u.getNome())
                .sobrenome(u.getSobrenome())
                .email(u.getEmail())
                .perfis(u.getPerfis())
                .build());
            });

            return usuariosDTOList;
        }

        return new ArrayList<>();
    }

    
    public List<UsuarioDTO> getUsuarioListDTO(){
    
        if(this.usuarios != null){
            List<UsuarioDTO> usuariosDTOList = new ArrayList<>();
            this.usuarios.forEach(u ->{
                usuariosDTOList.add(new UsuarioDTOBuilder()
                .idUsuario(u.getIdUsuario())
                .uid(u.getUid())
                .nome(u.getNome())
                .sobrenome(u.getSobrenome())
                .email(u.getEmail())
                .build());
            });

            return usuariosDTOList;
        }

        return new ArrayList<>();
    }

    
}
