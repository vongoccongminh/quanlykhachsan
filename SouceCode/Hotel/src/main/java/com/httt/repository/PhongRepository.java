package com.httt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.Phong;

public interface PhongRepository extends CrudRepository<Phong, Integer> {
	List<Phong> findByTenphongContaining(String q);
}
