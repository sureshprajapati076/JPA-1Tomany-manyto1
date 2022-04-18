package com.example.bank.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

@Entity
@Table(name = "employee")


public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String userId;

    private String password;
    private String name;
    private String secret;
    private String role;




    @OneToMany(mappedBy = "employee", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)

    private List<EmployeeAction> actions;



    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public List<EmployeeAction> getActions() {
        return actions;
    }

    public void setActions(List<EmployeeAction> actions) {
        this.actions = actions;
    }



}