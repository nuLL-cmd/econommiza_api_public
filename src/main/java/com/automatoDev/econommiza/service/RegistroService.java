package com.automatoDev.econommiza.service;

import com.automatoDev.econommiza.entity.Perspectiva;
import com.automatoDev.econommiza.entity.Registro;
import com.automatoDev.econommiza.exception.NegocioException;
import com.automatoDev.econommiza.repository.PerspectivaRepositorio;
import com.automatoDev.econommiza.repository.RegistroRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {
    
    @Autowired
    private RegistroRepositorio registroRepo;

    @Autowired PerspectivaRepositorio perspectivaRepo;



    public Registro postRegistro(Registro registro){
        if(registro.getPerspectiva().getIdPerspectiva() != null || registro.getPerspectiva().getIdPerspectiva() > 0){
            Perspectiva perspectiva = perspectivaRepo.findById(registro.getPerspectiva().getIdPerspectiva()).orElse(null);
            if(perspectiva != null){
                registro.setPerspectiva(perspectiva);
                
                return registroRepo.save(registro);
            }

            throw new NegocioException("Perspectiva não encontrada, não é possivel salvar.", HttpStatus.NOT_FOUND);
        }

        throw new NegocioException("Necessário uma perspectiva valida pra a operação.", HttpStatus.BAD_REQUEST);

    }
}
