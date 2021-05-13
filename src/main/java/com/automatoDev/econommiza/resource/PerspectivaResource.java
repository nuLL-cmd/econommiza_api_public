package com.automatoDev.econommiza.resource;

import javax.validation.Valid;

import com.automatoDev.econommiza.dto.PerspectivaDTO;
import com.automatoDev.econommiza.entity.Perspectiva;
import com.automatoDev.econommiza.service.PerspectivaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * @author Marco Aurelio.
 * @date 08/05/2021
 * 
 * Classe que fornecerar os recursos(endpoints) da aplicação para as perspectivas.
 */
@RestController
@RequestMapping("perspectivas")
//@ApiOperation(value = "Destinado ao manuseio de perspecivas da aplicação.")
public class PerspectivaResource {
    
    @Autowired
    private PerspectivaService perspectivaService;


    @ApiOperation(value = "Recurso destinado a administradores, pois retorna todas as perspectivas da base de dados.")
    @GetMapping(value = "admin/todos", produces = "application/json")
    private ResponseEntity<?> fetchAll(){
        return ResponseEntity.ok(perspectivaService.fetchAll());
    }

    @ApiOperation(value = "Recurso responsavel por trazer uma perspectiva com base no id do usuário.")
    @GetMapping(value = "{id}/user/id", produces = "application/json")
    public ResponseEntity<?> fetchPorUsuarioId(@PathVariable("id") Long id){
        return ResponseEntity.ok(perspectivaService.fetchPorUsuarioId(id));
    }

    @ApiOperation(value = "Recurso responsavel por trazer uma perspectiva com base no uid do usuário.")
    @GetMapping(value = "{uid}/user/uid", produces = "application/json")
    private ResponseEntity<?> fetchPorUsuarioUid(@PathVariable("uid") String uid){
        return ResponseEntity.ok(perspectivaService.fetchPorUsuarioUid(uid));
    }

    @ApiOperation(value = "Recurso responsavel por trazer uma perspectiva com base no id do usuário.")
    @GetMapping(value = "{id}", produces = "application/json")
    private ResponseEntity<?> fetchById(@PathVariable("id") Long id){
        return ResponseEntity.ok(perspectivaService.fetchById(id));
    }

    @ApiOperation(value = "Recurso que deleta uma perspectiva com base em seu id.")
    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deletePerspectiva(@PathVariable("id") Long id){
        perspectivaService.deletePerspectiva(id);
    }

    @ApiOperation(value = "Recurso responsavel por atualizar uma perspectiva")
    @PutMapping(produces = "application/json", consumes = "application/json")
    private ResponseEntity<?> putPerspectiva(@Valid @RequestBody Perspectiva perspectiva){
        return ResponseEntity.ok(perspectivaService.putPerspectiva(perspectiva));
    }

    @ApiOperation(value = "Recurso responsável por criar uma nova perspectiva.")
    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    private PerspectivaDTO postPerspectiva(@Valid @RequestBody Perspectiva perspectiva){
        return perspectivaService.postPerspectiva(perspectiva);
    }
    
}
