package com.example.CRM_PROJET_FIL_ROUGE.dao.repository;

import com.example.CRM_PROJET_FIL_ROUGE.dao.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
