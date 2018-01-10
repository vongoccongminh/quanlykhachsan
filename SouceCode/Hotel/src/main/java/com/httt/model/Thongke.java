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
@Table(name = "thongke")
public class Thongke implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	
	@Column(name = "mathongke", nullable = false)
	private int mathongke;
	
	@Column(name = "ngaythuchientk")
	private Date ngaythuchientk;

	@Column(name = "noidungtk")
	private String noidungtk;
	
	@Column(name = "ngaybd")
	private Date ngaybd;
	
	@Column(name = "ngaykt")
	private Date ngaykt;
	
	@Column(name = "sotienchi")
	private float sotienchi;
	
	@Column(name = "sotienthu")
	private float sotienthu;
	
	@Column(name = "slphongduocthue")
	private int slphongduocthue;
	
	@Column(name = "slphongkhongduocthue")
	private int slphongkhongduocthue;
	
	@Column(name = "slphongtrong")
	private int slphongtrong;
	
	@Column(name = "slkhachhang")
	private int slkhachhang;
	
	@Column(name = "slkhachhangdp")
	private int slkhachhangdp;
	
	@Column(name = "loaitk")
	private int loaitk	;
	
	@Column(name = "manv")
	private int manv;


	public int getMathongke() {
		return mathongke;
	}

	public void setMathongke(int mathongke) {
		this.mathongke = mathongke;
	}

	public Date getNgaythuchientk() {
		return ngaythuchientk;
	}

	public void setNgaythuchientk(Date ngaythuchientk) {
		this.ngaythuchientk = ngaythuchientk;
	}

	public String getNoidungtk() {
		return noidungtk;
	}

	public void setNoidungtk(String noidungtk) {
		this.noidungtk = noidungtk;
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

	public float getSotienchi() {
		return sotienchi;
	}

	public void setSotienchi(float sotienchi) {
		this.sotienchi = sotienchi;
	}

	public float getSotienthu() {
		return sotienthu;
	}

	public void setSotienthu(float sotienthu) {
		this.sotienthu = sotienthu;
	}

	public int getSlphongduocthue() {
		return slphongduocthue;
	}

	public void setSlphongduocthue(int slphongduocthue) {
		this.slphongduocthue = slphongduocthue;
	}

	public int getSlphongkhongduocthue() {
		return slphongkhongduocthue;
	}

	public void setSlphongkhongduocthue(int slphongkhongduocthue) {
		this.slphongkhongduocthue = slphongkhongduocthue;
	}

	public int getSlphongtrong() {
		return slphongtrong;
	}

	public void setSlphongtrong(int slphongtrong) {
		this.slphongtrong = slphongtrong;
	}

	public int getSlkhachhang() {
		return slkhachhang;
	}

	public void setSlkhachhang(int slkhachhang) {
		this.slkhachhang = slkhachhang;
	}

	public int getSlkhachhangdp() {
		return slkhachhangdp;
	}

	public void setSlkhachhangdp(int slkhachhangdp) {
		this.slkhachhangdp = slkhachhangdp;
	}

	public int getLoaitk() {
		return loaitk;
	}

	public void setLoaitk(int loaitk) {
		this.loaitk = loaitk;
	}

	public int getManv() {
		return manv;
	}

	public void setManv(int manv) {
		this.manv = manv;
	}

	public Thongke(int mathongke, Date ngaythuchientk, String noidungtk, Date ngaybd, Date ngaykt,
			float sotienchi, float sotienthu, int slphongduocthue, int slphongkhongduocthue, int slphongtrong,
			int slkhachhang, int slkhachhangdp, int loaitk, int manv) {
		super();
		this.mathongke = mathongke;
		this.ngaythuchientk = ngaythuchientk;
		this.noidungtk = noidungtk;
		this.ngaybd = ngaybd;
		this.ngaykt = ngaykt;
		this.sotienchi = sotienchi;
		this.sotienthu = sotienthu;
		this.slphongduocthue = slphongduocthue;
		this.slphongkhongduocthue = slphongkhongduocthue;
		this.slphongtrong = slphongtrong;
		this.slkhachhang = slkhachhang;
		this.slkhachhangdp = slkhachhangdp;
		this.loaitk = loaitk;
		this.manv = manv;
	}

	public Thongke() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	
}