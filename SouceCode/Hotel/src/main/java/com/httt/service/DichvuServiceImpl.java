package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.Dichvu;
import com.httt.repository.DichvuRepository;

@Service
public class DichvuServiceImpl implements DichvuService {
	@Autowired
    private DichvuRepository DichvuRepository;

    @Override
    public Iterable<Dichvu> findAll() {
        return DichvuRepository.findAll();
    }

    @Override
    public List<Dichvu> search(String q) {
        return DichvuRepository.findBytenDVContaining(q);
    }

    @Override
    public Dichvu findOne(int id) {
        return DichvuRepository.findOne(id);
    }

    @Override
    public void save(Dichvu contact) {
    	DichvuRepository.save(contact);
    }

    @Override
    public void delete(int id) {
    	DichvuRepository.delete(id);
    }
}