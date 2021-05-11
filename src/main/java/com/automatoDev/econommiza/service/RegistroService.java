package com.automatoDev.econommiza.service;

import java.util.ArrayList;
import java.util.List;

import com.automatoDev.econommiza.entity.Categoria;
import com.automatoDev.econommiza.entity.Perspectiva;
import com.automatoDev.econommiza.entity.Registro;
import com.automatoDev.econommiza.enumerator.TipoRegistroEnum;
import com.automatoDev.econommiza.exception.NegocioException;
import com.automatoDev.econommiza.repository.CategoriaRepositorio;
import com.automatoDev.econommiza.repository.PerspectivaRepositorio;
import com.automatoDev.econommiza.repository.RegistroRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {
    
    @Autowired
    private RegistroRepositorio registroRepo;

    @Autowired 
    private PerspectivaRepositorio perspectivaRepo;

    @Autowired
    private CategoriaRepositorio categoriaRepo;


    public Registro postRegistro(Registro registro){
        
        if(registro.getPerspectiva().getIdPerspectiva() > 0){
            List<Categoria> categorias = new ArrayList<>();
            Perspectiva perspectiva = perspectivaRepo.findById(registro.getPerspectiva().getIdPerspectiva()).orElseThrow(() ->
                new NegocioException("Perspectiva não encontrada, não é possivel salvar.", HttpStatus.NOT_FOUND)
            );


            if(registro.getTipo().equals(TipoRegistroEnum.E)){
                perspectiva.setTotalProventos(perspectiva.getTotalProventos().add(registro.getValor()));
            }else{
                perspectiva.setTotalDespesas(perspectiva.getTotalDespesas().add(registro.getValor()));
            }

            registro.getCategorias().forEach(cat ->{
                if(cat.getIdCategoria() > 0){

                    categorias.add(categoriaRepo.findById(cat.getIdCategoria()).orElseThrow(() ->
                    new NegocioException("Categoria "+cat.getIdCategoria()+ " não encontrada, não é possivel salvar.", HttpStatus.NOT_FOUND) ));

                    return;
                }
                throw new NegocioException("Uma das categorias informadas possui um id inválido. Não é possivel salvar.", HttpStatus.BAD_REQUEST);
     
            });

                registro.setPerspectiva(perspectiva);
                registro.setCategorias(categorias);

                perspectivaRepo.save(perspectiva);

                return registroRepo.save(registro);

            
        }

        throw new NegocioException("Necessário uma perspectiva valida pra a operação.", HttpStatus.BAD_REQUEST);

    }

    public Registro fetchPorId(Long id){
        if( id >0 ){
            return registroRepo.findById(id).orElse(null);
        }

        throw new NegocioException("Necessário um id válido para a operação.", HttpStatus.BAD_REQUEST);
    }



    public Registro putRegistro(Registro registro){
        
        if(registro.getIdRegistro() > 0){
            if(registro.getTipo() != null){

                List<Categoria> categorias = new ArrayList<>();

                Registro registroFind = registroRepo.findById(registro.getIdRegistro()).orElseThrow(() ->
                    new NegocioException("Registor não encontrado na base de dados, não é possível salvar.", HttpStatus.NOT_FOUND));
                
                Perspectiva perspectiva = perspectivaRepo.findById(registro.getPerspectiva().getIdPerspectiva()).orElseThrow(() ->
                    new NegocioException("Perspectiva informada não foi encontrada, não é possível salvar.", HttpStatus.NOT_FOUND));

                if(registroFind.getTipo().equals(TipoRegistroEnum.E))
                    perspectiva.setTotalProventos(perspectiva.getTotalProventos().subtract(registroFind.getValor()));
                else
                    perspectiva.setTotalDespesas(perspectiva.getTotalDespesas().subtract(registroFind.getValor()));



                if(registro.getTipo().equals(TipoRegistroEnum.E))
                    perspectiva.setTotalProventos(perspectiva.getTotalProventos().add(registro.getValor()));
                else
                    perspectiva.setTotalDespesas(perspectiva.getTotalDespesas().add(registro.getValor()));

                registro.getCategorias().forEach(cat ->{
                    if(cat.getIdCategoria() > 0){

                        categorias.add(categoriaRepo.findById(cat.getIdCategoria()).orElseThrow(() ->
                        new NegocioException("Categoria "+cat.getIdCategoria()+ " não encontrada, não é possivel atualizar.", HttpStatus.NOT_FOUND) ));

                        return;
                    }
                    throw new NegocioException("Uma das categorias informadas possui um id inválido. Não é possivel atualizar.", HttpStatus.BAD_REQUEST);
            
                });

                registro.setPerspectiva(perspectiva);
                
                registro.setCategorias(categorias);

                perspectivaRepo.save(perspectiva);

                return registroRepo.save(registro);
            }
            
            throw new NegocioException("O tipo de registro não foi definido, não é possivel atualizar.", HttpStatus.BAD_REQUEST);

            
        }

        throw new NegocioException("Necessário informar um id válido pra a operação.", HttpStatus.BAD_REQUEST);
    }
}
