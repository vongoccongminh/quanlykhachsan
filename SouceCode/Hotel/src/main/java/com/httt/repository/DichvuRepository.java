package com.httt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.Dichvu;

public interface DichvuRepository extends CrudRepository<Dichvu, Integer> {

    List<Dichvu> findBytenDVContaining(String q);

}
