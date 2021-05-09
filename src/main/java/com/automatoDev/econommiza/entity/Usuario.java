package com.automatoDev.econommiza.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.automatoDev.econommiza.entity.validationGroups.ConverterGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Marco Aurlélio
 * @date 01/05/2021
 * Classe de mapeamento para tb_usuario.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(value = Include.NON_NULL)
@EqualsAndHashCode(exclude = {"nome","email","senha"})
@Entity(name = "tb_usuario")
@Table(schema = "dbo")
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @NotNull(groups = ConverterGroup.Usuario.class)
    private Long idUsuario;


    @NotBlank(message = "Campo nome não pode ser vazio.")
    @Size(min = 3, max = 100, message = "Campo nomo deve contar entre 3 e 100 caracteres")
    private String nome;

    @Email(message = "Insira um email valido")
    @Size(max = 100, message = "Email pode conter no maximo 100 caracteres.")
    @NotBlank(message = "Deve ser informado um email no cadastro.")
    private String email;

    @NotBlank(message = "Campo senha não pode ser vazio.")
    @Size(min = 6, message = "Senha deve ter no minimo 6 caracteres")
    private String senha;

    @NotBlank(message = "Campo uid não pode ser nulo.")
    private String uid;

    @ManyToMany
    @JoinTable(name = "tb_perfil_usuario",schema = "dbo",
    joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private List<Perfil> perfis = new ArrayList<>();
    
}
