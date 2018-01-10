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
@Table(name = "ttdatphong")
public class DatPhong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "madp", nullable = false)
	private int madp;
	
	@Column(name = "ngaydp")
	private Date ngaydp;
	
	@Column(name = "ngaybd")
	private Date ngaybd;

	@Column(name = "ngaykt")
	private Date ngaykt;

	@Column(name = "mota")
	private String mota;

	@Column(name = "manv")
	private int manv;

	@Column(name = "makh")
	private int makh;

	public int getMadp() {
		return madp;
	}

	public void setMadp(int madp) {
		this.madp = madp;
	}

	public Date getNgaydp() {
		return ngaydp;
	}

	public void setNgaydp(Date ngaydp) {
		this.ngaydp = ngaydp;
	}

	public Date getNgaybd() {
		return ngaybd;
	}

	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}

	public Date getNgaykt() {
		return ngaykt;
	}

	public void setNgaykt(Date ngaykt) {
		this.ngaykt = ngaykt;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public int getManv() {
		return manv;
	}

	public void setManv(int manv) {
		this.manv = manv;
	}

	public int getMakh() {
		return makh;
	}

	public void setMakh(int makh) {
		this.makh = makh;
	}

	public DatPhong(int madp, Date ngaydp, Date ngaybd, Date ngaykt, String mota, int manv, int makh) {
		super();
		this.madp = madp;
		this.ngaydp = ngaydp;
		this.ngaybd = ngaybd;
		this.ngaykt = ngaykt;
		this.mota = mota;
		this.manv = manv;
		this.makh = makh;
	}

	public DatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
		
}