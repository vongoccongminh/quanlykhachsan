package com.httt.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.httt.model.Department;


@Service
public interface DepartmentService {
	
	Iterable<Department> findAll();

	List<Department> search(String q);

	Department findOne(int id);

	void save(Department department);

	void delete(int id);
}