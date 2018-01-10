package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.Thongke;
import com.httt.repository.ThongkeRepository;

@Service
public class ThongkeServiceImpl implements ThongkeService {
	@Autowired
    private ThongkeRepository thongkeRepository;

    @Override
    public Iterable<Thongke> findAll() {
        return thongkeRepository.findAll();
    }

    @Override
    public List<Thongke> search(int ma) {
        return thongkeRepository.findBymathongke(ma);
    }

    @Override
    public Thongke findOne(int id) {
        return thongkeRepository.findOne(id);
    }

    @Override
    public void save(Thongke thongke) {
    	thongkeRepository.save(thongke);
    }

    @Override
    public void delete(int id) {
    	thongkeRepository.delete(id);
    }
}