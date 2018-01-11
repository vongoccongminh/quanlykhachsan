package com.httt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dichvu")
public class Dichvu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "maDV", nullable = false)
	private int maDV;
	
	@Column(name = "tenDV", nullable = false)
	private String tenDV;
	
	@Column(name = "loaiDV", nullable = false)
	private int loaiDV;
	
	@Column(name = "moTa")
	private String moTa;
	
	@Column(name = "donGia")
	private int donGia;

	public Dichvu() {
		super();
	}

	public Dichvu(int maDV, String tenDV, int loaiDV, String moTa, int donGia) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.loaiDV = loaiDV;
		this.moTa = moTa;
		this.donGia = donGia;
	}

	public int getMaDV() {
		return maDV;
	}

	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public int getLoaiDV() {
		return loaiDV;
	}

	public void setLoaiDV(int loaiDV) {
		this.loaiDV = loaiDV;
	}	
	
	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}	
	
	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}	
	
}