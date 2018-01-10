package com.httt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Chitietdp")
public class Chitietdp implements Serializable{
private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "MaDP", nullable = false)
    private int MaDP;
    @Column(name = "Maphong", nullable = false)
    private int Maphong;
    @Column(name = "Gia", nullable = false)
    private int Gia;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaDP() {
		return MaDP;
	}
	public void setMaDP(int maDP) {
		MaDP = maDP;
	}
	public int getMaphong() {
		return Maphong;
	}
	public void setMaphong(int maphong) {
		Maphong = maphong;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	public Chitietdp(int id, int maDP, int maphong, int gia) {
		super();
		this.id = id;
		MaDP = maDP;
		Maphong = maphong;
		Gia = gia;
	}
	public Chitietdp() {
		super();
		// TODO Auto-generated constructor stub
	}


}
