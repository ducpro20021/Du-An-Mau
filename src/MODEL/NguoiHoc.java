
package MODEL;

import java.util.Date;


public class NguoiHoc {
    private String MaNguoiHoc;
    private String HoTen;
    private Date NgaySinh;
    private boolean GioiTinh;
    private String DienThoai;
    private String Email;
    private String GhiChu;
    private String MaNhanVien;
    private Date NgayDangKy;

    public NguoiHoc() {
    }

    public NguoiHoc(String MaNguoiHoc, String HoTen, Date NgaySinh,boolean GioiTinh, String DienThoai, String Email, String GhiChu, String MaNhanVien, Date NgayDangKy) {
        this.MaNguoiHoc = MaNguoiHoc;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DienThoai = DienThoai;
        this.Email = Email;
        this.GhiChu = GhiChu;
        this.MaNhanVien = MaNhanVien;
        this.NgayDangKy = NgayDangKy;
    }

    public String getMaNguoiHoc() {
        return MaNguoiHoc;
    }

    public void setMaNguoiHoc(String MaNguoiHoc) {
        this.MaNguoiHoc = MaNguoiHoc;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Date getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(Date NgayDangKy) {
        this.NgayDangKy = NgayDangKy;
    }

    @Override
    public String toString() {
        return "NguoiHoc{" + "MaNguoiHoc=" + MaNguoiHoc + ", HoTen=" + HoTen + ", NgaySinh=" + NgaySinh + ", GioiTinh=" + GioiTinh + ", DienThoai=" + DienThoai + ", Email=" + Email + ", GhiChu=" + GhiChu + ", MaNhanVien=" + MaNhanVien + ", NgayDangKy=" + NgayDangKy + '}';
    }

      
}
