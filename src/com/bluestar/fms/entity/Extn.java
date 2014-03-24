/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "extn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extn.findAll", query = "SELECT e FROM Extn e"),
    @NamedQuery(name = "Extn.findBySrNo", query = "SELECT e FROM Extn e WHERE e.srNo = :srNo"),
    @NamedQuery(name = "Extn.findByExtnNum", query = "SELECT e FROM Extn e WHERE e.extnNum = :extnNum")})
public class Extn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sr_no")
    private Integer srNo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "emp_name")
    private String empName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "extn_num")
    private int extnNum;

    public Extn() {
    }

    public Extn(Integer srNo) {
        this.srNo = srNo;
    }

    public Extn(Integer srNo, String empName, int extnNum) {
        this.srNo = srNo;
        this.empName = empName;
        this.extnNum = extnNum;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getExtnNum() {
        return extnNum;
    }

    public void setExtnNum(int extnNum) {
        this.extnNum = extnNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srNo != null ? srNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extn)) {
            return false;
        }
        Extn other = (Extn) object;
        if ((this.srNo == null && other.srNo != null) || (this.srNo != null && !this.srNo.equals(other.srNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Extn[ srNo=" + srNo + " ]";
    }
    
}
