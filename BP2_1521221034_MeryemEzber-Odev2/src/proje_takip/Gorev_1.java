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
@Table(name = "GOREV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gorev_1.findAll", query = "SELECT g FROM Gorev_1 g"),
    @NamedQuery(name = "Gorev_1.findByGorevId", query = "SELECT g FROM Gorev_1 g WHERE g.gorevId = :gorevId"),
    @NamedQuery(name = "Gorev_1.findByGorevAdi", query = "SELECT g FROM Gorev_1 g WHERE g.gorevAdi = :gorevAdi"),
    @NamedQuery(name = "Gorev_1.findByCalisanId", query = "SELECT g FROM Gorev_1 g WHERE g.calisanId = :calisanId"),
    @NamedQuery(name = "Gorev_1.findByProjeId", query = "SELECT g FROM Gorev_1 g WHERE g.projeId = :projeId"),
    @NamedQuery(name = "Gorev_1.findByGorevVerilisTarihi", query = "SELECT g FROM Gorev_1 g WHERE g.gorevVerilisTarihi = :gorevVerilisTarihi"),
    @NamedQuery(name = "Gorev_1.findByGorevTeslimEdilmesiGerekenTarih", query = "SELECT g FROM Gorev_1 g WHERE g.gorevTeslimEdilmesiGerekenTarih = :gorevTeslimEdilmesiGerekenTarih"),
    @NamedQuery(name = "Gorev_1.findByGorevTeslimTarihi", query = "SELECT g FROM Gorev_1 g WHERE g.gorevTeslimTarihi = :gorevTeslimTarihi")})
public class Gorev_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GOREV_ID")
    private Integer gorevId;
    @Basic(optional = false)
    @Column(name = "GOREV_ADI")
    private String gorevAdi;
    @Basic(optional = false)
    @Column(name = "CALISAN_ID")
    private String calisanId;
    @Basic(optional = false)
    @Column(name = "PROJE_ID")
    private int projeId;
    @Basic(optional = false)
    @Column(name = "GOREV_VERILIS_TARIHI")
    @Temporal(TemporalType.DATE)
    private Date gorevVerilisTarihi;
    @Basic(optional = false)
    @Column(name = "GOREV_TESLIM_EDILMESI_GEREKEN_TARIH")
    @Temporal(TemporalType.DATE)
    private Date gorevTeslimEdilmesiGerekenTarih;
    @Column(name = "GOREV_TESLIM_TARIHI")
    @Temporal(TemporalType.DATE)
    private Date gorevTeslimTarihi;

    public Gorev_1() {
    }

    public Gorev_1(Integer gorevId) {
        this.gorevId = gorevId;
    }

    public Gorev_1(Integer gorevId, String gorevAdi, String calisanId, int projeId, Date gorevVerilisTarihi, Date gorevTeslimEdilmesiGerekenTarih) {
        this.gorevId = gorevId;
        this.gorevAdi = gorevAdi;
        this.calisanId = calisanId;
        this.projeId = projeId;
        this.gorevVerilisTarihi = gorevVerilisTarihi;
        this.gorevTeslimEdilmesiGerekenTarih = gorevTeslimEdilmesiGerekenTarih;
    }

    public Integer getGorevId() {
        return gorevId;
    }

    public void setGorevId(Integer gorevId) {
        this.gorevId = gorevId;
    }

    public String getGorevAdi() {
        return gorevAdi;
    }

    public void setGorevAdi(String gorevAdi) {
        this.gorevAdi = gorevAdi;
    }

    public String getCalisanId() {
        return calisanId;
    }

    public void setCalisanId(String calisanId) {
        this.calisanId = calisanId;
    }

    public int getProjeId() {
        return projeId;
    }

    public void setProjeId(int projeId) {
        this.projeId = projeId;
    }

    public Date getGorevVerilisTarihi() {
        return gorevVerilisTarihi;
    }

    public void setGorevVerilisTarihi(Date gorevVerilisTarihi) {
        this.gorevVerilisTarihi = gorevVerilisTarihi;
    }

    public Date getGorevTeslimEdilmesiGerekenTarih() {
        return gorevTeslimEdilmesiGerekenTarih;
    }

    public void setGorevTeslimEdilmesiGerekenTarih(Date gorevTeslimEdilmesiGerekenTarih) {
        this.gorevTeslimEdilmesiGerekenTarih = gorevTeslimEdilmesiGerekenTarih;
    }

    public Date getGorevTeslimTarihi() {
        return gorevTeslimTarihi;
    }

    public void setGorevTeslimTarihi(Date gorevTeslimTarihi) {
        this.gorevTeslimTarihi = gorevTeslimTarihi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gorevId != null ? gorevId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gorev_1)) {
            return false;
        }
        Gorev_1 other = (Gorev_1) object;
        if ((this.gorevId == null && other.gorevId != null) || (this.gorevId != null && !this.gorevId.equals(other.gorevId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proje_takip.Gorev_1[ gorevId=" + gorevId + " ]";
    }
    
}
