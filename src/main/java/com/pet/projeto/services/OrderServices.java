package com.pet.projeto.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.projeto.model.Order;
import com.pet.projeto.repository.OrderRepository;


@Service
public class OrderServices {
    @Autowired
    private OrderRepository orderRepository; 

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

     public Order getCategoriaById(int id) {

            Optional<Order> order = orderRepository.findById(id);
            return order.orElse(null);
            
        }

         public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

        public boolean deleteOrder(int id){
            Optional<Order> existingOrder=orderRepository.findById(id);
            if(existingOrder.isPresent()){
            orderRepository.deleteById(id);
                return true;
            }
            return false;
        }
        public Order editarOrder(int id, int quantity){

            Optional<Order> order= orderRepository.findById(id);
    
            if(order.isPresent()){
                Order orderEscolhida=order.get();
                orderEscolhida.setQuantity(quantity);
                Order novaOrder = orderRepository.saveAndFlush(orderEscolhida);
                return novaOrder;
            
            }
    
            return null;
    
        }
}
