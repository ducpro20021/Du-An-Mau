/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPER;

import java.awt.Color;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class utilityHelper {
    
    public static String getRank(double diem) {
        String xepLoai = "Xuất sắc";
        if (diem < 0) {
            xepLoai = "Chưa nhập";

        } else if (diem < 3) {
            xepLoai = "Kém";

        } else if (diem < 5) {
            xepLoai = "Yếu";

        } else if (diem < 6.5) {

            xepLoai = "Trung bình";

        } else if (diem < 7.5) {
            xepLoai = "Khá";

        } else if (diem < 9) {
            xepLoai = "Giỏi";

        }
        return xepLoai;
    }

    public static boolean checkMaCD(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String manv = "[a-zA-Z0-9]{1,10}";
        if (id.matches(manv)) {
            return true;
        } else {
            txt.requestFocus();
         
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải có 1-10 kí tự\nchữ hoa, thường không dấu hoặc số.");
            return false;
        }
    }

    public static boolean checkTenCD(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = ".{3,50}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.requestFocus();
         
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải từ 3-50 kí tự.");
            return false;
        }
    }

    public static boolean checkTenNV(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = ".{3,50}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.requestFocus();
           
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải từ 3-50 kí tự.");
            return false;
        }
    }

    public static boolean checkMoTaCD(JTextArea txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = ".{3,255}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.requestFocus();
           
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải từ 3-255 kí tự.");
            return false;
        }
    }

    public static boolean checkThoiLuong(JTextField txt) {
        txt.setBackground(white);
        try {
            int hour = Integer.parseInt(txt.getText());
            if (hour > 10&&hour<500) {
                return true;
            } else {
                txt.requestFocus();
               
                MsgBox.alert(txt.getRootPane(), txt.getName() + " phải lớn hơn  10 và nhỏ hơn 500.");
                return false;
            }
        } catch (NumberFormatException e) {
           
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải là số nguyên.");
            return false;
        }
    }

    public static boolean checkHocPhi(JTextField txt) {
        txt.setBackground(white);
        try {
            float hp = Float.parseFloat(txt.getText());
            if (hp >= 100000&&hp<10000000) {
                return true;
            } else {
                txt.requestFocus();
            
                MsgBox.alert(txt.getRootPane(), txt.getName() + " phải là lớn hơn bằng  100.000 nhỏ hơn 10 triệu");
                return false;
            }
        } catch (NumberFormatException e) {
            
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải là số thực.");
            return false;
        }
    }

    public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.requestFocus();
           
            MsgBox.alert(txt.getRootPane(), txt.getName() + " không được trống");
            return false;
        }
    }

    public static boolean checkNullText1(JTextArea txt) {
         txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.requestFocus();
             txt.setBackground(Color.pink);
            MsgBox.alert(txt.getRootPane(), txt.getName() + " không được trống");
            return false;
        }
    }

    public static boolean checkNullPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 0) {
            return true;
        } else {
            txt.requestFocus();
            
            MsgBox.alert(txt.getRootPane(), txt.getName() + " không được trống");
            return false;
        }
    }
    
     public static boolean checkMaNV(JTextField txt){
         txt.setBackground(white);
        String id=txt.getText();
        String manv="[a-zA-Z0-9]{1,10}";
        if(id.matches(manv)){
            return true;
        }else{
          
            txt.requestFocus();
            MsgBox.alert(txt.getRootPane(),txt.getName()+" phải có 1-10 kí tự\nchữ hoa, thường không dấu hoặc số.");
            return false;
        }
    }
}
