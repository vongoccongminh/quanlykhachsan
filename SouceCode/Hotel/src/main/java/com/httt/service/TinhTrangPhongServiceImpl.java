package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.TinhTrangPhong;
import com.httt.repository.TinhTrangPhongRepository;

@Service
public class TinhTrangPhongServiceImpl implements TinhTrangPhongService {
	@Autowired
    private TinhTrangPhongRepository tinhtrangphongRepository;

    @Override
    public Iterable<TinhTrangPhong> findAll() {
        return tinhtrangphongRepository.findAll();
    }


    @Override
    public TinhTrangPhong findOne(int id) {
        return tinhtrangphongRepository.findOne(id);
    }

    @Override
    public void save(TinhTrangPhong contact) {
    	tinhtrangphongRepository.save(contact);
    }

    @Override
    public void delete(int id) {
    	tinhtrangphongRepository.delete(id);
    }
    
    @Override
    public List<TinhTrangPhong> laytinhtrang(int id) {
        return tinhtrangphongRepository.findTinhTrangPhong(id);
    }
}


