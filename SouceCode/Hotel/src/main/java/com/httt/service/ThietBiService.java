package com.httt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.httt.model.ThietBi;

@Service
public interface ThietBiService {
	Iterable<ThietBi> findAll();

	List<ThietBi> search(String q);

	ThietBi findOne(int id);

	void save(ThietBi thietBi);

	void delete(int id);

}
