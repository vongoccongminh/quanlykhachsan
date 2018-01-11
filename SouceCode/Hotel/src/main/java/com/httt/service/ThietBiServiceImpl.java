package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.ThietBi;
import com.httt.repository.ThietBiRepository;

@Service
public class ThietBiServiceImpl implements ThietBiService {
	@Autowired
	private ThietBiRepository thietBiRepository;
	
	@Override 
	public Iterable<ThietBi> findAll(){
		return thietBiRepository.findAll();
	}
	
	@Override
	public List<ThietBi> search(String q) {
		return  null;//thietBiRepository.FindBysoseriContaining(q);
	}

	@Override
	public ThietBi findOne(int id) {
		return thietBiRepository.findOne(id);
	}

	@Override
	public void save(ThietBi thietBi) { 
		thietBiRepository.save(thietBi);
	}

	@Override
	public void delete(int id) {
		thietBiRepository.delete(id);
	}
}
