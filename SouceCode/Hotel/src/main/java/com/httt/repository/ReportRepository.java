package com.httt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.Report;;


public interface ReportRepository extends CrudRepository<Report, Integer> {
    List<Report> findByNameContaining(String q);
}
