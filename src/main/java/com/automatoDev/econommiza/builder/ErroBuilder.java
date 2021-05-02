package com.automatoDev.econommiza.builder;

import java.util.List;

import com.automatoDev.econommiza.exception.model.CamposErro;
import com.automatoDev.econommiza.exception.model.Erro;

public class ErroBuilder {

    private Integer status;
    private String message;
    private Long timestamp;

    private List<CamposErro> campos;
    private String campo;
    

    public Erro builder(){
        return new Erro(this.status,this.message,this.timestamp,this.campos, this.campo);
    }

    public ErroBuilder status(Integer status){
        this.status = status;
        return this;
    }

    public ErroBuilder message(String message){
        this.message = message;
        return this;
    }

    public ErroBuilder timestamp(Long timestamp){
        this.timestamp = timestamp;
        return this;
    }

    public ErroBuilder campos(List<CamposErro> campos){
        this.campos = campos;
        return this;
    }

    public ErroBuilder campo(String campo){
        this.campo = campo;
        return this;
    }
}
