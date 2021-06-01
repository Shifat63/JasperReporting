package com.example.jasper_reporting.repositories;

import com.example.jasper_reporting.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
}
