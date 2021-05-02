package com.automatoDev.econommiza.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.automatoDev.econommiza.entity.validationGroups.ConverterGroup;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * @author
 * @date 01/05/2021
 * Classe de mapeamento para a entidade tb_perspectiva.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(exclude = {"nome","ano","totalProventos","totalDespesas","usuario"})
@Entity(name = "tb_perspectiva")
@Table(schema = "dbo")
public class Perspectiva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perspectiva")
    private Long idPerspectiva;

    @NotBlank(message = "A perspectiva precisa ter um mês.")
    private String nome;

    @NotNull(message = "A perspectiva pricisa ter um ano.")
    private Integer ano;

    @JsonProperty(access = Access.READ_ONLY)
    @NumberFormat(style = Style.CURRENCY)
    private BigDecimal totalProventos = new BigDecimal("0.00");

    @JsonProperty(access = Access.READ_ONLY)
    @NumberFormat(style = Style.CURRENCY)
    private BigDecimal totalDespesas = new BigDecimal("0.00");


    @OneToOne()
    @JoinColumn(name = "id_usuario")
    @NotNull(message = "Necessário informar um usuario para a perspectiva.")
    @Valid
    @ConvertGroup(from = Default.class, to = ConverterGroup.Usuario.class)
    private Usuario usuario;
    

    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name = "id_perspectiva")
    private List<Registro> registros;
}
