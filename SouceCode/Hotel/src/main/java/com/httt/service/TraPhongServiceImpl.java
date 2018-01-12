package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.TraPhong;
import com.httt.repository.TraPhongRepository;

@Service
public class TraPhongServiceImpl implements TraPhongService {
	@Autowired
    private TraPhongRepository traphongRepository;

    @Override
    public Iterable<TraPhong> findAll() {
        return traphongRepository.findAll();
    }

    @Override
    public TraPhong search(int q) {
        return traphongRepository.findByMatp(q);
    }

    @Override
    public TraPhong findOne(int matp) {
        return traphongRepository.findOne(matp);
    }

    @Override
    public void save(TraPhong traphong) {
    	traphongRepository.save(traphong);
    }

    @Override
    public void delete(int matp) {
    	traphongRepository.delete(matp);
    }
}