package com.httt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.httt.model.KhachHang;

@Service
public interface KhachHangService {
	Iterable<KhachHang> findAll();

	List<KhachHang> search(String q);

	KhachHang findOne(int id);

	void save(KhachHang khachhang);

	void delete(int id);

}
