/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.NhanVienDao;
import HELPER.*;
import HELPER.MsgBox;
import MODEL.NhanVien;
import java.awt.Color;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class NhanVienInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form NhanVienInternalFrame
     */
    NhanVienDao dao=new NhanVienDao();
    int row=-1;
    public NhanVienInternalFrame() {
        initComponents();
        init();
    }
    
    
    void init(){
        this.fillTable();
        this.row=-1;
        updateStatus();
    }
    void fillTable(){
        DefaultTableModel model=(DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list=dao.selectAll();
            for(NhanVien nv:list){
                Object[] row={
                    nv.getMaNV(),nv.getHoTen(),
                    nv.isVaiTro()?"Trưởng phòng":"Nhân viên",nv.getTrangThai()?"Hoạt động":"Không hoạt động"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    void setForm(NhanVien nv){
        txtMaNV.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());
        txtMatKhau.setText(nv.getMatKhau());
        txtXacNhanMatKhau.setText(nv.getMatKhau());
        rdbTruongPhong.setSelected(nv.isVaiTro());
        rdbNhanVien.setSelected(!nv.isVaiTro());
         cboHD.setSelected(nv.getTrangThai());
        cboKHD.setSelected(!nv.getTrangThai());
    }
    
    NhanVien getForm(){
        NhanVien nv=new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setHoTen(txtHoTen.getText());
        nv.setMatKhau(new String(txtMatKhau.getPassword()));
        nv.setVaiTro(rdbTruongPhong.isSelected());
        nv.setTrangThai(cboHD.isSelected());
        return nv;
    }
    
    void edit(){
        String manv=(String)tblNhanVien.getValueAt(row, 0);
        NhanVien nv=dao.selectById(manv);
        setForm(nv);
        tabs.setSelectedIndex(0);
        updateStatus();
    }
    void insert(){
        NhanVien nv=getForm();
        String mk2=new String(txtXacNhanMatKhau.getPassword());
        if(!mk2.equals(nv.getMatKhau())){
             txtXacNhanMatKhau.setBackground(Color.red);
            MsgBox.alert(this, "Xác nhận mật khẩu không đúng");
        }
        else{
            try {
                dao.insert(nv);
                fillTable();
                clearForm();
                MsgBox.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại!");
            }
        }
    }
    
    void update(){
      
            NhanVien nv = getForm();
            String MK2 = new String(txtXacNhanMatKhau.getPassword());
            String maNV=txtMaNV.getText();
            if (!MK2.equals(nv.getMatKhau())) {
                txtXacNhanMatKhau.requestFocus();
                MsgBox.alert(this, "Xác nhận mật khẩu không đúng");
            } else {
                try {
                    if(Auth.user.getMaNV().equals(maNV)||Auth.isManager()){
                        dao.update(nv);
                    fillTable();
                    MsgBox.alert(this, "Cập nhật thành công");
                    }else{
                        MsgBox.alert(this, "Không được sửa");
                    }
                    
                } catch (Exception e) {
                    MsgBox.alert(this, "Cập nhật thất bại!");
                }
            }
        

        
        
    }
    
    void updateStatus(){
       NhanVien nv = getForm();
        if (nv.getTrangThai()==true) {
            boolean edit = (this.row >= 0);
            if (!Auth.isManager()) {
                rdbNhanVien.setEnabled(false);
                rdbTruongPhong.setEnabled(false);
                cboHD.setEnabled(false);
                cboKHD.setEnabled(false);
                
            }
            btnInsert.setEnabled(!edit);
            btnUpdate.setEnabled(edit);
            
        }else if(nv.getTrangThai()==false){
            btnInsert.setEnabled(false);
            btnUpdate.setEnabled(false);
        }
       
        
        


        
        
//        txtHoTen.setEditable(!edit);
//        txtMatKhau.setEditable(!edit);
       
        
    }
    
    void clearForm(){
        NhanVien nv=new NhanVien();
        setForm(nv);
        row=-1;
        txtMaNV.setBackground(Color.white);
        txtXacNhanMatKhau.setBackground(Color.white);
        txtHoTen.setBackground(Color.white);
        updateStatus();
    }
    
   
    
    void delete(){
        if(!Auth.isManager()){
            MsgBox.alert(this, "Bạn không có quyền đổi trạng thái nhân viên!");
        }
        else{
            String manv=txtMaNV.getText();
            if(manv.equals(Auth.user.getMaNV())){
                MsgBox.alert(this, "Bạn không được đổi trạng thái chính bạn!");
            }
            else if(MsgBox.cofirm(this, "Bạn có thực sự đổi trạng thái nhân viên này?")){
                try {
                    NhanVien nv=getForm();
                    dao.update(nv);
                    fillTable();
                    MsgBox.alert(this, "Đổi trạng thái thành công!");
                } catch (Exception e) {
                    MsgBox.alert(this, "Đổi trạng thất bại!");
                }
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtXacNhanMatKhau = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdbTruongPhong = new javax.swing.JRadioButton();
        rdbNhanVien = new javax.swing.JRadioButton();
        btnInsert = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        cboHD = new javax.swing.JRadioButton();
        cboKHD = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Mã nhân viên");

        txtMaNV.setName("mã nhân viên"); // NOI18N

        jLabel2.setText("Mật khẩu");

        txtMatKhau.setName("Mật khẩu"); // NOI18N

        jLabel3.setText("Xác  nhận mật khẩu");

        txtXacNhanMatKhau.setName("Xác nhận mật khẩu"); // NOI18N

        jLabel4.setText("Họ tên");

        txtHoTen.setName("Họ tên"); // NOI18N

        jLabel5.setText("Vai trò");

        buttonGroup1.add(rdbTruongPhong);
        rdbTruongPhong.setText("Trưởng phòng");

        buttonGroup1.add(rdbNhanVien);
        rdbNhanVien.setText("Nhân viên");

        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Add.png"))); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        jLabel7.setText("Trạng thái");

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Update.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/New.png"))); // NOI18N
        btnNew.setText("Làm mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        buttonGroup2.add(cboHD);
        cboHD.setSelected(true);
        cboHD.setText("Hoạt động");

        buttonGroup2.add(cboKHD);
        cboKHD.setText("Không hoạt động");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(txtXacNhanMatKhau)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMaNV)
                                .addComponent(txtMatKhau))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNew))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdbTruongPhong)
                                .addGap(18, 18, 18)
                                .addComponent(rdbNhanVien)))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboHD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboKHD)))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbTruongPhong)
                    .addComponent(rdbNhanVien)
                    .addComponent(cboHD)
                    .addComponent(cboKHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnNew))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        tabs.addTab("Cập nhật", jPanel1);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ tên", "Vai Trò", "Trạng thái"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhanVienMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", jPanel2);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("QUẢN LÝ NHÂN VIÊN QUẢN TRỊ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/back.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   public boolean checkTrungMa(JTextField txt) {

        if (dao.selectById(txt.getText()) == null) {
            return true;
        } else {
            txt.setBackground(Color.red);
            MsgBox.alert(this, txt.getName() + " đã bị tồn tại.");
            return false;
        }
    }
   
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        if(utilityHelper.checkNullText(txtMaNV)&utilityHelper.checkNullPass(txtMatKhau)
                &&utilityHelper.checkNullPass(txtXacNhanMatKhau)&&utilityHelper.checkNullText(txtHoTen)){
            if(utilityHelper.checkMaNV(txtMaNV)&&utilityHelper.checkTenNV(txtHoTen)){
                if(checkTrungMa(txtMaNV)){
                     insert();
                }
            }
        }
       
    }//GEN-LAST:event_btnInsertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
      if(utilityHelper.checkNullPass(txtMatKhau)
                &&utilityHelper.checkNullPass(txtXacNhanMatKhau)&&utilityHelper.checkNullText(txtHoTen)){
          update();
          fillTable();
      }
       
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void tblNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            row=tblNhanVien.getSelectedRow();
            edit();
            if(!Auth.isManager()){
                String manv = txtMaNV.getText();
                if (manv.equals(Auth.user.getMaNV())) {
                    txtHoTen.setEditable(true);
                    txtMatKhau.setEditable(true);
                    txtXacNhanMatKhau.setEditable(true);

            }else {
                txtHoTen.setEditable(false);
                txtMaNV.setEditable(false);
                txtMatKhau.setEditable(false);
                txtXacNhanMatKhau.setEditable(false);
            }
            }
            else if(Auth.isManager()){
                rdbNhanVien.setEnabled(true);
                rdbTruongPhong.setEnabled(true);
                cboHD.setEnabled(true);
                cboKHD.setEnabled(true);
                 txtMaNV.setEditable(false);
            }
           
           
        }
    }//GEN-LAST:event_tblNhanVienMousePressed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton cboHD;
    private javax.swing.JRadioButton cboKHD;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbNhanVien;
    private javax.swing.JRadioButton rdbTruongPhong;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables
}
