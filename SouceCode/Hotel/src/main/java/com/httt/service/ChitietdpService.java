package com.httt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.httt.model.Thongtindatphong;
import com.httt.model.Chitietdp;

@Service
public interface ChitietdpService {
	Iterable<Chitietdp> findAll();

	Chitietdp findOne(int id);
	List<Chitietdp> findChitietdp(int ma_dp);
	void save(Chitietdp thongtin);
	void deleteByid(int id);
	void delete(int id);
}
