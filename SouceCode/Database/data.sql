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

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for baocao
-- ----------------------------
DROP TABLE IF EXISTS `baocao`;
CREATE TABLE `baocao`  (
  `MaBaoCao` int(11) NOT NULL,
  `TenBaoCao` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LoaiBaoCao` int(11) NULL DEFAULT NULL,
  `NguoiLap` int(11) NULL DEFAULT NULL,
  `NgayLap` date NULL DEFAULT NULL,
  `NoiDung` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GhiChu` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaBaoCao`) USING BTREE,
  INDEX `BaoCao_MaLoaiBaoCao`(`LoaiBaoCao`) USING BTREE,
  INDEX `BaoCao_MaNhanVien`(`NguoiLap`) USING BTREE,
  CONSTRAINT `BaoCao_MaLoaiBaoCao` FOREIGN KEY (`LoaiBaoCao`) REFERENCES `loaibaocao` (`MaLoaiBaoCao`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `BaoCao_MaNhanVien` FOREIGN KEY (`NguoiLap`) REFERENCES `nhanvien` (`MaNV`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bophan
-- ----------------------------
DROP TABLE IF EXISTS `bophan`;
CREATE TABLE `bophan`  (
  `MaBP` int(11) NOT NULL,
  `TenBP` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NguoiQuanLy` int(11) NULL DEFAULT NULL,
  `SoLuongNV` int(11) NULL DEFAULT NULL,
  `ThongTinBP` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaBP`) USING BTREE,
  INDEX `BoPhan_NguoiQuanLi`(`NguoiQuanLy`) USING BTREE,
  CONSTRAINT `BoPhan_NguoiQuanLi` FOREIGN KEY (`NguoiQuanLy`) REFERENCES `nhanvien` (`MaNV`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chitietdp
-- ----------------------------
DROP TABLE IF EXISTS `chitietdp`;
CREATE TABLE `chitietdp`  (
  `MaDP` int(11) NOT NULL,
  `LoaiPhong` int(11) NOT NULL,
  `Gia` float NULL DEFAULT NULL,
  `SL` int(11) NULL DEFAULT NULL,
  `ThanhTien` float NULL DEFAULT NULL,
  PRIMARY KEY (`MaDP`, `LoaiPhong`) USING BTREE,
  INDEX `FK_CHITIETDP_LOAIPHONG`(`LoaiPhong`) USING BTREE,
  CONSTRAINT `FK_CHITIETDP_LOAIPHONG` FOREIGN KEY (`LoaiPhong`) REFERENCES `loaiphong` (`MaLoai`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_CHITIETDP_THONGTINDATPHONG` FOREIGN KEY (`MaDP`) REFERENCES `thongtindatphong` (`madp`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chitietkyguihanhly
-- ----------------------------
DROP TABLE IF EXISTS `chitietkyguihanhly`;
CREATE TABLE `chitietkyguihanhly`  (
  `MaTP` int(11) NOT NULL,
  `GiaTri` float NULL DEFAULT NULL,
  `KhoiLuongHanhLy` int(11) NULL DEFAULT NULL,
  `LoaiHanhLy` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TinhTrang` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `KichThuocDxRxC` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaTP`) USING BTREE,
  CONSTRAINT `CTKyGuiHL_MaTP` FOREIGN KEY (`MaTP`) REFERENCES `thongtinthuephong` (`matp`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for chitietthuedichvu
-- ----------------------------
DROP TABLE IF EXISTS `chitietthuedichvu`;
CREATE TABLE `chitietthuedichvu`  (
  `MaTP` int(11) NOT NULL,
  `MaDV` int(11) NOT NULL,
  `Gia` float NULL DEFAULT NULL,
  `SL` int(11) NULL DEFAULT NULL,
  `ThanhTien` float NULL DEFAULT NULL,
  PRIMARY KEY (`MaTP`, `MaDV`) USING BTREE,
  INDEX `CTThueDV_MaDV`(`MaDV`) USING BTREE,
  CONSTRAINT `CTThueDV_MaDV` FOREIGN KEY (`MaDV`) REFERENCES `dichvu` (`maDV`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `CTThueDV_MaTP` FOREIGN KEY (`MaTP`) REFERENCES `thongtinthuephong` (`matp`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for congviec
-- ----------------------------
DROP TABLE IF EXISTS `congviec`;
CREATE TABLE `congviec`  (
  `MaCV` int(11) NOT NULL,
  `TenCV` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NgayBD` datetime(0) NULL DEFAULT NULL,
  `NgayKT` datetime(0) NULL DEFAULT NULL,
  `TongChiPhi` float NULL DEFAULT NULL,
  PRIMARY KEY (`MaCV`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of congviec
-- ----------------------------
INSERT INTO `congviec` VALUES (1, 'Bảo vệ', NULL, NULL, NULL);
INSERT INTO `congviec` VALUES (2, 'Tiếp tân', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_infor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberofemployees` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dichvu
-- ----------------------------
DROP TABLE IF EXISTS `dichvu`;
CREATE TABLE `dichvu`  (
  `maDV` int(11) NOT NULL AUTO_INCREMENT,
  `tenDV` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `loaiDV` int(11) NOT NULL,
  `moTa` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `donGia` int(11) NULL DEFAULT NULL,
  `don_gia` int(11) NULL DEFAULT NULL,
  `mo_ta` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`maDV`) USING BTREE,
  INDEX `DichVu_LoaiDV`(`loaiDV`) USING BTREE,
  CONSTRAINT `DichVu_LoaiDV` FOREIGN KEY (`loaiDV`) REFERENCES `loaidichvu` (`maLDV`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dichvu
-- ----------------------------
INSERT INTO `dichvu` VALUES (1, 'Xông hơi', 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birth_day` date NOT NULL,
  `dept` int(11) NOT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passport` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passwords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salary` float NULL DEFAULT NULL,
  `status` bit(1) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '40 Đường D2, Quận Bình Thạnh', '1985-01-10', 0, 'Nam', '', 'Đỗ Đăng Dũng', '2121335467', '$2a$10$qwAw3opRnDpUxD4G2H0cJu3YvmAdwr9wOGnYZ85CEvarcEpJDUg9S', '012258742933', 2.5, b'1', 'dungdo0110');

-- ----------------------------
-- Table structure for employee_role
-- ----------------------------
DROP TABLE IF EXISTS `employee_role`;
CREATE TABLE `employee_role`  (
  `employee_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`, `role_id`) USING BTREE,
  INDEX `FK7jol9jrbtlt6ctiehegh6besp`(`role_id`) USING BTREE,
  CONSTRAINT `FK7jol9jrbtlt6ctiehegh6besp` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKo7rvk7ejtx29vru9cyhf7o68a` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for khachhang
-- ----------------------------
DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE `khachhang`  (
  `MaKH` int(11) NOT NULL AUTO_INCREMENT,
  `TenKH` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Phai` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CMND` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SDT` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DiaChi` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MaLoaiKH` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`MaKH`) USING BTREE,
  UNIQUE INDEX `CMND`(`CMND`) USING BTREE,
  INDEX `KhachHang_MaLoaiKH`(`MaLoaiKH`) USING BTREE,
  CONSTRAINT `KhachHang_MaLoaiKH` FOREIGN KEY (`MaLoaiKH`) REFERENCES `loaikhachhang` (`MaLoaiKH`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of khachhang
-- ----------------------------
INSERT INTO `khachhang` VALUES (1, 'Nguyễn Thị Thu Hà', 'Nữ', '2122456786', '016539443293', 'Hồ Chí Minh', 1);
INSERT INTO `khachhang` VALUES (3, 'Lê Hoài Nam', 'Nam', '2113923832', '09872635223', 'Hà Nội', 1);

-- ----------------------------
-- Table structure for lichsusuachua
-- ----------------------------
DROP TABLE IF EXISTS `lichsusuachua`;
CREATE TABLE `lichsusuachua`  (
  `NgaySuaChua` datetime(0) NOT NULL,
  `MaTB` int(11) NOT NULL,
  `LyDoSuaChua` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ChiPhi` float NULL DEFAULT NULL,
  `HanBaoHanhSuaDen` datetime(0) NULL DEFAULT NULL,
  `ThongTinSua` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`NgaySuaChua`, `MaTB`) USING BTREE,
  INDEX `FK_LICHSUSUACHUA_THIETBI`(`MaTB`) USING BTREE,
  CONSTRAINT `FK_LICHSUSUACHUA_THIETBI` FOREIGN KEY (`MaTB`) REFERENCES `thietbi` (`MaTB`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for loaibaocao
-- ----------------------------
DROP TABLE IF EXISTS `loaibaocao`;
CREATE TABLE `loaibaocao`  (
  `MaLoaiBaoCao` int(11) NOT NULL,
  `TenLoaiBaoCao` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MoTa` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaLoaiBaoCao`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loaibaocao
-- ----------------------------
INSERT INTO `loaibaocao` VALUES (1, 'báo cáo doanh thu', NULL);
INSERT INTO `loaibaocao` VALUES (2, 'báo cáo khách hàng', '');

-- ----------------------------
-- Table structure for loaidichvu
-- ----------------------------
DROP TABLE IF EXISTS `loaidichvu`;
CREATE TABLE `loaidichvu`  (
  `maLDV` int(11) NOT NULL AUTO_INCREMENT,
  `tenLDV` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `moTa` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mo_ta` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`maLDV`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loaidichvu
-- ----------------------------
INSERT INTO `loaidichvu` VALUES (1, 'massage', 'massage toàn thân', 'massage toàn thân');
INSERT INTO `loaidichvu` VALUES (2, 'vệ sinh', 'làm vệ sinh phòng', 'vệ sinh phòng');

-- ----------------------------
-- Table structure for loaikhachhang
-- ----------------------------
DROP TABLE IF EXISTS `loaikhachhang`;
CREATE TABLE `loaikhachhang`  (
  `MaLoaiKH` int(11) NOT NULL AUTO_INCREMENT,
  `TenLoaiKH` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MoTa` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaLoaiKH`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loaikhachhang
-- ----------------------------
INSERT INTO `loaikhachhang` VALUES (1, 'Cá nhân', 'khách hàng cá nhân');
INSERT INTO `loaikhachhang` VALUES (2, 'Công ty', 'doanh nghiệp, tổ chức');
INSERT INTO `loaikhachhang` VALUES (3, 'Du lịch', 'khách đi du lịch');

-- ----------------------------
-- Table structure for loaiphong
-- ----------------------------
DROP TABLE IF EXISTS `loaiphong`;
CREATE TABLE `loaiphong`  (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MoTa` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Gia` float NULL DEFAULT NULL,
  PRIMARY KEY (`MaLoai`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loaiphong
-- ----------------------------
INSERT INTO `loaiphong` VALUES (1, 'Phòng đơn', 'phòng đơn ', 200000);
INSERT INTO `loaiphong` VALUES (2, 'Phòng đôi', 'phòng đôi', 350000);

-- ----------------------------
-- Table structure for loaithietbi
-- ----------------------------
DROP TABLE IF EXISTS `loaithietbi`;
CREATE TABLE `loaithietbi`  (
  `MaLoai` int(11) NOT NULL AUTO_INCREMENT,
  `TenLoai` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HangSX` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DichVuBaoTri` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GhiChu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NienHan` int(11) NULL DEFAULT NULL,
  `TinhTrang` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaLoai`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loaithietbi
-- ----------------------------
INSERT INTO `loaithietbi` VALUES (1, 'Máy lạnh 1hp', 'lg', '0122334451', NULL, 3, 'tot');
INSERT INTO `loaithietbi` VALUES (2, 'Máy nóng lạnh', 'ariston', '0293294722', NULL, 5, 'ok');

-- ----------------------------
-- Table structure for loaithongke
-- ----------------------------
DROP TABLE IF EXISTS `loaithongke`;
CREATE TABLE `loaithongke`  (
  `MaLoaiTK` int(11) NOT NULL,
  `TenLoaiTK` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GhiChu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaLoaiTK`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loaithongke
-- ----------------------------
INSERT INTO `loaithongke` VALUES (1, 'Tháng', 'thống kê theo tháng');
INSERT INTO `loaithongke` VALUES (2, 'Năm', 'thống kê theo năm');
INSERT INTO `loaithongke` VALUES (3, 'Tuần', 'thống kê theo tuần');

-- ----------------------------
-- Table structure for nhanvien
-- ----------------------------
DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE `nhanvien`  (
  `MaNV` int(11) NOT NULL,
  `TenNV` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NTNS` date NULL DEFAULT NULL,
  `DiaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SDT` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CMND` char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Luong` float NULL DEFAULT NULL,
  `MaBP` int(11) NULL DEFAULT NULL,
  `Username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Passwords` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TrangThai` char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MaNV`) USING BTREE,
  INDEX `NhanVien_MaBP`(`MaBP`) USING BTREE,
  CONSTRAINT `NhanVien_MaBP` FOREIGN KEY (`MaBP`) REFERENCES `bophan` (`MaBP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nhanvien
-- ----------------------------
INSERT INTO `nhanvien` VALUES (1, 'Nguyễn Văn Hòa', NULL, NULL, NULL, NULL, NULL, NULL, 'hoanguyen', '123456', '');
INSERT INTO `nhanvien` VALUES (2, 'Trần Thị Hoa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for phancong
-- ----------------------------
DROP TABLE IF EXISTS `phancong`;
CREATE TABLE `phancong`  (
  `MaNV` int(11) NOT NULL,
  `MaCV` int(11) NOT NULL,
  `ChiTietCongViec` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DanhGia` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PhuCap` float NULL DEFAULT NULL,
  PRIMARY KEY (`MaNV`, `MaCV`) USING BTREE,
  INDEX `PhanCong_MaCV`(`MaCV`) USING BTREE,
  CONSTRAINT `PhanCong_MaCV` FOREIGN KEY (`MaCV`) REFERENCES `congviec` (`MaCV`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `PhanCong_MaNV` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phancong
-- ----------------------------
INSERT INTO `phancong` VALUES (1, 1, 'nhân viên bảo vệ', NULL, NULL);

-- ----------------------------
-- Table structure for phong
-- ----------------------------
DROP TABLE IF EXISTS `phong`;
CREATE TABLE `phong`  (
  `MaPhong` int(11) NOT NULL,
  `TenPhong` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GiaPhong` float NULL DEFAULT NULL,
  `MoTa` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MaLoai` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`MaPhong`) USING BTREE,
  INDEX `FK_PHONG`(`MaLoai`) USING BTREE,
  CONSTRAINT `FK_PHONG` FOREIGN KEY (`MaLoai`) REFERENCES `loaiphong` (`MaLoai`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phong
-- ----------------------------
INSERT INTO `phong` VALUES (1, 'A1234', 150000, NULL, 1);
INSERT INTO `phong` VALUES (2, 'A001', 1222000, NULL, 2);

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_at` date NOT NULL,
  `created_person` int(11) NOT NULL,
  `file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thietbi
-- ----------------------------
DROP TABLE IF EXISTS `thietbi`;
CREATE TABLE `thietbi`  (
  `MaTB` int(11) NOT NULL AUTO_INCREMENT,
  `TenTB` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SoSeri` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NgayNhap` datetime(0) NULL DEFAULT NULL,
  `NgayHetBaoHanh` datetime(0) NULL DEFAULT NULL,
  `NienHan` int(11) NULL DEFAULT NULL,
  `TinhTrang` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SuDungTrongPhong` int(11) NULL DEFAULT NULL,
  `NhanVienQuanLy` int(11) NULL DEFAULT NULL,
  `LoaiTB` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`MaTB`) USING BTREE,
  INDEX `FK_THIETBI1`(`SuDungTrongPhong`) USING BTREE,
  INDEX `FK_THIETBI2`(`NhanVienQuanLy`) USING BTREE,
  INDEX `FK_THIETBI3`(`LoaiTB`) USING BTREE,
  CONSTRAINT `FK_THIETBI1` FOREIGN KEY (`SuDungTrongPhong`) REFERENCES `phong` (`MaPhong`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_THIETBI2` FOREIGN KEY (`NhanVienQuanLy`) REFERENCES `nhanvien` (`MaNV`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_THIETBI3` FOREIGN KEY (`LoaiTB`) REFERENCES `loaithietbi` (`MaLoai`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thietbi
-- ----------------------------
INSERT INTO `thietbi` VALUES (4, 'a', '2243', '2018-01-12 00:00:00', '2018-01-31 00:00:00', 3, 'tốt', 1, 1, 1);

-- ----------------------------
-- Table structure for thongke
-- ----------------------------
DROP TABLE IF EXISTS `thongke`;
CREATE TABLE `thongke`  (
  `MaThongKe` int(11) NOT NULL,
  `NgayThucHienTK` datetime(0) NULL DEFAULT NULL,
  `NoiDungTK` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NgayBD` datetime(0) NULL DEFAULT NULL,
  `NgayKT` datetime(0) NULL DEFAULT NULL,
  `SoTienChi1` float NULL DEFAULT NULL,
  `SoTienChi2` float NULL DEFAULT NULL,
  `SoTienThu1` float NULL DEFAULT NULL,
  `SoTienThu2` float NULL DEFAULT NULL,
  `SLPhongDuocThue1` int(11) NULL DEFAULT NULL,
  `SLPhongDuocThue2` int(11) NULL DEFAULT NULL,
  `SLPhongKhongDuocThue1` int(11) NULL DEFAULT NULL,
  `SLPhongKhongDuocThue2` int(11) NULL DEFAULT NULL,
  `SLPhongTrong1` int(11) NULL DEFAULT NULL,
  `SLPhongTrong2` int(11) NULL DEFAULT NULL,
  `SLKhachHang1` int(11) NULL DEFAULT NULL,
  `SLKhachHang2` int(11) NULL DEFAULT NULL,
  `LoaiTK` int(11) NULL DEFAULT NULL,
  `MaNV` int(11) NULL DEFAULT NULL,
  `slkhachhang` int(11) NULL DEFAULT NULL,
  `slkhachhangdp` int(11) NULL DEFAULT NULL,
  `slphongduocthue` int(11) NULL DEFAULT NULL,
  `slphongkhongduocthue` int(11) NULL DEFAULT NULL,
  `slphongtrong` int(11) NULL DEFAULT NULL,
  `sotienchi` float NULL DEFAULT NULL,
  `sotienthu` float NULL DEFAULT NULL,
  PRIMARY KEY (`MaThongKe`) USING BTREE,
  INDEX `ThongKe_LoaiTK`(`LoaiTK`) USING BTREE,
  INDEX `ThongKe_MaNV`(`MaNV`) USING BTREE,
  CONSTRAINT `ThongKe_LoaiTK` FOREIGN KEY (`LoaiTK`) REFERENCES `loaithongke` (`MaLoaiTK`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ThongKe_MaNV` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thongtindatphong
-- ----------------------------
DROP TABLE IF EXISTS `thongtindatphong`;
CREATE TABLE `thongtindatphong`  (
  `madp` int(11) NOT NULL AUTO_INCREMENT,
  `ngaydp` datetime(0) NULL DEFAULT NULL,
  `ngaybd` datetime(0) NULL DEFAULT NULL,
  `ngaykt` datetime(0) NULL DEFAULT NULL,
  `mota` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manv` int(11) NULL DEFAULT NULL,
  `makh` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`madp`) USING BTREE,
  INDEX `FK_THONGTINDATPHONG_NHANVIEN`(`manv`) USING BTREE,
  INDEX `FK_THONGTINDATPHONG_KHACHHANG`(`makh`) USING BTREE,
  CONSTRAINT `FK_THONGTINDATPHONG_KHACHHANG` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`MaKH`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_THONGTINDATPHONG_NHANVIEN` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`MaNV`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thongtindatphong
-- ----------------------------
INSERT INTO `thongtindatphong` VALUES (1, '2018-01-10 14:23:42', '2018-01-13 14:23:55', '2018-01-15 14:24:01', NULL, 1, 1);

-- ----------------------------
-- Table structure for thongtinhuydatphong
-- ----------------------------
DROP TABLE IF EXISTS `thongtinhuydatphong`;
CREATE TABLE `thongtinhuydatphong`  (
  `MaHuyDP` int(11) NOT NULL,
  `NgayHuy` datetime(0) NULL DEFAULT NULL,
  `MaDP` int(11) NULL DEFAULT NULL,
  `NguyenNhan` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GhiChu` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MaNV` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`MaHuyDP`) USING BTREE,
  INDEX `FK_THONGTINHUYDATPHONG_THONGTINDATPHONG`(`MaDP`) USING BTREE,
  INDEX `FK_THONGTINHUYDATPHONG_NHANVIEN`(`MaNV`) USING BTREE,
  CONSTRAINT `FK_THONGTINHUYDATPHONG_NHANVIEN` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_THONGTINHUYDATPHONG_THONGTINDATPHONG` FOREIGN KEY (`MaDP`) REFERENCES `thongtindatphong` (`madp`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thongtinthuephong
-- ----------------------------
DROP TABLE IF EXISTS `thongtinthuephong`;
CREATE TABLE `thongtinthuephong`  (
  `matp` int(10) NOT NULL AUTO_INCREMENT,
  `madp` int(11) NULL DEFAULT NULL,
  `giathuephong` int(11) NULL DEFAULT NULL,
  `giaytotamgiu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`matp`) USING BTREE,
  INDEX `TTThuePhong_MaDP`(`madp`) USING BTREE,
  CONSTRAINT `TTThuePhong_MaDP` FOREIGN KEY (`madp`) REFERENCES `thongtindatphong` (`madp`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thongtinthuephong
-- ----------------------------
INSERT INTO `thongtinthuephong` VALUES (1, 1, 500000, 'cmnd');

-- ----------------------------
-- Table structure for thongtintraphong
-- ----------------------------
DROP TABLE IF EXISTS `thongtintraphong`;
CREATE TABLE `thongtintraphong`  (
  `matp` int(11) NOT NULL AUTO_INCREMENT,
  `mathuephong` int(11) NULL DEFAULT NULL,
  `makh` int(11) NULL DEFAULT NULL,
  `thoigiantraphong` datetime(0) NULL DEFAULT NULL,
  `chiphiphatsinh` float NULL DEFAULT NULL,
  `mota` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tongien` float NULL DEFAULT NULL,
  PRIMARY KEY (`matp`) USING BTREE,
  INDEX `TTTraPhong_MaTP`(`mathuephong`) USING BTREE,
  CONSTRAINT `TTTraPhong_MaTP` FOREIGN KEY (`mathuephong`) REFERENCES `thongtinthuephong` (`matp`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thongtintraphong
-- ----------------------------
INSERT INTO `thongtintraphong` VALUES (1, 1, 11, '2018-01-15 14:29:30', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tinhtrangphong
-- ----------------------------
DROP TABLE IF EXISTS `tinhtrangphong`;
CREATE TABLE `tinhtrangphong`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Phong` int(11) NULL DEFAULT NULL,
  `TinhTrang` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Ngay` date NULL DEFAULT NULL,
  `GhiChu` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_CHITIETDP_PHONG`(`Phong`) USING BTREE,
  CONSTRAINT `FK_CHITIETDP_PHONG` FOREIGN KEY (`Phong`) REFERENCES `phong` (`MaPhong`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ttdatphong
-- ----------------------------
DROP TABLE IF EXISTS `ttdatphong`;
CREATE TABLE `ttdatphong`  (
  `madp` int(11) NOT NULL AUTO_INCREMENT,
  `makh` int(11) NULL DEFAULT NULL,
  `manv` int(11) NULL DEFAULT NULL,
  `mota` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ngaybd` date NULL DEFAULT NULL,
  `ngaydp` date NULL DEFAULT NULL,
  `ngaykt` date NULL DEFAULT NULL,
  PRIMARY KEY (`madp`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

