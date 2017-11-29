package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.BaoCao;
import com.example.repository.BaoCaoRepository;

@Service
public class BaoCaoServiceImpl implements BaoCaoService {

    @Autowired
    private BaoCaoRepository baocaoRepository;
    
    @Override
    public Iterable<BaoCao> findAll(){
    	return baocaoRepository.findAll();
    }
    
    @Override
    public List<BaoCao> search(String q){
    	return baocaoRepository.findByNameContaining(q);
    }
    
    @Override
    public BaoCao findOne(int maBaoCao) {
    	return baocaoRepository.findOne(maBaoCao);
    }
    
    @Override
    public void save(BaoCao baocao) {
        baocaoRepository.save(baocao);
    }
    
    @Override
    public void delete(int maBaoCao) {
        baocaoRepository.delete(maBaoCao);
    }
    
    
}
