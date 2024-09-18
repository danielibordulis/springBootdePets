package com.pet.projeto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.projeto.model.Administrador;
import com.pet.projeto.services.AdministradorServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
@RequestMapping
public class AdministradorController {

    @Autowired
    private AdministradorServices administradorServices;
    
    @GetMapping("/getAllAdministradores")
    public List<Administrador> getAllAdministradores() {
        return administradorServices.getAllAdministradores();
    }
    
    @PostMapping("/criarNovoAdmin")
    public Administrador criarAdministrador(@RequestBody Administrador administrador) {
       
        
        return administradorServices.saveAdministrador(administrador);
    }

    @DeleteMapping("/deletarAdmin/{id}")
    public boolean deleteAdministrador(@RequestParam int id) {
        return administradorServices.deleteAdministrador(id);
    }
    
    

}
