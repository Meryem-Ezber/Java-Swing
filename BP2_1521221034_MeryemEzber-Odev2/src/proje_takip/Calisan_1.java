/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje_takip;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "CALISAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calisan_1.findAll", query = "SELECT c FROM Calisan_1 c"),
    @NamedQuery(name = "Calisan_1.findByCalisanId", query = "SELECT c FROM Calisan_1 c WHERE c.calisanId = :calisanId"),
    @NamedQuery(name = "Calisan_1.findByCalisanAdi", query = "SELECT c FROM Calisan_1 c WHERE c.calisanAdi = :calisanAdi"),
    @NamedQuery(name = "Calisan_1.findByCalisanSoyadi", query = "SELECT c FROM Calisan_1 c WHERE c.calisanSoyadi = :calisanSoyadi"),
    @NamedQuery(name = "Calisan_1.findByCalisanSifre", query = "SELECT c FROM Calisan_1 c WHERE c.calisanSifre = :calisanSifre"),
    @NamedQuery(name = "Calisan_1.findByYoneticiId", query = "SELECT c FROM Calisan_1 c WHERE c.yoneticiId = :yoneticiId")})
public class Calisan_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CALISAN_ID")
    private String calisanId;
    @Basic(optional = false)
    @Column(name = "CALISAN_ADI")
    private String calisanAdi;
    @Basic(optional = false)
    @Column(name = "CALISAN_SOYADI")
    private String calisanSoyadi;
    @Basic(optional = false)
    @Column(name = "CALISAN_SIFRE")
    private String calisanSifre;
    @Basic(optional = false)
    @Column(name = "YONETICI_ID")
    private String yoneticiId;
  

    public Calisan_1() {
    }

    public Calisan_1(String calisanId) {
        this.calisanId = calisanId;
    }

    public Calisan_1(String calisanId, String calisanAdi, String calisanSoyadi, String calisanSifre, String yoneticiId) {
        this.calisanId = calisanId;
        this.calisanAdi = calisanAdi;
        this.calisanSoyadi = calisanSoyadi;
        this.calisanSifre = calisanSifre;
        this.yoneticiId = yoneticiId;
       
    }

    public String getCalisanId() {
        return calisanId;
    }

    public void setCalisanId(String calisanId) {
        this.calisanId = calisanId;
    }

    public String getCalisanAdi() {
        return calisanAdi;
    }

    public void setCalisanAdi(String calisanAdi) {
        this.calisanAdi = calisanAdi;
    }

    public String getCalisanSoyadi() {
        return calisanSoyadi;
    }

    public void setCalisanSoyadi(String calisanSoyadi) {
        this.calisanSoyadi = calisanSoyadi;
    }

    public String getCalisanSifre() {
        return calisanSifre;
    }

    public void setCalisanSifre(String calisanSifre) {
        this.calisanSifre = calisanSifre;
    }

    public String getYoneticiId() {
        return yoneticiId;
    }

    public void setYoneticiId(String yoneticiId) {
        this.yoneticiId = yoneticiId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calisanId != null ? calisanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calisan_1)) {
            return false;
        }
        Calisan_1 other = (Calisan_1) object;
        if ((this.calisanId == null && other.calisanId != null) || (this.calisanId != null && !this.calisanId.equals(other.calisanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return calisanId+" - "+calisanAdi+" "+calisanSoyadi;
    }
    
}
