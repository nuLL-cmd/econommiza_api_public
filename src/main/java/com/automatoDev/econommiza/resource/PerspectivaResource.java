package com.automatoDev.econommiza.resource;

import javax.validation.Valid;

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

/**
 * @author Marco Aurelio.
 * @date 08/05/2021
 * 
 * Classe que fornecerar os recursos(endpoints) da aplicação para as perspectivas.
 */
@RestController
@RequestMapping("perspectivas")
public class PerspectivaResource {
    
    @Autowired
    private PerspectivaService perspectivaService;


    @GetMapping("admin/todos")
    public ResponseEntity<?> fetchAll(){
        return ResponseEntity.ok(perspectivaService.fetchAll());
    }

    @GetMapping("{id}/user/id")
    public ResponseEntity<?> fetchPorUsuarioId(@PathVariable("id") Long id){
        return ResponseEntity.ok(perspectivaService.fetchPorUsuarioId(id));
    }

    @GetMapping("{uid}/user/uid")
    public ResponseEntity<?> fetchPorUsuarioUid(@PathVariable("uid") String uid){
        return ResponseEntity.ok(perspectivaService.fetchPorUsuarioUid(uid));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> fetchById(@PathVariable("id") Long id){
        return ResponseEntity.ok(perspectivaService.fetchById(id));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerspectiva(Long id){
        perspectivaService.deletePerspectiva(id);
    }

    @PutMapping
    public ResponseEntity<?> putPerspectiva(@Valid @RequestBody Perspectiva perspectiva){
        return ResponseEntity.ok(perspectivaService.putPerspectiva(perspectiva));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Perspectiva postPerspectiva(@Valid @RequestBody Perspectiva perspectiva){
        return perspectivaService.postPerspectiva(perspectiva);
    }
    
}
