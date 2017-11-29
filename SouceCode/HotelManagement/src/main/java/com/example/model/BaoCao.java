package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BAOCAO")
public class BaoCao {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MaBaoCao", nullable = false)
	private int MaBaoCao;
	
	@Column(name="TenBaoCao", nullable = false)
	private String TenBaoCao;
	
	@Column(name="LoaiBaoCao", nullable = false)
	private int LoaiBaoCao;
	
	@Column(name="NguoiLap", nullable = false)
	private int NguoiLap;
	
	@Column(name="NgayLap", nullable = false)
	private String NgayLap;
	
	@Column(name="NoiDung", nullable = false)
	private String NoiDung;
	
	@Column(name="GhiChu", nullable = false)
	private String GhiChu;
	
	
	public BaoCao(int maBaoCao, String tenBaoCao, int loaiBaoCao, int nguoiLap, String ngayLap, String noiDung,
			String ghiChu) {
		super();
		MaBaoCao = maBaoCao;
		TenBaoCao = tenBaoCao;
		LoaiBaoCao = loaiBaoCao;
		NguoiLap = nguoiLap;
		NgayLap = ngayLap;
		NoiDung = noiDung;
		GhiChu = ghiChu;
	}
	
	
	public BaoCao() {
		super();
	}


	public int getMaBaoCao() {
		return MaBaoCao;
	}
	public void setMaBaoCao(int maBaoCao) {
		MaBaoCao = maBaoCao;
	}
	public String getTenBaoCao() {
		return TenBaoCao;
	}
	public void setTenBaoCao(String tenBaoCao) {
		TenBaoCao = tenBaoCao;
	}
	public int getLoaiBaoCao() {
		return LoaiBaoCao;
	}
	public void setLoaiBaoCao(int loaiBaoCao) {
		LoaiBaoCao = loaiBaoCao;
	}
	public int getNguoiLap() {
		return NguoiLap;
	}
	public void setNguoiLap(int nguoiLap) {
		NguoiLap = nguoiLap;
	}
	public String getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(String ngayLap) {
		NgayLap = ngayLap;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
	
}
