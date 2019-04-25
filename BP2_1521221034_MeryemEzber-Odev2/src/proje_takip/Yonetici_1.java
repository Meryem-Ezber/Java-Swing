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
@Table(name = "YONETICI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yonetici_1.findAll", query = "SELECT y FROM Yonetici_1 y"),
    @NamedQuery(name = "Yonetici_1.findByYoneticiId", query = "SELECT y FROM Yonetici_1 y WHERE y.yoneticiId = :yoneticiId"),
    @NamedQuery(name = "Yonetici_1.findByYoneticiAdi", query = "SELECT y FROM Yonetici_1 y WHERE y.yoneticiAdi = :yoneticiAdi"),
    @NamedQuery(name = "Yonetici_1.findByYoneticiSoyadi", query = "SELECT y FROM Yonetici_1 y WHERE y.yoneticiSoyadi = :yoneticiSoyadi"),
    @NamedQuery(name = "Yonetici_1.findByYoneticiSifre", query = "SELECT y FROM Yonetici_1 y WHERE y.yoneticiSifre = :yoneticiSifre")})
public class Yonetici_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "YONETICI_ID")
    private String yoneticiId;
    @Basic(optional = false)
    @Column(name = "YONETICI_ADI")
    private String yoneticiAdi;
    @Basic(optional = false)
    @Column(name = "YONETICI_SOYADI")
    private String yoneticiSoyadi;
    @Basic(optional = false)
    @Column(name = "YONETICI_SIFRE")
    private String yoneticiSifre;

    public Yonetici_1() {
    }

    public Yonetici_1(String yoneticiId) {
        this.yoneticiId = yoneticiId;
    }

    public Yonetici_1(String yoneticiId, String yoneticiAdi, String yoneticiSoyadi, String yoneticiSifre) {
        this.yoneticiId = yoneticiId;
        this.yoneticiAdi = yoneticiAdi;
        this.yoneticiSoyadi = yoneticiSoyadi;
        this.yoneticiSifre = yoneticiSifre;
    }

    public String getYoneticiId() {
        return yoneticiId;
    }

    public void setYoneticiId(String yoneticiId) {
        this.yoneticiId = yoneticiId;
    }

    public String getYoneticiAdi() {
        return yoneticiAdi;
    }

    public void setYoneticiAdi(String yoneticiAdi) {
        this.yoneticiAdi = yoneticiAdi;
    }

    public String getYoneticiSoyadi() {
        return yoneticiSoyadi;
    }

    public void setYoneticiSoyadi(String yoneticiSoyadi) {
        this.yoneticiSoyadi = yoneticiSoyadi;
    }

    public String getYoneticiSifre() {
        return yoneticiSifre;
    }

    public void setYoneticiSifre(String yoneticiSifre) {
        this.yoneticiSifre = yoneticiSifre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yoneticiId != null ? yoneticiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yonetici_1)) {
            return false;
        }
        Yonetici_1 other = (Yonetici_1) object;
        if ((this.yoneticiId == null && other.yoneticiId != null) || (this.yoneticiId != null && !this.yoneticiId.equals(other.yoneticiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proje_takip.Yonetici_1[ yoneticiId=" + yoneticiId + " ]";
    }
    
}
