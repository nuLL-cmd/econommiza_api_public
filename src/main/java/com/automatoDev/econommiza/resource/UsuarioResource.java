package com.automatoDev.econommiza.resource;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.automatoDev.econommiza.dto.UsuarioPerfilDTO;
import com.automatoDev.econommiza.entity.Usuario;
import com.automatoDev.econommiza.service.UsuarioService;

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
 * @date 04/05/2021
 * 
 * Classe que fornecerar os recursos(endpoints) da aplicação para os usuarios.
 */
@RestController
@RequestMapping("usuarios")
public class UsuarioResource {
    

    @Autowired
    private UsuarioService usuarioService;

    @ApiOperation(value = "Recurso destinado a adminstradores, que traz todos os usuários da base.")
    @GetMapping(produces = "application/json")
    private ResponseEntity<?> fetchAll(){
        
        return ResponseEntity.ok(usuarioService.fetchAll());
    }

    @ApiOperation(value = "Recurso responsavel por trazer um usuari com base no seu id.")
    @GetMapping(value = "{id}",produces = "application/json")
    private ResponseEntity<?> fetchById(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.fetchById(id));
    }

    @ApiOperation(value = "Recurso responsavel por trazer uma perspectiva com base no seu uid.")
    @GetMapping(value = "{uid}/uid",produces = "application/json")
    private ResponseEntity<?> fetchByUid(@PathVariable("uid") String uid){
        return ResponseEntity.ok(usuarioService.fetchByUid(uid));
    }


    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Grava um novo usuário na base.")
    private UsuarioPerfilDTO postUsuario(@Valid @RequestBody Usuario usuario){
        return usuarioService.postUsuario(usuario);
    }

    @ApiOperation(value = "Atualiza um usuário existente na base de dados.")
    @PutMapping(produces = "application/json", consumes = "application/json")
    private ResponseEntity<Usuario> putUsuario(@Valid @RequestBody Usuario usuario){
  
        return ResponseEntity.ok(usuarioService.putUsuario(usuario));
    }

    @ApiOperation(value = "Recurso que deleta o usuário todos os seus dados do banco.")
    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteUsuario(@PathVariable("id") Long id){
        usuarioService.deleteUsuario(id);
    }

    @GetMapping(value = "/testing",produces = "application/json")
    public Map<String, Object> testing(){
        Map<String, Object> map = new HashMap<>();
        map.put("Teste", "Hello World");

        return map;
    }

}
