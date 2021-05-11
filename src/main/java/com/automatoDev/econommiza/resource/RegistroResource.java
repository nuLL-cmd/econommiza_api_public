package com.automatoDev.econommiza.resource;

import javax.validation.Valid;

import com.automatoDev.econommiza.entity.Registro;
import com.automatoDev.econommiza.service.RegistroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registros")
public class RegistroResource {
    
    @Autowired
    private RegistroService registroService;

    @GetMapping("{id}")
    private ResponseEntity<?> fetchPorId(@PathVariable Long id){
        return ResponseEntity.ok(registroService.fetchPorId(id));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Registro postRegistro(@Valid @RequestBody Registro registro){
        return registroService.postRegistro(registro);
    }

    @PutMapping
    private ResponseEntity<?> putRegistro(@Valid @RequestBody Registro registro){
        return ResponseEntity.ok(registroService.putRegistro(registro));
    }


}
