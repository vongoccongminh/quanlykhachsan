package com.httt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.httt.model.LoaiKhachHang;

@Service
public interface LoaiKhachHangService {
	Iterable<LoaiKhachHang> findAll();

	List<LoaiKhachHang> search(String q);

	LoaiKhachHang findOne(int id);

	void save(LoaiKhachHang loaikhachhang);

	void delete(int id);

}
