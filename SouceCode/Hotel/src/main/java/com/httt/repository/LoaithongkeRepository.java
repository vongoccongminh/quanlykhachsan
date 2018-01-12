package com.httt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.Loaithongke;

public interface LoaithongkeRepository extends CrudRepository<Loaithongke, Integer> {

    List<Loaithongke> findBymaloaitk(Integer ma);
    

}
