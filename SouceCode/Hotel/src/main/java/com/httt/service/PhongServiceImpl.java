package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.Phong;
import com.httt.repository.PhongRepository;;

@Service
public class PhongServiceImpl implements PhongService {
	@Autowired
    private PhongRepository phongRepository;

    @Override
    public Iterable<Phong> findAll() {
        return phongRepository.findAll();
    }


    @Override
    public Phong findOne(int id) {
        return phongRepository.findOne(id);
    }

    @Override
    public void save(Phong contact) {
    	phongRepository.save(contact);
    }

    @Override
    public void delete(int id) {
    	phongRepository.delete(id);
    }
    
    @Override
    public List<Phong> search(String q) {
        return phongRepository.findByTenphongContaining(q);
    }
}
