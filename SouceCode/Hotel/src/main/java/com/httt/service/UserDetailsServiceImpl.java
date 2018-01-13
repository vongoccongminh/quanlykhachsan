package com.httt.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.httt.model.Employee;
import com.httt.repository.EmployeeRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Employee employee = (Employee) employeeRepository.findByUsername(name);
        System.out.println("1");
        if (employee == null) {
        	System.out.println("2");
            throw new UsernameNotFoundException("Employee not found");
        }

        String role = employee.getRole();
  
      System.out.println("role" + role);
              System.out.println("pass1" + employee.getUsername());       
      GrantedAuthority authority = new SimpleGrantedAuthority(role);	
      List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
		grantList.add(authority);

		System.out.println("pass" + employee.getPassword());
       return new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(),true, true, true, true,  grantList);
    }

}