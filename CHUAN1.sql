create database SOF2041
go
use  SOF2041
go

create table NhanVien
(
	MaNV varchar(10)not null,
	MatKhau varchar(50) not null,
	HoTen nvarchar(50)not null,
	VaiTro bit DEFAULT 0 not null,
	TrangThai bit default 1,
	primary key(MaNV)
)

go

INSERT INTO NhanVien
(MaNV,MatKhau,HoTen,VaiTro)
VALUES
(N'NV01','123','Tam Phong',1),
(N'NV02','123','Kien',0);

select*from NhanVien
update NhanVien set TrangThai=0 where MaNV='NV012'
delete from NhanVien where MaNV='12'
go
create table ChuyenDe
(
	MaCD varchar(10) not null,
	TenCD nvarchar(50) not null,
	HocPhi float not null,
	ThoiLuong int not null,
	Hinh varchar(50) not null,
	MoTa nvarchar(225) not null,
	primary key(MaCD)
)

go
SELECT*FROM ChuyenDe
INSERT INTO ChuyenDe
(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa)
VALUES
('CD1',N'Lập trình Java 1',100000,80,N'',N'Lập trình Java 1'),
('CD2',N'Lập trình Java 2',100001,81,N'',N'Lập trình Java 2');

go
create table KhoaHoc
(
	MaKH int identity(1,1) not null,
	MaCD varchar(10) not null,
	HocPhi float not null,
	ThoiLuong int not null,
	NgayKG date not null,
	GhiChu nvarchar(255) null,
	MaNV varchar(10)not null,
	NgayTao date DEFAULT GETDATE() not null,
	primary key(MaKH),
	foreign key (MaCD) references ChuyenDe(MaCD) on delete no action on update cascade,
	foreign key (MaNV) references NhanVien(MaNV) on delete no action on update cascade
)
go

INSERT INTO KhoaHoc
(MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV)
VALUES
('CD1',100000,80,'2020-10-10','KHÔNG','NV01'),
('CD2',100001,81,'2020-10-11','KHÔNG','NV02');

INSERT INTO KhoaHoc
(MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV)
VALUES
('CD11',100000,80,'2018-10-10','KHÔNG','NV01'),
('CD2',100001,81,'2019-10-11','KHÔNG','NV02');

select*from KhoaHoc
go
create table NguoiHoc
(
	MaNH varchar(10)not null,
	HoTen nvarchar(50) not null,
	NgaySinh date not null,
	GioiTinh bit DEFAULT 1 not null,
	DienThoai varchar(11)not null,
	Email nvarchar(50)not null,
	GhiChu nvarchar(225)null,
	MaNV varchar(10)not null,
	NgayDK date DEFAULT GETDATE() not null,
	primary key(MaNH),
	foreign key (MaNV) references NHANVIEN(MaNV) on update cascade
)
GO
INSERT INTO NguoiHoc
(MaNH,HoTen,NgaySinh,GioiTinh,DienThoai,Email,GhiChu,MaNV)
VALUES
('NH1',N'DOÃN CHÍ BÌNH','1998-12-12',1,'0987654321','binhdc@gmail.com',N'đẹp trai','NV01'),
('NH2',N'DOÃN CHÍ KÍNH','1998-12-12',1,'0987654322','Kinhdc@gmail.com',N'đẹp trai','NV02');
go
create table HocVien
(
	MaHV int IDENTITY(1,1) not null,
	MaKH int  not null,
	MaNH varchar(10) not null,
	Diem float null,
	primary key(MaHV),
	foreign key (MaKH) references KHOAHOC(MaKH) on update cascade,
	foreign key (MaNH) references NGUOIHOC(MaNH) 
)

INSERT INTO HocVien
(MaKH,MaNH,Diem)
VALUES
(1,'NH1',9),
(2,'NH2',8);
select*from HocVien
SELECT*FROM KhoaHoc
SELECT*FROM NguoiHoc
select * from ChuyenDe
select * from NhanVien
DELETE FROM NguoiHoc WHERE MaNH='NH2'


	CREATE PROC sp_BangDiem(@MaKH INT)
	AS
	BEGIN
		SELECT 
			NguoiHoc.MaNH,
			NguoiHoc.HoTen,
			HocVien.Diem 
		FROM NguoiHoc 
			JOIN HocVien ON NguoiHoc.MaNH=HocVien.MaNH 
		WHERE HocVien.MaKH=@MaKH
		ORDER BY HocVien.Diem DESC
	END




	
	CREATE PROC sp_ThongKeDiem
	AS
	BEGIN
		SELECT
			TenCD ChuyenDe,
			COUNT(MaHV) SoHV,
			MIN(Diem) ThapNhat,
			MAX(Diem) CaoNhat,
			AVG(Diem) TrungBinh
		FROM KHOAHOC
			JOIN HocVien ON KhoaHoc.MaKH=HocVien.MaKH
			JOIN ChuyenDe ON ChuyenDe.MaCD=KhoaHoc.MaCD
		GROUP BY TenCD
	END

	
	CREATE PROC sp_ThongKeDoanhThu(@Year int)
	AS
	BEGIN
		SELECT
			TenCD ChuyenDe,
			COUNT(DISTINCT KHOAHOC.MaKH) SOKH,
			COUNT(HocVien.MaHV) SoHV,
			SUM(KhoaHoc.HocPhi) DoanhThu,
			MIN(KhoaHoc.HocPhi) ThapNhat,
			Max(KhoaHoc.HocPhi) CaoNhat,
			AVG(KhoaHoc.HocPhi) TrungBinh
		FROM KhoaHoc
			JOIN HocVien ON KhoaHoc.MaKH=HocVien.MaKH
			JOIN ChuyenDe ON ChuyenDe.MaCD=KhoaHoc.MaCD
		WHERE YEAR(NgayKG)=@Year
		GROUP BY TenCD
	END


	
	CREATE PROC sp_ThongKeNguoiHoc
	AS
	BEGIN
		SELECT
			YEAR(NgayDK) Nam,
			COUNT(*) SoLuong,
			MIN(NgayDK) DauTien,
			MAX(NgayDK) CuoiCung
		FROM NguoiHoc
		GROUP BY YEAR(NgayDK)
	END

	EXEC sp_ThongKeNguoiHoc
	exec sp_ThongKeDoanhThu 2020
	EXEC sp_ThongKeDiem
	EXEC sp_BangDiem 1

	drop proc sp_ThongKeNguoiHoc
	drop proc sp_ThongKeDoanhThu 
	drop proc sp_ThongKeDiem
	drop proc sp_BangDiem 
	SELECT*FROM NhanVien
	select distinct year(NgayKG) from KhoaHoc ORDER BY Year(NgayKG) desc