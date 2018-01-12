package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.Loaithongke;
import com.httt.repository.LoaithongkeRepository;

@Service
public class LoaithongkeServiceImpl implements LoaithongkeService {
	@Autowired
    private LoaithongkeRepository loaithongkeRepository;

    @Override
    public Iterable<Loaithongke> findAll() {
        return loaithongkeRepository.findAll();
    }

    @Override
    public List<Loaithongke> search(int ma) {
        return loaithongkeRepository.findBymaloaitk(ma);
    }

    @Override
    public Loaithongke findOne(int id) {
        return loaithongkeRepository.findOne(id);
    }

    @Override
    public void save(Loaithongke loaithongke) {
    	loaithongkeRepository.save(loaithongke);
    }

    @Override
    public void delete(int id) {
    	loaithongkeRepository.delete(id);
    }
}