package com.pet.projeto.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.projeto.model.Administrador;
import com.pet.projeto.repository.AdministradorRepository;

@Service
public class AdministradorServices {
  
@Autowired
private AdministradorRepository administradorRepository; 

public List<Administrador> getAllAdministradores(){
    return administradorRepository.findAll();
}

  public Administrador getAdministradorById(int id) {

        Optional<Administrador> administrador = administradorRepository.findById(id);
        return administrador.orElse(null);
        
    }

    public Administrador saveAdministrador(Administrador administrador) {
    return administradorRepository.save(administrador);
    }

    public boolean deleteAdministrador(int id){
        Optional<Administrador> existingAdministrador=administradorRepository.findById(id);
        if(existingAdministrador.isPresent()){
            administradorRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Administrador editarAdministrador(int id, boolean isAdmin){

        Optional<Administrador> administrador= administradorRepository.findById(id);

        if(administrador.isPresent()){
            Administrador admin=administrador.get();
            admin.setIsAdmin(isAdmin);
            Administrador novoAdministrador = administradorRepository.saveAndFlush(admin);
            return novoAdministrador;
        
        }

        return null;

    }

}

