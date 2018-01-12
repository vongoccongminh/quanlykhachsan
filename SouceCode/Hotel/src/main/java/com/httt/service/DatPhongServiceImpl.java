package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.service.DatPhongService;
import com.httt.model.DatPhong;
import com.httt.repository.DatPhongRepository;

@Service
public class DatPhongServiceImpl implements DatPhongService {
	@Autowired
    private DatPhongRepository datphongRepository;

    @Override
    public Iterable<DatPhong> findAll() {
        return datphongRepository.findAll();
    }

    @Override
    public DatPhong search(int q) {
        return datphongRepository.findByMadp(q);
    }

    @Override
    public DatPhong findOne(int madp) {
        return datphongRepository.findOne(madp);
    }

    @Override
    public void save(DatPhong datphong) {
    	datphongRepository.save(datphong);
    }

    @Override
    public void delete(int madp) {
    	datphongRepository.delete(madp);
    }
}