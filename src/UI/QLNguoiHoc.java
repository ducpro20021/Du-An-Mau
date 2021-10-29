/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.NguoiHocDAO;
import HELPER.Auth;
import MODEL.NguoiHoc;
import helper.dateHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class QLNguoiHoc extends javax.swing.JInternalFrame {

    NguoiHocDAO dao = new NguoiHocDAO();

    /**
     * Creates new form QLNguoiHoc
     */
    public QLNguoiHoc() {
        initComponents();
        init();
        this.FillTable();
    }

    public void init() {
        this.SetEndisable();
        this.btnThem.setEnabled(false);
        this.txtMaNH.setEnabled(false);
        rdoNam.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Tab = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        bntSerch = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaNH = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListNH = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtSearch2 = new javax.swing.JTextField();
        btnSerchDS = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Quản Lý Người học");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("SVN-Androgyne", 0, 11)); // NOI18N
        jLabel3.setText("Mã người học");

        bntSerch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Search.png"))); // NOI18N
        bntSerch.setText("Tìm Kiếm");
        bntSerch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSerchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(bntSerch)
                .addGap(46, 46, 46))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(bntSerch))
                    .addComponent(txtSearch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("SVN-Androgyne", 0, 11)); // NOI18N
        jLabel4.setText("Mã người học");

        jLabel5.setFont(new java.awt.Font("SVN-Androgyne", 0, 11)); // NOI18N
        jLabel5.setText("Họ và Tên");

        jLabel6.setFont(new java.awt.Font("SVN-Androgyne", 0, 11)); // NOI18N
        jLabel6.setText("Số điện thoại");

        jLabel7.setFont(new java.awt.Font("SVN-Androgyne", 0, 11)); // NOI18N
        jLabel7.setText("Giới tính");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        jLabel10.setFont(new java.awt.Font("SVN-Androgyne", 0, 11)); // NOI18N
        jLabel10.setText("Ghi chú");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Add.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Update.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/New.png"))); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SVN-Androgyne", 0, 11)); // NOI18N
        jLabel8.setText("Ngày Sinh");

        jLabel11.setFont(new java.awt.Font("SVN-Androgyne", 0, 11)); // NOI18N
        jLabel11.setText("Email");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/NguoiHojc.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNH, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(rdoNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtMaNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnThem)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tab.addTab("Cập nhật", jPanel3);

        tblListNH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NH", "Họ và tên", "Giới tính", "Ngày sinh", "Điện thoại", "Email", "Mã NV", "Ngày ĐK"
            }
        ));
        tblListNH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListNHMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblListNHMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblListNH);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("SVN-Androgyne", 0, 11)); // NOI18N
        jLabel9.setText("Nhập mã người học");

        btnSerchDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/Search.png"))); // NOI18N
        btnSerchDS.setText("Tìm Kiếm");
        btnSerchDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerchDSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSerchDS)
                .addGap(58, 58, 58))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSerchDS))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
        );

        Tab.addTab("Danh Sách", jPanel2);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tab)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tab)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.Them();
    }//GEN-LAST:event_btnThemActionPerformed

    private void bntSerchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSerchActionPerformed
        String ma = txtSearch.getText();
        if (ma.length() <= 0) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào mã chuyên đề để tìm kiếm!", "", JOptionPane.ERROR_MESSAGE);
            txtSearch.requestFocus();
            return;
        } else {
            this.TimKiem(ma);
            btnSua.setEnabled(true);
            txtMaNH.setEnabled(false);
            btnThem.setEnabled(false);
        }
    }//GEN-LAST:event_bntSerchActionPerformed

    private void btnSerchDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerchDSActionPerformed
        String ma = txtSearch2.getText();
        if (ma.length() <= 0) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào mã chuyên đề để tìm kiếm!", "", JOptionPane.ERROR_MESSAGE);
            txtSearch.requestFocus();
            return;
        } else {
            this.TimKiemInDanhSach(ma);
        }
    }//GEN-LAST:event_btnSerchDSActionPerformed

     int row=-1;
      void setForm(NguoiHoc nv){
       txtMaNH.setText(nv.getMaNguoiHoc());
      txtNgaySinh.setText(dateHelper.toString(nv.getNgaySinh()));
       txtEmail.setText(nv.getEmail());
       txtGhiChu.setText(nv.getGhiChu());
       txtTen.setText(nv.getHoTen());
       txtSDT.setText(nv.getDienThoai());
        rdoNam.setSelected(nv.isGioiTinh());
        rdoNu.setSelected(!nv.isGioiTinh());
    }
    void edit(){
        String manv=(String)tblListNH.getValueAt(row, 0);
        NguoiHoc nv=dao.selectById(manv);
        setForm(nv);
        Tab.setSelectedIndex(0);
        
    }
    private void tblListNHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListNHMouseClicked
       
    }//GEN-LAST:event_tblListNHMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.ClearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        this.Sua();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.Xoa();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblListNHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListNHMousePressed
        // TODO add your handling code here:
          if(evt.getClickCount()==2){
            row=tblListNH.getSelectedRow();
            edit();
            btnSua.setEnabled(true);
            btnThem.setEnabled(false);
        }
    }//GEN-LAST:event_tblListNHMousePressed

    private void Xoa() {
        String ma = txtMaNH.getText();
        if (ma.equals("")) {
            String mas = JOptionPane.showInputDialog(this, "Nhập mã người học", "Xóa", JOptionPane.YES_NO_CANCEL_OPTION);
            if (dao.Delete(mas) > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công.");
                FillTable();
                ClearForm();
            } else if (mas == null) {
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Sai mã người học", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            int a = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa người học  này không", "Xóa", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                if (dao.Delete(ma) > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công.");
                    FillTable();
                    ClearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Kiểm tra lại thông tin!");
                    txtMaNH.requestFocus();
                }
            }
        }
    }

    void FillTable() {
        DefaultTableModel mol = (DefaultTableModel) tblListNH.getModel();
        List<NguoiHoc> ls = dao.selectAll();
        mol.setRowCount(0);
        for (NguoiHoc nh : ls) {
            mol.addRow(new Object[]{nh.getMaNguoiHoc(), nh.getHoTen(), this.GioiTinh(nh.isGioiTinh()),  dateHelper.toString(nh.getNgaySinh()), nh.getDienThoai(), nh.getEmail(), nh.getMaNhanVien(),  dateHelper.toString(nh.getNgayDangKy())});
        }

    }

    private String GioiTinh(boolean gt) {
        if (gt == true) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    void TimKiem(String ma) {
        NguoiHoc nh = dao.SelectByID(ma);
        if (nh == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy.");
            txtSearch.requestFocus();
            return;
        } else {
            SetForm(nh);
        }
    }

    private void SetForm(NguoiHoc nh) {
        txtMaNH.setText(nh.getMaNguoiHoc());
        txtTen.setText(nh.getHoTen());
        txtNgaySinh.setText(String.valueOf(nh.getNgaySinh()));
        txtSDT.setText(nh.getDienThoai());
        txtGhiChu.setText(nh.getGhiChu());
        txtEmail.setText(nh.getEmail());
        if (nh.isGioiTinh() == true) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        btnThem.setEnabled(false);
    }

    private void TimKiemInDanhSach(String ma) {
        NguoiHoc nh = dao.SelectByID(ma);
        List<NguoiHoc> ls = dao.selectAll();
        int index = -1;

        if (nh == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy.");
            txtSearch.requestFocus();
            return;
        } else {
            for (int i = 0; i < ls.size(); i++) {
                if (nh.getMaNguoiHoc().equals(ls.get(i).getMaNguoiHoc())) {
                    index = i;
                }
            }
            tblListNH.setRowSelectionInterval(index, index);
        }
    }

    public void SetEndisable() {
        Auth auth = new Auth();
        if (!auth.isManager()) {
            btnXoa.setEnabled(false);
        }
    }

    private void ClearForm() {
        txtEmail.setText("");
        txtGhiChu.setText("");
        txtMaNH.setText("");
        txtNgaySinh.setText("");
        txtSDT.setText("");
        txtTen.setText("");
        rdoNam.setSelected(true);

        btnSua.setEnabled(false);
        btnThem.setEnabled(true);
        txtMaNH.setEnabled(true);
    }

    private void MouseClickedEven() {
        int index = tblListNH.getSelectedRow();
        List<NguoiHoc> ls = dao.selectAll();
        NguoiHoc nhs = ls.get(index);
        SetForm(nhs);
        Tab.setSelectedIndex(0);
        btnSua.setEnabled(true);
        btnThem.setEnabled(false);
        txtMaNH.setEnabled(false);
    }

    private NguoiHoc GetForm() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date now = new Date();
        String date = sdf.format(now);
        String sn = String.valueOf(txtNgaySinh.getText());

        NguoiHoc nh = new NguoiHoc();
        nh.setMaNguoiHoc(txtMaNH.getText());
        nh.setHoTen(txtTen.getText());
        nh.setGioiTinh(this.LayGioiTinh());
        nh.setNgaySinh(sdf.parse(sn));
        nh.setDienThoai(txtSDT.getText());
        nh.setEmail(txtEmail.getText());
        nh.setGhiChu(txtGhiChu.getText());
        nh.setNgayDangKy(sdf.parse(date));
        nh.setMaNhanVien(Auth.user.getMaNV());
        return nh;

    }

    private boolean LayGioiTinh() {
        if (rdoNam.isSelected() == true) {
            return true;
        } else {
            return false;
        }
    }

    private void Sua() {
        String rgsdt = "(0)\\d{9}";
        String rgEmail = "\\w+@\\w+.\\w+";
        String rdten = "^\\pL+[\\pL\\pZ\\pP]{0,}$";
        String rgMa = "(NH)\\d{2,8}";
        String rgNgay = "(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)"
                + "(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d"
                + "{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0"
                + "[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])"
                + "00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

        if (txtTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào tên");
            txtTen.requestFocus();
            return;
        } else if (txtTen.getText().matches(rdten) == false) {
            JOptionPane.showMessageDialog(this, "Họ và tên không hợp lệ.", "", JOptionPane.ERROR_MESSAGE);
            txtTen.requestFocus();
            return;
        } else if (txtNgaySinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào ngày sinh");
            txtNgaySinh.requestFocus();
            return;
        } else if (txtNgaySinh.getText().matches(rgNgay) == false) {
            JOptionPane.showMessageDialog(this, "Ngày không hợp lệ", "", JOptionPane.ERROR_MESSAGE);
            txtNgaySinh.requestFocus();
            return;
        } else if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào số điện thoại");
            txtSDT.requestFocus();
            return;
        } else if (txtSDT.getText().matches(rgsdt) == false) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ", "", JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return;
        } else if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào email");
            txtEmail.requestFocus();
            return;
        } else if (txtEmail.getText().matches(rgEmail) == false) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ");
            txtEmail.requestFocus();
            return;
        } else {
            try {
                NguoiHoc nh = this.GetForm();
                if (dao.Update(nh) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    FillTable();
                    ClearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại, kiểm tra lại thông tin", "Sửa thông tin", JOptionPane.ERROR_MESSAGE);
                    txtMaNH.requestFocus();
                    return;
                }
            } catch (ParseException ex) {
                Logger.getLogger(QLNguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void Them() {
        String rgsdt = "(0)\\d{9}";
        String rgEmail = "\\w+@\\w+.\\w+";
        String rdten = "^\\pL+[\\pL\\pZ\\pP]{0,}$";
        String rgMa = "(NH)\\d{2,8}";
        String rgNgay = "(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)"
                + "(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d"
                + "{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0"
                + "[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])"
                + "00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

        if (txtMaNH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào mã người học");
            txtMaNH.requestFocus();
            return;
        } else if (txtMaNH.getText().matches(rgMa) == false) {
            JOptionPane.showMessageDialog(this, "Mã người học không hợp lệ)", "", JOptionPane.ERROR_MESSAGE);
            txtMaNH.requestFocus();
            return;
        } else if (txtTen.equals("")) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào tên");
            txtTen.requestFocus();
            return;
        } else if (txtTen.getText().matches(rdten) == false) {
            JOptionPane.showMessageDialog(this, "Họ và tên không hợp lệ.", "", JOptionPane.ERROR_MESSAGE);
            txtTen.requestFocus();
            return;
        } else if (txtNgaySinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào ngày sinh");
            txtNgaySinh.requestFocus();
            return;
        } else if (txtNgaySinh.getText().matches(rgNgay) == false) {
            JOptionPane.showMessageDialog(this, "Ngày không hợp lệ", "", JOptionPane.ERROR_MESSAGE);
            txtNgaySinh.requestFocus();
            return;
        } else if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào số điện thoại");
            txtSDT.requestFocus();
            return;
        } else if (txtSDT.getText().matches(rgsdt) == false) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ", "", JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return;
        } else if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Phải nhập vào email");
            txtEmail.requestFocus();
            return;
        } else if (txtEmail.getText().matches(rgEmail) == false) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ");
            txtEmail.requestFocus();
            return;
        } else {
            try {
                NguoiHoc nh = this.GetForm();
                if (dao.Insert(nh) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    FillTable();
                    ClearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại, kiểm tra lại mã người học", "Thêm người học", JOptionPane.ERROR_MESSAGE);
                    txtMaNH.requestFocus();
                    return;
                }
            } catch (ParseException ex) {
                Logger.getLogger(QLNguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tab;
    private javax.swing.JButton bntSerch;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSerchDS;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblListNH;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaNH;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
