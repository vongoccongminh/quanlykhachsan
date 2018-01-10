package com.httt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Thongtinhuydp")
public class Thongtinhuydatphong implements Serializable{
private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "Madp", nullable = false)
    private int Madp;
    @Column(name = "Maphong", nullable = false)
    private int Maphong;
    @Column(name = "Ngayhuy", nullable = false)
    private Date Ngayhuy;
    @Column(name = "Nguyennhan", nullable = false)
    private String Nguyennhan;
    @Column(name = "Manv", nullable = false)
    private int Manv;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMadp() {
		return Madp;
	}
	public void setMadp(int madp) {
		Madp = madp;
	}
	public int getMaphong() {
		return Maphong;
	}
	public void setMaphong(int maphong) {
		Maphong = maphong;
	}
	public Date getNgayhuy() {
		return Ngayhuy;
	}
	public void setNgayhuy(Date ngayhuy) {
		Ngayhuy = ngayhuy;
	}
	public String getNguyennhan() {
		return Nguyennhan;
	}
	public void setNguyennhan(String nguyennhan) {
		Nguyennhan = nguyennhan;
	}
	public int getManv() {
		return Manv;
	}
	public void setManv(int manv) {
		Manv = manv;
	}
	public Thongtinhuydatphong(int id, int madp, int maphong, Date ngayhuy, String nguyennhan, int manv) {
		super();
		this.id = id;
		Madp = madp;
		Maphong = maphong;
		Ngayhuy = ngayhuy;
		Nguyennhan = nguyennhan;
		Manv = manv;
	}
	public Thongtinhuydatphong() {
		super();
		// TODO Auto-generated constructor stub
	}






}
