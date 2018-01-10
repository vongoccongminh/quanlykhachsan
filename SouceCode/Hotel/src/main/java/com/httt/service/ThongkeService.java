package com.httt.service;
import java.util.List;
import com.httt.model.Thongke;

public interface ThongkeService {
	Iterable<Thongke> findAll();

    List<Thongke> search(int q);

    Thongke findOne(int id);

    void save(Thongke thongke);

    void delete(int id);
}