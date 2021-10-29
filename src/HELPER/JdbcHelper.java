/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class JdbcHelper {
    static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl="jdbc:sqlserver://localhost\\LAPTOP-TH531KEO\\SQLEXPRESS:1433;databaseName=SOF2041";
    static String user="sa";
    static String pass="11102002";
    
    static{
        try {
            Class.forName(driver);
        } catch (Exception e) {
        }
    }
    
    public static PreparedStatement getStmt(String sql,Object...args) throws SQLException{
        
       Connection conn=DriverManager.getConnection(dburl, user, pass);
       PreparedStatement pstm;
       if(sql.trim().startsWith("{")){
           pstm=conn.prepareCall(sql);
       }else{
           pstm=conn.prepareStatement(sql);
       }
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i+1,args[i]);
        }
        return pstm;
        
    }
    
    public static int update(String sql,Object...args) throws Exception{
        try {
            PreparedStatement pstm=JdbcHelper.getStmt(sql, args);
            try {
                return pstm.executeUpdate();
            } 
            finally{
                pstm.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static ResultSet query(String sql,Object...args) throws Exception{
        try {
                 PreparedStatement pstm=JdbcHelper.getStmt(sql, args);
                 try {
                return  pstm.executeQuery();
            } finally{
                     
                 }
        } catch (Exception e) {
            throw  new Exception(e);
        }
   
        
    }
    
    public static Object value(String sql,Object...args){
        try {
            ResultSet rs=JdbcHelper.query(sql,args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return  null;
        } catch (Exception e) {
            throw new RuntimeException(e);
           
        }
    } 
}
