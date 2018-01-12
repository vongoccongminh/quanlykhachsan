package com.httt.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.httt.model.Loaidichvu;

@Service
public interface LoaidichvuService {
	Iterable<Loaidichvu> findAll();

	List<Loaidichvu> search(String q);

	Loaidichvu findOne(int id);

	void save(Loaidichvu loaidichvu);

	void delete(int id);

}
