package com.httt.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaikhachhang")
public class LoaiKhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "maloaikh", nullable= false)
	private int maloaikh;
	
	@Column(name = "tenloaikh", nullable= false)
	private String tenloaikh;
	
	@Column(name = "mota", nullable= false)
	private String mota;

	public LoaiKhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiKhachHang(int maloaikh, String tenloaikh, String mota) {
		super();
		this.maloaikh = maloaikh;
		this.tenloaikh = tenloaikh;
		this.mota = mota;
	}

	public int getMaloaikh() {
		return maloaikh;
	}

	public void setMaloaikh(int maloaikh) {
		this.maloaikh = maloaikh;
	}

	public String getTenloaikh() {
		return tenloaikh;
	}

	public void setTenloaikh(String tenloaikh) {
		this.tenloaikh = tenloaikh;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	
}
