package com.httt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.httt.model.TinhTrangPhong;

public interface TinhTrangPhongRepository extends CrudRepository<TinhTrangPhong, Integer> {
	
	@Query("SELECT t FROM TinhTrangPhong  t WHERE t.phong =?1 and t.ngay in (select max(ngay) from TinhTrangPhong WHERE phong =?1)")
    public List<TinhTrangPhong> findTinhTrangPhong(int phong);
	
	
	@Query("SELECT t FROM TinhTrangPhong  t WHERE t.phong =?1 ")
    public List<TinhTrangPhong> findPhong(int phong);
}

