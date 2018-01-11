package com.httt.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "makh", nullable= false)
	private int makh;
	
	@Column(name = "tenkh", nullable= false)
	private String tenkh;
	
	@Column(name = "phai", nullable= false)
	private String phai;

	@Column(name = "cmnd", nullable= false)
	private String cmnd;

	@Column(name = "sdt", nullable= false)
	private String sdt;
	
	@Column(name = "diachi", nullable= false)
	private String diachi;
	
	@Column(name = "maloaikh", nullable= false)
	private int maloaikh;

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(int makh, String tenkh, String phai, String cmnd, String sdt, String diachi, int maloaikh) {
		super();
		this.makh = makh;
		this.tenkh = tenkh;
		this.phai = phai;
		this.cmnd = cmnd;
		this.sdt = sdt;
		this.diachi = diachi;
		this.maloaikh = maloaikh;
	}

	public int getMakh() {
		return makh;
	}

	public void setMakh(int makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getPhai() {
		return phai;
	}

	public void setPhai(String phai) {
		this.phai = phai;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public int getMaloaikh() {
		return maloaikh;
	}

	public void setMaloaikh(int maloaikh) {
		this.maloaikh = maloaikh;
	}
	
	
}
