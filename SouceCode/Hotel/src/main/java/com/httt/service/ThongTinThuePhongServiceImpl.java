package com.httt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.repository.ThongTinThuePhongRepository;
import com.httt.model.ThongTinThuePhong;

@Service
public class ThongTinThuePhongServiceImpl implements ThongTinThuePhongService {
	@Autowired
    private ThongTinThuePhongRepository ThongTinThuePhongRepository;

    @Override
    public Iterable<ThongTinThuePhong> findAll() {
        return ThongTinThuePhongRepository.findAll();
    }

	@Override
	public List<ThongTinThuePhong> search(int q) {
		return ThongTinThuePhongRepository.findByMatp(q);
	}


    @Override
    public ThongTinThuePhong findOne(int matp) {
        return ThongTinThuePhongRepository.findOne(matp);
    }

    @Override
    public void save(ThongTinThuePhong contact) {
    	ThongTinThuePhongRepository.save(contact);
    }

    @Override
    public void delete(int matp) {
    	ThongTinThuePhongRepository.delete(matp);
    }
}
