package com.pet.projeto.repository;

import com.pet.projeto.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
    
}