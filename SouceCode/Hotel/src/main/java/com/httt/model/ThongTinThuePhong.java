package com.httt.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thongtinthuephong")
public class ThongTinThuePhong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "matp", nullable = false)
	private int matp;
	
	@Column(name = "madp", nullable = false)
	private int madp;
	
	@Column(name = "giathuephong")
	private int GiaThuePhong;

	@Column(name = "giaytotamgiu")
	private String GiayToTamGiu;

	public int getMatp() {
		return matp;
	}

	public void setMatp(int matp) {
		this.matp = matp;
	}

	public int getMadp() {
		return madp;
	}

	public void setMadp(int madp) {
		this.madp = madp;
	}

	public int getGiaThuePhong() {
		return GiaThuePhong;
	}

	public void setGiaThuePhong(int giaThuePhong) {
		this.GiaThuePhong = giaThuePhong;
	}

	public String getGiayToTamGiu() {
		return GiayToTamGiu;
	}

	public void setGiayToTamGiu(String giayToTamGiu) {
		this.GiayToTamGiu = giayToTamGiu;
	}

	public ThongTinThuePhong(int matp, int madp, int giaThuePhong, String giayToTamGiu) {
		super();
		this.matp = matp;
		this.madp = madp;
		this.GiaThuePhong = giaThuePhong;
		this.GiayToTamGiu = giayToTamGiu;
	}

	public ThongTinThuePhong() {
		super();
		// TODO Auto-generated constructor stub
	}
}
	
	
	