package com.httt.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "thietbi")
public class ThietBi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "matb")
	private int matb;
	
	public int getMatb() {
		return matb;
	}

	public void setMatb(int matb) {
		this.matb = matb;
	}

	public String getTentb() {
		return tentb;
	}

	public void setTentb(String tentb) {
		this.tentb = tentb;
	}

	public String getSoseri() {
		return soseri;
	}

	public void setSoseri(String soseri) {
		this.soseri = soseri;
	}

	public Date getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

	public Date getNgayhetbaohanh() {
		return ngayhetbaohanh;
	}

	public void setNgayhetbaohanh(Date ngayhetbaohanh) {
		this.ngayhetbaohanh = ngayhetbaohanh;
	}

	public int getNienhan() {
		return nienhan;
	}

	public void setNienhan(int nienhan) {
		this.nienhan = nienhan;
	}

	public String getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public int getSudungtrongphong() {
		return sudungtrongphong;
	}

	public void setSudungtrongphong(int sudungtrongphong) {
		this.sudungtrongphong = sudungtrongphong;
	}

	public int getNhanvienquanly() {
		return nhanvienquanly;
	}

	public void setNhanvienquanly(int nhanvienquanly) {
		this.nhanvienquanly = nhanvienquanly;
	}

	public int getLoaitb() {
		return loaitb;
	}

	public void setLoaitb(int loaitb) {
		this.loaitb = loaitb;
	}

	public ThietBi(int matb, String tentb, String soseri, Date ngaynhap, Date ngayhetbaohanh, int nienhan,
			String tinhtrang, int sudungtrongphong, int nhanvienquanly, int loaitb) {
		super();
		this.matb = matb;
		this.tentb = tentb;
		this.soseri = soseri;
		this.ngaynhap = ngaynhap;
		this.ngayhetbaohanh = ngayhetbaohanh;
		this.nienhan = nienhan;
		this.tinhtrang = tinhtrang;
		this.sudungtrongphong = sudungtrongphong;
		this.nhanvienquanly = nhanvienquanly;
		this.loaitb = loaitb;
	}

	public ThietBi() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "tentb")
	private String tentb;
	
	@Column(name = "soseri")
	private String soseri;

	@Column(name = "ngaynhap")
	private Date ngaynhap;

	@Column(name = "ngayhetbaohanh")
	private Date ngayhetbaohanh;
	
	@Column(name = "nienhan")
	private int nienhan;
	
	@Column(name = "tinhtrang")
	private String tinhtrang;
	
	@Column(name = "sudungtrongphong")
	private int sudungtrongphong;
	
	@Column(name = "nhanvienquanly")
	private int nhanvienquanly;
	
	@Column(name = "loaitb")
	private int loaitb;
	
	
}
