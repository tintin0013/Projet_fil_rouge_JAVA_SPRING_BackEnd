package com.example.CRM_PROJET_FIL_ROUGE.service;

import com.example.CRM_PROJET_FIL_ROUGE.dao.model.Client;
import com.example.CRM_PROJET_FIL_ROUGE.dao.model.Order;
import com.example.CRM_PROJET_FIL_ROUGE.dao.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    //GET ALL ORDER
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }


    //GET BY  ID ORDER

    public Optional<Order> findById(Integer id){
        Optional<Order> optional = orderRepository.findById(id);
        return optional;
    }


    // CREATE ORDER
    public void  addOrder(Order order){
         orderRepository.insertNewOrder(order.getTypePresta()
                 ,order.getTypePresta(),order.getClient().getId()
                 ,order.getNombreJours(),order.getUnitPrice(),order.getState());
    }


    // UPDATE ORDER
    public void updateOrder(Order order){
         orderRepository.updateOrder(order.getTypePresta(),order.getDesignation(),order.getClient().getId(),order.getNombreJours(),order.getUnitPrice(),order.getState(),order.getId());
    }


    //DELETE ORDER
    public boolean deleteOrder(Integer id){
        if(findById(id).isEmpty())
            return false;
        else {
            orderRepository.deleteById(id);
            return true;
        }
    }

}
