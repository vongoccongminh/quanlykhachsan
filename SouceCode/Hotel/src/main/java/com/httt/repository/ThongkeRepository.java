package com.httt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.Thongke;

public interface ThongkeRepository extends CrudRepository<Thongke, Integer> {

    List<Thongke> findBymathongke(Integer ma);
    

}
