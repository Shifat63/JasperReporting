package com.example.jasper_reporting.controllers;

import com.example.jasper_reporting.model.Employee;
import com.example.jasper_reporting.model.EmployeeSet;
import com.example.jasper_reporting.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class EmployeeRestController {
    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Set<Employee> getAllEmployees() throws Exception{
        /*EmployeeSet employeeSet = new EmployeeSet();
        employeeSet.employees = employeeService.findAll();*/
        return employeeService.findAll();
    }
}
