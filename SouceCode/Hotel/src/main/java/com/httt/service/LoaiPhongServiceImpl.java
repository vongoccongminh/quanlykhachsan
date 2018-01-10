package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.LoaiPhong;
import com.httt.repository.LoaiPhongRepository;

@Service
public class LoaiPhongServiceImpl implements LoaiPhongService {
	@Autowired
    private LoaiPhongRepository loaiphongRepository;

    @Override
    public Iterable<LoaiPhong> findAll() {
        return loaiphongRepository.findAll();
    }


    @Override
    public LoaiPhong findOne(int id) {
        return loaiphongRepository.findOne(id);
    }

    @Override
    public void save(LoaiPhong contact) {
    	loaiphongRepository.save(contact);
    }

    @Override
    public void delete(int id) {
    	loaiphongRepository.delete(id);
    }
  
    @Override
    public List<LoaiPhong> layloaiphong(int id) {
        return loaiphongRepository.findLoaiPhong(id);
    }
}

