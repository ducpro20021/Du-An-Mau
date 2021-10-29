/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import HELPER.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ThongKeDAO {
    
    private List<Object[]>getListOfArray(String sql,String[]cols,Object...args){
        try {
            List<Object[]>list=new ArrayList<>();
            ResultSet rs=JdbcHelper.query(sql, args);
            while (rs.next()) {                
                Object[] vals=new Object[cols.length];
                for (int i = 0; i <cols.length; i++) {
                    vals[i]=rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Object[]> getNguoiHoc() {
       
        String sql="{CALL sp_ThongKeNguoiHoc}";
        String[] cols={"Nam","SoLuong","DauTien","CuoiCung"};
        return getListOfArray(sql, cols);

    }

 
    public List<Object[]> getBangDiem(Integer makh) {
       
        String sql="{CALL sp_BangDiem(?)}";
        String[] cols={"MaNH","HoTen","Diem"};
        return getListOfArray(sql, cols, makh);
    }

   
    public List<Object[]> getDiemChuyenDe()  {
        String sql="{CALL sp_ThongKeDiem}";
        String[] cols={"ChuyenDe","SoHV","ThapNhat","CaoNhat","TrungBinh"};
        return getListOfArray(sql, cols);
    }

    /*
    tổng hợp doanh thu từng chuyên đề (theo từng năm)
    @param int nam
    @return <Object[]> list : tên chuyên đề - số KH - số HV - doanh thu - HP cao nhất - HP thấp nhất - HP trung bình
     */
    public List<Object[]> getDoanhThu(Integer nam) {
        String sql="{CALL sp_ThongKeDoanhThu(?)}";
        String[] cols={"ChuyenDe","SOKH","SoHV","DoanhThu","ThapNhat","CaoNhat","TrungBinh"};
        return getListOfArray(sql, cols,nam);
    }

    
}
