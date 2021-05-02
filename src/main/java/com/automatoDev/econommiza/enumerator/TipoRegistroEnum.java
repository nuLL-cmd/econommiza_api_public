package com.automatoDev.econommiza.enumerator;

import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonValue;


/**
 * @author Marco Aurélio
 * @date  01/05/2021
 * Tipo enumerado que representará os tipos de registro de um determinado registro.
 */
public enum TipoRegistroEnum {

    E("E", "ENTRADA"),
    S("S","SAIDA");
    

    private final String codigo;
    private final String descricao;

    private TipoRegistroEnum(String codigo, String descricao){

        this.codigo = codigo;
        this.descricao = descricao;

        try{
            Field field = this.getClass().getSuperclass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(this, this.codigo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @JsonValue
    public String getDescricao(){
        return this.descricao;
    }

    
}
