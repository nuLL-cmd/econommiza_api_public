package com.automatoDev.econommiza.enumerator;

import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Marco Aurélio
 * @date 01/05/2021
 * Tipo enumerado que representa o perfil de usuarios.
 */

public enum PerfilEnum {
    
    ADMIN("ADMIN","ROLE_ADMINISTRADOR"),
    USER("USER","ROLE_USUARIO");

    private final String codigo;
    private final String descricao;


    private PerfilEnum(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;

        try{
            Field field = this.getClass().getSuperclass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(this,this.codigo);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro perfilEnum: "+e.getMessage());

            //TODO Colocar exception personalizada aqui
        }

    }


    public String getDescricao(){
        return this.descricao;
    }

    @JsonValue
    public String getCodigo(){
        return this.codigo;
    }


}
