package com.httt.service;

import java.util.List;

import com.httt.model.LoaiThietBi;

public interface LoaiThietBiService {
	Iterable<LoaiThietBi> findAll();

	List<LoaiThietBi> search(String q);

	LoaiThietBi findOne(int id);

	void save(LoaiThietBi thietBi);

	void delete(int id);
}
