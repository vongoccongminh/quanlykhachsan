package com.httt.service;

import java.util.List;

import com.httt.model.LoaiPhong;

public interface LoaiPhongService {
	Iterable<LoaiPhong> findAll();

	LoaiPhong findOne(int id);

    void save(LoaiPhong contact);

    void delete(int id);
    
    List<LoaiPhong> layloaiphong(int maphong);
    
}
