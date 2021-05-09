package com.automatoDev.econommiza.resource;

import javax.validation.Valid;

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


    @GetMapping
    public ResponseEntity<?> fetchAll(){
        
        return ResponseEntity.ok(usuarioService.fetchAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> fetchById(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.fetchById(id));
    }
    @GetMapping("{uid}/uid")
    public ResponseEntity<?> fetchByUid(@PathVariable("uid") String uid){
        return ResponseEntity.ok(usuarioService.fetchByUid(uid));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario postUsuario(@Valid @RequestBody Usuario usuario){
        return usuarioService.postUsuario(usuario);
    }

    @PutMapping
    public ResponseEntity<Usuario> putUsuario(@Valid @RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.putUsuario(usuario));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable("id") Long id){
        usuarioService.deleteUsuario(id);
    }

}
