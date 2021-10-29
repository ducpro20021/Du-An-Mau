
package UI;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ManHinhChao extends javax.swing.JDialog {

    public ManHinhChao(java.awt.Frame parent, boolean modal) {
         super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
      ChayPhanTram();
    }

     
  
    public void ChayPhanTram() {
         Thread t=new Thread(){
                int i=-1;
          @Override
          public void run(){
              while(true){
                  try {
                      i++;
                      ProgessBar.setValue(i);
                     
                      if(i==50)jLabel1.setText("");
                      if(i==90)jLabel1.setText("");
                      if(i==100){
                         ManHinhChao.this.dispose();   //đóng ChaoJDialog
                         break; 
                      }
                      Thread.sleep(20);   //thread tạm dừng hoạt động trong 20 ms
                  } catch (InterruptedException ex) {
                      break;
                  }
              }
          }  
        };
        t.start();       //t
      
//        DangNhapJDialog a=new DangNhapJDialog();
//        a.setVisible(true);
        
       
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ProgessBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProgessBar.setBackground(new java.awt.Color(0, 0, 255));
        ProgessBar.setForeground(new java.awt.Color(0, 0, 255));
        ProgessBar.setStringPainted(true);
        jPanel1.add(ProgessBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 700, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/backgroundlogin_1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//     public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManHinhChao(new javax.swing.JFrame(),true).setVisible(true);
//            }
//        });
//    }
//    public static void main(String args[]) {
//        ManHinhChao mh = new ManHinhChao();
//        mh.setSize(685, 437);
//        mh.setVisible(true);
//        mh.ChayPhanTram();
//        mh.dispose();
//        
//        
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgessBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
