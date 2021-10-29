/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class HocVienDAO extends EduSysDAO<HocVien, Object> {

    String INSERT_SQL = "INSERT INTO HocVien(MaHV,MaKH,MaNH,Diem) values(?,?,?,?)";
    String UPDATE_SQL = "UPDATE HocVien set MaKH=?,MaNH=?,Diem=? WHERE MaHV=?";
    String DELETE_SQL = "DELETE FROM HocVien WHERE MaHV=?";
    String SELECT_ALL_SQL = "SELECT*FROM HocVien";
    String SELECT_BY_ID_SQL = "SELECT*FROM HocVien WHERE MaHV=?"; 
    String INSERT = "INSERT INTO HocVien(MaKH,MaNH,Diem) values(?,?,?)";
    String UPDATE_Diem = "Update HocVien set Diem = ? where MaHV = ?";

    @Override
    public void insert(HocVien entity) {
        try {
            JdbcHelper.update(INSERT_SQL, entity.getMaHV(), entity.getMaKH(), entity.getMaNH(), entity.getDiem());
        } catch (Exception ex) {
            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HocVien entity) {
        try {
            JdbcHelper.update(UPDATE_SQL, entity.getMaKH(), entity.getMaNH(), entity.getDiem(), entity.getMaHV());
        } catch (Exception ex) {
            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object id) {
        try {
            JdbcHelper.update(DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HocVien selectById(Object id) {
        List<HocVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HocVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<HocVien> selectBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HocVien entity = new HocVien();
                entity.setMaHV(rs.getInt("MaHV"));
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaNH(rs.getString("MaNH"));
                entity.setDiem(rs.getFloat("Diem"));

                list.add(entity);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<HocVien> selectByKhoaHoc(Integer makh) {
        String sql = "SELECT*FROM HocVien where MaKH=?";
        return this.selectBySql(sql, makh);
    }
    
    public int Insert(HocVien entity) {
        try {
            return JdbcHelper.update(INSERT, entity.getMaKH(), entity.getMaNH(), entity.getDiem());
        } catch (Exception ex) {
            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public int Delete(Object id) {
        try {
            return JdbcHelper.update(DELETE_SQL, id);
        } catch (Exception ex) {
            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    public int Update(HocVien entity) {
        try {
           return JdbcHelper.update(UPDATE_Diem,entity.getDiem(), entity.getMaHV());
        } catch (Exception ex) {
            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    

}
