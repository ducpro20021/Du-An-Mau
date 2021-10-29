/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class GioiThieu extends javax.swing.JInternalFrame {
    int i = -1;

    public GioiThieu() {
        initComponents();
        this.setForm();
    }
    
    public void setForm() {
        if (i == -1) {
            btnPrev.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lblhinh = new javax.swing.JLabel();
        lblText1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblText2 = new javax.swing.JLabel();

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageIcon/back.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setToolTipText("");

        btnPrev.setText("Quay Lại");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText("Tiếp");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblhinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblhinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/BackgroundPoly.png"))); // NOI18N

        lblText1.setText("Phần mềm EduSys là phần mềm quản lí các khóa học theo chuyên đề .");

        jLabel4.setFont(new java.awt.Font("SVN-Androgyne", 1, 24)); // NOI18N
        jLabel4.setText("Giới thiệu");

        lblText2.setText("Được tạo ra bởi nhóm sinh viên bao gồm: Hà Trung Kiên, Nguyễn Trung Đức , Phạm Nguyên Đức");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblText1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblText2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblhinh, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack)))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblhinh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblText1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnNext))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        i++;
        String hinh = null;
        hinh = "gioithieu" + i + ".jpg";
        this.SetHinh(hinh);
        if (i >= 2) {
            btnNext.setEnabled(false);
        }
        btnPrev.setEnabled(true);
        if (i == 0) {
            lblText1.setLocation(300, 500);
            lblText1.setText("Hệ thống được quản lí chặt chẽ");
            lblText2.setText("");
        }
        if (i == 1) {
            lblText1.setText("Các tính năng sử dụng dễ dàng");
        } else if (i == 2) {
            lblText1.setText("Có tính bảo mật cao");
        }
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        String hinh = null;
        hinh = "gioithieu" + (i - 1) + ".jpg";
        this.SetHinh(hinh);
        i--;
        if (i < 0) {
            btnPrev.setEnabled(false);
            this.SetHinh("BackgroundPoly.png");
            lblText1.setText("Phần mềm EduSys là phần mềm quản lí các khóa học theo chuyên đề.");
            lblText2.setText("Được tạo ra bởi nhóm sinh viên bao gồm: Hà Trung Kiên, Nguyễn Trung Đức , Phạm Nguyên Đức");
        }
        btnNext.setEnabled(true);
        if (i == 0) {
            lblText1.setText("Hệ thống được quản lí chặt chẽ");
            lblText2.setText("");
        }
        if (i == 1) {
            lblText1.setText("Các tính năng sử dụng dễ dàng");
        } else if (i == 2) {
            lblText1.setText("Có tính bảo mật cao");
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    public void SetHinh(String ten) {
        ImageIcon image = new ImageIcon("D:\\Du an mau\\DucNT\\src\\Image\\" + ten);
        lblhinh.setIcon(image);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblText1;
    private javax.swing.JLabel lblText2;
    private javax.swing.JLabel lblhinh;
    // End of variables declaration//GEN-END:variables
}
