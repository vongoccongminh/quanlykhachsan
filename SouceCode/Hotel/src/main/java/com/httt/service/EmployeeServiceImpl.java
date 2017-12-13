package com.httt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.Employee;
import com.httt.repository.EmployeeRepository;;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> search(String q) {
		return employeeRepository.findByNameContaining(q);
	}

	@Override
	public Employee findOne(int id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public void save(Employee employee) { 
		employeeRepository.save(employee);
	}

	@Override
	public void delete(int id) {
		employeeRepository.delete(id);
	}
}

