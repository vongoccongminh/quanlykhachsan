package com.httt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.httt.model.LoaiThietBi;;

public interface LoaiThietBiRepository extends CrudRepository<LoaiThietBi, Integer> {
		List<LoaiThietBi> findBytenloaiContaining(String q);
}
