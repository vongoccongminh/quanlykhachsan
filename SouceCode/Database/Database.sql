CREATE DATABASE QLKhachSan

GO
USE QLKhachSan
GO

CREATE TABLE BAOCAO (
	MaBaoCao int primary key,
	TenBaoCao nvarchar(30),
	LoaiBaoCao int,
	NguoiLap int,
	NgayLap date,
	NoiDung nvarchar(100),
	GhiChu nvarchar(50)
)

select * from QLKhachSan.BAOCAO





CREATE TABLE LOAIBAOCAO
(
	MaLoaiBaoCao int primary key,
	TenLoaiBaoCao nvarchar(30),
	MoTa nvarchar(30)
)

CREATE TABLE DICHVU
(
	MaDV int primary key,
	TenDV nvarchar(50),
	MoTa nvarchar(50),
	DonGia money,
	LoaiDV int
)

CREATE TABLE LOAIDICHVU
(
	MaLoaiDV int primary key,
	TenLoaiDV nvarchar(20),
	MoTa nvarchar(50)
)

CREATE TABLE CHITIETTHUEDICHVU
(
	MaTP int,
	MaDV int,
	Gia money,
	SL int,
	ThanhTien money
	primary key (MaTP, MaDV)
)

CREATE TABLE THONGTINTHUEPHONG
(
	MaTP int primary key,
	MaDP int,
	GiaThuePhong money,
	GiayToTamGiu  nvarchar(100)
)

CREATE TABLE CHITIETKYGUIHANHLY
(
	MaTP int primary key,
	GiaTri money,
	KhoiLuongHanhLy int,
	LoaiHanhLy nvarchar(50),
	TinhTrang nvarchar(50),
	KichThuocDxRxC nvarchar(50)
)


CREATE TABLE THONGTINTRAPHONG 
(
	MaTP int primary key,
	ThoiGianTraPhong datetime,
	ChiPhiPhatSinh money,
	ThongTinGhiChu nvarchar(100),
	TongTien money
)

CREATE TABLE NHANVIEN
(
	MaNV int primary key,
	TenNV nvarchar(30),
	NTNS date,
	DiaChi nvarchar(100),
	SDT char(15),
	CMND char(15),
	Luong money,
	MaBP int,
	Username nvarchar(20),
	Passwords nvarchar(20),
	TrangThai bit
)

CREATE TABLE BOPHAN
(
	MaBP int primary key,
	TenBP nvarchar(30),
	NguoiQuanLy int,
	SoLuongNV int,
	ThongTinBP nvarchar(100)
)

CREATE TABLE CONGVIEC
(
	MaCV int primary key,
	TenCV nvarchar(50),
	NgayBD datetime,
	NgayKT datetime,
	TongChiPhi money
)

CREATE TABLE PHANCONG
(
	MaNV int,
	MaCV int,
	ChiTietCongViec nvarchar(50),
	DanhGia nvarchar(50),
	PhuCap money,
	primary key (MaNV, MaCV)
)

CREATE TABLE KHACHHANG
(
	MaKH int primary key,
	TenKH nvarchar(50),
	Phai nvarchar(10),
	CMND_Passport nvarchar(20),
	SDT char(15),
	DiaChi nvarchar(50),
	MaLoaiKH int
)

CREATE TABLE LOAIKHACHHANG
(
	MaLoaiKH int primary key,
	TenLoaiKH nvarchar(50),
	MoTa nvarchar(100)
)

CREATE TABLE THONGKE
(
	MaThongKe int primary key,
	NgayThucHienTK datetime,
	NoiDungTK nvarchar(100),
	NgayBD datetime,
	NgayKT datetime,
	SoTienChi money,
	SoTienThu money,
	SLPhongDuocThue int,
	SLPhongKhongDuocThue int,
	SLPhongTrong int,
	SLKhachHang int,
	SLKhachHangDP int,
	LoaiTK int,
	MaNV int
)


GO
CREATE TABLE LOAITHONGKE
(
	MaLoaiTK	int,
	TenLoaiTK	nvarchar(50),
	GhiChu		nvarchar(100),
	PRIMARY KEY(MaLoaiTK)
);
GO
CREATE TABLE PHONG
(
	MaPhong		int,
	GiaPhong	money,
	MoTa		nvarchar(50),
	MaLoai		int,
	PRIMARY KEY(MaPhong),
	--CONSTRAINT FK_PHONG FOREIGN KEY (MaLoai) REFERENCES LOAIPHONG(MaLoai)
);
GO
CREATE TABLE LOAIPHONG
(
	MaLoai		int,
	TenLoai		nvarchar(50),
	MoTa		nvarchar(50),
	Gia			money,
	PRIMARY KEY(MaLoai)
);
GO
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
	PRIMARY KEY(MaTB),
	--CONSTRAINT FK_THIETBI1 FOREIGN KEY SuDungTrongPhong REFERENCES PHONG(MaPhong),
	--CONSTRAINT FK_THIETBI2 FOREIGN KEY NhanVienQuanLy REFERENCES NHANVIEN(MaNV),
	--CONSTRAINT FK_THIETBI3 FOREIGN KEY LoaiTB REFERENCES LOAITHIETBI(MaLoai)
);
GO
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
	PRIMARY KEY(MaLoai),
	--CONSTRAINT FK_LOAITHIETBI1 FOREIGN KEY SuDungTrongPhong REFERENCES PHONG(MaPhong)
);

create table LICHSUSUACHUA
(
	NgaySuaChua datetime ,
	MaTB int,
	LyDoSuaChua nvarchar(50),
	ChiPhi money,
	HanBaoHanhSuaDen datetime,
	ThongTinSua nvarchar(100),
	primary key (NgaySuaChua, MaTB)
);
create table THONGTINHUYDATPHONG
(
MaHuyDP int primary key,
NgayHuy datetime,
MaDP int,
NguyenNhan nvarchar(100),
GhiChu nvarchar(50),
MaNV int
);
create table THONGTINDATPHONG
(
MaDP int primary key,
NgayDP datetime,
NgayBD datetime,
NgayKT datetime,
MoTa nvarchar(100),
MaNV int,
MaKH int
);
create table CHITIETDP
(
MaDP int ,
LoaiPhong int,
Gia money,
SL int,
ThanhTien money,
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

--Tao khoa ngoai

ALTER TABLE BAOCAO
ADD CONSTRAINT BaoCao_MaLoaiBaoCao
FOREIGN KEY (LoaiBaoCao)
REFERENCES LOAIBAOCAO(MaLoaiBaoCao)

ALTER TABLE BAOCAO
ADD CONSTRAINT BaoCao_MaNhanVien
FOREIGN KEY (NguoiLap)
REFERENCES NhanVien(MaNV)

ALTER TABLE DICHVU
ADD CONSTRAINT DichVu_LoaiDV
FOREIGN KEY (LoaiDV)
REFERENCES LoaiDichVu(MaLoaiDV)

ALTER TABLE CHITIETTHUEDICHVU
ADD CONSTRAINT CTThueDV_MaTP
FOREIGN KEY (MaTP)
REFERENCES  ThongTinThuePhong(MaTP)


ALTER TABLE CHITIETTHUEDICHVU
ADD CONSTRAINT CTThueDV_MaDV
FOREIGN KEY (MaDV)
REFERENCES DichVu(MaDV)

ALTER TABLE ThongTinThuePhong
ADD CONSTRAINT TTThuePhong_MaDP 
FOREIGN KEY (MaDP)
REFERENCES ThongTinDatPhong(MaDP)

ALTER TABLE CHITIETKYGUIHANHLY
ADD CONSTRAINT CTKyGuiHL_MaTP
FOREIGN KEY (MaTP)
REFERENCES ThongTinThuePhong(MaTP)

ALTER TABLE THONGTINTRAPHONG
ADD CONSTRAINT TTTraPhong_MaTP
FOREIGN KEY (MaTP)
REFERENCES ThongTinThuePhong(MaTP)

ALTER TABLE NHANVIEN
ADD CONSTRAINT NhanVien_MaBP
FOREIGN KEY (MaBP)
REFERENCES BoPhan(MaBP)

ALTER TABLE BOPHAN 
ADD CONSTRAINT BoPhan_NguoiQuanLi
FOREIGN KEY (NguoiQuanLy)
REFERENCES NhanVien(MaNV)

ALTER TABLE PHANCONG
ADD CONSTRAINT PhanCong_MaNV
FOREIGN KEY (MaNV)
REFERENCES NhanVien(MaNV)

ALTER TABLE PHANCONG
ADD CONSTRAINT PhanCong_MaCV
FOREIGN KEY (MaCV)
REFERENCES CongViec(MaCV)

ALTER TABLE KHACHHANG
ADD CONSTRAINT KhachHang_MaLoaiKH
FOREIGN KEY (MaLoaiKH)
REFERENCES LoaiKhachHang(MaLoaiKH)

ALTER TABLE THONGKE
ADD CONSTRAINT ThongKe_LoaiTK
FOREIGN KEY (LoaiTK)
REFERENCES LoaiThongKe(MaLoaiTK)

ALTER TABLE THONGKE
ADD CONSTRAINT ThongKe_MaNV
FOREIGN KEY (MaNV)
REFERENCES NhanVien(MaNV)

GO
ALTER TABLE PHONG 
ADD CONSTRAINT FK_PHONG 
FOREIGN KEY (MaLoai) 
REFERENCES LOAIPHONG(MaLoai);
GO
ALTER TABLE THIETBI 
ADD CONSTRAINT FK_THIETBI1 
FOREIGN KEY (SuDungTrongPhong) 
REFERENCES PHONG(MaPhong);
GO
ALTER TABLE THIETBI 
ADD CONSTRAINT FK_THIETBI2 
FOREIGN KEY (NhanVienQuanLy) 
REFERENCES NHANVIEN(MaNV);
GO
ALTER TABLE THIETBI 
ADD CONSTRAINT FK_THIETBI3 
FOREIGN KEY (LoaiTB) 
REFERENCES LOAITHIETBI(MaLoai);
GO
ALTER TABLE LOAITHIETBI 
ADD CONSTRAINT FK_LOAITHIETBI1 
FOREIGN KEY (SuDungTrongPhong) 
REFERENCES PHONG(MaPhong);

GO
ALTER TABLE LICHSUSUACHUA
ADD CONSTRAINT FK_LICHSUSUACHUA_THIETBI
FOREIGN KEY (MaTB)
REFERENCES THIETBI(MaTB)
GO
ALTER TABLE THONGTINHUYDATPHONG
ADD CONSTRAINT FK_THONGTINHUYDATPHONG_THONGTINDATPHONG
FOREIGN KEY (MaDP)
REFERENCES THONGTINDATPHONG(MaDP)
GO
ALTER TABLE THONGTINHUYDATPHONG
ADD CONSTRAINT FK_THONGTINHUYDATPHONG_NHANVIEN
FOREIGN KEY (MaNV)
REFERENCES NHANVIEN(MaNV)
GO
ALTER TABLE THONGTINDATPHONG
ADD CONSTRAINT FK_THONGTINDATPHONG_NHANVIEN
FOREIGN KEY (MaNV)
REFERENCES NHANVIEN(MaNV)
GO
ALTER TABLE THONGTINDATPHONG
ADD CONSTRAINT FK_THONGTINDATPHONG_KHACHHANG
FOREIGN KEY (MaKH)
REFERENCES KHACHHANG(MaKH)
GO
ALTER TABLE CHITIETDP
ADD CONSTRAINT FK_CHITIETDP_THONGTINDATPHONG
FOREIGN KEY (MaDP)
REFERENCES THONGTINDATPHONG(MaDP)
GO
ALTER TABLE CHITIETDP
ADD CONSTRAINT FK_CHITIETDP_LOAIPHONG
FOREIGN KEY (LoaiPhong)
REFERENCES LOAIPHONG(MaLoai)
GO
ALTER TABLE TINHTRANGPHONG
ADD CONSTRAINT FK_CHITIETDP_PHONG
FOREIGN KEY (Phong)
REFERENCES PHONG(MaPhong)
