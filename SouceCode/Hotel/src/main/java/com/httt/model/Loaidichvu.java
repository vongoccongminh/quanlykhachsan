package com.httt.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "loaidichvu")
public class Loaidichvu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "maLDV", nullable= false)
	private int maLDV;
	
	@Column(name = "tenLDV", nullable= false)
	private String tenLDV;
	
	@Column(name = "moTa")
	private String moTa;
	
	public Loaidichvu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loaidichvu(int maLDV, String tenLDV, String moTa) {
		super();
		this.maLDV = maLDV;
		this.tenLDV = tenLDV;
		this.moTa = moTa;
	}

	public int getMaLDV() {
		return maLDV;
	}

	public void setMaLDV(int maLDV) {
		this.maLDV = maLDV;
	}

	public String getTenLDV() {
		return tenLDV;
	}

	public void setTenLDV(String tenLDV) {
		this.tenLDV = tenLDV;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}
