package com.httt.service;


import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.Thongtindatphong;
import com.httt.repository.ThongtindatphongRepository;
import com.httt.model.Thongtinhuydatphong;
import com.httt.repository.ThongtinhuydatphongRepository;

@Service
public class ThongtinhuydatphongServicelmpl implements ThongtinhuydatphongService {
	@Autowired
	private ThongtinhuydatphongRepository thongtinhuydatphongRepository;

	@Override
	public Iterable<Thongtinhuydatphong> findAll() {
		return thongtinhuydatphongRepository.findAll();
	}

	@Override
	public Thongtinhuydatphong findOne(int id) {
		return thongtinhuydatphongRepository.findOne(id);
	}
	@Override
	public void save(Thongtinhuydatphong thongtin) {
		thongtinhuydatphongRepository.save(thongtin);
	}

	@Override
	public void delete(int id) {
		thongtinhuydatphongRepository.delete(id);
	}

}
