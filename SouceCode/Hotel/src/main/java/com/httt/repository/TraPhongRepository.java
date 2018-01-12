package com.httt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.TraPhong;

public interface TraPhongRepository extends CrudRepository<TraPhong, Integer> {

    TraPhong findByMatp(Integer matp);

}