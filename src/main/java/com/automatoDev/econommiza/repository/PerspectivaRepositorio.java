package com.automatoDev.econommiza.repository;

import java.util.List;

import com.automatoDev.econommiza.entity.Perspectiva;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PerspectivaRepositorio extends JpaRepository<Perspectiva, Long>{

    List<Perspectiva> findByUsuario_uid(String uid);
    List<Perspectiva> findByUsuario_idUsuario(Long id);
    
}
