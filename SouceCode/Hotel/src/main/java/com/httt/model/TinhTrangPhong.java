package com.httt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TINHTRANGPHONG")
public class TinhTrangPhong {

	@Id
	@Column(name = "id", nullable = false)
    private int id;
	@Column(name = "phong", nullable = false)
    private int phong;
	
    @Column(name = "tinhtrang", nullable = false)
    private String tinhtrang;
    
    @Column(name = "ngay", nullable = false)
    private Date ngay;
    
    @Column(name = "ghichu", nullable = false)
    private String ghichu;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getPhong() {
		return phong;
	}

	public void setPhong(int phong) {
		this.phong = phong;
	}

	public String getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	
	public TinhTrangPhong(int id,int Phong, String TinhTrang, Date Ngay, String GhiChu) {
		super();
		this.id=id;
		this.phong = Phong;
		this.tinhtrang = TinhTrang;
		this.ngay = Ngay;
		this.ghichu = GhiChu;
	}
	
	public TinhTrangPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
    
   
}
