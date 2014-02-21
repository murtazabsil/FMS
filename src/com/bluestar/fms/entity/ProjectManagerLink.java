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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author murtaza.khan
 */
@Entity
@Table(name = "project_manager_link")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectManagerLink.findAll", query = "SELECT p FROM ProjectManagerLink p"),
    @NamedQuery(name = "ProjectManagerLink.findByProjectManagerLinkId", query = "SELECT p FROM ProjectManagerLink p WHERE p.projectManagerLinkId = :projectManagerLinkId")})
public class ProjectManagerLink implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "project_manager_link_id")
    private Long projectManagerLinkId;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private Project projectId;
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
    @ManyToOne(optional = false)
    private Manager managerId;

    public ProjectManagerLink() {
    }

    public ProjectManagerLink(Long projectManagerLinkId) {
        this.projectManagerLinkId = projectManagerLinkId;
    }

    public Long getProjectManagerLinkId() {
        return projectManagerLinkId;
    }

    public void setProjectManagerLinkId(Long projectManagerLinkId) {
        this.projectManagerLinkId = projectManagerLinkId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public Manager getManagerId() {
        return managerId;
    }

    public void setManagerId(Manager managerId) {
        this.managerId = managerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectManagerLinkId != null ? projectManagerLinkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectManagerLink)) {
            return false;
        }
        ProjectManagerLink other = (ProjectManagerLink) object;
        if ((this.projectManagerLinkId == null && other.projectManagerLinkId != null) || (this.projectManagerLinkId != null && !this.projectManagerLinkId.equals(other.projectManagerLinkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.ProjectManagerLink[ projectManagerLinkId=" + projectManagerLinkId + " ]";
    }
    
}
