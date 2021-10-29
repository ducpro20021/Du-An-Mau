/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import java.util.List;
import MODEL.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class NhanVienDao extends EduSysDAO<NhanVien, Object>{
String INSERT_SQL="INSERT INTO NhanVien(MaNV,MatKhau,HoTen,VaiTro,TrangThai) values(?,?,?,?,?)";
String UPDATE_SQL="UPDATE NhanVien set MatKhau=?,HoTen=?,VaiTro=?,TrangThai=? WHERE MaNV=?";
String DELETE_SQL="DELETE FROM NhanVien WHERE MaNV=?";
String SELECT_ALL_SQL="SELECT*FROM NhanVien";
String SELECT_BY_ID_SQL="SELECT*FROM NhanVien WHERE MaNV=?";

    @Override
    public void insert(NhanVien entity) {
    try {
        JdbcHelper.update(INSERT_SQL, entity.getMaNV(),entity.getMatKhau(),
                entity.getHoTen(),entity.isVaiTro(),entity.getTrangThai());
    } catch (Exception ex) {
        Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void update(NhanVien entity) {
         try {
        JdbcHelper.update(UPDATE_SQL,entity.getMatKhau(),
                entity.getHoTen(),entity.isVaiTro(),entity.getTrangThai(), entity.getMaNV());
    } catch (Exception ex) {
        Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void delete(Object id) {
    try {
        JdbcHelper.update(DELETE_SQL, id);
    } catch (Exception ex) {
        Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
     @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien>list=new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                entity.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(entity);
            
        }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }


    @Override
    public NhanVien selectById(Object id) {
      List<NhanVien>list=this.selectBySql(SELECT_BY_ID_SQL, id);
      if(list.isEmpty()){
          return null;
      }
      return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
       return this.selectBySql(SELECT_ALL_SQL);
    }

   
    
    
}
