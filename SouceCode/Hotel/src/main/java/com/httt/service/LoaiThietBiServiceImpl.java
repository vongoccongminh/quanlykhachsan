package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.LoaiThietBi;
import com.httt.repository.LoaiThietBiRepository;

@Service
public class LoaiThietBiServiceImpl implements LoaiThietBiService{
	@Autowired
	private LoaiThietBiRepository loaiThietBiRepository;
	
	@Override 
	public Iterable<LoaiThietBi> findAll(){
		return loaiThietBiRepository.findAll();
	}
	
	@Override
	public List<LoaiThietBi> search(String q) {
		return  loaiThietBiRepository.findBytenloaiContaining(q);
	}

	@Override
	public LoaiThietBi findOne(int id) {
		return loaiThietBiRepository.findOne(id);
	}

	@Override
	public void save(LoaiThietBi loaithietBi) { 
		loaiThietBiRepository.save(loaithietBi);
	}

	@Override
	public void delete(int id) {
		loaiThietBiRepository.delete(id);
	}
}
