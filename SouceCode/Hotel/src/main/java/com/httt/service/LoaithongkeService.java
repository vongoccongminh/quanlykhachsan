package com.httt.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.httt.model.Loaithongke;

@Service
public interface LoaithongkeService {
	Iterable<Loaithongke> findAll();

    List<Loaithongke> search(int q);

    Loaithongke findOne(int id);

    void save(Loaithongke loaithongke);

    void delete(int id);
}