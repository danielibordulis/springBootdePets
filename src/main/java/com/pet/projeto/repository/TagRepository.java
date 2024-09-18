package com.pet.projeto.repository;

import com.pet.projeto.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer>{
    
}