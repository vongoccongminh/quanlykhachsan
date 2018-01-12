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
	
	@Column(name = "sotienchi1")
	private float sotienchi1;
	
	@Column(name = "sotienchi2")
	private float sotienchi2;
	
	@Column(name = "sotienthu1")
	private float sotienthu1;
	
	@Column(name = "sotienthu2")
	private float sotienthu2;
	
	@Column(name = "slphongduocthue1")
	private int slphongduocthue1;
	
	@Column(name = "slphongduocthue2")
	private int slphongduocthue2;
	
	@Column(name = "slphongkhongduocthue1")
	private int slphongkhongduocthue1;
	
	@Column(name = "slphongkhongduocthue2")
	private int slphongkhongduocthue2;
	
	@Column(name = "slphongtrong1")
	private int slphongtrong1;
	
	@Column(name = "slphongtrong2")
	private int slphongtrong2;
	
	@Column(name = "slphongduocdat1")
	private int slphongduocdat1;
	
	@Column(name = "slphongduocdat2")
	private int slphongduocdat2;
	
	@Column(name = "slkhachhang1")
	private int slkhachhang1;
	
	@Column(name = "slkhachhang2")
	private int slkhachhang2;
		
	@Column(name = "loaitk")
	private int loaitk	;
	
	@Column(name = "manv")
	private int manv;






	public Thongke(int mathongke, Date ngaythuchientk, String noidungtk, Date ngaybd, Date ngaykt, float sotienchi1,
			float sotienchi2, float sotienthu1, float sotienthu2, int slphongduocthue1, int slphongduocthue2,
			int slphongkhongduocthue1, int slphongkhongduocthue2, int slphongtrong1, int slphongtrong2,
			int slphongduocdat1, int slphongduocdat2, int slkhachhang1, int slkhachhang2, int loaitk, int manv) {
		super();
		this.mathongke = mathongke;
		this.ngaythuchientk = ngaythuchientk;
		this.noidungtk = noidungtk;
		this.ngaybd = ngaybd;
		this.ngaykt = ngaykt;
		this.sotienchi1 = sotienchi1;
		this.sotienchi2 = sotienchi2;
		this.sotienthu1 = sotienthu1;
		this.sotienthu2 = sotienthu2;
		this.slphongduocthue1 = slphongduocthue1;
		this.slphongduocthue2 = slphongduocthue2;
		this.slphongkhongduocthue1 = slphongkhongduocthue1;
		this.slphongkhongduocthue2 = slphongkhongduocthue2;
		this.slphongtrong1 = slphongtrong1;
		this.slphongtrong2 = slphongtrong2;
		this.slphongduocdat1 = slphongduocdat1;
		this.slphongduocdat2 = slphongduocdat2;
		this.slkhachhang1 = slkhachhang1;
		this.slkhachhang2 = slkhachhang2;
		this.loaitk = loaitk;
		this.manv = manv;
	}




	public int getSlphongduocdat1() {
		return slphongduocdat1;
	}




	public void setSlphongduocdat1(int slphongduocdat1) {
		this.slphongduocdat1 = slphongduocdat1;
	}




	public int getSlphongduocdat2() {
		return slphongduocdat2;
	}




	public void setSlphongduocdat2(int slphongduocdat2) {
		this.slphongduocdat2 = slphongduocdat2;
	}




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




	public float getSotienchi1() {
		return sotienchi1;
	}




	public void setSotienchi1(float sotienchi1) {
		this.sotienchi1 = sotienchi1;
	}




	public float getSotienchi2() {
		return sotienchi2;
	}




	public void setSotienchi2(float sotienchi2) {
		this.sotienchi2 = sotienchi2;
	}




	public float getSotienthu1() {
		return sotienthu1;
	}




	public void setSotienthu1(float sotienthu1) {
		this.sotienthu1 = sotienthu1;
	}




	public float getSotienthu2() {
		return sotienthu2;
	}




	public void setSotienthu2(float sotienthu2) {
		this.sotienthu2 = sotienthu2;
	}




	public int getSlphongduocthue1() {
		return slphongduocthue1;
	}




	public void setSlphongduocthue1(int slphongduocthue1) {
		this.slphongduocthue1 = slphongduocthue1;
	}




	public int getSlphongduocthue2() {
		return slphongduocthue2;
	}




	public void setSlphongduocthue2(int slphongduocthue2) {
		this.slphongduocthue2 = slphongduocthue2;
	}




	public int getSlphongkhongduocthue1() {
		return slphongkhongduocthue1;
	}




	public void setSlphongkhongduocthue1(int slphongkhongduocthue1) {
		this.slphongkhongduocthue1 = slphongkhongduocthue1;
	}




	public int getSlphongkhongduocthue2() {
		return slphongkhongduocthue2;
	}




	public void setSlphongkhongduocthue2(int slphongkhongduocthue2) {
		this.slphongkhongduocthue2 = slphongkhongduocthue2;
	}




	public int getSlphongtrong1() {
		return slphongtrong1;
	}




	public void setSlphongtrong1(int slphongtrong1) {
		this.slphongtrong1 = slphongtrong1;
	}




	public int getSlphongtrong2() {
		return slphongtrong2;
	}




	public void setSlphongtrong2(int slphongtrong2) {
		this.slphongtrong2 = slphongtrong2;
	}




	public int getSlkhachhang1() {
		return slkhachhang1;
	}




	public void setSlkhachhang1(int slkhachhang1) {
		this.slkhachhang1 = slkhachhang1;
	}




	public int getSlkhachhang2() {
		return slkhachhang2;
	}




	public void setSlkhachhang2(int slkhachhang2) {
		this.slkhachhang2 = slkhachhang2;
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




	public Thongke() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	
}