package com.httt.repository;

import java.util.List;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.httt.model.LoaiKhachHang;

public interface LoaiKhachHangRepository extends CrudRepository<LoaiKhachHang, Integer> {
	 List<LoaiKhachHang> findBytenloaikh(String q);
}



