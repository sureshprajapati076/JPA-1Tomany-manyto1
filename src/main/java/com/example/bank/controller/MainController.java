package com.example.bank.controller;

import com.example.bank.domain.Company;
import com.example.bank.domain.Employee;
import com.example.bank.domain.EmployeeAction;
import com.example.bank.dto.ActionDTO;
import com.example.bank.dto.EmployeeActionDTO;
import com.example.bank.dto.EmployeeDTO;
import com.example.bank.repo.ActionRepo;
import com.example.bank.repo.CompanyRepo;
import com.example.bank.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    CompanyRepo companyRepo;
    @Autowired
    ActionRepo actionRepo;


    @PostMapping("/add/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    @GetMapping("/getall/employee")
    public List<EmployeeDTO> getEmployees(){
       List<Employee> employeeList= employeeRepo.findAll();

       List<EmployeeDTO> employeeDTOList=new ArrayList<>();

       for(Employee emp: employeeList){
           List<ActionDTO> actionDTOS=new ArrayList<>();
           for(EmployeeAction employeeAction:emp.getActions()){
               actionDTOS.add(new ActionDTO(employeeAction.getDate(),employeeAction.getCheckInTime(),employeeAction.getCheckOutTime()));
           }

           employeeDTOList.add(new EmployeeDTO(emp.getUserId(),emp.getName(),emp.getRole(),emp.getCompany(),actionDTOS));
       }



       return employeeDTOList;


    }

    @PostMapping("/add/company")
    public Company addCompany(@RequestBody Company company){
        return companyRepo.save(company);
    }
    @GetMapping("/getall/company")
    public List<Company> getCompany(){
        return companyRepo.findAll();
    }

    @PostMapping("/add/action")
    public EmployeeAction addAction(@RequestBody EmployeeAction action){
        return actionRepo.save(action);
    }
    @GetMapping("/getall/action")
    public List<EmployeeActionDTO> getActions(){
        List<EmployeeAction> list= actionRepo.findAll();
        return list.stream().map(action-> new EmployeeActionDTO(action.getDate(),action.getCheckInTime(),action.getCheckOutTime(),action.getEmployee().getUserId())).collect(Collectors.toList());
    }



}
