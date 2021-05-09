package com.automatoDev.econommiza.repository;

import java.util.List;

import com.automatoDev.econommiza.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Marco Aurelio.
 * @date 04/05/2021
 * 
 * Classe de repository que contem os metodos de busca jpa.
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{
    
    List<Usuario> findByUid(String uid);

}
