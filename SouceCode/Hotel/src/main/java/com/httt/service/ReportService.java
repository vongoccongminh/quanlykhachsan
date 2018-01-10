package com.httt.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.httt.model.Report;

@Service
public interface ReportService {
	Iterable<Report> findAll();

	List<Report> search(String q);

	Report findOne(int id);

	void save(Report report);

	void delete(int id);
	
}
