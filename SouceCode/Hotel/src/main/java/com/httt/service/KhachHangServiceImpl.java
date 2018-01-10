package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.KhachHang;
import com.httt.repository.KhachHangRepository;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	@Autowired
	private KhachHangRepository khachhangRepository;
	
	@Override 
	public Iterable<KhachHang> findAll(){
		return khachhangRepository.findAll();
	}
	
	@Override
	public List<KhachHang> search(String q) {
		return khachhangRepository.findBycmndContaining(q);
	}

	@Override
	public KhachHang findOne(int id) {
		return khachhangRepository.findOne(id);
	}

	@Override
	public void save(KhachHang khachhang) { 
		khachhangRepository.save(khachhang);
	}

	@Override
	public void delete(int id) {
		khachhangRepository.delete(id);
	}
}
