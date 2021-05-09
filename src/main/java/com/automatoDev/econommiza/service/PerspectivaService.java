package com.automatoDev.econommiza.service;

import java.util.List;

import com.automatoDev.econommiza.entity.Perspectiva;
import com.automatoDev.econommiza.entity.Usuario;
import com.automatoDev.econommiza.exception.NegocioException;
import com.automatoDev.econommiza.repository.PerspectivaRepositorio;
import com.automatoDev.econommiza.repository.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author Marco Aurélio.
 * @date 07/05/2021
 * 
 * Classe de serviço que contera a regra de negocio referente as Perspectivas.
 */
@Service
public class PerspectivaService {

    @Autowired
    private PerspectivaRepositorio perspectivaRepo;

    @Autowired
    private UsuarioRepositorio usuarioRepo;



    public List<Perspectiva> fetchAll(){
        return perspectivaRepo.findAll();

    }

    public Perspectiva fetchById(Long id){
        if(id > 0)
            return perspectivaRepo.findById(id).orElse(null);
        
        throw new NegocioException("Deve ser informado um id válido.", HttpStatus.BAD_REQUEST);

    }

    public List<Perspectiva> fetchPorUsuarioId(Long id){
        if(id >= 0){
            return perspectivaRepo.findByUsuario_idUsuario(id);
        }

        throw new NegocioException("Deve ser informado um id válido.",HttpStatus.BAD_REQUEST);
        
    }

    public List<Perspectiva> fetchPorUsuarioUid(String uid){
        if(!uid.isEmpty()){
            return perspectivaRepo.findByUsuario_uid(uid.trim());
        }

        throw new NegocioException("Deve ser informado um uid válido.", HttpStatus.BAD_REQUEST);
    }

    public void deletePerspectiva(Long id){
        if(id >= 0){
            if(perspectivaRepo.existsById(id))
                perspectivaRepo.deleteById(id);

            return;
        }

        throw new NegocioException("Deve ser informado um id válido",HttpStatus.BAD_REQUEST);
    }

    public Perspectiva postPerspectiva(Perspectiva perspectiva){
        Usuario usuario = usuarioRepo.findById(perspectiva.getUsuario().getIdUsuario()).orElseThrow(() ->
        new NegocioException("Usuario não encontrado na base de dados.", HttpStatus.NOT_FOUND));;

        
        perspectiva.setUsuario(usuario);

        return perspectivaRepo.save(perspectiva);
    }

    public Perspectiva putPerspectiva(Perspectiva perspectiva){

        if(perspectiva.getIdPerspectiva() != null || perspectiva.getIdPerspectiva() >= 0){

            if(perspectivaRepo.existsById(perspectiva.getIdPerspectiva())){
                Usuario usuario = usuarioRepo.findById(perspectiva.getUsuario().getIdUsuario()).orElseThrow(() ->
                new NegocioException("Usuario não encontrado na base de dados.", HttpStatus.NOT_FOUND));;

                perspectiva.setUsuario(usuario);

                return perspectivaRepo.save(perspectiva);
            }

           throw new NegocioException("Usuario não encontrado na base de dados.", HttpStatus.NOT_FOUND);
        }

        throw new NegocioException("Deve ser informado um id válido",HttpStatus.BAD_REQUEST);
       

    }


    
}
