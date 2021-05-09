package com.automatoDev.econommiza.repository;

import com.automatoDev.econommiza.entity.Perspectiva;
import com.automatoDev.econommiza.entity.Registro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepositorio extends JpaRepository<Registro, Long>{
    
   
}
