package com.httt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.httt.model.Role;
import com.httt.model.Employee;
import com.httt.repository.EmployeeRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Employee employee = (Employee) employeeRepository.findByNameContaining(name);
        System.out.println("1");
        if (employee == null) {
        	System.out.println("2");
            throw new UsernameNotFoundException("Employee not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = employee.getRoles();
        
        System.out.println("TEEEEE" + employee.getRoles());
        
        for (Role role : roles) {
        	System.out.println("3");
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                employee.getUsername(), employee.getPasswords(), grantedAuthorities);
    }

}