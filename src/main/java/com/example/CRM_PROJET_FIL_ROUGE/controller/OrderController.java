package com.example.CRM_PROJET_FIL_ROUGE.controller;


import com.example.CRM_PROJET_FIL_ROUGE.dao.model.Client;
import com.example.CRM_PROJET_FIL_ROUGE.dao.model.Order;
import com.example.CRM_PROJET_FIL_ROUGE.service.ClientService;
import com.example.CRM_PROJET_FIL_ROUGE.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderController {

    @Autowired
    OrderService orderService;

    //GET ALL ORDERS
    @GetMapping("orders")
    public ResponseEntity<?> getOrders(){
        if (orderService.getOrders().isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderService.getOrders());
    }

    // GET BY ID ORDER
    @GetMapping("orders/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") Integer id){
        for(Order o : orderService.getOrders()){
            if(o.getId().equals(id))
                return ResponseEntity.ok(o);
        }
        return ResponseEntity.status(404).body("Order with ID " + id + " not found");
    }

    // POST  ORDER
    @PostMapping("orders")
    public ResponseEntity<Order> addOrder(@RequestBody Order newOrder){
        orderService.addOrder(newOrder);
        return ResponseEntity.ok().build();
    }


//    UPDATE ORDER
    @PutMapping("orders/{id}")
    public ResponseEntity<?> updateOrder(@RequestBody Order order, @PathVariable("id") Integer id){
        if (order.getId() == null){
            return ResponseEntity.badRequest().body("Request Error : Missing Order identifier");
        }
        if (!order.getId().equals(id)){
            return ResponseEntity.badRequest().body("Identifier values are different");
        }
        orderService.updateOrder( order);
        return ResponseEntity.ok().build();

    }

    // DELETE ORDER
    @DeleteMapping("orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Integer id){
        if(orderService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            orderService.deleteOrder(id);
            return ResponseEntity.ok("ok");
        }
    }
}
