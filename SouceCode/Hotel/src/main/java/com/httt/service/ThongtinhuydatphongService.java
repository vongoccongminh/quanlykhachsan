package com.httt.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.httt.model.Thongtindatphong;
import com.httt.model.Thongtinhuydatphong;

@Service
public interface ThongtinhuydatphongService {
	Iterable<Thongtinhuydatphong> findAll();

	Thongtinhuydatphong findOne(int id);
	//void insertdata(int ma_dp,int maphong,String ngay,String nguyennhan,int ma_nv);
	void save(Thongtinhuydatphong thongtin);

	void delete(int id);
}
