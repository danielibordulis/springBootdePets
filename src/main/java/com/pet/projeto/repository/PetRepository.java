package com.pet.projeto.repository;

import com.pet.projeto.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer>{
    
}