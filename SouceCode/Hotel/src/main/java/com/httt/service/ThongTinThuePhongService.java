package com.httt.service;




import java.util.List;

import com.httt.model.ThongTinThuePhong;

public interface ThongTinThuePhongService {
	Iterable<ThongTinThuePhong> findAll();

    List<ThongTinThuePhong> search(int q);

    ThongTinThuePhong findOne(int matp);

    void save(ThongTinThuePhong contact);

    void delete(int matp);
}
