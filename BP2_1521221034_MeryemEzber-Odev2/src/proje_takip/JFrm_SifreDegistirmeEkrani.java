/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje_takip;

import java.awt.Toolkit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class JFrm_SifreDegistirmeEkrani extends javax.swing.JFrame {

    /**
     * Creates new form JFrm_SifreDegistir
     */
    Yonetici_1 y_logined;
    Calisan_1 c_logined;

    public JFrm_SifreDegistirmeEkrani() {
        initComponents();
        setTitle("Şifre Değiştirme Ekranı");
        Toolkit kit = Toolkit.getDefaultToolkit();
        int EkranY = (int) kit.getScreenSize().width; //Ekran boyutunun genişliğini alıyoruz...
        int EkranX = (int) kit.getScreenSize().height;//Ekran boyutunun yüksekliğini alıyoruz...
        this.setSize(413, 430); // Pencere boyutunu belirliyoruz...
        this.setLocation((EkranY - 413) / 2, (EkranX - 430) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxt_kullaniciId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPassword_eskiSifre = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPassword_yeniSifre = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kullanıcı Id :");

        jLabel2.setText("Eski Şifre :");

        jButton1.setText("Şifre Değiştir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Yeni Şifre :");

        jButton2.setText("Vazgeç");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxt_kullaniciId, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(jPassword_eskiSifre)
                            .addComponent(jPassword_yeniSifre)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxt_kullaniciId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword_eskiSifre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword_yeniSifre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(41, 41, 41)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String kullaniciId = jtxt_kullaniciId.getText();
        String eskisifre = String.copyValueOf(jPassword_eskiSifre.getPassword());
        String yenisifre = String.copyValueOf(jPassword_yeniSifre.getPassword());

        Yonetici_1 yonetici = null;
        Calisan_1 calisan = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BP2_1521221034_MeryemEzber_Odev1PU");
        EntityManager em = emf.createEntityManager();

        // gelen kullanıcı yönetici mi diye kontrol etmek için
        Query q1 = em.createQuery("SELECT y FROM Yonetici_1 y WHERE y.yoneticiId=:y_kId AND y.yoneticiSifre=:y_sif ");
        q1.setParameter("y_kId", kullaniciId);
        q1.setParameter("y_sif", eskisifre);

        // gelen kullanıcı çalışan mı diye kontrol etmek için
        Query q2 = em.createQuery("SELECT c FROM Calisan_1 c WHERE c.calisanId=:c_kId AND c.calisanSifre=:c_sif");
        q2.setParameter("c_kId", kullaniciId);
        q2.setParameter("c_sif", eskisifre);

        try {
            yonetici = (Yonetici_1) q1.getSingleResult();
        } catch (Exception e) {
            yonetici = null;
        }

        if (yonetici != null) {
            Query q = em.createQuery("UPDATE Yonetici_1 y SET y.yoneticiSifre=:sif WHERE y.yoneticiId=:id");
            q.setParameter("sif", yenisifre);
            q.setParameter("id", kullaniciId);
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(rootPane, "Şifreniz değiştirildi!");
            JFrm_GirisEkrani newgirisekrani = new JFrm_GirisEkrani();
            newgirisekrani.setVisible(true);
            this.dispose();

        } else {
            try {
                calisan = (Calisan_1) q2.getSingleResult();
            } catch (Exception e) {
                calisan = null;
            }
            if (calisan != null) {
                Query q = em.createQuery("UPDATE Calisan_1 c SET c.calisanSifre=:sif WHERE c.calisanId=:id");
                q.setParameter("sif", yenisifre);
                q.setParameter("id", kullaniciId);
                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(rootPane, "Şifreniz değiştirildi!");
                JFrm_GirisEkrani newgirisekrani = new JFrm_GirisEkrani();
                newgirisekrani.setVisible(true);
                this.dispose();
            }
        }

        if (yonetici == null && calisan == null) {
            JOptionPane.showMessageDialog(rootPane, "Girdiğiniz Id ve eski şifre eşleşmemektedir.");
            temizle();
        }

        
        
        
        
//        em1.close();
//        emf1.close();
//        em2.close();
//        emf2.close();
//        String kullaniciId = jtxt_kullaniciId.getText();
//        String eskisifre = String.copyValueOf(jPassword_eskiSifre.getPassword());
//        String yenisifre = String.copyValueOf(jPassword_yeniSifre.getPassword());
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BP2_1521221034_MeryemEzber_Odev1PU");
//        EntityManager em = emf.createEntityManager();
//
//        // gelen kullanıcı yönetici mi diye kontrol etmek için
//        Query q1 = em.createQuery("SELECT y FROM Yonetici_1 y WHERE y.yoneticiId=:y_kId AND y.yoneticiSifre=:y_sif ");
//        q1.setParameter("y_kId", kullaniciId);
//        q1.setParameter("y_sif", eskisifre);
//
//        // gelen kullanıcı çalışan mı diye kontrol etmek için
//        Query q2 = em.createQuery("SELECT c FROM Calisan_1 c WHERE c.calisanId=:c_kId AND c.calisanSifre=:c_sif");
//        q2.setParameter("c_kId", kullaniciId);
//        q2.setParameter("c_sif", eskisifre);
//
//        if (q1.getSingleResult() != null) {
//            Query q = em.createQuery("UPDATE Yonetici_1 y SET y.yoneticiSifre=:sif WHERE y.yoneticiId=:id");
//            q.setParameter("sif", yenisifre);
//            q.setParameter("id", kullaniciId);
//            em.getTransaction().begin();
//            q.executeUpdate();
//            em.getTransaction().commit();
//            JOptionPane.showMessageDialog(rootPane, "Şifreniz değiştirildi!");
//            JFrm_GirisEkrani newgirisekrani = new JFrm_GirisEkrani();
//            newgirisekrani.setVisible(true);
//            this.dispose();
//
//        } else if (q2.getSingleResult() != null) {
//            Query q = em.createQuery("UPDATE Calisan_1 c SET c.yoneticiSifre=:sif WHERE c.calisanId:id");
//            q.setParameter("sif", yenisifre);
//            q.setParameter("id", kullaniciId);
//            em.getTransaction().begin();
//            q.executeUpdate();
//            em.getTransaction().commit();
//            JOptionPane.showMessageDialog(rootPane, "Şifreniz değiştirildi!");
//            JFrm_GirisEkrani newgirisekrani = new JFrm_GirisEkrani();
//            newgirisekrani.setVisible(true);
//            this.dispose();
//        }
//
//        if (q1.getSingleResult() == null && q2.getSingleResult() == null) {
//            JOptionPane.showMessageDialog(rootPane, "Girdiğiniz Id ve eski şifre eşleşmemektedir.");
//            temizle();
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFrm_GirisEkrani newgirisekrani = new JFrm_GirisEkrani();
        newgirisekrani.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrm_SifreDegistirmeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrm_SifreDegistirmeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrm_SifreDegistirmeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrm_SifreDegistirmeEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrm_SifreDegistirmeEkrani().setVisible(true);
            }
        });
    }

    void temizle() {
        jtxt_kullaniciId.setText("");
        jPassword_eskiSifre.setText("");
        jPassword_yeniSifre.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPassword_eskiSifre;
    private javax.swing.JPasswordField jPassword_yeniSifre;
    private javax.swing.JTextField jtxt_kullaniciId;
    // End of variables declaration//GEN-END:variables
}