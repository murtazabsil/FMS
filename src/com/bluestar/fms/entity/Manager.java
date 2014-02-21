/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m"),
    @NamedQuery(name = "Manager.findByManagerId", query = "SELECT m FROM Manager m WHERE m.managerId = :managerId"),
    @NamedQuery(name = "Manager.findByManagerName", query = "SELECT m FROM Manager m WHERE m.managerName = :managerName"),
    @NamedQuery(name = "Manager.findByManagerEmpId", query = "SELECT m FROM Manager m WHERE m.managerEmpId = :managerEmpId"),
    @NamedQuery(name = "Manager.findByManagerDeptId", query = "SELECT m FROM Manager m WHERE m.managerDeptId = :managerDeptId"),
    @NamedQuery(name = "Manager.findByManagerDescrition", query = "SELECT m FROM Manager m WHERE m.managerDescrition = :managerDescrition")})
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "manager_id")
    private Long managerId;
    @Size(max = 64)
    @Column(name = "manager_name")
    private String managerName;
    @Size(max = 10)
    @Column(name = "manager_emp_id")
    private String managerEmpId;
    @Column(name = "manager_dept_id")
    private BigInteger managerDeptId;
    @Size(max = 255)
    @Column(name = "manager_descrition")
    private String managerDescrition;
    @JoinColumn(name = "manager_location_id", referencedColumnName = "location_id")
    @ManyToOne
    private Location managerLocationId;
    @JoinColumn(name = "manager_lob_id", referencedColumnName = "lob_id")
    @ManyToOne
    private Lob managerLobId;
    @JoinColumn(name = "manager_account_id", referencedColumnName = "account_id")
    @ManyToOne
    private Account managerAccountId;
    @JoinColumn(name = "manager_currency", referencedColumnName = "currency_id")
    @ManyToOne
    private Currency managerCurrency;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "managerId")
    private Collection<ProjectManagerLink> projectManagerLinkCollection;

    public Manager() {
    }

    public Manager(Long managerId) {
        this.managerId = managerId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmpId() {
        return managerEmpId;
    }

    public void setManagerEmpId(String managerEmpId) {
        this.managerEmpId = managerEmpId;
    }

    public BigInteger getManagerDeptId() {
        return managerDeptId;
    }

    public void setManagerDeptId(BigInteger managerDeptId) {
        this.managerDeptId = managerDeptId;
    }

    public String getManagerDescrition() {
        return managerDescrition;
    }

    public void setManagerDescrition(String managerDescrition) {
        this.managerDescrition = managerDescrition;
    }

    public Location getManagerLocationId() {
        return managerLocationId;
    }

    public void setManagerLocationId(Location managerLocationId) {
        this.managerLocationId = managerLocationId;
    }

    public Lob getManagerLobId() {
        return managerLobId;
    }

    public void setManagerLobId(Lob managerLobId) {
        this.managerLobId = managerLobId;
    }

    public Account getManagerAccountId() {
        return managerAccountId;
    }

    public void setManagerAccountId(Account managerAccountId) {
        this.managerAccountId = managerAccountId;
    }

    public Currency getManagerCurrency() {
        return managerCurrency;
    }

    public void setManagerCurrency(Currency managerCurrency) {
        this.managerCurrency = managerCurrency;
    }

    @XmlTransient
    public Collection<ProjectManagerLink> getProjectManagerLinkCollection() {
        return projectManagerLinkCollection;
    }

    public void setProjectManagerLinkCollection(Collection<ProjectManagerLink> projectManagerLinkCollection) {
        this.projectManagerLinkCollection = projectManagerLinkCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (managerId != null ? managerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.managerId == null && other.managerId != null) || (this.managerId != null && !this.managerId.equals(other.managerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Manager[ managerId=" + managerId + " ]";
    }
    
}
