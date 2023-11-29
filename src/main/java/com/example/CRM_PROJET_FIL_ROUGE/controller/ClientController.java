package com.example.CRM_PROJET_FIL_ROUGE.controller;

import com.example.CRM_PROJET_FIL_ROUGE.dao.model.Client;
import com.example.CRM_PROJET_FIL_ROUGE.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class ClientController {

    @Autowired
    ClientService clientService;

    // GET ALL CLIENTS
    @GetMapping("clients")
    public ResponseEntity<?> getClients(){
        if (clientService.getClients().isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientService.getClients());
    }

    // GET BY ID CLIENT
    @GetMapping("clients/{id}")
    public ResponseEntity<?> getClient(@PathVariable("id") Integer id){
        for(Client c : clientService.getClients()){
            if(c.getId().equals(id))
                return ResponseEntity.ok(c);
        }
        return ResponseEntity.status(404).body("Client with 'ID " + id + " not found");
    }

    // POST  CLIENT
    @PostMapping("clients")
    public ResponseEntity<Client> addClient(@RequestBody Client newClient){
        clientService.addClient(newClient);
        return ResponseEntity.ok().build();
    }

    // UPDATE CLIENT
    @PutMapping("clients/{id}")
    public ResponseEntity<?> updateClient(@RequestBody Client client, @PathVariable("id") Integer id){
        if (client.getId() == null){
            return ResponseEntity.badRequest().body("Request Error : Missing Client identifier");
        }
        if (!client.getId().equals(id)){
            return ResponseEntity.badRequest().body("Identifier values are different");
        }
        return ResponseEntity.ok(clientService.updateClient( client));

    }

    // DELETE CLIENT
    @DeleteMapping("clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Integer id){
        if(clientService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            clientService.deleteClient(id);
            return ResponseEntity.ok("ok");
        }
    }


}
