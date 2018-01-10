package com.httt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.httt.model.LoaiPhong;

public interface LoaiPhongRepository extends CrudRepository<LoaiPhong, Integer> {
	@Query("SELECT t FROM LoaiPhong  t WHERE t.maloai =?1")
    public List<LoaiPhong> findLoaiPhong(int maloai);
}
