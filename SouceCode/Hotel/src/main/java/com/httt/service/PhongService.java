package com.httt.service;

import java.util.List;

import com.httt.model.Phong;

public interface PhongService {
	Iterable<Phong> findAll();

    Phong findOne(int id);

    void save(Phong contact);

    void delete(int id);
    
    List<Phong> search(String q);
    
}