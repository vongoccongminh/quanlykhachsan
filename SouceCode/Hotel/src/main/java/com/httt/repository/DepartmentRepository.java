package com.httt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.Department;


public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    List<Department> findByName(String Name);

}