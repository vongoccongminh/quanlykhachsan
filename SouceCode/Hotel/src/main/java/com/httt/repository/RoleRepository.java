package com.httt.repository;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);

}