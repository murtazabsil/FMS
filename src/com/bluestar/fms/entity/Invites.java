/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author murtaza.khan
 */
@Entity
@Table(name = "invites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invites.findAll", query = "SELECT i FROM Invites i"),
    @NamedQuery(name = "Invites.findBySno", query = "SELECT i FROM Invites i WHERE i.sno = :sno"),
    @NamedQuery(name = "Invites.findByFrom", query = "SELECT i FROM Invites i WHERE i.from = :from"),
    @NamedQuery(name = "Invites.findByTo", query = "SELECT i FROM Invites i WHERE i.to = :to"),
    @NamedQuery(name = "Invites.findByStatus", query = "SELECT i FROM Invites i WHERE i.status = :status")})
public class Invites implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sno")
    private Integer sno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "From")
    private String from;
    @Size(max = 200)
    @Column(name = "To")
    private String to;
    @Size(max = 200)
    @Column(name = "Status")
    private String status;

    public Invites() {
    }

    public Invites(Integer sno) {
        this.sno = sno;
    }

    public Invites(Integer sno, String from) {
        this.sno = sno;
        this.from = from;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sno != null ? sno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invites)) {
            return false;
        }
        Invites other = (Invites) object;
        if ((this.sno == null && other.sno != null) || (this.sno != null && !this.sno.equals(other.sno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Invites[ sno=" + sno + " ]";
    }
    
}
