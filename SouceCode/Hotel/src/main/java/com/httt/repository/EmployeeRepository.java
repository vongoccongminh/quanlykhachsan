package com.httt.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.httt.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByNameContaining(String q);
    public Employee findByUsername(String username);

}