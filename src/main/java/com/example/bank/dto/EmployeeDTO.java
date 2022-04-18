package com.example.bank.dto;

import com.example.bank.domain.Company;
import com.example.bank.domain.EmployeeAction;

import java.util.List;


public class EmployeeDTO {
    private String userId;
    private String name;
    private String role;
    private Company company;
    private List<ActionDTO> actions;

    public EmployeeDTO(String userId) {
        this.userId = userId;
    }

    public EmployeeDTO(String userId, String name, String role, Company company, List<ActionDTO> actions) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.company = company;
        this.actions = actions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<ActionDTO> getActions() {
        return actions;
    }

    public void setActions(List<ActionDTO> actions) {
        this.actions = actions;
    }
}