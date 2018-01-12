/*
 Navicat Premium Data Transfer
 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : hotel
 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001
 Date: 12/01/2018 14:54:47
*/

create database hotel;

use hotel;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for baocao
-- ----------------------------
DROP TABLE IF EXISTS `baocao`;
CREATE TABLE `baocao` (
  `MaBaoCao` int(11) NOT NULL,
  `TenBaoCao` varchar(30) DEFAULT NULL,
  `LoaiBaoCao` int(11) DEFAULT NULL,
  `NguoiLap` int(11) DEFAULT NULL,
  `NgayLap` date DEFAULT NULL,
  `NoiDung` varchar(100) DEFAULT NULL,
  `GhiChu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaBaoCao`) USING BTREE,
  KEY `BaoCao_MaLoaiBaoCao` (`LoaiBaoCao`) USING BTREE,
  KEY `BaoCao_MaNhanVien` (`NguoiLap`) USING BTREE,
  CONSTRAINT `BaoCao_MaLoaiBaoCao` FOREIGN KEY (`LoaiBaoCao`) REFERENCES `loaibaocao` (`MaLoaiBaoCao`),
  CONSTRAINT `BaoCao_MaNhanVien` FOREIGN KEY (`NguoiLap`) REFERENCES `nhanvien` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of baocao
-- ----------------------------

-- ----------------------------
-- Table structure for bophan
-- ----------------------------
DROP TABLE IF EXISTS `bophan`;
CREATE TABLE `bophan` (
  `MaBP` int(11) NOT NULL,
  `TenBP` varchar(30) DEFAULT NULL,
  `NguoiQuanLy` int(11) DEFAULT NULL,
  `SoLuongNV` int(11) DEFAULT NULL,
  `ThongTinBP` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MaBP`) USING BTREE,
  KEY `BoPhan_NguoiQuanLi` (`NguoiQuanLy`) USING BTREE,
  CONSTRAINT `BoPhan_NguoiQuanLi` FOREIGN KEY (`NguoiQuanLy`) REFERENCES `nhanvien` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bophan
-- ----------------------------

-- ----------------------------
-- Table structure for chitietdp
-- ----------------------------
DROP TABLE IF EXISTS `chitietdp`;
CREATE TABLE `chitietdp` (
  `MaDP` int(11) NOT NULL,
  `LoaiPhong` int(11) NOT NULL,
  `Gia` float DEFAULT NULL,
  `SL` int(11) DEFAULT NULL,
  `ThanhTien` float DEFAULT NULL,
  PRIMARY KEY (`MaDP`,`LoaiPhong`) USING BTREE,
  KEY `FK_CHITIETDP_LOAIPHONG` (`LoaiPhong`) USING BTREE,
  CONSTRAINT `FK_CHITIETDP_LOAIPHONG` FOREIGN KEY (`LoaiPhong`) REFERENCES `loaiphong` (`MaLoai`),
  CONSTRAINT `FK_CHITIETDP_THONGTINDATPHONG` FOREIGN KEY (`MaDP`) REFERENCES `thongtindatphong` (`madp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of chitietdp
-- ----------------------------

-- ----------------------------
-- Table structure for chitietkyguihanhly
-- ----------------------------
DROP TABLE IF EXISTS `chitietkyguihanhly`;
CREATE TABLE `chitietkyguihanhly` (
  `MaTP` int(11) NOT NULL,
  `GiaTri` float DEFAULT NULL,
  `KhoiLuongHanhLy` int(11) DEFAULT NULL,
  `LoaiHanhLy` varchar(50) DEFAULT NULL,
  `TinhTrang` varchar(50) DEFAULT NULL,
  `KichThuocDxRxC` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaTP`) USING BTREE,
  CONSTRAINT `CTKyGuiHL_MaTP` FOREIGN KEY (`MaTP`) REFERENCES `thongtinthuephong` (`matp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of chitietkyguihanhly
-- ----------------------------

-- ----------------------------
-- Table structure for chitietthuedichvu
-- ----------------------------
DROP TABLE IF EXISTS `chitietthuedichvu`;
CREATE TABLE `chitietthuedichvu` (
  `MaTP` int(11) NOT NULL,
  `MaDV` int(11) NOT NULL,
  `Gia` float DEFAULT NULL,
  `SL` int(11) DEFAULT NULL,
  `ThanhTien` float DEFAULT NULL,
  PRIMARY KEY (`MaTP`,`MaDV`) USING BTREE,
  KEY `CTThueDV_MaDV` (`MaDV`) USING BTREE,
  CONSTRAINT `CTThueDV_MaDV` FOREIGN KEY (`MaDV`) REFERENCES `dichvu` (`maDV`),
  CONSTRAINT `CTThueDV_MaTP` FOREIGN KEY (`MaTP`) REFERENCES `thongtinthuephong` (`matp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of chitietthuedichvu
-- ----------------------------

-- ----------------------------
-- Table structure for congviec
-- ----------------------------
DROP TABLE IF EXISTS `congviec`;
CREATE TABLE `congviec` (
  `MaCV` int(11) NOT NULL,
  `TenCV` varchar(50) DEFAULT NULL,
  `NgayBD` datetime DEFAULT NULL,
  `NgayKT` datetime DEFAULT NULL,
  `TongChiPhi` float DEFAULT NULL,
  PRIMARY KEY (`MaCV`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of congviec
-- ----------------------------
INSERT INTO `congviec` VALUES ('1', 'Bảo vệ', null, null, null);
INSERT INTO `congviec` VALUES ('2', 'Tiếp tân', null, null, null);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_infor` varchar(255) DEFAULT NULL,
  `manager` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `numberofemployees` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------

-- ----------------------------
-- Table structure for dichvu
-- ----------------------------
DROP TABLE IF EXISTS `dichvu`;
CREATE TABLE `dichvu` (
  `maDV` int(11) NOT NULL AUTO_INCREMENT,
  `tenDV` varchar(50) NOT NULL,
  `loaiDV` int(11) NOT NULL,
  `moTa` varchar(50) DEFAULT NULL,
  `donGia` int(11) DEFAULT NULL,
  `don_gia` int(11) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maDV`) USING BTREE,
  KEY `DichVu_LoaiDV` (`loaiDV`) USING BTREE,
  CONSTRAINT `DichVu_LoaiDV` FOREIGN KEY (`loaiDV`) REFERENCES `loaidichvu` (`maLDV`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of dichvu
-- ----------------------------
INSERT INTO `dichvu` VALUES ('1', 'Xong hoi', '1', null, '1', '500000', 'Khach hang tam hoi nuoc nong tai phong tam hoi cua khach san. Don gia tinh theo gio.');
INSERT INTO `dichvu` VALUES ('2', 'Tennis', '1', null, null, '300000', 'Khach hang choi danh bong tennis tai khu vuc san choi the thao cua khach san. Don gia tinh theo gio');
INSERT INTO `dichvu` VALUES ('3', 'Boi', '5', null, null, '100000', 'Khach hang su dung ho boi chung tai khach san. Don gia tinh theo gio.');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `birth_day` date NOT NULL,
  `dept` int(11) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `passport` varchar(255) NOT NULL,
  `passwords` varchar(255) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `salary` float DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '40 Đường D2, Quận Bình Thạnh', '1985-01-10', '0', 'Nam', '', 'Đỗ Đăng Dũng', '2121335467', '$2a$10$qwAw3opRnDpUxD4G2H0cJu3YvmAdwr9wOGnYZ85CEvarcEpJDUg9S', '012258742933', '2.5', '', 'dungdo0110', null, null);

-- ----------------------------
-- Table structure for employee_role
-- ----------------------------
DROP TABLE IF EXISTS `employee_role`;
CREATE TABLE `employee_role` (
  `employee_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`,`role_id`) USING BTREE,
  KEY `FK7jol9jrbtlt6ctiehegh6besp` (`role_id`) USING BTREE,
  CONSTRAINT `FK7jol9jrbtlt6ctiehegh6besp` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKo7rvk7ejtx29vru9cyhf7o68a` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employee_role
-- ----------------------------

-- ----------------------------
-- Table structure for khachhang
-- ----------------------------
DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE `khachhang` (
  `MaKH` int(11) NOT NULL AUTO_INCREMENT,
  `TenKH` varchar(50) DEFAULT NULL,
  `Phai` varchar(10) DEFAULT NULL,
  `CMND` varchar(20) DEFAULT NULL,
  `SDT` char(15) DEFAULT NULL,
  `DiaChi` varchar(50) DEFAULT NULL,
  `MaLoaiKH` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaKH`) USING BTREE,
  UNIQUE KEY `CMND` (`CMND`) USING BTREE,
  KEY `KhachHang_MaLoaiKH` (`MaLoaiKH`) USING BTREE,
  CONSTRAINT `KhachHang_MaLoaiKH` FOREIGN KEY (`MaLoaiKH`) REFERENCES `loaikhachhang` (`MaLoaiKH`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of khachhang
-- ----------------------------
INSERT INTO `khachhang` VALUES ('1', 'Nguyễn Thị Thu Hà', 'Nữ', '2122456786', '016539443293', 'Hồ Chí Minh', '1');
INSERT INTO `khachhang` VALUES ('3', 'Lê Hoài Nam', 'Nam', '2113923832', '09872635223', 'Hà Nội', '1');

-- ----------------------------
-- Table structure for lichsusuachua
-- ----------------------------
DROP TABLE IF EXISTS `lichsusuachua`;
CREATE TABLE `lichsusuachua` (
  `NgaySuaChua` datetime NOT NULL,
  `MaTB` int(11) NOT NULL,
  `LyDoSuaChua` varchar(50) DEFAULT NULL,
  `ChiPhi` float DEFAULT NULL,
  `HanBaoHanhSuaDen` datetime DEFAULT NULL,
  `ThongTinSua` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`NgaySuaChua`,`MaTB`) USING BTREE,
  KEY `FK_LICHSUSUACHUA_THIETBI` (`MaTB`) USING BTREE,
  CONSTRAINT `FK_LICHSUSUACHUA_THIETBI` FOREIGN KEY (`MaTB`) REFERENCES `thietbi` (`MaTB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of lichsusuachua
-- ----------------------------

-- ----------------------------
-- Table structure for loaibaocao
-- ----------------------------
DROP TABLE IF EXISTS `loaibaocao`;
CREATE TABLE `loaibaocao` (
  `MaLoaiBaoCao` int(11) NOT NULL,
  `TenLoaiBaoCao` varchar(30) DEFAULT NULL,
  `MoTa` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`MaLoaiBaoCao`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of loaibaocao
-- ----------------------------
INSERT INTO `loaibaocao` VALUES ('1', 'báo cáo doanh thu', null);
INSERT INTO `loaibaocao` VALUES ('2', 'báo cáo khách hàng', '');

-- ----------------------------
-- Table structure for loaidichvu
-- ----------------------------
DROP TABLE IF EXISTS `loaidichvu`;
CREATE TABLE `loaidichvu` (
  `maLDV` int(11) NOT NULL AUTO_INCREMENT,
  `tenLDV` varchar(50) NOT NULL,
  `moTa` varchar(50) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maLDV`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of loaidichvu
-- ----------------------------
INSERT INTO `loaidichvu` VALUES ('1', 'Cao cap', 'massage toàn thân', 'Danh cho khach hang co nhu cau su dung dich vu cao cap');
INSERT INTO `loaidichvu` VALUES ('5', 'Thuong', null, 'Danh cho khach hang co nhu cau su dung dich vu co ban');

-- ----------------------------
-- Table structure for loaikhachhang
-- ----------------------------
DROP TABLE IF EXISTS `loaikhachhang`;
CREATE TABLE `loaikhachhang` (
  `MaLoaiKH` int(11) NOT NULL AUTO_INCREMENT,
  `TenLoaiKH` varchar(50) DEFAULT NULL,
  `MoTa` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MaLoaiKH`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of loaikhachhang
-- ----------------------------
INSERT INTO `loaikhachhang` VALUES ('1', 'Cá nhân', 'khách hàng cá nhân');
INSERT INTO `loaikhachhang` VALUES ('2', 'Công ty', 'doanh nghiệp, tổ chức');
INSERT INTO `loaikhachhang` VALUES ('3', 'Du lịch', 'khách đi du lịch');

-- ----------------------------
-- Table structure for loaiphong
-- ----------------------------
DROP TABLE IF EXISTS `loaiphong`;
CREATE TABLE `loaiphong` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(50) DEFAULT NULL,
  `MoTa` varchar(50) DEFAULT NULL,
  `Gia` float DEFAULT NULL,
  PRIMARY KEY (`MaLoai`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of loaiphong
-- ----------------------------
INSERT INTO `loaiphong` VALUES ('1', 'Thuong', 'cccccccc', '300000');
INSERT INTO `loaiphong` VALUES ('2', 'Vip', 'cccccccc', '500000');
INSERT INTO `loaiphong` VALUES ('3', 'Dac biet', 'cccccccc', '800000');

-- ----------------------------
-- Table structure for loaithietbi
-- ----------------------------
DROP TABLE IF EXISTS `loaithietbi`;
CREATE TABLE `loaithietbi` (
  `MaLoai` int(11) NOT NULL AUTO_INCREMENT,
  `TenLoai` varchar(50) DEFAULT NULL,
  `HangSX` varchar(50) DEFAULT NULL,
  `DichVuBaoTri` varchar(100) DEFAULT NULL,
  `GhiChu` varchar(100) DEFAULT NULL,
  `NienHan` int(11) DEFAULT NULL,
  `TinhTrang` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`MaLoai`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of loaithietbi
-- ----------------------------
INSERT INTO `loaithietbi` VALUES ('1', 'Máy lạnh 1hp', 'lg', '0122334451', null, '3', 'tot');
INSERT INTO `loaithietbi` VALUES ('2', 'Máy nóng lạnh', 'ariston', '0293294722', null, '5', 'ok');
INSERT INTO `loaithietbi` VALUES ('3', 'Tủ quần áo', 'Super Wood', '0991124141', null, '5', 'khong moi mot');

-- ----------------------------
-- Table structure for loaithongke
-- ----------------------------
DROP TABLE IF EXISTS `loaithongke`;
CREATE TABLE `loaithongke` (
  `MaLoaiTK` int(11) NOT NULL,
  `TenLoaiTK` varchar(50) DEFAULT NULL,
  `GhiChu` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MaLoaiTK`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of loaithongke
-- ----------------------------
INSERT INTO `loaithongke` VALUES ('1', 'Thống kê ngày', 'thống kê theo ngày');
INSERT INTO `loaithongke` VALUES ('2', 'Thống kê tuần', 'thống kê theo tuần');
INSERT INTO `loaithongke` VALUES ('3', 'Thống kê tháng', 'thống kê theo tháng');
INSERT INTO `loaithongke` VALUES ('4', 'Thống kê quý', 'thống kê theo quý');
INSERT INTO `loaithongke` VALUES ('5', 'Thống kê năm', 'thống kê theo năm');

-- ----------------------------
-- Table structure for nhanvien
-- ----------------------------
DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE `nhanvien` (
  `MaNV` int(11) NOT NULL,
  `TenNV` varchar(30) DEFAULT NULL,
  `NTNS` date DEFAULT NULL,
  `DiaChi` varchar(100) DEFAULT NULL,
  `SDT` char(15) DEFAULT NULL,
  `CMND` char(15) DEFAULT NULL,
  `Luong` float DEFAULT NULL,
  `MaBP` int(11) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Passwords` varchar(20) DEFAULT NULL,
  `TrangThai` char(5) DEFAULT NULL,
  PRIMARY KEY (`MaNV`) USING BTREE,
  KEY `NhanVien_MaBP` (`MaBP`) USING BTREE,
  CONSTRAINT `NhanVien_MaBP` FOREIGN KEY (`MaBP`) REFERENCES `bophan` (`MaBP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of nhanvien
-- ----------------------------
INSERT INTO `nhanvien` VALUES ('1', 'Nguyễn Văn Hòa', null, null, null, null, null, null, 'hoanguyen', '123456', '');
INSERT INTO `nhanvien` VALUES ('2', 'Trần Thị Hoa', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for phancong
-- ----------------------------
DROP TABLE IF EXISTS `phancong`;
CREATE TABLE `phancong` (
  `MaNV` int(11) NOT NULL,
  `MaCV` int(11) NOT NULL,
  `ChiTietCongViec` varchar(50) DEFAULT NULL,
  `DanhGia` varchar(50) DEFAULT NULL,
  `PhuCap` float DEFAULT NULL,
  PRIMARY KEY (`MaNV`,`MaCV`) USING BTREE,
  KEY `PhanCong_MaCV` (`MaCV`) USING BTREE,
  CONSTRAINT `PhanCong_MaCV` FOREIGN KEY (`MaCV`) REFERENCES `congviec` (`MaCV`),
  CONSTRAINT `PhanCong_MaNV` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of phancong
-- ----------------------------
INSERT INTO `phancong` VALUES ('1', '1', 'nhân viên bảo vệ', null, null);

-- ----------------------------
-- Table structure for phong
-- ----------------------------
DROP TABLE IF EXISTS `phong`;
CREATE TABLE `phong` (
  `MaPhong` int(11) NOT NULL,
  `TenPhong` varchar(50) DEFAULT NULL,
  `GiaPhong` float DEFAULT NULL,
  `MoTa` varchar(50) DEFAULT NULL,
  `MaLoai` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaPhong`) USING BTREE,
  KEY `FK_PHONG` (`MaLoai`) USING BTREE,
  CONSTRAINT `FK_PHONG` FOREIGN KEY (`MaLoai`) REFERENCES `loaiphong` (`MaLoai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of phong
-- ----------------------------
INSERT INTO `phong` VALUES ('1', 'B101', '500000', 'co tu lanh, co may nuoc nong', '2');
INSERT INTO `phong` VALUES ('2', 'C201', '750000', 'co tu lanh, co may nuoc nong, co tivi, co may lanh', '3');
INSERT INTO `phong` VALUES ('3', 'A301', '280000', 'co tu lanh, co tivi', '1');
INSERT INTO `phong` VALUES ('4', 'A102', '310000', 'co tu lanh, co tivi', '1');
INSERT INTO `phong` VALUES ('5', 'B105', '550000', 'co tu lanh, co may nuoc nong, co tivi', '2');
INSERT INTO `phong` VALUES ('6', 'B303', '490000', 'co tu lanh, co may nuoc nong', '2');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `created_at` date NOT NULL,
  `created_person` int(11) NOT NULL,
  `file` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for thietbi
-- ----------------------------
DROP TABLE IF EXISTS `thietbi`;
CREATE TABLE `thietbi` (
  `MaTB` int(11) NOT NULL AUTO_INCREMENT,
  `TenTB` varchar(50) DEFAULT NULL,
  `SoSeri` varchar(50) DEFAULT NULL,
  `NgayNhap` datetime DEFAULT NULL,
  `NgayHetBaoHanh` datetime DEFAULT NULL,
  `NienHan` int(11) DEFAULT NULL,
  `TinhTrang` varchar(20) DEFAULT NULL,
  `SuDungTrongPhong` int(11) DEFAULT NULL,
  `NhanVienQuanLy` int(11) DEFAULT NULL,
  `LoaiTB` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaTB`) USING BTREE,
  KEY `FK_THIETBI1` (`SuDungTrongPhong`) USING BTREE,
  KEY `FK_THIETBI2` (`NhanVienQuanLy`) USING BTREE,
  KEY `FK_THIETBI3` (`LoaiTB`) USING BTREE,
  CONSTRAINT `FK_THIETBI1` FOREIGN KEY (`SuDungTrongPhong`) REFERENCES `phong` (`MaPhong`),
  CONSTRAINT `FK_THIETBI2` FOREIGN KEY (`NhanVienQuanLy`) REFERENCES `nhanvien` (`MaNV`),
  CONSTRAINT `FK_THIETBI3` FOREIGN KEY (`LoaiTB`) REFERENCES `loaithietbi` (`MaLoai`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of thietbi
-- ----------------------------
INSERT INTO `thietbi` VALUES ('4', 'a', '2243', '2018-01-12 00:00:00', '2018-01-31 00:00:00', '3', 'tốt', '1', '1', '1');

-- ----------------------------
-- Table structure for thongke
-- ----------------------------
DROP TABLE IF EXISTS `thongke`;
CREATE TABLE `thongke` (
  `MaThongKe` int(11) NOT NULL AUTO_INCREMENT,
  `NgayThucHienTK` datetime DEFAULT NULL,
  `NoiDungTK` varchar(100) DEFAULT NULL,
  `NgayBD` datetime DEFAULT NULL,
  `NgayKT` datetime DEFAULT NULL,
  `SoTienChi1` float DEFAULT NULL,
  `SoTienChi2` float DEFAULT NULL,
  `SoTienThu1` float DEFAULT NULL,
  `SoTienThu2` float DEFAULT NULL,
  `SLPhongDuocThue1` int(11) DEFAULT NULL,
  `SLPhongDuocThue2` int(11) DEFAULT NULL,
  `SLPhongKhongDuocThue1` int(11) DEFAULT NULL,
  `SLPhongKhongDuocThue2` int(11) DEFAULT NULL,
  `SLPhongTrong1` int(11) DEFAULT NULL,
  `SLPhongTrong2` int(11) DEFAULT NULL,
  `SLKhachHang1` int(11) DEFAULT NULL,
  `SLKhachHang2` int(11) DEFAULT NULL,
  `SLPhongDuocDat1` int(11) DEFAULT NULL,
  `SLPhongDuocDat2` int(11) DEFAULT NULL,
  `LoaiTK` int(11) DEFAULT NULL,
  `MaNV` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaThongKe`) USING BTREE,
  KEY `ThongKe_LoaiTK` (`LoaiTK`) USING BTREE,
  KEY `ThongKe_MaNV` (`MaNV`) USING BTREE,
  CONSTRAINT `ThongKe_LoaiTK` FOREIGN KEY (`LoaiTK`) REFERENCES `loaithongke` (`MaLoaiTK`),
  CONSTRAINT `ThongKe_MaNV` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of thongke
-- ----------------------------
INSERT INTO `thongke` VALUES ('1', '2018-01-12 00:00:00', 'demo', '2018-01-01 00:00:00', '2018-01-02 00:00:00', '0', '0', '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '1', '1');
INSERT INTO `thongke` VALUES ('2', '2018-01-13 00:00:00', 'so luong dat phong', '2018-01-10 00:00:00', '2018-01-15 00:00:00', '0', '0', '0', '0', '0', '2', '1', '0', '0', '0', '0', '0', '1', '0', '1', '1');

-- ----------------------------
-- Table structure for thongtindatphong
-- ----------------------------
DROP TABLE IF EXISTS `thongtindatphong`;
CREATE TABLE `thongtindatphong` (
  `madp` int(11) NOT NULL AUTO_INCREMENT,
  `ngaydp` datetime DEFAULT NULL,
  `ngaybd` datetime DEFAULT NULL,
  `ngaykt` datetime DEFAULT NULL,
  `mota` varchar(100) DEFAULT NULL,
  `manv` int(11) DEFAULT NULL,
  `makh` int(11) DEFAULT NULL,
  PRIMARY KEY (`madp`) USING BTREE,
  KEY `FK_THONGTINDATPHONG_NHANVIEN` (`manv`) USING BTREE,
  KEY `FK_THONGTINDATPHONG_KHACHHANG` (`makh`) USING BTREE,
  CONSTRAINT `FK_THONGTINDATPHONG_KHACHHANG` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`MaKH`),
  CONSTRAINT `FK_THONGTINDATPHONG_NHANVIEN` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`MaNV`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of thongtindatphong
-- ----------------------------
INSERT INTO `thongtindatphong` VALUES ('1', '2018-01-10 14:23:42', '2018-01-13 14:23:55', '2018-01-15 14:24:01', null, '1', '1');

-- ----------------------------
-- Table structure for thongtinhuydatphong
-- ----------------------------
DROP TABLE IF EXISTS `thongtinhuydatphong`;
CREATE TABLE `thongtinhuydatphong` (
  `MaHuyDP` int(11) NOT NULL,
  `NgayHuy` datetime DEFAULT NULL,
  `MaDP` int(11) DEFAULT NULL,
  `NguyenNhan` varchar(100) DEFAULT NULL,
  `GhiChu` varchar(50) DEFAULT NULL,
  `MaNV` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaHuyDP`) USING BTREE,
  KEY `FK_THONGTINHUYDATPHONG_THONGTINDATPHONG` (`MaDP`) USING BTREE,
  KEY `FK_THONGTINHUYDATPHONG_NHANVIEN` (`MaNV`) USING BTREE,
  CONSTRAINT `FK_THONGTINHUYDATPHONG_NHANVIEN` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  CONSTRAINT `FK_THONGTINHUYDATPHONG_THONGTINDATPHONG` FOREIGN KEY (`MaDP`) REFERENCES `thongtindatphong` (`madp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of thongtinhuydatphong
-- ----------------------------

-- ----------------------------
-- Table structure for thongtinthuephong
-- ----------------------------
DROP TABLE IF EXISTS `thongtinthuephong`;
CREATE TABLE `thongtinthuephong` (
  `matp` int(10) NOT NULL AUTO_INCREMENT,
  `madp` int(11) DEFAULT NULL,
  `giathuephong` int(11) DEFAULT NULL,
  `giaytotamgiu` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`matp`) USING BTREE,
  KEY `TTThuePhong_MaDP` (`madp`) USING BTREE,
  CONSTRAINT `TTThuePhong_MaDP` FOREIGN KEY (`madp`) REFERENCES `thongtindatphong` (`madp`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of thongtinthuephong
-- ----------------------------
INSERT INTO `thongtinthuephong` VALUES ('1', '1', '500000', 'cmnd');

-- ----------------------------
-- Table structure for thongtintraphong
-- ----------------------------
DROP TABLE IF EXISTS `thongtintraphong`;
CREATE TABLE `thongtintraphong` (
  `matp` int(11) NOT NULL AUTO_INCREMENT,
  `mathuephong` int(11) DEFAULT NULL,
  `makh` int(11) DEFAULT NULL,
  `thoigiantraphong` datetime DEFAULT NULL,
  `chiphiphatsinh` float DEFAULT NULL,
  `mota` varchar(50) DEFAULT NULL,
  `tongien` float DEFAULT NULL,
  `tongtien` float DEFAULT NULL,
  PRIMARY KEY (`matp`) USING BTREE,
  KEY `TTTraPhong_MaTP` (`mathuephong`) USING BTREE,
  CONSTRAINT `TTTraPhong_MaTP` FOREIGN KEY (`mathuephong`) REFERENCES `thongtinthuephong` (`matp`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of thongtintraphong
-- ----------------------------
INSERT INTO `thongtintraphong` VALUES ('1', '1', '11', '2018-01-15 14:29:30', null, null, null, null);

-- ----------------------------
-- Table structure for tinhtrangphong
-- ----------------------------
DROP TABLE IF EXISTS `tinhtrangphong`;
CREATE TABLE `tinhtrangphong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Phong` int(11) DEFAULT NULL,
  `TinhTrang` varchar(20) DEFAULT NULL,
  `Ngay` date DEFAULT NULL,
  `GhiChu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_CHITIETDP_PHONG` (`Phong`) USING BTREE,
  CONSTRAINT `FK_CHITIETDP_PHONG` FOREIGN KEY (`Phong`) REFERENCES `phong` (`MaPhong`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tinhtrangphong
-- ----------------------------
INSERT INTO `tinhtrangphong` VALUES ('1', '1', 'con trong', '2018-01-01', '.......');
INSERT INTO `tinhtrangphong` VALUES ('2', '1', 'con trong', '2018-01-02', '.......');
INSERT INTO `tinhtrangphong` VALUES ('3', '1', 'dang sua chua', '2018-01-03', '.......');
INSERT INTO `tinhtrangphong` VALUES ('4', '1', 'dang sua chua', '2018-01-04', '.......');
INSERT INTO `tinhtrangphong` VALUES ('5', '1', 'dang thue', '2018-01-05', '.......');
INSERT INTO `tinhtrangphong` VALUES ('6', '1', 'con trong', '2018-01-06', '.......');
INSERT INTO `tinhtrangphong` VALUES ('7', '1', 'dang thue', '2018-01-07', '.......');
INSERT INTO `tinhtrangphong` VALUES ('8', '1', 'dang thue', '2018-01-08', '.......');
INSERT INTO `tinhtrangphong` VALUES ('9', '1', 'dang thue', '2018-01-09', '.......');
INSERT INTO `tinhtrangphong` VALUES ('10', '1', 'con trong', '2018-01-10', '.......');
INSERT INTO `tinhtrangphong` VALUES ('11', '1', 'con trong', '2018-01-11', '.......');
INSERT INTO `tinhtrangphong` VALUES ('12', '1', 'dang thue', '2018-01-12', '.......');
INSERT INTO `tinhtrangphong` VALUES ('13', '1', 'con trong', '2018-01-13', '.......');
INSERT INTO `tinhtrangphong` VALUES ('14', '1', 'dang thue', '2018-01-14', '.......');
INSERT INTO `tinhtrangphong` VALUES ('15', '1', 'dang thue', '2018-01-15', '.......');
INSERT INTO `tinhtrangphong` VALUES ('16', '2', 'dang thue', '2018-01-14', '.......');
INSERT INTO `tinhtrangphong` VALUES ('17', '2', 'dang thue', '2018-01-15', '.......');
INSERT INTO `tinhtrangphong` VALUES ('18', '2', 'con trong', '2018-01-16', '.......');

-- ----------------------------
-- Table structure for ttdatphong
-- ----------------------------
DROP TABLE IF EXISTS `ttdatphong`;
CREATE TABLE `ttdatphong` (
  `madp` int(11) NOT NULL AUTO_INCREMENT,
  `makh` int(11) DEFAULT NULL,
  `manv` int(11) DEFAULT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `ngaybd` date DEFAULT NULL,
  `ngaydp` date DEFAULT NULL,
  `ngaykt` date DEFAULT NULL,
  PRIMARY KEY (`madp`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of ttdatphong
-- ----------------------------

