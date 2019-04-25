/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje_takip;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "PROJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proje_1.findAll", query = "SELECT p FROM Proje_1 p"),
    @NamedQuery(name = "Proje_1.findByProjeId", query = "SELECT p FROM Proje_1 p WHERE p.projeId = :projeId"),
    @NamedQuery(name = "Proje_1.findByProjeAdi", query = "SELECT p FROM Proje_1 p WHERE p.projeAdi = :projeAdi"),
    @NamedQuery(name = "Proje_1.findByYoneticiId", query = "SELECT p FROM Proje_1 p WHERE p.yoneticiId = :yoneticiId"),
    @NamedQuery(name = "Proje_1.findByProjeVerilisTarihi", query = "SELECT p FROM Proje_1 p WHERE p.projeVerilisTarihi = :projeVerilisTarihi"),
    @NamedQuery(name = "Proje_1.findByProjeTeslimEdilmesiGerekenTarih", query = "SELECT p FROM Proje_1 p WHERE p.projeTeslimEdilmesiGerekenTarih = :projeTeslimEdilmesiGerekenTarih")})
public class Proje_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROJE_ID")
    private Integer projeId;
    @Basic(optional = false)
    @Column(name = "PROJE_ADI")
    private String projeAdi;
    @Basic(optional = false)
    @Column(name = "YONETICI_ID")
    private String yoneticiId;
    @Basic(optional = false)
    @Column(name = "PROJE_VERILIS_TARIHI")
    @Temporal(TemporalType.DATE)
    private Date projeVerilisTarihi;
    @Basic(optional = false)
    @Column(name = "PROJE_TESLIM_EDILMESI_GEREKEN_TARIH")
    @Temporal(TemporalType.DATE)
    private Date projeTeslimEdilmesiGerekenTarih;

    public Proje_1() {
    }

    public Proje_1(Integer projeId) {
        this.projeId = projeId;
    }

    public Proje_1(Integer projeId, String projeAdi, String yoneticiId, Date projeVerilisTarihi, Date projeTeslimEdilmesiGerekenTarih) {
        this.projeId = projeId;
        this.projeAdi = projeAdi;
        this.yoneticiId = yoneticiId;
        this.projeVerilisTarihi = projeVerilisTarihi;
        this.projeTeslimEdilmesiGerekenTarih = projeTeslimEdilmesiGerekenTarih;
    }

    public Integer getProjeId() {
        return projeId;
    }

    public void setProjeId(Integer projeId) {
        this.projeId = projeId;
    }

    public String getProjeAdi() {
        return projeAdi;
    }

    public void setProjeAdi(String projeAdi) {
        this.projeAdi = projeAdi;
    }

    public String getYoneticiId() {
        return yoneticiId;
    }

    public void setYoneticiId(String yoneticiId) {
        this.yoneticiId = yoneticiId;
    }

    public Date getProjeVerilisTarihi() {
        return projeVerilisTarihi;
    }

    public void setProjeVerilisTarihi(Date projeVerilisTarihi) {
        this.projeVerilisTarihi = projeVerilisTarihi;
    }

    public Date getProjeTeslimEdilmesiGerekenTarih() {
        return projeTeslimEdilmesiGerekenTarih;
    }

    public void setProjeTeslimEdilmesiGerekenTarih(Date projeTeslimEdilmesiGerekenTarih) {
        this.projeTeslimEdilmesiGerekenTarih = projeTeslimEdilmesiGerekenTarih;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projeId != null ? projeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proje_1)) {
            return false;
        }
        Proje_1 other = (Proje_1) object;
        if ((this.projeId == null && other.projeId != null) || (this.projeId != null && !this.projeId.equals(other.projeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return projeId + " - "+projeAdi;
    }
    
}
