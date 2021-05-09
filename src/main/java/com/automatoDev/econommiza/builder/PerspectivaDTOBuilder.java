package com.automatoDev.econommiza.builder;

import java.math.BigDecimal;
import java.util.List;

import com.automatoDev.econommiza.dto.PerspectivaDTO;
import com.automatoDev.econommiza.dto.UsuarioDTO;
import com.automatoDev.econommiza.entity.Registro;

/**
 * @author Marco Aurélio.
 * @date 07/05/2021
 * 
 * Classe que segue o padrão Builder para a classe PerspectivaDTO.
 */
public class PerspectivaDTOBuilder {

    private Long idPerspectiva;
    private String nome;
    private Integer ano;
    private BigDecimal totalProventos  = new BigDecimal("0.00");
    private BigDecimal totalDespesas = new BigDecimal("0.00");
    private UsuarioDTO usuario;
    private List<Registro> registros;

    public PerspectivaDTO build(){
        return new PerspectivaDTO(this.idPerspectiva, this.nome, this.ano, this.totalProventos, this.totalDespesas, this.usuario, this.registros);
    }

    public PerspectivaDTOBuilder idPerspectiva(Long idPerspectiva){
        this.idPerspectiva = idPerspectiva;
        return this;
    }

    public PerspectivaDTOBuilder nome(String nome){
        this.nome = nome;
        return this;
    }

    public PerspectivaDTOBuilder ano(Integer ano){
        this.ano = ano;
        return this;
    }

    public PerspectivaDTOBuilder totalProventos(BigDecimal totalProventos){
        this.totalProventos = totalProventos;
        return this;
    }

    public PerspectivaDTOBuilder totalDespesas(BigDecimal totalDespesas){
        this.totalDespesas = totalDespesas;
        return this;
    }
    
    public PerspectivaDTOBuilder usuario(UsuarioDTO usuario){
        this.usuario = usuario;
        return this;
    }

    public PerspectivaDTOBuilder registros(List<Registro> registros){
        this.registros = registros;
        return this;
    }
    
}
