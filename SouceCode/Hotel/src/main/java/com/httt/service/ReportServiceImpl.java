package com.httt.service;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.httt.model.Report;
import com.httt.repository.ReportRepository;;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportRepository reportRepository;

	@Override
	public Iterable<Report> findAll() {
		return reportRepository.findAll();
	}

	@Override
	public List<Report> search(String q) {
		return reportRepository.findByNameContaining(q);
	}

	@Override
	public Report findOne(int id) {
		return reportRepository.findOne(id);
	}

	@Override
	public void save(Report report) { 
		reportRepository.save(report);
	}

	@Override
	public void delete(int id) {
		reportRepository.delete(id);
	}
	

}

