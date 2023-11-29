package com.example.CRM_PROJET_FIL_ROUGE.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="company_name", nullable = false, length = 100)
    private String companyName;
    @Column(name="first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name="last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;
    @Column(name = "phone_number", nullable = false, length = 15, unique = true)
    private String phoneNumber;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;
    @Column(name = "zip_code", nullable = false, length = 30)
    private String zipCode;
    @Column(name = "city", nullable = false, length = 100)
    private String city;
    @Column(name = "country", nullable = false, length = 100)
    private  String country;
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "int4")
    private ClientStatus state;

    @OneToMany
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties(value = { "client" })
    private List<Order> orders = new ArrayList<>();


    public Client() {
    }

    public Client(Integer id, String companyName, String firstName, String lastName, String email, String phoneNumber, String address, String zipCode, String city, String country, ClientStatus state, List<Order> orders) {
        this.id = id;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.state = state;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ClientStatus getState() {
        return state;
    }

    public void setState(ClientStatus state) {
        this.state = state;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state=" + state +
                ", orders=" + orders +
                '}';
    }
}
