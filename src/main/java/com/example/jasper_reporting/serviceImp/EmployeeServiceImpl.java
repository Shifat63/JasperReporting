package com.example.jasper_reporting.serviceImp;

import com.example.jasper_reporting.model.Employee;
import com.example.jasper_reporting.repositories.EmployeeRepo;
import com.example.jasper_reporting.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Set<Employee> findAll() throws Exception {
        Set<Employee> employeeSet = new HashSet<>();
        employeeRepo.findAll().forEach(employeeSet::add);
        return employeeSet;
    }

    @Override
    public Employee findById(Long empId) throws Exception {
        Employee employee = employeeRepo.findById(empId).get();
        return employee;
    }
}
