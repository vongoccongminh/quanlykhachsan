package com.httt.service;

import java.util.List;
import com.httt.model.Dichvu;

public interface DichvuService {
	Iterable<Dichvu> findAll();

    List<Dichvu> search(String q);

    Dichvu findOne(int id);

    void save(Dichvu contact);

    void delete(int id);
}
