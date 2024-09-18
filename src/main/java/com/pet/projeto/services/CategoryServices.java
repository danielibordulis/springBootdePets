package com.pet.projeto.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.projeto.model.Category;
import com.pet.projeto.repository.CategoryRepository;


@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository; 

    public List<Category> getAllCategorias(){
        return categoryRepository.findAll();
    }

    public Category getCategoriaById(int id) {

            Optional<Category> categoria = categoryRepository.findById(id);
            return categoria.orElse(null);
            
        }
        public Category saveCategoria(Category category) {
        return categoryRepository.save(category);
    }

     public boolean deleteCategoria(int id){
        Optional<Category> existingCategoria=categoryRepository.findById(id);
        if(existingCategoria.isPresent()){
           categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

     public Category editarCategoria(int id, String nome){

        Optional<Category> categoria= categoryRepository.findById(id);

        if(categoria.isPresent()){
            Category categoriaEscolhida=categoria.get();
            categoriaEscolhida.setName(nome);
            Category novaCategoria = categoryRepository.saveAndFlush(categoriaEscolhida);
            return novaCategoria;
        
        }

        return null;

    }


}
