package com.example.CRM_PROJET_FIL_ROUGE.dao.repository;

import com.example.CRM_PROJET_FIL_ROUGE.dao.model.Order;
import com.example.CRM_PROJET_FIL_ROUGE.dao.model.OrderStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="INSERT INTO orders (type_presta,designation,client_id,nb_days,unit_price,state)  VALUES (?1,?2,?3,?4,?5,?6)", nativeQuery = true)
    void insertNewOrder(String typePresta, String designation, int i, Integer nombreJours, BigInteger unitPrice, OrderStatus i1);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value ="UPDATE orders SET type_presta = ?1,designation =?2,client_id =?3,nb_days =?4,unit_price =?5,state=?6  WHERE id=?7", nativeQuery = true)
    int updateOrder(String typePresta, String designation, int i, Integer nbDays, BigInteger unitPrice, OrderStatus i1,int id);

}
