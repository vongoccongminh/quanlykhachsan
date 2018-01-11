package com.httt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.Department;
import com.httt.repository.DepartmentRepository;;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Iterable<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public List<Department> search(String Name) {
		return departmentRepository.findByName(Name);
	}

	@Override
	public Department findOne(int id) {
		return departmentRepository.findOne(id);
	}

	@Override
	public void save(Department department) { 
		departmentRepository.save(department);
	}

	@Override
	public void delete(int id) {
		departmentRepository.delete(id);
	}
}

