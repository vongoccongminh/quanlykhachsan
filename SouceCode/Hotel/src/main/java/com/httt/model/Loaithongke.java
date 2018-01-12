package com.httt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaithongke")
public class Loaithongke implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name = "maloaitk", nullable = false)
	private int maloaitk;
	
	@Column(name = "tenloaitk")
	private String tenloaitk;
	
	@Column(name = "ghichu")
	private String ghichu;

	public int getMaloaitk() {
		return maloaitk;
	}

	public void setMaloaitk(int maloaitk) {
		this.maloaitk = maloaitk;
	}

	public String getTenloaitk() {
		return tenloaitk;
	}

	public void setTenloaitk(String tenloaitk) {
		this.tenloaitk = tenloaitk;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Loaithongke(int maloaitk, String tenloaitk, String ghichu) {
		super();
		this.maloaitk = maloaitk;
		this.tenloaitk = tenloaitk;
		this.ghichu = ghichu;
	}
	
	public Loaithongke() {
		super();
		// TODO Auto-generated constructor stub
	}
}
