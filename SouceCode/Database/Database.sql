create database hotel;
use hotel;

CREATE TABLE BAOCAO (
	MaBaoCao int,
	TenBaoCao nvarchar(30),
	LoaiBaoCao int,
	NguoiLap int,
	NgayLap date,
	NoiDung nvarchar(100),
	GhiChu nvarchar(50),
	PRIMARY KEY(MaBaoCao)
);

CREATE TABLE LOAIBAOCAO
(
	MaLoaiBaoCao int,
	TenLoaiBaoCao nvarchar(30),
	MoTa nvarchar(30),
	PRIMARY KEY(MaLoaiBaoCao)
);

CREATE TABLE DICHVU
(
	MaDV int,
	TenDV nvarchar(50),
	MoTa nvarchar(50),
	DonGia float,
	LoaiDV int,
	PRIMARY KEY(MaDV)
);

CREATE TABLE LOAIDICHVU
(
	MaLoaiDV int,
	TenLoaiDV nvarchar(20),
	MoTa nvarchar(50),
	PRIMARY KEY(MaLoaiDV)
);

CREATE TABLE CHITIETTHUEDICHVU
(
	MaTP int,
	MaDV int,
	Gia float,
	SL int,
	ThanhTien float,
	primary key (MaTP, MaDV)
);

CREATE TABLE THONGTINTHUEPHONG
(
	MaTP int,
	MaDP int,
	GiaThuePhong float,
	GiayToTamGiu  nvarchar(100),
	PRIMARY KEY(MaTP)
);

CREATE TABLE CHITIETKYGUIHANHLY
(
	MaTP int,
	GiaTri float,
	KhoiLuongHanhLy int,
	LoaiHanhLy nvarchar(50),
	TinhTrang nvarchar(50),
	KichThuocDxRxC nvarchar(50),
	PRIMARY KEY(MaTP)
);


CREATE TABLE THONGTINTRAPHONG 
(
	MaTP int,
	ThoiGianTraPhong datetime,
	ChiPhiPhatSinh float,
	ThongTinGhiChu nvarchar(100),
	TongTien float,
	PRIMARY KEY(MaTP)
);

CREATE TABLE NHANVIEN
(
	MaNV int,
	TenNV nvarchar(30),
	NTNS date,
	DiaChi nvarchar(100),
	SDT char(15),
	CMND char(15),
	Luong float,
	MaBP int,
	Username nvarchar(20),
	Passwords nvarchar(20),
	TrangThai char(5),
	PRIMARY KEY(MaNV)
);

CREATE TABLE BOPHAN
(
	MaBP int ,
	TenBP nvarchar(30),
	NguoiQuanLy int,
	SoLuongNV int,
	ThongTinBP nvarchar(100),
	PRIMARY KEY(MaBP)
);

CREATE TABLE CONGVIEC
(
	MaCV int,
	TenCV nvarchar(50),
	NgayBD datetime,
	NgayKT datetime,
	TongChiPhi float,
	PRIMARY KEY(MaCV)
);

CREATE TABLE PHANCONG
(
	MaNV int,
	MaCV int,
	ChiTietCongViec nvarchar(50),
	DanhGia nvarchar(50),
	PhuCap float,
	primary key (MaNV, MaCV)
);

CREATE TABLE KHACHHANG
(
	MaKH int auto_increment,
	TenKH nvarchar(50),
	Phai nvarchar(10),
	CMND nvarchar(20),
	SDT char(15),
	DiaChi nvarchar(50),
	MaLoaiKH int, 
	PRIMARY KEY(MaKH),
	UNIQUE (CMND)
);

CREATE TABLE LOAIKHACHHANG
(
	MaLoaiKH int,
	TenLoaiKH nvarchar(50),
	MoTa nvarchar(100),
	PRIMARY KEY(MaLoaiKH)
);

CREATE TABLE THONGKE
(
	MaThongKe int,
	NgayThucHienTK datetime,
	NoiDungTK nvarchar(100),
	NgayBD datetime,
	NgayKT datetime,
	SoTienChi FLOAT,
	SoTienThu float,
	SLPhongDuocThue int,
	SLPhongKhongDuocThue int,
	SLPhongTrong int,
	SLKhachHang int,
	SLKhachHangDP int,
	LoaiTK int,
	MaNV int,
	PRIMARY KEY (MaThongKe)
);

CREATE TABLE LOAITHONGKE
(
	MaLoaiTK	int,
	TenLoaiTK	nvarchar(50),
	GhiChu		nvarchar(100),
	PRIMARY KEY(MaLoaiTK)
);

CREATE TABLE LOAIPHONG
(
	MaLoai		int,
	TenLoai		nvarchar(50),
	MoTa		nvarchar(50),
	Gia			float,
	PRIMARY KEY(MaLoai)
);

CREATE TABLE PHONG
(
	MaPhong		int,
	GiaPhong	float,
	MoTa		nvarchar(50),
	MaLoai		int,
	PRIMARY KEY(MaPhong)
-- 	--CONSTRAINT FK_PHONG FOREIGN KEY (MaLoai) REFERENCES LOAIPHONG(MaLoai)
);



CREATE TABLE THIETBI
(
	MaTB				int,
	TenTB				nvarchar(50),
	SoSeri				nvarchar(50),
	NgayNhap			datetime,
	NgayHetBaoHanh		datetime,
	NienHan				int,
	TinhTrang			nvarchar(20),
	SuDungTrongPhong	int,
	NhanVienQuanLy		int,
	LoaiTB				int,
	PRIMARY KEY(MaTB)
-- 	--CONSTRAINT FK_THIETBI1 FOREIGN KEY SuDungTrongPhong REFERENCES PHONG(MaPhong),
-- 	--CONSTRAINT FK_THIETBI2 FOREIGN KEY NhanVienQuanLy REFERENCES NHANVIEN(MaNV),
-- 	--CONSTRAINT FK_THIETBI3 FOREIGN KEY LoaiTB REFERENCES LOAITHIETBI(MaLoai)
);

CREATE TABLE LOAITHIETBI
(
	MaLoai				int,
	TenLoai				nvarchar(50),
	HangSX				nvarchar(50),
	DichVuBaoTri		nvarchar(100),
	GhiChu				nvarchar(100),
	NienHan				int,
	TinhTrang			nvarchar(20),
	SuDungTrongPhong	int,
	PRIMARY KEY(MaLoai)
-- 	--CONSTRAINT FK_LOAITHIETBI1 FOREIGN KEY SuDungTrongPhong REFERENCES PHONG(MaPhong)
);

create table LICHSUSUACHUA
(
	NgaySuaChua datetime ,
	MaTB int,
	LyDoSuaChua nvarchar(50),
	ChiPhi float,
	HanBaoHanhSuaDen datetime,
	ThongTinSua nvarchar(100),
	primary key (NgaySuaChua, MaTB)
);

create table THONGTINHUYDATPHONG
(
	MaHuyDP int ,
	NgayHuy datetime,
	MaDP int,
	NguyenNhan nvarchar(100),
	GhiChu nvarchar(50),
	MaNV int,
	PRIMARY KEY (MaHuyDP)
);

create table THONGTINDATPHONG
(
MaDP int,
NgayDP datetime,
NgayBD datetime,
NgayKT datetime,
MoTa nvarchar(100),
MaNV int,
MaKH int,
PRIMARY key (MaDP)
);

create table CHITIETDP
(
MaDP int ,
LoaiPhong int,
Gia float,
SL int,
ThanhTien float,
primary key (MaDP, LoaiPhong)
);

create table TINHTRANGPHONG
(
Phong int,
TinhTrang nvarchar(20),
Ngay date,
GhiChu nvarchar(50),
primary key (Phong, Ngay)
);

-- Tao khoa ngoai

ALTER TABLE BAOCAO
ADD CONSTRAINT BaoCao_MaLoaiBaoCao
FOREIGN KEY (LoaiBaoCao)
REFERENCES LOAIBAOCAO(MaLoaiBaoCao);

ALTER TABLE BAOCAO
ADD CONSTRAINT BaoCao_MaNhanVien
FOREIGN KEY (NguoiLap)
REFERENCES NhanVien(MaNV);

ALTER TABLE DICHVU
ADD CONSTRAINT DichVu_LoaiDV
FOREIGN KEY (LoaiDV)
REFERENCES LoaiDichVu(MaLoaiDV);

ALTER TABLE CHITIETTHUEDICHVU
ADD CONSTRAINT CTThueDV_MaTP
FOREIGN KEY (MaTP)
REFERENCES  ThongTinThuePhong(MaTP);


ALTER TABLE CHITIETTHUEDICHVU
ADD CONSTRAINT CTThueDV_MaDV
FOREIGN KEY (MaDV)
REFERENCES DichVu(MaDV);

ALTER TABLE ThongTinThuePhong
ADD CONSTRAINT TTThuePhong_MaDP 
FOREIGN KEY (MaDP)
REFERENCES ThongTinDatPhong(MaDP);

ALTER TABLE CHITIETKYGUIHANHLY
ADD CONSTRAINT CTKyGuiHL_MaTP
FOREIGN KEY (MaTP)
REFERENCES ThongTinThuePhong(MaTP);

ALTER TABLE THONGTINTRAPHONG
ADD CONSTRAINT TTTraPhong_MaTP
FOREIGN KEY (MaTP)
REFERENCES ThongTinThuePhong(MaTP);

ALTER TABLE NHANVIEN
ADD CONSTRAINT NhanVien_MaBP
FOREIGN KEY (MaBP)
REFERENCES BoPhan(MaBP);

ALTER TABLE BOPHAN 
ADD CONSTRAINT BoPhan_NguoiQuanLi
FOREIGN KEY (NguoiQuanLy)
REFERENCES NhanVien(MaNV);

ALTER TABLE PHANCONG
ADD CONSTRAINT PhanCong_MaNV
FOREIGN KEY (MaNV)
REFERENCES NhanVien(MaNV);

ALTER TABLE PHANCONG
ADD CONSTRAINT PhanCong_MaCV
FOREIGN KEY (MaCV)
REFERENCES CongViec(MaCV);

ALTER TABLE KHACHHANG
ADD CONSTRAINT KhachHang_MaLoaiKH
FOREIGN KEY (MaLoaiKH)
REFERENCES LoaiKhachHang(MaLoaiKH);

ALTER TABLE THONGKE
ADD CONSTRAINT ThongKe_LoaiTK
FOREIGN KEY (LoaiTK)
REFERENCES LoaiThongKe(MaLoaiTK);

ALTER TABLE THONGKE
ADD CONSTRAINT ThongKe_MaNV
FOREIGN KEY (MaNV)
REFERENCES NhanVien(MaNV);

ALTER TABLE PHONG 
ADD CONSTRAINT FK_PHONG 
FOREIGN KEY (MaLoai) 
REFERENCES LOAIPHONG(MaLoai);

ALTER TABLE THIETBI 
ADD CONSTRAINT FK_THIETBI1 
FOREIGN KEY (SuDungTrongPhong) 
REFERENCES PHONG(MaPhong);

ALTER TABLE THIETBI 
ADD CONSTRAINT FK_THIETBI2 
FOREIGN KEY (NhanVienQuanLy) 
REFERENCES NHANVIEN(MaNV);

ALTER TABLE THIETBI 
ADD CONSTRAINT FK_THIETBI3 
FOREIGN KEY (LoaiTB) 
REFERENCES LOAITHIETBI(MaLoai);

ALTER TABLE LOAITHIETBI 
ADD CONSTRAINT FK_LOAITHIETBI1 
FOREIGN KEY (SuDungTrongPhong) 
REFERENCES PHONG(MaPhong);

ALTER TABLE LICHSUSUACHUA
ADD CONSTRAINT FK_LICHSUSUACHUA_THIETBI
FOREIGN KEY (MaTB)
REFERENCES THIETBI(MaTB);

ALTER TABLE THONGTINHUYDATPHONG
ADD CONSTRAINT FK_THONGTINHUYDATPHONG_THONGTINDATPHONG
FOREIGN KEY (MaDP)
REFERENCES THONGTINDATPHONG(MaDP);

ALTER TABLE THONGTINHUYDATPHONG
ADD CONSTRAINT FK_THONGTINHUYDATPHONG_NHANVIEN
FOREIGN KEY (MaNV)
REFERENCES NHANVIEN(MaNV);

ALTER TABLE THONGTINDATPHONG
ADD CONSTRAINT FK_THONGTINDATPHONG_NHANVIEN
FOREIGN KEY (MaNV)
REFERENCES NHANVIEN(MaNV);

ALTER TABLE THONGTINDATPHONG
ADD CONSTRAINT FK_THONGTINDATPHONG_KHACHHANG
FOREIGN KEY (MaKH)
REFERENCES KHACHHANG(MaKH);

ALTER TABLE CHITIETDP
ADD CONSTRAINT FK_CHITIETDP_THONGTINDATPHONG
FOREIGN KEY (MaDP)
REFERENCES THONGTINDATPHONG(MaDP);

ALTER TABLE CHITIETDP
ADD CONSTRAINT FK_CHITIETDP_LOAIPHONG
FOREIGN KEY (LoaiPhong)
REFERENCES LOAIPHONG(MaLoai);

ALTER TABLE TINHTRANGPHONG
ADD CONSTRAINT FK_CHITIETDP_PHONG
FOREIGN KEY (Phong)
REFERENCES PHONG(MaPhong);
