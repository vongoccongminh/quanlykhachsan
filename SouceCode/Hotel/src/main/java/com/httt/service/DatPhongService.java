package com.httt.service;
import java.util.List;
import com.httt.model.DatPhong;

public interface DatPhongService {
	Iterable<DatPhong> findAll();

    List<DatPhong> search(int q);

    DatPhong findOne(int madp);

    void save(DatPhong contact);

    void delete(int madp);
}