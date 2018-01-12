package com.httt.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thongtintraphong")
public class TraPhong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "matp", nullable = false)
	private int matp;
	@Column(name = "mathuephong")
	private int mathuephong;
	@Column(name = "makh")
	private int makh;
	@Column(name = "thoigiantraphong")
	private Date thoigiantraphong;
	
	@Column(name = "mota")
	private String mota;

	@Column(name = "chiphiphatsinh")
	private float chiphiphatsinh;

	@Column(name = "tongtien")
	private float tongtien;

	public int getMatp() {
		return matp;
	}

	public void setMatp(int matp) {
		this.matp = matp;
	}

	public int getMathuephong() {
		return mathuephong;
	}

	public void setMathuephong(int mathuephong) {
		this.mathuephong = mathuephong;
	}

	public int getMakh() {
		return makh;
	}

	public void setMakh(int makh) {
		this.makh = makh;
	}

	public Date getThoigiantraphong() {
		return thoigiantraphong;
	}

	public void setThoigiantraphong(Date thoigiantraphong) {
		this.thoigiantraphong = thoigiantraphong;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public float getChiphiphatsinh() {
		return chiphiphatsinh;
	}

	public void setChiphiphatsinh(float chiphiphatsinh) {
		this.chiphiphatsinh = chiphiphatsinh;
	}

	public float getTongtien() {
		return tongtien;
	}

	public void setTongtien(float tongtien) {
		this.tongtien = tongtien;
	}

	public TraPhong(int matp, int mathuephong, int makh, Date thoigiantraphong, String mota, float chiphiphatsinh,
			float tongtien) {
		super();
		this.matp = matp;
		this.mathuephong = mathuephong;
		this.makh = makh;
		this.thoigiantraphong = thoigiantraphong;
		this.mota = mota;
		this.chiphiphatsinh = chiphiphatsinh;
		this.tongtien = tongtien;
	}

	public TraPhong() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
		
}