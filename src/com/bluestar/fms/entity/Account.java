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
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountId", query = "SELECT a FROM Account a WHERE a.accountId = :accountId"),
    @NamedQuery(name = "Account.findByAccountName", query = "SELECT a FROM Account a WHERE a.accountName = :accountName"),
    @NamedQuery(name = "Account.findByAccountClient", query = "SELECT a FROM Account a WHERE a.accountClient = :accountClient"),
    @NamedQuery(name = "Account.findByAccountDesc", query = "SELECT a FROM Account a WHERE a.accountDesc = :accountDesc")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_id")
    private Long accountId;
    @Size(max = 64)
    @Column(name = "account_name")
    private String accountName;
    @Size(max = 64)
    @Column(name = "account_client")
    private String accountClient;
    @Size(max = 255)
    @Column(name = "account_desc")
    private String accountDesc;
    @OneToMany(mappedBy = "managerAccountId")
    private Collection<Manager> managerCollection;
    @OneToMany(mappedBy = "projectAccount")
    private Collection<Project> projectCollection;
    @JoinColumn(name = "account_head", referencedColumnName = "regid")
    @ManyToOne
    private User accountHead;
    @JoinColumn(name = "account_location", referencedColumnName = "location_id")
    @ManyToOne
    private Location accountLocation;
    @JoinColumn(name = "account_lob", referencedColumnName = "lob_id")
    @ManyToOne
    private Lob accountLob;

    public Account() {
    }

    public Account(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountClient() {
        return accountClient;
    }

    public void setAccountClient(String accountClient) {
        this.accountClient = accountClient;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    @XmlTransient
    public Collection<Manager> getManagerCollection() {
        return managerCollection;
    }

    public void setManagerCollection(Collection<Manager> managerCollection) {
        this.managerCollection = managerCollection;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    public User getAccountHead() {
        return accountHead;
    }

    public void setAccountHead(User accountHead) {
        this.accountHead = accountHead;
    }

    public Location getAccountLocation() {
        return accountLocation;
    }

    public void setAccountLocation(Location accountLocation) {
        this.accountLocation = accountLocation;
    }

    public Lob getAccountLob() {
        return accountLob;
    }

    public void setAccountLob(Lob accountLob) {
        this.accountLob = accountLob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Account[ accountId=" + accountId + " ]";
    }
    
}
