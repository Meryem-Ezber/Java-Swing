/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje_takip;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class JFrm_YoneticiEkrani extends javax.swing.JFrame {

    /**
     * Creates new form JFrm_ScreenManager
     */
    DefaultTableModel dtm_calisanListesi = new DefaultTableModel();
    DefaultTableModel dtm_projeListesi = new DefaultTableModel();
    DefaultTableModel dtm_yoneticiEkran = new DefaultTableModel();
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM.yyyy");

    public List<Calisan_1> calisanlar;
    public List<Proje_1> projeler;
    public List<Gorev_1> gorevler;

    public JFrm_YoneticiEkrani() {

        initComponents();
        setTitle(JFrm_GirisEkrani.y_logined.getYoneticiAdi() + " " + JFrm_GirisEkrani.y_logined.getYoneticiSoyadi());
        Toolkit kit = Toolkit.getDefaultToolkit();
        int EkranY = (int) kit.getScreenSize().width; //Ekran boyutunun genişliğini alıyoruz...
        int EkranX = (int) kit.getScreenSize().height;//Ekran boyutunun yüksekliğini alıyoruz...
        this.setSize(900, 700); // Pencere boyutunu belirliyoruz...
        this.setLocation((EkranY - 900) / 2, (EkranX - 700) / 2);

        dtm_calisanListesi.setColumnIdentifiers(new String[]{"Çalışan Id", "Çalışan Adı", "Çalışan Soaydı"});
        jtbl_calisanListesi.setModel(dtm_calisanListesi);
        dtm_projeListesi.setColumnIdentifiers(new String[]{"Proje Id", "Proje Adı", "Veriliş Tarihi", "Teslim Edilmesi Gereken Tarih"});
        jtbl_projeListesi.setModel(dtm_projeListesi);
        dtm_yoneticiEkran.setColumnIdentifiers(new String[]{"Görev Id", "Proje Id", "Çalışan Id", "Görev Adı", "Veriliş Tarihi", "Teslim Edilmesi Gereken Tarih", "Teslim Tarihi"});
        jtbl_işlemler.setModel(dtm_yoneticiEkran);
        jbtn_calisanEkle.setEnabled(false);
        jbtn_calisanSil.setEnabled(false);
        jbtn_projeEkle.setEnabled(false);
        jbtn_projeSil.setEnabled(false);
        jbtn_projeyeCalisanGoreviEkle.setEnabled(false);
        Date tarih = new Date();
        jDateChooser_proje.setDate(tarih);
        jDateChooser_gorev.setDate(tarih);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BP2_1521221034_MeryemEzber_Odev1PU");
        EntityManager em = emf.createEntityManager();
        Query q1 = em.createQuery("SELECT c FROM Calisan_1 c WHERE c.yoneticiId=:id");
        q1.setParameter("id", JFrm_GirisEkrani.y_logined.getYoneticiId());
        calisanlar = q1.getResultList();
        for (Calisan_1 calisan : calisanlar) {
            dtm_calisanListesi.addRow(new Object[]{calisan.getCalisanId(), calisan.getCalisanAdi(), calisan.getCalisanSoyadi()});
            jComboBox_calisanlar.addItem(calisan);
        }

        Query q2 = em.createQuery("SELECT P FROM Proje_1 p WHERE p.yoneticiId=:id");
        q2.setParameter("id", JFrm_GirisEkrani.y_logined.getYoneticiId());
        projeler = q2.getResultList();
        for (Proje_1 proje : projeler) {
            dtm_projeListesi.addRow(new Object[]{proje.getProjeId(), proje.getProjeAdi(), sdf.format(proje.getProjeVerilisTarihi()), sdf.format(proje.getProjeTeslimEdilmesiGerekenTarih())});
            jComboBox_projeler.addItem(proje);
        }

        for (Calisan_1 calisan : calisanlar) {
            Query q3 = em.createQuery("SELECT g FROM Gorev_1 g WHERE g.calisanId=:id");
            q3.setParameter("id", calisan.getCalisanId());
            gorevler = q3.getResultList();
            for (Gorev_1 gorev : gorevler) {
                if (gorev.getGorevTeslimTarihi() == null) {
                    dtm_yoneticiEkran.addRow(new Object[]{gorev.getGorevId(), gorev.getProjeId(), gorev.getCalisanId(), gorev.getGorevAdi(),
                        sdf.format(gorev.getGorevVerilisTarihi()), sdf.format(gorev.getGorevTeslimEdilmesiGerekenTarih()), (gorev.getGorevTeslimTarihi())});
                } else if (gorev.getGorevTeslimTarihi() != null) {
                    dtm_yoneticiEkran.addRow(new Object[]{gorev.getGorevId(), gorev.getProjeId(), gorev.getCalisanId(), gorev.getGorevAdi(),
                        sdf.format(gorev.getGorevVerilisTarihi()), sdf.format(gorev.getGorevTeslimEdilmesiGerekenTarih()), sdf.format(gorev.getGorevTeslimTarihi())});
                }
            }
        }

        jComboBox_calisanlar.setSelectedIndex(-1);
        jComboBox_projeler.setSelectedIndex(-1);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtxt_calisanAdi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxt_calisanSoyadi = new javax.swing.JTextField();
        jbtn_calisanEkle = new javax.swing.JButton();
        jbtn_calisanSil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_calisanListesi = new javax.swing.JTable();
        jCheckBox_calisanOnay = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxt_projeAdi = new javax.swing.JTextField();
        jbtn_projeEkle = new javax.swing.JButton();
        jbtn_projeSil = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_projeListesi = new javax.swing.JTable();
        jCheckBox_projeOnay = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser_proje = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_projeler = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_calisanlar = new javax.swing.JComboBox<>();
        jbtn_projeyeCalisanGoreviEkle = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbl_işlemler = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtxt_gorev = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox_gorevOnay = new javax.swing.JCheckBox();
        jDateChooser_gorev = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_calisanArama = new javax.swing.JMenuItem();
        jMenuItem_projeArama = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_filtreleme = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar3.add(jMenu8);

        jMenu9.setText("File");
        jMenuBar4.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar4.add(jMenu10);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Adı :");

        jLabel6.setText("Soyadı :");

        jbtn_calisanEkle.setText("Çalışan Ekle");
        jbtn_calisanEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_calisanEkleActionPerformed(evt);
            }
        });

        jbtn_calisanSil.setText("Çalışan Sil");
        jbtn_calisanSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_calisanSilActionPerformed(evt);
            }
        });

        jtbl_calisanListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbl_calisanListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_calisanListesiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_calisanListesi);

        jCheckBox_calisanOnay.setText("Yukarıda bilgileri girilen çalışan kaydını onaylıyor musunuz?");
        jCheckBox_calisanOnay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_calisanOnayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_calisanOnay)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxt_calisanAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxt_calisanSoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtn_calisanEkle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtn_calisanSil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxt_calisanAdi)
                    .addComponent(jbtn_calisanEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_calisanSoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jbtn_calisanSil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_calisanOnay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        jTabbedPane1.addTab("Çalışan İşlemleri", jPanel1);

        jLabel3.setText("Projenin Adı :");

        jbtn_projeEkle.setText("Proje Ekle");
        jbtn_projeEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_projeEkleActionPerformed(evt);
            }
        });

        jbtn_projeSil.setText("Proje Sil");
        jbtn_projeSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_projeSilActionPerformed(evt);
            }
        });

        jtbl_projeListesi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbl_projeListesi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_projeListesiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtbl_projeListesi);

        jCheckBox_projeOnay.setText("Yukarıda bilgileri girilen proje kaydını onaylıyor musunuz?");
        jCheckBox_projeOnay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_projeOnayActionPerformed(evt);
            }
        });

        jLabel1.setText("Projenin Teslim Tarihi :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_projeOnay)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(12, 12, 12))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(8, 8, 8)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jDateChooser_proje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtxt_projeAdi, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtn_projeEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtn_projeSil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxt_projeAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtn_projeEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jbtn_projeSil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jDateChooser_proje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox_projeOnay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proje İşlemleri", jPanel2);

        jLabel8.setText("Proje seçiniz : ");

        jLabel9.setText("Projeye çalışan seçiniz :");

        jbtn_projeyeCalisanGoreviEkle.setText("Projeye Çalışanının Görevini Ekle");
        jbtn_projeyeCalisanGoreviEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_projeyeCalisanGoreviEkleActionPerformed(evt);
            }
        });

        jtbl_işlemler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jtbl_işlemler);

        jLabel2.setText("Çalışanın projedeki görevini tanımlayınız :");

        jLabel4.setText("Görevin teslim tarihini belirleyiniz :");

        jCheckBox_gorevOnay.setText("Yukarıdaki çalışan ve proje ile görev eşleşmesini onaylıyor musunuz? ");
        jCheckBox_gorevOnay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_gorevOnayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox_calisanlar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox_projeler, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtxt_gorev, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jDateChooser_gorev, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_gorevOnay)
                            .addComponent(jbtn_projeyeCalisanGoreviEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox_projeler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox_calisanlar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxt_gorev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser_gorev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox_gorevOnay)
                .addGap(18, 18, 18)
                .addComponent(jbtn_projeyeCalisanGoreviEkle)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Çalışana Proje Atama İşlemleri", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 800, 590));

        jMenu1.setText("Çıkış");

        jMenuItem1.setText("Ana Ekrana Dön");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Arama");

        jMenuItem_calisanArama.setText("Çalışan Ara");
        jMenuItem_calisanArama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_calisanAramaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_calisanArama);

        jMenuItem_projeArama.setText("Proje Ara");
        jMenuItem_projeArama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_projeAramaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_projeArama);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Filtreleme");

        jMenuItem_filtreleme.setText("Çalışanın Görevleri");
        jMenuItem_filtreleme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_filtrelemeActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_filtreleme);

        jMenuItem2.setText("Projenin Çalışanları");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu11.setText("Geçmiş");

        jMenuItem3.setText("Çalışanların Geçmişi");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem3);

        jMenuBar1.add(jMenu11);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox_projeOnayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_projeOnayActionPerformed
        // TODO add your handling code here:
        Date tarih = new Date();
        if (jCheckBox_projeOnay.isSelected()) {
            jtxt_projeAdi.setEnabled(false);
            jDateChooser_proje.setEnabled(false);
            if (jtxt_projeAdi.getText().length() == 0) {
                jbtn_projeEkle.setEnabled(false);
                jbtn_projeSil.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Bilgileri eksiksiz doldurun!");
                jCheckBox_projeOnay.setSelected(false);
                jtxt_projeAdi.setEnabled(true);
                jDateChooser_proje.setEnabled(true);
            } else if (tarih.compareTo(jDateChooser_proje.getCalendar().getTime()) == 1) {
                JOptionPane.showMessageDialog(rootPane, "Aynı gün veya geçmiş bir tarihe proje veremezsiniz.");
                jCheckBox_projeOnay.setSelected(false);
                jtxt_projeAdi.setEnabled(true);
                jDateChooser_proje.setEnabled(true);
            } else {
                jbtn_projeEkle.setEnabled(true);
            }
        } else {
            jtxt_projeAdi.setEnabled(true);
            jbtn_projeEkle.setEnabled(false);
            jDateChooser_proje.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox_projeOnayActionPerformed

    private void jtbl_projeListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_projeListesiMouseClicked
        // TODO add your handling code here:
        jbtn_projeSil.setEnabled(true);
    }//GEN-LAST:event_jtbl_projeListesiMouseClicked

    private void jbtn_projeSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_projeSilActionPerformed
        // TODO add your handling code here:
        Object o = null;
        String id = String.valueOf(jtbl_projeListesi.getValueAt(jtbl_projeListesi.getSelectedRow(), 0));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BP2_1521221034_MeryemEzber_Odev1PU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT g FROM Gorev_1 g WHERE g.projeId = :id");
        q.setParameter("id", Integer.parseInt(id));

        try {
            o = q.getSingleResult();
        } catch (Exception e) {
            o = null;
        }

        if (o == null) {
            Query q2 = em.createQuery("DELETE FROM Proje_1 p  WHERE p.projeId=:id");
            q2.setParameter("id", Integer.parseInt(id));

            jComboBox_projeler.removeAllItems();
            dtm_projeListesi.setRowCount(0);

            em.getTransaction().begin();
            q2.executeUpdate();

            Query q3 = em.createQuery("SELECT p FROM Proje_1 p WHERE P.yoneticiId=:id");
            q3.setParameter("id", JFrm_GirisEkrani.y_logined.getYoneticiId());
            projeler = q3.getResultList();

            for (Proje_1 proje : projeler) {
                dtm_projeListesi.addRow(new Object[]{proje.getProjeId(), proje.getProjeAdi(), sdf.format(proje.getProjeVerilisTarihi()), sdf.format(proje.getProjeTeslimEdilmesiGerekenTarih())});
                jComboBox_projeler.addItem(proje);
            }

            em.getTransaction().commit();
            secimleriTemizle();
            jbtn_projeSil.setEnabled(false);
        } else if (o != null) {
            JOptionPane.showMessageDialog(rootPane, "Projeye görev atandığı için projeyi silemezsiniz.");
            jbtn_projeSil.setEnabled(false);
        }


    }//GEN-LAST:event_jbtn_projeSilActionPerformed

    private void jbtn_projeEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_projeEkleActionPerformed
        try {
            // TODO add your handling code here:
            Proje proje = new Proje();
            proje.yöneticisi = JFrm_GirisEkrani.y_logined.getYoneticiAdi() + " " + JFrm_GirisEkrani.y_logined.getYoneticiSoyadi();
            proje.yoneticiid = JFrm_GirisEkrani.y_logined.getYoneticiId();
            proje.adi = jtxt_projeAdi.getText();
            proje.teslimDurumu = false;
            Date tarih = new Date();
            proje.verilisTarihi = tarih;
            proje.teslimEdilmesiGerekenTarih = jDateChooser_proje.getCalendar().getTime();

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/PROJE_TAKIP", "SA", "AS");

            String q1 = "SELECT MAX(PROJE_ID) max_id FROM PROJE";
            Statement statement = con.createStatement();
            ResultSet idMax = statement.executeQuery(q1);
            int id = 0;
            if (idMax.next()) {
                id = idMax.getInt("max_id");
            }
            id++;
            proje.id = id;

            String q2 = "INSERT INTO PROJE (PROJE_ID,PROJE_ADI,YONETICI_ID,PROJE_VERILIS_TARIHI,PROJE_TESLIM_EDILMESI_GEREKEN_TARIH) VALUES(?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(q2);

            stm.setInt(1, proje.id);
            stm.setString(2, proje.adi);
            stm.setString(3, proje.yoneticiid);
            stm.setDate(4, (new java.sql.Date(proje.verilisTarihi.getTime())));
            stm.setDate(5, (new java.sql.Date(proje.teslimEdilmesiGerekenTarih.getTime())));

            stm.executeUpdate();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BP2_1521221034_MeryemEzber_Odev1PU");
            EntityManager em = emf.createEntityManager();
            Query q3 = em.createQuery("SELECT P FROM Proje_1 p WHERE p.yoneticiId=:id");
            q3.setParameter("id", JFrm_GirisEkrani.y_logined.getYoneticiId());
            List<Proje_1> projeler = q3.getResultList();
            jComboBox_projeler.removeAllItems();
            for (Proje_1 p : projeler) {
                jComboBox_projeler.addItem(p);
            }

            dtm_projeListesi.addRow(new Object[]{proje.id, proje.adi, sdf.format(proje.verilisTarihi), sdf.format(proje.teslimEdilmesiGerekenTarih)});

            jtxt_projeAdi.setText("");
            jCheckBox_projeOnay.setSelected(false);
            jtxt_projeAdi.setEnabled(true);
            jDateChooser_proje.setEnabled(true);
            jbtn_projeEkle.setEnabled(false);
            secimleriTemizle();
        } catch (SQLException ex) {
            Logger.getLogger(JFrm_YoneticiEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtn_projeEkleActionPerformed

    private void jbtn_projeyeCalisanGoreviEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_projeyeCalisanGoreviEkleActionPerformed
        // TODO add your handling code here:
        Proje_1 secilenProje = (Proje_1) jComboBox_projeler.getSelectedItem();
        Calisan_1 secilenKisi = (Calisan_1) jComboBox_calisanlar.getSelectedItem();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BP2_1521221034_MeryemEzber_Odev1PU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Gorev_1 gorev = new Gorev_1();

            //BUNU ENTITYBEAN ILE YAP
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/PROJE_TAKIP", "SA", "AS");

            String q = "SELECT MAX(GOREV_ID) max_id FROM GOREV";
            Statement statement = con.createStatement();
            ResultSet idMax = statement.executeQuery(q);
            int id = 0;
            if (idMax.next()) {
                id = idMax.getInt("max_id");
            }
            id++;

            gorev.setGorevId(id);
            gorev.setGorevAdi(jtxt_gorev.getText());
            gorev.setCalisanId(secilenKisi.getCalisanId());
            gorev.setProjeId(secilenProje.getProjeId());
            Date tarih = new Date();
            gorev.setGorevVerilisTarihi(tarih);
            gorev.setGorevTeslimEdilmesiGerekenTarih(jDateChooser_gorev.getCalendar().getTime());
            gorev.setGorevTeslimTarihi(null);

            dtm_yoneticiEkran.addRow(new Object[]{gorev.getGorevId(), gorev.getProjeId(), gorev.getCalisanId(), gorev.getGorevAdi(),
                sdf.format(gorev.getGorevVerilisTarihi()), sdf.format(gorev.getGorevTeslimEdilmesiGerekenTarih()), null});

            jbtn_projeyeCalisanGoreviEkle.setEnabled(false);

            em.persist(gorev);
            em.getTransaction().commit();
            em.close();

        } catch (SQLException ex) {
            Logger.getLogger(JFrm_YoneticiEkrani.class.getName()).log(Level.SEVERE, null, ex);

        }
        jComboBox_calisanlar.setSelectedIndex(-1);
        jComboBox_projeler.setSelectedIndex(-1);
        jtxt_gorev.setText("");
        Date tarih = new Date();
        jComboBox_calisanlar.setEnabled(true);
        jComboBox_projeler.setEnabled(true);
        jDateChooser_gorev.setEnabled(true);
        jDateChooser_gorev.setDate(tarih);
        jtxt_gorev.setEnabled(true);
        jCheckBox_gorevOnay.setSelected(false);

    }//GEN-LAST:event_jbtn_projeyeCalisanGoreviEkleActionPerformed

    private void jCheckBox_calisanOnayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_calisanOnayActionPerformed
        // TODO add your handling code here:
        if (jCheckBox_calisanOnay.isSelected()) {
            jtxt_calisanAdi.setEnabled(false);
            jtxt_calisanSoyadi.setEnabled(false);
            if (jtxt_calisanAdi.getText().length() == 0 || jtxt_calisanSoyadi.getText().length() == 0) {
                jbtn_calisanEkle.setEnabled(false);
                jbtn_calisanSil.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Bilgileri eksiksiz doldurun!");
                jCheckBox_calisanOnay.setSelected(false);
                jtxt_calisanAdi.setEnabled(true);
                jtxt_calisanSoyadi.setEnabled(true);
            } else {
                jbtn_calisanEkle.setEnabled(true);
            }
        } else {
            jtxt_calisanAdi.setEnabled(true);
            jtxt_calisanSoyadi.setEnabled(true);
            jbtn_calisanEkle.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_calisanOnayActionPerformed

    private void jtbl_calisanListesiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_calisanListesiMouseClicked
        // TODO add your handling code here:
        jbtn_calisanSil.setEnabled(true);
    }//GEN-LAST:event_jtbl_calisanListesiMouseClicked

    private void jbtn_calisanSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_calisanSilActionPerformed
        // TODO add your handling code here:
        Object o = null;
        String id = String.valueOf(jtbl_calisanListesi.getValueAt(jtbl_calisanListesi.getSelectedRow(), 0));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BP2_1521221034_MeryemEzber_Odev1PU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT g FROM Gorev_1 g WHERE g.calisanId=:id");
        q.setParameter("id", id);

        try {
            o = q.getSingleResult();
        } catch (Exception e) {
            o = null;
        }

        if (o == null) {
            Query q2 = em.createQuery("DELETE FROM Calisan_1 c  WHERE c.calisanId=:id");
            q2.setParameter("id", id);

            jComboBox_calisanlar.removeAllItems();
            dtm_calisanListesi.setRowCount(0);

            em.getTransaction().begin();
            q2.executeUpdate();

            Query q3 = em.createQuery("SELECT c FROM Calisan_1 c WHERE c.yoneticiId=:id");
            q3.setParameter("id", JFrm_GirisEkrani.y_logined.getYoneticiId());
            calisanlar = q3.getResultList();

            for (Calisan_1 calisan : calisanlar) {
                dtm_calisanListesi.addRow(new Object[]{calisan.getCalisanId(), calisan.getCalisanAdi(), calisan.getCalisanSoyadi()});
                jComboBox_calisanlar.addItem(calisan);

            }
            em.getTransaction().commit();
            jbtn_calisanSil.setEnabled(false);
            secimleriTemizle();
        } else if (o != null) {
            JOptionPane.showMessageDialog(rootPane, "Çalışana görev atandığı için çalışanı silemezsiniz.");
            jbtn_calisanSil.setEnabled(false);
        }

    }//GEN-LAST:event_jbtn_calisanSilActionPerformed

    private void jbtn_calisanEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_calisanEkleActionPerformed
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BP2_1521221034_MeryemEzber_Odev1PU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Calisan_1 yenicalisan = new Calisan_1();

            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/PROJE_TAKIP", "SA", "AS");
            String q1 = "SELECT MAX(ID) max_id FROM IDNUMARALARI";
            Statement statement = con.createStatement();

            ResultSet idMax = statement.executeQuery(q1);
            int id = 0;
            if (idMax.next()) {
                id = idMax.getInt("max_id");
            }
            id++;

            yenicalisan.setCalisanId(String.valueOf(id));
            yenicalisan.setCalisanAdi(jtxt_calisanAdi.getText());
            yenicalisan.setCalisanSoyadi(jtxt_calisanSoyadi.getText());
            yenicalisan.setYoneticiId(JFrm_GirisEkrani.y_logined.getYoneticiId());
            Random rdm = new Random();
            yenicalisan.setCalisanSifre(String.valueOf(rdm.nextInt(8999) + 1000));

            String q3 = "INSERT INTO IDNUMARALARI (ID,TYPE) VALUES(?,?)";
            PreparedStatement stm = con.prepareStatement(q3);

            stm.setInt(1, Integer.parseInt(yenicalisan.getCalisanId()));
            stm.setString(2, "Çalışan");
            stm.executeUpdate();

            jComboBox_calisanlar.addItem(yenicalisan);
            dtm_calisanListesi.addRow(new String[]{yenicalisan.getCalisanId(), yenicalisan.getCalisanAdi(), yenicalisan.getCalisanSoyadi()});
            JOptionPane.showMessageDialog(rootPane, "Kayıt Başarılı. " + yenicalisan.getCalisanAdi() + " " + yenicalisan.getCalisanSoyadi() + " için belirlenen şifre " + yenicalisan.getCalisanSifre());

            em.persist(yenicalisan);
            em.getTransaction().commit();
            em.close();

            calisanListesiTemizle();
            jbtn_calisanEkle.setEnabled(false);
            jtxt_calisanAdi.setEnabled(true);
            jtxt_calisanSoyadi.setEnabled(true);
            jCheckBox_calisanOnay.setSelected(false);
            secimleriTemizle();
        } catch (SQLException ex) {
            Logger.getLogger(JFrm_YoneticiEkrani.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try {
//            // TODO add your handling code here:
//            Calisan yenicalisan = new Calisan();
//            yenicalisan.adi = jtxt_calisanAdi.getText();
//            yenicalisan.soyadi = jtxt_calisanSoyadi.getText();
//            yenicalisan.yoneticiid = JFrm_GirisEkrani.y_logined.getYoneticiId();
//            Random rdm = new Random();
//            yenicalisan.password = String.valueOf(rdm.nextInt(8999) + 1000);
//
//            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/PROJETAKIP", "sa", "as");
//            String q1 = "SELECT MAX(ID) max_id FROM IDNUMARALARI";
//            Statement statement = con.createStatement();
//
//            ResultSet idMax = statement.executeQuery(q1);
//            int id = 0;
//            if (idMax.next()) {
//                id = idMax.getInt("max_id");
//            }
//            id++;
//
//            yenicalisan.id = String.valueOf(id);
//
//            String q2 = "INSERT INTO CALISAN (CALISAN_ID,CALISAN_ADI,CALISAN_SOYADI,CALISAN_SIFRE,YONETICI_ID) VALUES(?,?,?,?,?)";
//            PreparedStatement stm1 = con.prepareStatement(q2);
//
//            stm1.setString(1, String.valueOf(yenicalisan.id));
//            stm1.setString(2, yenicalisan.adi);
//            stm1.setString(3, yenicalisan.soyadi);
//            stm1.setString(4, yenicalisan.password);
//            stm1.setString(5, yenicalisan.yoneticiid);
//
//            stm1.executeUpdate();
//
//            String q3 = "INSERT INTO IDNUMARALARI (ID,TYPE) VALUES(?,?)";
//            PreparedStatement stm2 = con.prepareStatement(q3);
//
//            stm2.setInt(1, Integer.parseInt(yenicalisan.id));
//            stm2.setString(2, "Çalışan");
//
//            stm2.executeUpdate();
//
////            jComboBox_calisanlar.addItem(yenicalisan);
//
//            JOptionPane.showMessageDialog(rootPane, "Kayıt Başarılı. " + yenicalisan.adi + " " + yenicalisan.soyadi + " için belirlenen şifre " + yenicalisan.password);
//            dtm_calisanListesi.addRow(new String[]{yenicalisan.id, yenicalisan.adi, yenicalisan.soyadi});
//
//        } catch (SQLException ex) {
//            Logger.getLogger(JFrm_YoneticiKayitEkrani.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        calisanListesiTemizle();
//        jbtn_calisanEkle.setEnabled(false);
//        jtxt_calisanAdi.setEnabled(true);
//        jtxt_calisanSoyadi.setEnabled(true);
//        jCheckBox_calisanOnay.setSelected(false);
//        secimleriTemizle();

    }//GEN-LAST:event_jbtn_calisanEkleActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JFrm_GirisEkrani newgirisekrani = new JFrm_GirisEkrani();
        newgirisekrani.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem_calisanAramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_calisanAramaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JFrm_CalisanAra newaramaekrani = new JFrm_CalisanAra();
        newaramaekrani.setVisible(true);
    }//GEN-LAST:event_jMenuItem_calisanAramaActionPerformed

    private void jMenuItem_filtrelemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_filtrelemeActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JFrm_CalisaninGörevleriniFiltrele newfiltrelemeekrani = new JFrm_CalisaninGörevleriniFiltrele();
        newfiltrelemeekrani.setVisible(true);
    }//GEN-LAST:event_jMenuItem_filtrelemeActionPerformed

    private void jMenuItem_projeAramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_projeAramaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JFrm_ProjeAra newprojeara = new JFrm_ProjeAra();
        newprojeara.setVisible(true);
    }//GEN-LAST:event_jMenuItem_projeAramaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JFrm_ProjeninCalisanlariveGorevleriniFiltrele newfiltrelemeekrani = new JFrm_ProjeninCalisanlariveGorevleriniFiltrele();
        newfiltrelemeekrani.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jCheckBox_gorevOnayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_gorevOnayActionPerformed
        // TODO add your handling code here:
        Date trh = new Date();
        if (jCheckBox_gorevOnay.isSelected()) {
            jComboBox_calisanlar.setEnabled(false);
            jComboBox_projeler.setEnabled(false);
            jDateChooser_proje.setEnabled(false);
            jtxt_gorev.setEnabled(false);
            if (jComboBox_projeler.getSelectedIndex() == -1 || jComboBox_calisanlar.getSelectedIndex() == -1 || jtxt_gorev.getText().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Proje veya çalışan seçiniz veya görevi tanımlayınız.");
                jComboBox_calisanlar.setEnabled(true);
                jComboBox_projeler.setEnabled(true);
                jDateChooser_proje.setEnabled(true);
                jtxt_gorev.setEnabled(true);
                jCheckBox_gorevOnay.setSelected(false);

            } else if (jComboBox_projeler.getSelectedIndex() != -1 && jComboBox_calisanlar.getSelectedIndex() != -1 && jtxt_gorev.getText().length() != 0) {
                Proje_1 secilenProje = (Proje_1) jComboBox_projeler.getSelectedItem();
                if (secilenProje.getProjeTeslimEdilmesiGerekenTarih().compareTo(jDateChooser_gorev.getCalendar().getTime()) == -1 || trh.compareTo(jDateChooser_gorev.getCalendar().getTime()) == 1) {
                    JOptionPane.showMessageDialog(rootPane, "Aynı güne, geçmiş bir tarihe ve seçmiş olduğunuz projenin teslim tarihinden sonraki bir tarihe görev veremezsiniz.");
                    jComboBox_calisanlar.setEnabled(true);
                    jComboBox_projeler.setEnabled(true);
                    jDateChooser_proje.setEnabled(true);
                    jtxt_gorev.setEnabled(true);
                    jCheckBox_gorevOnay.setSelected(false);
                } else {
                    //
                    Gorev_1 gorev;
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BP2_1521221034_MeryemEzber_Odev1PU");
                    EntityManager em = emf.createEntityManager();

                    Proje_1 p = (Proje_1) jComboBox_projeler.getSelectedItem();
                    Calisan_1 c = (Calisan_1) jComboBox_calisanlar.getSelectedItem();

                    Query q = em.createQuery("SELECT g FROM Gorev_1 g WHERE g.projeId = :projeId AND g.calisanId=:calisanId");
                    q.setParameter("projeId", p.getProjeId());
                    q.setParameter("calisanId", c.getCalisanId());

                    try {
                        gorev = (Gorev_1) q.getSingleResult();
                    } catch (Exception e) {
                        gorev = null;
                        jbtn_projeyeCalisanGoreviEkle.setEnabled(true);
                    }
                    if (gorev != null) {
                        JOptionPane.showMessageDialog(rootPane, "Çalışan bu projede görevlendirilmiş!");
                        jComboBox_calisanlar.setEnabled(true);
                        jComboBox_projeler.setEnabled(true);
                        jDateChooser_proje.setEnabled(true);
                        jtxt_gorev.setEnabled(true);
                        jCheckBox_gorevOnay.setSelected(false);
                    }
///
                }
            }
        } else {
            jComboBox_calisanlar.setEnabled(true);
            jComboBox_projeler.setEnabled(true);
            jDateChooser_proje.setEnabled(true);
            jtxt_gorev.setEnabled(true);
            jCheckBox_gorevOnay.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox_gorevOnayActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:

        try (Scanner s = new Scanner(new BufferedReader(new FileReader("C:\\ProjeTakip\\Gecmis.txt")))) {

            for (int i = 0; s.hasNextLine(); i++) {
                    System.out.println(s.nextLine() + "  ");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JFrm_YoneticiEkrani.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    void calisanListesiTemizle() {
        jtxt_calisanAdi.setText("");
        jtxt_calisanSoyadi.setText("");
    }

    void secimleriTemizle() {
        jComboBox_calisanlar.setSelectedIndex(-1);
        jComboBox_projeler.setSelectedIndex(-1);
        Date tarih = new Date();
        jDateChooser_proje.setDate(tarih);
        jDateChooser_gorev.setDate(tarih);
    }

//    public static void main(String args[]) {
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
//            java.util.logging.Logger.getLogger(JFrm_YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrm_YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrm_YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrm_YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFrm_YoneticiEkrani().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox_calisanOnay;
    private javax.swing.JCheckBox jCheckBox_gorevOnay;
    private javax.swing.JCheckBox jCheckBox_projeOnay;
    private javax.swing.JComboBox<Calisan_1> jComboBox_calisanlar;
    private javax.swing.JComboBox<Proje_1> jComboBox_projeler;
    private com.toedter.calendar.JDateChooser jDateChooser_gorev;
    private com.toedter.calendar.JDateChooser jDateChooser_proje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem_calisanArama;
    private javax.swing.JMenuItem jMenuItem_filtreleme;
    private javax.swing.JMenuItem jMenuItem_projeArama;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtn_calisanEkle;
    private javax.swing.JButton jbtn_calisanSil;
    private javax.swing.JButton jbtn_projeEkle;
    private javax.swing.JButton jbtn_projeSil;
    private javax.swing.JButton jbtn_projeyeCalisanGoreviEkle;
    private javax.swing.JTable jtbl_calisanListesi;
    private javax.swing.JTable jtbl_işlemler;
    private javax.swing.JTable jtbl_projeListesi;
    private javax.swing.JTextField jtxt_calisanAdi;
    private javax.swing.JTextField jtxt_calisanSoyadi;
    private javax.swing.JTextField jtxt_gorev;
    private javax.swing.JTextField jtxt_projeAdi;
    // End of variables declaration//GEN-END:variables
}
