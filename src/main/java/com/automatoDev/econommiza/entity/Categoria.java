package com.automatoDev.econommiza.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.automatoDev.econommiza.enumerator.CategoriaEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Marco Aurélio.
 * @date 01/05/2021
 * Classe de mapeamento para a entidade tb_categoria.
 */

 @Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor
 @ToString
 @EqualsAndHashCode(exclude = {"nome","descricao","dtCriacao"})
 @Entity(name = "tb_categoria")
 @Table(schema = "dbo")
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum nome;

    @NotBlank(message = "Campo descricao não pode ser vazio.")
    private String descricao;

    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "dt_criacao")
    private Long dtCriacao;
}
