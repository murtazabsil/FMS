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
@Table(name = "forecast_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForecastType.findAll", query = "SELECT f FROM ForecastType f"),
    @NamedQuery(name = "ForecastType.findByForecastTypeId", query = "SELECT f FROM ForecastType f WHERE f.forecastTypeId = :forecastTypeId"),
    @NamedQuery(name = "ForecastType.findByForecastType", query = "SELECT f FROM ForecastType f WHERE f.forecastType = :forecastType")})
public class ForecastType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "forecast_type_id")
    private Long forecastTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "forecast_type")
    private String forecastType;

    public ForecastType() {
    }

    public ForecastType(Long forecastTypeId) {
        this.forecastTypeId = forecastTypeId;
    }

    public ForecastType(Long forecastTypeId, String forecastType) {
        this.forecastTypeId = forecastTypeId;
        this.forecastType = forecastType;
    }

    public Long getForecastTypeId() {
        return forecastTypeId;
    }

    public void setForecastTypeId(Long forecastTypeId) {
        this.forecastTypeId = forecastTypeId;
    }

    public String getForecastType() {
        return forecastType;
    }

    public void setForecastType(String forecastType) {
        this.forecastType = forecastType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forecastTypeId != null ? forecastTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForecastType)) {
            return false;
        }
        ForecastType other = (ForecastType) object;
        if ((this.forecastTypeId == null && other.forecastTypeId != null) || (this.forecastTypeId != null && !this.forecastTypeId.equals(other.forecastTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.ForecastType[ forecastTypeId=" + forecastTypeId + " ]";
    }
    
}
