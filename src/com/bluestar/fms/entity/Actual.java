/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author murtaza.khan
 */
@Entity
@Table(name = "actual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actual.findAll", query = "SELECT a FROM Actual a"),
    @NamedQuery(name = "Actual.findByActualId", query = "SELECT a FROM Actual a WHERE a.actualId = :actualId"),
    @NamedQuery(name = "Actual.findByCreatedOn", query = "SELECT a FROM Actual a WHERE a.createdOn = :createdOn")})
public class Actual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "actual_id")
    private Long actualId;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actualId")
    private Collection<ActualDetail> actualDetailCollection;
    @JoinColumn(name = "created_by", referencedColumnName = "manager_id")
    @ManyToOne(optional = false)
    private Manager createdBy;
    @JoinColumn(name = "forecast_id", referencedColumnName = "forecast_id")
    @ManyToOne(optional = false)
    private Forecast forecastId;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private Project projectId;

    public Actual() {
    }

    public Actual(Long actualId) {
        this.actualId = actualId;
    }

    public Long getActualId() {
        return actualId;
    }

    public void setActualId(Long actualId) {
        this.actualId = actualId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @XmlTransient
    public Collection<ActualDetail> getActualDetailCollection() {
        return actualDetailCollection;
    }

    public void setActualDetailCollection(Collection<ActualDetail> actualDetailCollection) {
        this.actualDetailCollection = actualDetailCollection;
    }

    public Manager getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Manager createdBy) {
        this.createdBy = createdBy;
    }

    public Forecast getForecastId() {
        return forecastId;
    }

    public void setForecastId(Forecast forecastId) {
        this.forecastId = forecastId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actualId != null ? actualId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actual)) {
            return false;
        }
        Actual other = (Actual) object;
        if ((this.actualId == null && other.actualId != null) || (this.actualId != null && !this.actualId.equals(other.actualId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Actual[ actualId=" + actualId + " ]";
    }
    
}
