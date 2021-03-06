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

CREATE TABLE dichvu 
(
	maDV INT  NOT NULL auto_increment PRIMARY KEY,
	tenDV nvarchar ( 50 ) NOT NULL,
	loaiDV INT NOT NULL,
	moTa nvarchar ( 50 ),
	donGia INT 
);

CREATE TABLE loaidichvu 
(
	maLDV INT NOT NULL auto_increment PRIMARY KEY,
	tenLDV nvarchar(50) NOT NULL,
	moTa nvarchar (50)
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

CREATE TABLE THONGTINTHUEPHONG(
	matp int(10) not null auto_increment PRIMARY key,
	madp int,
	giathuephong int,
	giaytotamgiu  nvarchar(100)
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


CREATE TABLE thongtintraphong
(
	matp int not null AUTO_INCREMENT,
        mathuephong int,
	makh int,
	thoigiantraphong datetime,
	chiphiphatsinh float,
	mota nvarchar(50),
	tongien float,
	PRIMARY KEY(matp)
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
	MaLoaiKH int auto_increment,
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
	SoTienChi1 FLOAT,
	SoTienChi2 FLOAT,
	SoTienThu1 float,
	SoTienThu2 float,
	SLPhongDuocThue1 int,
	SLPhongDuocThue2 int,
	SLPhongKhongDuocThue1 int,
	SLPhongKhongDuocThue2 int,
	SLPhongTrong1 int,
	SLPhongTrong2 int,
	SLKhachHang1 int,
	SLKhachHang2 int,
	SLPhongDuocDat1 int,
	SLPhongDuocDat2 int,
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
	TenPhong        nvarchar(50),
	GiaPhong	float,
	MoTa		nvarchar(50),
	MaLoai		int,
	PRIMARY KEY(MaPhong)
-- 	--CONSTRAINT FK_PHONG FOREIGN KEY (MaLoai) REFERENCES LOAIPHONG(MaLoai)
);



CREATE TABLE THIETBI
(
	MaTB				int auto_increment,
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
	MaLoai				int auto_increment,
	TenLoai				nvarchar(50),
	HangSX				nvarchar(50),
	DichVuBaoTri		nvarchar(100),
	GhiChu				nvarchar(100),
	NienHan				int,
	TinhTrang			nvarchar(20),
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

create table thongtindatphong
(
madp int AUTO_INCREMENT PRIMARY KEY,
ngaydp datetime,
ngaybd datetime,
ngaykt datetime,
mota nvarchar(100),
manv int,
makh int
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
id int AUTO_INCREMENT PRIMARY KEY,
Phong int,
TinhTrang nvarchar(20),
Ngay date,
GhiChu nvarchar(50)
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

ALTER TABLE dichvu
ADD CONSTRAINT DichVu_LoaiDV
FOREIGN KEY (loaiDV)
REFERENCES loaidichvu(maLDV);

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
REFERENCES thongtindatphong(madp);

ALTER TABLE CHITIETKYGUIHANHLY
ADD CONSTRAINT CTKyGuiHL_MaTP
FOREIGN KEY (MaTP)
REFERENCES ThongTinThuePhong(MaTP);

ALTER TABLE thongtintraphong
ADD CONSTRAINT TTTraPhong_MaTP
FOREIGN KEY (mathuephong)
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

ALTER TABLE LICHSUSUACHUA
ADD CONSTRAINT FK_LICHSUSUACHUA_THIETBI
FOREIGN KEY (MaTB)
REFERENCES THIETBI(MaTB);

ALTER TABLE THONGTINHUYDATPHONG
ADD CONSTRAINT FK_THONGTINHUYDATPHONG_THONGTINDATPHONG
FOREIGN KEY (MaDP)
REFERENCES thongtindatphong(madp);

ALTER TABLE THONGTINHUYDATPHONG
ADD CONSTRAINT FK_THONGTINHUYDATPHONG_NHANVIEN
FOREIGN KEY (MaNV)
REFERENCES NHANVIEN(MaNV);

ALTER TABLE thongtindatphong
ADD CONSTRAINT FK_THONGTINDATPHONG_NHANVIEN
FOREIGN KEY (manv)
REFERENCES NHANVIEN(MaNV);

ALTER TABLE thongtindatphong
ADD CONSTRAINT FK_THONGTINDATPHONG_KHACHHANG
FOREIGN KEY (makh)
REFERENCES KHACHHANG(MaKH);

ALTER TABLE CHITIETDP
ADD CONSTRAINT FK_CHITIETDP_THONGTINDATPHONG
FOREIGN KEY (MaDP)
REFERENCES thongtindatphong(madp);

ALTER TABLE CHITIETDP
ADD CONSTRAINT FK_CHITIETDP_LOAIPHONG
FOREIGN KEY (LoaiPhong)
REFERENCES LOAIPHONG(MaLoai);

ALTER TABLE TINHTRANGPHONG
ADD CONSTRAINT FK_CHITIETDP_PHONG
FOREIGN KEY (Phong)
REFERENCES PHONG(MaPhong);
