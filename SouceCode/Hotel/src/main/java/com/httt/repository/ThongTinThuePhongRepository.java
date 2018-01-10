package com.httt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.ThongTinThuePhong;


public interface ThongTinThuePhongRepository extends CrudRepository<ThongTinThuePhong, Integer> {

    List<ThongTinThuePhong> findByMatp(Integer q);

}
