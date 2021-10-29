/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import HELPER.JdbcHelper;
import MODEL.ChuyenDe;
import MODEL.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class chuyenDeDAO extends EduSysDAO<ChuyenDe, Object>{

    String INSERT_SQL = "INSERT INTO ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) values(?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE ChuyenDe set TenCD=?,HocPhi=?,ThoiLuong=?,Hinh=?,MoTa=? WHERE MaCD=?";
    String DELETE_SQL = "DELETE FROM ChuyenDe WHERE MaCD=?";
    String SELECT_ALL_SQL = "SELECT*FROM ChuyenDe";
    String SELECT_BY_ID_SQL = "SELECT*FROM ChuyenDe WHERE MaCD=?";

    @Override
    public void insert(ChuyenDe entity) {
        try {
            JdbcHelper.update(INSERT_SQL, entity.getMaCD(),entity.getTenCD()
                    ,entity.getHocPhi(),entity.getThoiLuong(),entity.getHinh(),entity.getMoTa());
        } catch (Exception ex) {
            Logger.getLogger(chuyenDeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ChuyenDe entity) {
        try {
            JdbcHelper.update(UPDATE_SQL,entity.getTenCD()
                    ,entity.getHocPhi(),entity.getThoiLuong(),entity.getHinh(),entity.getMoTa(),entity.getMaCD());
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
    public ChuyenDe selectById(Object id) {
      List<ChuyenDe>list=this.selectBySql(SELECT_BY_ID_SQL, id);
      if(list.isEmpty()){
          return null;
      }
      return list.get(0);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<ChuyenDe> selectBySql(String sql, Object... args) {
       List<ChuyenDe>list=new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChuyenDe entity = new ChuyenDe();
                entity.setMaCD(rs.getString("MaCD"));
                entity.setTenCD(rs.getString("TenCD"));
                entity.setHocPhi(rs.getDouble("HocPhi"));
                entity.setThoiLuong(rs.getInt("ThoiLuong"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setMoTa(rs.getString("MoTa"));
                list.add(entity);
            
        }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
