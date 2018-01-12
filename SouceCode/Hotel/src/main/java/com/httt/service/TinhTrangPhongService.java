package com.httt.service;

import java.util.List;

import com.httt.model.TinhTrangPhong;

public interface TinhTrangPhongService {
	Iterable<TinhTrangPhong> findAll();

	TinhTrangPhong findOne(int id);

    void save(TinhTrangPhong contact);

    void delete(int id);
   
    List<TinhTrangPhong> laytinhtrang(int maphong);
    
    List<TinhTrangPhong> layphong(int maphong);
   }
