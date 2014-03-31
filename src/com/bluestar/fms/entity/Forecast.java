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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author murtaza.khan
 */
@Entity
@Table(name = "forecast")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forecast.findAll", query = "SELECT f FROM Forecast f"),
    @NamedQuery(name = "Forecast.findByForecastId", query = "SELECT f FROM Forecast f WHERE f.forecastId = :forecastId"),
    @NamedQuery(name = "Forecast.findByForecastName", query = "SELECT f FROM Forecast f WHERE f.forecastName = :forecastName"),
    @NamedQuery(name = "Forecast.findByForecastYear", query = "SELECT f FROM Forecast f WHERE f.forecastYear = :forecastYear"),
    @NamedQuery(name = "Forecast.findByCreatedOn", query = "SELECT f FROM Forecast f WHERE f.createdOn = :createdOn")})
public class Forecast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "forecast_id")
    private Long forecastId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "forecast_name")
    private String forecastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forecast_year")
    private int forecastYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private Project projectId;
    @JoinColumn(name = "forecast_month", referencedColumnName = "month_id")
    @ManyToOne(optional = false)
    private Month forecastMonth;
    @JoinColumn(name = "created_by", referencedColumnName = "manager_id")
    @ManyToOne(optional = false)
    private Manager createdBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forecastId")
    private Collection<ForecastDetail> forecastDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forecastId")
    private Collection<Actual> actualCollection;

    public Forecast() {
    }

    public Forecast(Long forecastId) {
        this.forecastId = forecastId;
    }

    public Forecast(Long forecastId, String forecastName, int forecastYear, Date createdOn) {
        this.forecastId = forecastId;
        this.forecastName = forecastName;
        this.forecastYear = forecastYear;
        this.createdOn = createdOn;
    }

    public Long getForecastId() {
        return forecastId;
    }

    public void setForecastId(Long forecastId) {
        this.forecastId = forecastId;
    }

    public String getForecastName() {
        return forecastName;
    }

    public void setForecastName(String forecastName) {
        this.forecastName = forecastName;
    }

    public int getForecastYear() {
        return forecastYear;
    }

    public void setForecastYear(int forecastYear) {
        this.forecastYear = forecastYear;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public Month getForecastMonth() {
        return forecastMonth;
    }

    public void setForecastMonth(Month forecastMonth) {
        this.forecastMonth = forecastMonth;
    }

    public Manager getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Manager createdBy) {
        this.createdBy = createdBy;
    }

    @XmlTransient
    public Collection<ForecastDetail> getForecastDetailCollection() {
        return forecastDetailCollection;
    }

    public void setForecastDetailCollection(Collection<ForecastDetail> forecastDetailCollection) {
        this.forecastDetailCollection = forecastDetailCollection;
    }

    @XmlTransient
    public Collection<Actual> getActualCollection() {
        return actualCollection;
    }

    public void setActualCollection(Collection<Actual> actualCollection) {
        this.actualCollection = actualCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forecastId != null ? forecastId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forecast)) {
            return false;
        }
        Forecast other = (Forecast) object;
        if ((this.forecastId == null && other.forecastId != null) || (this.forecastId != null && !this.forecastId.equals(other.forecastId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Forecast[ forecastId=" + forecastId + " ]";
    }
    
}
