package com.automatoDev.econommiza.resource;

import javax.validation.Valid;

import com.automatoDev.econommiza.entity.Registro;
import com.automatoDev.econommiza.service.RegistroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registros")
public class RegistroResource {
    
    @Autowired
    private RegistroService registroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Registro postRegistro(@Valid @RequestBody Registro registro){
        return registroService.postRegistro(registro);
    }
}
