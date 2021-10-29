package DAO;

import HELPER.JdbcHelper;
import MODEL.NguoiHoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NguoiHocDAO extends EduSysDAO<NguoiHoc, Object> {

    String SelectAll = "Select * from NguoiHoc";
    String SELECT_BY_ID_SQL = "SELECT*FROM NguoiHoc WHERE MaNH=?";
    String DELETE_SQL = "DELETE FROM NguoiHoc WHERE MaNH=?";
    String INSERT_SQL = "Insert Into NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) values (?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "update NguoiHoc set HoTen = ? , NgaySinh = ? , GioiTinh = ?, DienThoai = ?, Email = ?, GhiChu = ?, MaNV = ?, NgayDK = ? where MaNH = ?";
    @Override
    public NguoiHoc selectById(Object id) {
        List<NguoiHoc> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return this.selectBySql(SelectAll);
    }

    @Override
    protected List<NguoiHoc> selectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NguoiHoc nh = new NguoiHoc();
                nh.setMaNguoiHoc(rs.getString("MaNH"));
                nh.setMaNhanVien(rs.getString("MaNV"));
                nh.setHoTen(rs.getString("HoTen"));
                int gt = rs.getInt("GioiTinh");
                boolean gioit;
                if (gt == 1) {
                    gioit = true;
                } else {
                    gioit = false;
                }
                nh.setGioiTinh(gioit);
                nh.setNgaySinh(rs.getDate("NgaySinh"));
                nh.setDienThoai(rs.getString("DienThoai"));
                nh.setEmail(rs.getString("Email"));
                nh.setNgayDangKy(rs.getDate("NgayDK"));
                nh.setGhiChu(rs.getString("GhiChu"));
                list.add(nh);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public NguoiHoc SelectByID(String ma) {
        List<NguoiHoc> list = this.selectBySql(SELECT_BY_ID_SQL, ma);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int Delete(String id) {
        try {
            return JdbcHelper.update(DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public int Update(NguoiHoc nh) {
        try {
            return JdbcHelper.update(UPDATE_SQL, nh.getHoTen(),
                    nh.getNgaySinh(), nh.isGioiTinh(), nh.getDienThoai(),
                     nh.getEmail(), nh.getGhiChu(), nh.getMaNhanVien(), nh.getNgayDangKy(), nh.getMaNguoiHoc());

        } catch (Exception ex) {
//            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public List<NguoiHoc>selectNotlnCourse(int makh,String keyword){
        String sql="select*from NguoiHoc where HoTen Like? and MaNH NOT INT(SELECT MaNH from HocVien where MaKH=?)";
        return this.selectBySql(sql, "%"+keyword+"%",makh);
    }
    
    public int Insert(NguoiHoc nh) {
        try {
            return JdbcHelper.update(INSERT_SQL, nh.getMaNguoiHoc(), nh.getHoTen(),
                    nh.getNgaySinh(), nh.isGioiTinh(), nh.getDienThoai(),
                     nh.getEmail(), nh.getGhiChu(), nh.getMaNhanVien(), nh.getNgayDangKy());
        } catch (Exception ex) {
//            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public void insert(NguoiHoc entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(NguoiHoc entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
