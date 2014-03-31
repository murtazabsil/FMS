/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByRegid", query = "SELECT u FROM User u WHERE u.regid = :regid"),
    @NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
    @NamedQuery(name = "User.findByEmailaddress", query = "SELECT u FROM User u WHERE u.emailaddress = :emailaddress"),
    @NamedQuery(name = "User.findByDesignation", query = "SELECT u FROM User u WHERE u.designation = :designation"),
    @NamedQuery(name = "User.findByEmpid", query = "SELECT u FROM User u WHERE u.empid = :empid"),
    @NamedQuery(name = "User.findByContactnumber", query = "SELECT u FROM User u WHERE u.contactnumber = :contactnumber")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "regid")
    private Long regid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "userid")
    private String userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 100)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 200)
    @Column(name = "address")
    private String address;
    @Size(max = 64)
    @Column(name = "emailaddress")
    private String emailaddress;
    @Column(name = "designation")
    private BigInteger designation;
    @Size(max = 20)
    @Column(name = "empid")
    private String empid;
    @Size(max = 20)
    @Column(name = "contactnumber")
    private String contactnumber;
    @OneToMany(mappedBy = "lobHead")
    private Collection<Lob> lobCollection;
    @OneToMany(mappedBy = "accountHead")
    private Collection<Account> accountCollection;
    @JoinColumn(name = "user_type", referencedColumnName = "user_type_id")
    @ManyToOne
    private UserType userType;

    public User() {
    }

    public User(Long regid) {
        this.regid = regid;
    }

    public User(Long regid, String userid, String password) {
        this.regid = regid;
        this.userid = userid;
        this.password = password;
    }

    public Long getRegid() {
        return regid;
    }

    public void setRegid(Long regid) {
        this.regid = regid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public BigInteger getDesignation() {
        return designation;
    }

    public void setDesignation(BigInteger designation) {
        this.designation = designation;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    @XmlTransient
    public Collection<Lob> getLobCollection() {
        return lobCollection;
    }

    public void setLobCollection(Collection<Lob> lobCollection) {
        this.lobCollection = lobCollection;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regid != null ? regid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.regid == null && other.regid != null) || (this.regid != null && !this.regid.equals(other.regid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.User[ regid=" + regid + " ]";
    }
    
}
