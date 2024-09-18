package com.pet.projeto.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.projeto.model.User;
import com.pet.projeto.repository.UserRepository;

@Service
public class UserServices {
     @Autowired
        private UserRepository userRepository; 

        public List<User> getAllUsers(){
            return userRepository.findAll();
        }

         public User getUserById(int id) {

                Optional<User> user = userRepository.findById(id);
                return user.orElse(null);
                
            }
             public User saveUser(User user) {
            return userRepository.save(user);
    }

            public boolean deleteUser(int id){
                Optional<User> existingUser=userRepository.findById(id);
                if(existingUser.isPresent()){
                userRepository.deleteById(id);
                    return true;
                }
                return false;
            }

    
}
