package com.httt.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.httt.model.KhachHang;

public interface KhachHangRepository extends CrudRepository<KhachHang, Integer> {
	 List<KhachHang> findBycmndContaining(String q);
}



