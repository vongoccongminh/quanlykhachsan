package com.httt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.httt.model.Thongke;
import com.httt.model.TinhTrangPhong;

public interface ThongkeRepository extends CrudRepository<Thongke, Integer> {

    List<Thongke> findBymathongke(Integer ma);
  
    

}
