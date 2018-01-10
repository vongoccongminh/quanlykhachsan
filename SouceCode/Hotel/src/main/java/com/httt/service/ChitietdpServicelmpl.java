package com.httt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httt.model.Thongtindatphong;
import com.httt.repository.ThongtindatphongRepository;
import com.httt.model.Chitietdp;
import com.httt.repository.ChitietdpRepository;

@Service
public class ChitietdpServicelmpl implements ChitietdpService {
	@Autowired
	private ChitietdpRepository chitietdpRepository;

	@Override
	public Iterable<Chitietdp> findAll() {
		return chitietdpRepository.findAll();
	}
	@Override
	public List<Chitietdp> findChitietdp(int ma_dp) {
		return chitietdpRepository.findThongtinchitietdatphong(ma_dp);
	}
	@Override
	public void deleteByid(int id) {
		chitietdpRepository.deleteByid(id);
	}
	@Override
	public Chitietdp findOne(int id) {
		return chitietdpRepository.findOne(id);
	}
	@Override
	public void save(Chitietdp employee) {
		chitietdpRepository.save(employee);
	}

	@Override
	public void delete(int id) {
		chitietdpRepository.delete(id);
	}
}
