package com.pet.projeto.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.projeto.model.Tag;
import com.pet.projeto.repository.TagRepository;

@Service
public class TagServices {
        @Autowired
        private TagRepository tagRepository; 

        public List<Tag> getAllTags(){
            return tagRepository.findAll();
        }
        public Tag getTagById(int id) {

                Optional<Tag> tag = tagRepository.findById(id);
                return tag.orElse(null);
                
            }
             public Tag saveTag(Tag tag) {
            return tagRepository.save(tag);
    }

        public boolean deleteTag(int id){
            Optional<Tag> existingTag=tagRepository.findById(id);
            if(existingTag.isPresent()){
            tagRepository.deleteById(id);
                return true;
            }
            return false;
        }

        public Tag editarTag(int id, String nome){

            Optional<Tag> tag= tagRepository.findById(id);
    
            if(tag.isPresent()){
                Tag tagEscolhida=tag.get();
                tagEscolhida.setName(nome);
                Tag novaTag = tagRepository.saveAndFlush(tagEscolhida);
                return novaTag;
            
            }
    
            return null;
    
        }
}
