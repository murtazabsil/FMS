/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author murtaza.khan
 */
@Entity
@Table(name = "lob")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lob.findAll", query = "SELECT l FROM Lob l"),
    @NamedQuery(name = "Lob.findByLobId", query = "SELECT l FROM Lob l WHERE l.lobId = :lobId"),
    @NamedQuery(name = "Lob.findByLobName", query = "SELECT l FROM Lob l WHERE l.lobName = :lobName"),
    @NamedQuery(name = "Lob.findByLobHead", query = "SELECT l FROM Lob l WHERE l.lobHead = :lobHead"),
    @NamedQuery(name = "Lob.findByLobDesc", query = "SELECT l FROM Lob l WHERE l.lobDesc = :lobDesc")})
public class Lob implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "lob_id")
    private Long lobId;
    @Size(max = 64)
    @Column(name = "lob_name")
    private String lobName;
    @Size(max = 64)
    @Column(name = "lob_head")
    private String lobHead;
    @Size(max = 255)
    @Column(name = "lob_desc")
    private String lobDesc;
    @OneToMany(mappedBy = "managerLobId")
    private Collection<Manager> managerCollection;
    @JoinColumn(name = "lob_location", referencedColumnName = "location_id")
    @ManyToOne
    private Location lobLocation;
    @OneToMany(mappedBy = "projectLob")
    private Collection<Project> projectCollection;
    @OneToMany(mappedBy = "accountLob")
    private Collection<Account> accountCollection;

    public Lob() {
    }

    public Lob(Long lobId) {
        this.lobId = lobId;
    }

    public Long getLobId() {
        return lobId;
    }

    public void setLobId(Long lobId) {
        this.lobId = lobId;
    }

    public String getLobName() {
        return lobName;
    }

    public void setLobName(String lobName) {
        this.lobName = lobName;
    }

    public String getLobHead() {
        return lobHead;
    }

    public void setLobHead(String lobHead) {
        this.lobHead = lobHead;
    }

    public String getLobDesc() {
        return lobDesc;
    }

    public void setLobDesc(String lobDesc) {
        this.lobDesc = lobDesc;
    }

    @XmlTransient
    public Collection<Manager> getManagerCollection() {
        return managerCollection;
    }

    public void setManagerCollection(Collection<Manager> managerCollection) {
        this.managerCollection = managerCollection;
    }

    public Location getLobLocation() {
        return lobLocation;
    }

    public void setLobLocation(Location lobLocation) {
        this.lobLocation = lobLocation;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lobId != null ? lobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lob)) {
            return false;
        }
        Lob other = (Lob) object;
        if ((this.lobId == null && other.lobId != null) || (this.lobId != null && !this.lobId.equals(other.lobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Lob[ lobId=" + lobId + " ]";
    }
    
}
