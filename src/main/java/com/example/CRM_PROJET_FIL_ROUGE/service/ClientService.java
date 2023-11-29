package com.example.CRM_PROJET_FIL_ROUGE.service;

import com.example.CRM_PROJET_FIL_ROUGE.dao.model.Client;
import com.example.CRM_PROJET_FIL_ROUGE.dao.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    //GET ALL CLIENT
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    //GET BY  ID CLIENT
    public Optional<Client> findById(Integer id){
        Optional<Client> optional = clientRepository.findById(id);
        return optional;
    }

    // CREATE CLIENT
    public Client addClient(Client client){
        return clientRepository.save(client);
    }

    // UPDATE CLIENT
    public Client updateClient(Client client){
        return clientRepository.save(client);
    }

    //DELETE CLIENT
    public boolean deleteClient(Integer id){
        if(findById(id).isEmpty())
            return false;
        else {
            clientRepository.deleteById(id);
            return true;
        }
    }

}
