package com.automatoDev.econommiza.adapter;

import java.util.ArrayList;
import java.util.List;

import com.automatoDev.econommiza.builder.PerspectivaDTOBuilder;
import com.automatoDev.econommiza.dto.PerspectivaDTO;
import com.automatoDev.econommiza.entity.Perspectiva;

/**
 * @author Marco Aurélio.
 * @date 07/05/2021
 * 
 * Classe que segue o padrão Adapter para a classe PerspectivaDTO e seus tipos.
 */
public class PerspectivaDTOAdapter {


    private List<Perspectiva> perspectivas;


    private Perspectiva perspectiva;


    public PerspectivaDTOAdapter(List<Perspectiva> perspectivas) {
        this.perspectivas = perspectivas;
    }


    public PerspectivaDTOAdapter(Perspectiva perspectiva) {
        this.perspectiva = perspectiva;
    }


    public PerspectivaDTO getPerspectivaDTO(){
  
        if(this.perspectiva != null){
            return new PerspectivaDTOBuilder().idPerspectiva(this.perspectiva.getIdPerspectiva())
                .nome(this.perspectiva.getNome())
                .ano(this.perspectiva.getAno())
                .registros(this.perspectiva.getRegistros())
                .totalDespesas(this.perspectiva.getTotalDespesas())
                .totalProventos(this.perspectiva.getTotalProventos())
                .usuario(new UsuarioDTOAdapter(this.perspectiva.getUsuario()).getUsuarioDTO())
                .build();
                
        }

        return null;
    }

    public List<PerspectivaDTO> getPerspectivaListDTO(){

        if(this.perspectivas != null){

            List<PerspectivaDTO> perspectivaDTOs = new ArrayList<>();
            this.perspectivas.forEach(p ->{
                perspectivaDTOs.add(new PerspectivaDTOBuilder()
                .idPerspectiva(p.getIdPerspectiva())
                .nome(p.getNome())
                .ano(p.getAno())
                .totalDespesas(p.getTotalDespesas())
                .totalProventos(p.getTotalProventos())
                .registros(p.getRegistros())
                .usuario(new UsuarioDTOAdapter(p.getUsuario()).getUsuarioDTO())
                .build());
            });

            return perspectivaDTOs;
        }

        return new ArrayList<>();
    }
}
