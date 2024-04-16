package com.teste.restapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.restapp.model.Usuario;
import com.teste.restapp.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    @CrossOrigin
    @GetMapping
    public List<Usuario> listar(){
        return repository.findAll();

    }
    @PostMapping
    public Usuario adicionar(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }
    @PutMapping
    public Usuario editar(@RequestBody Usuario usuario){
        if(usuario.getId()>0){
            return repository.save(usuario);

        }else{
            return null;
        }
        
    }
    public String deletar(@RequestBody Usuario usuario){
      
        if(usuario.getId()>0){
            repository.delete(usuario);
            return "Removido com sucesso";
          

        }else{
            return "Usuario não encontrado";
        }
    }
}