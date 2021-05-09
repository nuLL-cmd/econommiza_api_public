package com.automatoDev.econommiza.service;

import java.util.ArrayList;
import java.util.List;

import com.automatoDev.econommiza.adapter.UsuarioDTOAdapter;
import com.automatoDev.econommiza.dto.UsuarioPerfilDTO;
import com.automatoDev.econommiza.entity.Perfil;
import com.automatoDev.econommiza.entity.Usuario;
import com.automatoDev.econommiza.enumerator.PerfilEnum;
import com.automatoDev.econommiza.exception.NegocioException;
import com.automatoDev.econommiza.repository.PerfilRepositorio;
import com.automatoDev.econommiza.repository.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author Marco Aurelio.
 * @date 04/05/2021
 * 
 * Classe de serviço que contem a regra de negocio no que tange a Usuarios da apliação.
 */
@Service
public class UsuarioService {
    

    @Autowired
    private UsuarioRepositorio usuarioRepo;

    @Autowired
    private PerfilRepositorio perfilRepo;



    public List<UsuarioPerfilDTO> fetchAll(){
        return new UsuarioDTOAdapter(usuarioRepo.findAll()).getUsuarioPerfilListDTO();
    }

    public UsuarioPerfilDTO fetchById(Long id){

        if(id >= 0)
            return new UsuarioDTOAdapter(usuarioRepo.findById(id).orElse(null)).getUsuarioPerfilDTO();

        throw new NegocioException("Id informado é inválido.", HttpStatus.BAD_REQUEST);
    }

    public List<UsuarioPerfilDTO> fetchByUid(String uid){
        if(!uid.isEmpty()){
            return new UsuarioDTOAdapter(usuarioRepo.findByUid(uid.trim())).getUsuarioPerfilListDTO();
        }

        throw new NegocioException("UID informado é inválido.", HttpStatus.BAD_REQUEST);
    }

    public UsuarioPerfilDTO postUsuario(Usuario usuario){
        
        List<Perfil> perfis = new ArrayList<>();
        if(usuario.getPerfis().size() != 0){
            for(Perfil p: usuario.getPerfis()){
                if(p.getIdPerfil() == null){
                    perfis.add(p);
                }
            }

            usuario.getPerfis().removeAll(perfis);
            perfis.clear();
            int count = 0;

            for(Perfil p: usuario.getPerfis()){
                Perfil perfil = perfilRepo.findById(p.getIdPerfil()).orElse(null);
                if(perfil != null){
                    perfis.add(perfil);
                    if(perfil.getPerfil() != PerfilEnum.USER)
                        count++;
                } 
            }

            if(count == perfis.size()){
               perfis.add(new Perfil(2L, PerfilEnum.USER));
            }

            usuario.setPerfis(perfis);

        }else{
            perfis.add(new Perfil(2L, PerfilEnum.USER));
            usuario.setPerfis(perfis);
        }
     
        usuario.setNome(usuario.getNome().toUpperCase());
        usuario.setSobrenome(usuario.getSobrenome().toUpperCase());
         return new  UsuarioDTOAdapter(usuarioRepo.save(usuario)).getUsuarioPerfilDTO();
       
    }


    public Usuario putUsuario(Usuario usuario){

        if(usuario.getIdUsuario() != null || usuario.getIdUsuario() >= 0 ){
            if(usuarioRepo.existsById(usuario.getIdUsuario())){
                usuario.setNome(usuario.getNome().toUpperCase());
                usuario.setSobrenome(usuario.getSobrenome().toUpperCase());
                return usuarioRepo.save(usuario);
            }

            throw new NegocioException("Usuario não encontrado na base de dados.", HttpStatus.NOT_FOUND);
           
        }

        throw new NegocioException("Id do usuário informado é inválido.", HttpStatus.BAD_REQUEST);
    }

    public void deleteUsuario(Long id){

        if(id >= 0){
            if(usuarioRepo.existsById(id))
            usuarioRepo.deleteById(id);

            return;
            
        }

        throw new NegocioException("Deve ser informado um id válido.", HttpStatus.BAD_REQUEST);
    }
}



