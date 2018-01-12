package com.httt.service;
import java.util.List;
import com.httt.model.DatPhong;

public interface DatPhongService {
	Iterable<DatPhong> findAll();

    DatPhong search(int q);

    DatPhong findOne(int madp);

    void save(DatPhong datphong);

    void delete(int madp);
}