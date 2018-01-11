package com.httt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.LoaiKhachHang;
import com.httt.repository.LoaiKhachHangRepository;

@Service
public class LoaiKhachHangServiceImpl implements LoaiKhachHangService{
	@Autowired
	private LoaiKhachHangRepository loaikhachhangRepository;
	

	public Iterable<LoaiKhachHang> findAll(){
		return loaikhachhangRepository.findAll();
	}
	

	public List<LoaiKhachHang> search(String q) {
		return null;
	}

	
	public LoaiKhachHang findOne(int id) {
		return loaikhachhangRepository.findOne(id);
	}


	public void save(LoaiKhachHang loaikhachhang) { 
		loaikhachhangRepository.save(loaikhachhang);
	}

	public void delete(int id) {
		loaikhachhangRepository.delete(id);
	}
}
