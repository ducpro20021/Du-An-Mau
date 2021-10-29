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
public class KhoaHocDAO extends EduSysDAO<KhoaHoc, Object> {

    String INSERT_SQL = "INSERT INTO KhoaHoc (MaKH,MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao) values(?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE KhoaHoc set MaCD=?,HocPhi=?,ThoiLuong=?,NgayKG=?,GhiChu=?,MaNV=?,NgayTao=?  WHERE MaKH=?";
    String DELETE_SQL = "DELETE FROM KhoaHoc WHERE MaKH=?";
    String SELECT_ALL_SQL = "SELECT*FROM KhoaHoc";
    String SELECT_BY_ID_SQL = "SELECT*FROM KhoaHoc WHERE MaKH=?";
    String INSERT = "INSERT INTO KhoaHoc (MaCD,HocPhi,ThoiLuong,NgayKG,GhiChu,MaNV,NgayTao) values(?,?,?,?,?,?,?)";

    @Override
    public void insert(KhoaHoc entity) {
        try {
            JdbcHelper.update(INSERT_SQL, entity.getMaKH(), entity.getMaCD(), entity.getHocPhi(),
                    entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao());
        } catch (Exception ex) {
            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KhoaHoc entity) {
        try {
            JdbcHelper.update(UPDATE_SQL, entity.getMaCD(), entity.getHocPhi(),
                    entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao(), entity.getMaKH());
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
    public KhoaHoc selectById(Object id) {
        List<KhoaHoc> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public List<KhoaHoc> selectByChuyenDe(String macd) {
        String sql = "SELECT*FROM KhoaHoc where MaCD=?";
        return this.selectBySql(sql, macd);
    }

    @Override
    protected List<KhoaHoc> selectBySql(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhoaHoc entity = new KhoaHoc();
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaCD(rs.getString("MaCD"));
                entity.setHocPhi(rs.getInt("HocPhi"));
                entity.setThoiLuong(rs.getInt("ThoiLuong"));
                entity.setNgayKG(rs.getDate("NgayKG"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayTao(rs.getDate("NgayTao"));

                list.add(entity);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public KhoaHoc SelectByID(int ma) {
        List<KhoaHoc> list = this.selectBySql(SELECT_BY_ID_SQL, ma);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int Insert(KhoaHoc entity) {
        try {
            return  JdbcHelper.update(INSERT, entity.getMaCD(), entity.getHocPhi(),
                    entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao());
        } catch (Exception ex) {
            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    public int Update(KhoaHoc entity) {
        try {
           return JdbcHelper.update(UPDATE_SQL, entity.getMaCD(), entity.getHocPhi(),
                    entity.getThoiLuong(), entity.getNgayKG(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao(), entity.getMaKH());
        } catch (Exception ex) {
            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public int Delete(Object id) {
        try {
            return JdbcHelper.update(DELETE_SQL, id);
        } catch (Exception ex) {
//            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
     public List<Integer>selectYear(){
        String sql="select distinct year(NgayKG) from KhoaHoc ORDER BY Year(NgayKG) desc";
        List<Integer> list=new ArrayList<>();
        try {
            ResultSet rs=JdbcHelper.query(sql);
            while (rs.next()) {                
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
