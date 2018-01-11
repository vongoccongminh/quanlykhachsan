package com.httt.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.httt.model.ThietBi;

public interface ThietBiRepository extends CrudRepository<ThietBi, Integer> {
	List<ThietBi> findBytentbContaining(String q);
}



//import com.httt.model.Employee;
//
//
//public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
//    List<Employee> findByNameContaining(String q);
//
//}