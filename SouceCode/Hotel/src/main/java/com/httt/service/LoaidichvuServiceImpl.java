package com.httt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.Loaidichvu;
import com.httt.repository.LoaidichvuRepository;

@Service
public class LoaidichvuServiceImpl implements LoaidichvuService{
	@Autowired
	private LoaidichvuRepository loaidichvuRepository;
	

	public Iterable<Loaidichvu> findAll(){
		return loaidichvuRepository.findAll();
	}
	

	public List<Loaidichvu> search(String q) {
		return null;
	}

	
	public Loaidichvu findOne(int id) {
		return loaidichvuRepository.findOne(id);
	}


	public void save(Loaidichvu loaidichvu) { 
		loaidichvuRepository.save(loaidichvu);
	}

	public void delete(int id) {
		loaidichvuRepository.delete(id);
	}
}