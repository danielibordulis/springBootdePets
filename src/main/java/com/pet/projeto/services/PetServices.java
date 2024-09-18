package com.pet.projeto.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.projeto.model.Pet;
import com.pet.projeto.repository.PetRepository;

@Service
public class PetServices {
    @Autowired
    private PetRepository petRepository; 

    public List<Pet> getAllPet(){
        return petRepository.findAll();
    }
    public Pet getPetById(int id) {

            Optional<Pet> pet = petRepository.findById(id);
            return pet.orElse(null);
            
        }

        public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public boolean deletePet(int id){
            Optional<Pet> existingPet=petRepository.findById(id);
            if(existingPet.isPresent()){
            petRepository.deleteById(id);
                return true;
            }
            return false;
        }

        public Pet editarPet(int id, String nome){

            Optional<Pet> pet= petRepository.findById(id);
    
            if(pet.isPresent()){
                Pet petEscolhido=pet.get();
                petEscolhido.setName(nome);
                Pet novoPet = petRepository.saveAndFlush(petEscolhido);
                return novoPet;
            
            }
    
            return null;
    
        }

}
