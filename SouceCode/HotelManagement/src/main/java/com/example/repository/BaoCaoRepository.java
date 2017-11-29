package com.example.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.model.*;

public interface BaoCaoRepository extends CrudRepository <BaoCao, Integer>{
	List<BaoCao> findByNameContaining(String q);
}
