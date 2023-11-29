package com.example.CRM_PROJET_FIL_ROUGE.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="type_presta", nullable = false, length = 100)
    private String typePresta;
    @Column(nullable = false, length = 100)
    private String designation;

    @ManyToOne
    @JoinColumn(name= "client_id", nullable = false)
    private Client client;
    @Column(name="nb_days", nullable = false)
    private Integer nombreJours;
    @Column(name="unit_price", nullable = false, columnDefinition = "NUMERIC")
    private BigInteger unitPrice;
    @Column(name="total_exclude_taxe", columnDefinition = "NUMERIC")
    private BigInteger totalExcludeTaxe;
    @Column(name="total_with_taxe", columnDefinition = "NUMERIC")
    private BigInteger totalWithTaxe;
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "int4")
    private OrderStatus state;

    public Order() {
    }

    public Order(Integer id, String typePresta, String designation, Client client, Integer nombreJours, BigInteger unitPrice, BigInteger totalExcludeTaxe, BigInteger totalWithTaxe, OrderStatus state) {
        this.id = id;
        this.typePresta = typePresta;
        this.designation = designation;
        this.nombreJours = nombreJours;
        this.unitPrice = unitPrice;
        this.totalExcludeTaxe = totalExcludeTaxe;
        this.totalWithTaxe = totalWithTaxe;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getNombreJours() {
        return nombreJours;
    }

    public void setNombreJours(Integer nombreJours) {
        this.nombreJours = nombreJours;
    }

    public BigInteger getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigInteger unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigInteger getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(BigInteger totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public BigInteger getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(BigInteger totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public OrderStatus getState() {
        return state;
    }

    public void setState(OrderStatus state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", client=" + client +
                ", nombreJours=" + nombreJours +
                ", unitPrice=" + unitPrice +
                ", totalExcludeTaxe=" + totalExcludeTaxe +
                ", totalWithTaxe=" + totalWithTaxe +
                ", state=" + state +
                '}';
    }
}
