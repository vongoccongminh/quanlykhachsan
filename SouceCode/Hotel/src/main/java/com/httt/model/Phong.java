package com.httt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "PHONG")
public class Phong implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "maphong", nullable = false)
    private int maphong;
    
    @Column(name = "tenphong", nullable = false)
    private String tenphong;
    
    @Column(name = "giaphong", nullable = false)
    private float giaphong;
    
    
    @Column(name = "mota", nullable = false)
    private String mota;
    
    
    @Column(name = "maloai", nullable = false)
    private int maloai;
    
    
	
	
	public int getMaphong() {
		return maphong;
	}
	public void setMaphong(int maphong) {
		this.maphong = maphong;
	}
	public String getTenphong() {
		return tenphong;
	}
	public void setTenphong(String tenphong) {
		this.tenphong = tenphong;
	}
	public float getGiaphong() {
		return giaphong;
	}
	public void setGiaphong(float giaphong) {
		this.giaphong = giaphong;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public int getMaloai() {
		return maloai;
	}
	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}
	public Phong(int MaPhong, String TenPhong, float GiaPhong, String MoTa, int MaLoai) {
		super();
		this.maphong = MaPhong;
		this.tenphong = TenPhong;
		this.giaphong = GiaPhong;
		this.mota = MoTa;
		this.maloai = MaLoai;
	}
	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}