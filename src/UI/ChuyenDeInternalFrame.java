/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.*;
import HELPER.*;
import HELPER.XImage;
import MODEL.ChuyenDe;
import MODEL.KhoaHoc;
import java.awt.Color;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ChuyenDeInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form ChuyenDeInternalFrame
     */
   JFileChooser fileChoose=new JFileChooser();
   chuyenDeDAO dao=new chuyenDeDAO();
   ChuyenDe cd=new ChuyenDe();
   KhoaHocDAO khdao=new KhoaHocDAO();
   int row=-1;
    public ChuyenDeInternalFrame() {
        initComponents();
        init();
        
    }
    
    void init(){
        fillTable();
        updateStatus();
        row=-1;
    }

    void chonAnh(){
        if(fileChoose.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File file=fileChoose.getSelectedFile();
            XImage.save(file);
            ImageIcon icon=XImage.read(file.getName());
            lblAnh.setIcon(icon);
            lblAnh.setToolTipText(file.getName());
        }
    }
    
    
    void updateStatus() {
       boolean edit=(this.row>=0);
       txtMaCD.setEditable(!edit);
       btnInsert.setEnabled(!edit);
       btnUpdate.setEnabled(edit);
       btnDelete.setEnabled(edit);
       
    }
    
    void setForm(ChuyenDe cd){
        txtMaCD.setText(cd.getMaCD());
        txtTenCD.setText(cd.getTenCD());
        txtThoiLuong.setText(String.valueOf(cd.getThoiLuong()));
        txtHocPHi.setText(String.valueOf(cd.getHocPhi()));
        txtMoTa.setText(cd.getMoTa());
        if(cd.getHinh()!=null){
            lblAnh.setToolTipText(cd.getHinh());
            lblAnh.setIcon(XImage.read(cd.getHinh()));
        }
        
      
    }
      ChuyenDe getForm(){
        ChuyenDe cd=new ChuyenDe();
        cd.setMaCD(txtMaCD.getText());
        cd.setTenCD(txtTenCD.getText());
        cd.setThoiLuong(Integer.valueOf(txtThoiLuong.getText()));
        cd.setHocPhi(Double.valueOf(txtHocPHi.getText()));
        cd.setMoTa(txtMoTa.getText());
        cd.setHinh(lblAnh.getToolTipText());
        return cd;
    }
      
      
      void fillTable(){
        DefaultTableModel model=(DefaultTableModel) tblChuyenDe.getModel();
        model.setRowCount(0);
        try {
            List<ChuyenDe> list=dao.selectAll();
            for(ChuyenDe nv:list){
                Object[] row={
                    nv.getMaCD(),nv.getTenCD(),
                    nv.getHocPhi()+"",nv.getThoiLuong(),nv.getHinh(),
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
      
       void edit(){
        String manv=(String)tblChuyenDe.getValueAt(row, 0);
        ChuyenDe nv=dao.selectById(manv);
        setForm(nv);
        tabs.setSelectedIndex(0);
        updateStatus();
    }
       
       
       
      
        void insert() {
        ChuyenDe nv = getForm();

        try {

            if (Auth.user.getTrangThai() == false) {
                MsgBox.alert(this, "Không có quyền vì trạng thái của bạn là không hoạt động");
            } else {
                if (nv.getHinh() == null) {
                    MsgBox.alert(this, "bạn chưa chọn hình");
                } else {
                    dao.insert(nv);
                    fillTable();
                    clearForm();
                    MsgBox.alert(this, "Thêm mới thành công!");
                }
            }
            

        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại!");
        }
    }
        
        
        void update(){
        ChuyenDe nv=getForm();
       
            try {
                dao.update(nv);
                fillTable();
                clearForm();
                MsgBox.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "cập nhật thất bại!");
            }
        }
        
         void delete() {
             ChuyenDe cd1=getForm();
           String macd = txtMaCD.getText();
            List<KhoaHoc> kh1=khdao.selectByChuyenDe(macd);
        if (MsgBox.cofirm(this, "Bạn có muốn xóa hay không?")) {
            
            KhoaHoc kh=new KhoaHoc();
             
             
            try {
                if (kh1.isEmpty()) {
                    
                    dao.delete(macd);
                    fillTable();
                    clearForm();
                    MsgBox.alert(this, "Xóa thành công!");
                } else {
                    MsgBox.alert(this, "Không được xóa vì chuyên để đã có khóa học");
                }
              
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại!");
            }
        }
    }
        void clearForm(){
            ChuyenDe cd=new ChuyenDe();
            setForm(cd);
            row=-1;
            updateStatus();
           
    }
        private String LayMaCD(String ten) {
        List<ChuyenDe> ls = dao.selectAll();
        String ma = null;
        for (int i = 0; i < ls.size(); i++) {
            if (ten.equals(ls.get(i).getTenCD())) {
                ma = ls.get(i).getMaCD();
            }
        }
        return ma;
    }
        public boolean checkTrungMa(JTextField txt) {

        if (dao.selectById(txt.getText()) == null) {
            return true;
        } else {
            txt.requestFocus();
            txt.setBackground(Color.red);
            MsgBox.alert(this, txt.getName() + " đã bị tồn tại.");
            return false;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaCD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenCD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHocPHi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChuyenDe = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setText("Mã chuyên đề");

        txtMaCD.setName("mã chuyên đề"); // NOI18N

        jLabel2.setText("Tên chuyên đề");

        txtTenCD.setName("tên chuyên đề"); // NOI18N

        jLabel3.setText("Học phí");

        txtHocPHi.setName("học phí"); // NOI18N

        jLabel4.setText("Thời lượng");

        txtThoiLuong.setName("thời lượng"); // NOI18N

        jLabel5.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        txtMoTa.setName("mô tả"); // NOI18N
        jScrollPane1.setViewportView(txtMoTa);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setText("Hình logo");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/New.png"))); // NOI18N
        jButton2.setText("Mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Add.png"))); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Update.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtThoiLuong)
                            .addComponent(txtHocPHi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenCD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaCD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHocPHi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(29, 29, 29))
        );

        tabs.addTab("Danh sách", jPanel1);

        tblChuyenDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã CD", "Tên CD", "Học Phí", "Thời lượng", "Hình"
            }
        ));
        tblChuyenDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblChuyenDeMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblChuyenDe);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Cập nhật", jPanel2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/back.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("QUẢN LÝ CHUYÊN ĐỀ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblChuyenDeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuyenDeMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            row=tblChuyenDe.getSelectedRow();
            edit();
        }
    }//GEN-LAST:event_tblChuyenDeMousePressed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        if (utilityHelper.checkNullText(txtMaCD) && utilityHelper.checkNullText(txtTenCD)
                && utilityHelper.checkNullText(txtHocPHi) && utilityHelper.checkNullText(txtThoiLuong)&&utilityHelper.checkNullText1(txtMoTa)) {
            if (utilityHelper.checkMaCD(txtMaCD) && utilityHelper.checkTenCD(txtTenCD) && utilityHelper.checkHocPhi(txtHocPHi)
                    && utilityHelper.checkThoiLuong(txtThoiLuong) && utilityHelper.checkMoTaCD(txtMoTa)) {
                if (checkTrungMa(txtMaCD)) {
                    insert();
                }
            }
        }
       
    }//GEN-LAST:event_btnInsertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        // TODO add your handling code here:
        chonAnh();
    }//GEN-LAST:event_lblAnhMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (utilityHelper.checkNullText(txtTenCD)
                && utilityHelper.checkNullText(txtHocPHi) && utilityHelper.checkNullText(txtThoiLuong) && utilityHelper.checkNullText1(txtMoTa)) {
            if (utilityHelper.checkTenCD(txtTenCD) && utilityHelper.checkHocPhi(txtHocPHi)
                    && utilityHelper.checkThoiLuong(txtThoiLuong) && utilityHelper.checkMoTaCD(txtMoTa)) {
                update();
                fillTable();
            }
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblChuyenDe;
    private javax.swing.JTextField txtHocPHi;
    private javax.swing.JTextField txtMaCD;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenCD;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
