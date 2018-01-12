package com.httt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "LOAIPHONG")
public class LoaiPhong implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "maloai", nullable = false)
    private int maloai;
    
    @Column(name = "tenloai", nullable = false)
    private String tenloai;

    
    @Column(name = "mota", nullable = false)
    private String mota;
    
    
    @Column(name = "Gia", nullable = false)
    private float Gia;
  

	public int getMaloai() {
		return maloai;
	}

	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public float getGia() {
		return Gia;
	}

	public void setGia(float gia) {
		Gia = gia;
	}

	public LoaiPhong(int MaLoai, String TenLoai, float GiaPhong, String MoTa) {
		super();
		this.maloai = MaLoai;
		this.tenloai = TenLoai;
		this.Gia = GiaPhong;
		this.mota = MoTa;
	}
	
	public LoaiPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}