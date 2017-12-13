package com.httt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.httt.model.Employee;

@Service
public interface EmployeeService {
	Iterable<Employee> findAll();

	List<Employee> search(String q);

	Employee findOne(int id);

	void save(Employee employee);

	void delete(int id);
}