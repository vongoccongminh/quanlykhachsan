package com.httt.service;
import java.util.List;
import com.httt.model.TraPhong;

public interface TraPhongService {
	Iterable<TraPhong> findAll();

    TraPhong search(int q);

    TraPhong findOne(int matp);

    void save(TraPhong traphong);

    void delete(int matp);
}