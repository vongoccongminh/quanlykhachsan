package com.httt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.DatPhong;

public interface DatPhongRepository extends CrudRepository<DatPhong, Integer> {

    List<DatPhong> findBymadpContaining(int madp);

}