/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Basic;

/**
 *
 * @author pankaj.amal
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByProjectId", query = "SELECT p FROM Project p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "Project.findByProjectName", query = "SELECT p FROM Project p WHERE p.projectName = :projectName"),
    @NamedQuery(name = "Project.findByStartDate", query = "SELECT p FROM Project p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Project.findByEndDate", query = "SELECT p FROM Project p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Project.findByProjectDesc", query = "SELECT p FROM Project p WHERE p.projectDesc = :projectDesc")})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_id")
    private Long projectId;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "project_desc")
    private String projectDesc;
    @JoinColumn(name = "project_type", referencedColumnName = "type_id")
    @ManyToOne
    private Type projectType;
    @JoinColumn(name = "project_status", referencedColumnName = "status_id")
    @ManyToOne
    private Status projectStatus;
    @JoinColumn(name = "pm_id", referencedColumnName = "manager_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Manager manager;
    @JoinColumn(name = "project_priority", referencedColumnName = "priority_id")
    @ManyToOne
    private Priority projectPriority;
    @JoinColumn(name = "project_lob", referencedColumnName = "lob_id")
    @ManyToOne
    private Lob projectLob;
    @JoinColumn(name = "project_base_currency", referencedColumnName = "currency_id")
    @ManyToOne
    private Currency projectBaseCurrency;
    @JoinColumn(name = "project_account", referencedColumnName = "account_id")
    @ManyToOne
    private Account projectAccount;

    public Project() {
    }

    public Project(Long projectId) {
        this.projectId = projectId;
    }

   
   public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public Type getProjectType() {
        return projectType;
    }

    public void setProjectType(Type projectType) {
        this.projectType = projectType;
    }

    public Status getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Status projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Priority getProjectPriority() {
        return projectPriority;
    }

    public void setProjectPriority(Priority projectPriority) {
        this.projectPriority = projectPriority;
    }

    public Lob getProjectLob() {
        return projectLob;
    }

    public void setProjectLob(Lob projectLob) {
        this.projectLob = projectLob;
    }

    public Currency getProjectBaseCurrency() {
        return projectBaseCurrency;
    }

    public void setProjectBaseCurrency(Currency projectBaseCurrency) {
        this.projectBaseCurrency = projectBaseCurrency;
    }

    public Account getProjectAccount() {
        return projectAccount;
    }

    public void setProjectAccount(Account projectAccount) {
        this.projectAccount = projectAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Project[ project=" + projectId + " ]";
    }
    
}
