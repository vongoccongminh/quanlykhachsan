package com.example.service;

import java.util.List;

import com.example.model.BaoCao;

public interface BaoCaoService {
	Iterable<BaoCao> findAll();
	
	List<BaoCao> search(String q);
	
	BaoCao findOne(int id);
	
	void save(BaoCao baocao);
	
	void delete(int id);
}
