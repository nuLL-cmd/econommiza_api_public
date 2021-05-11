package com.automatoDev.econommiza.dto;

import java.math.BigDecimal;
import java.util.List;

import com.automatoDev.econommiza.entity.Registro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * Modelo dto para a classe Perspectiva.java.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class PerspectivaDTO {
    
    private Long idPerspectiva;
    private String nome;
    private Integer ano;
    private BigDecimal totalProventos  = new BigDecimal("0.00");
    private BigDecimal totalDespesas = new BigDecimal("0.00");
    private UsuarioDTO usuario;
    @JsonIgnoreProperties({"categorias","perspectiva"})
    private List<Registro> registros;
}
