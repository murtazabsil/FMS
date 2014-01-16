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
@Table(name = "forecast_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForecastDetail.findAll", query = "SELECT f FROM ForecastDetail f"),
    @NamedQuery(name = "ForecastDetail.findByForecastDetailId", query = "SELECT f FROM ForecastDetail f WHERE f.forecastDetailId = :forecastDetailId"),
    @NamedQuery(name = "ForecastDetail.findByCost", query = "SELECT f FROM ForecastDetail f WHERE f.cost = :cost")})
public class ForecastDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "forecast_detail_id")
    private Long forecastDetailId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;
    @JoinColumn(name = "month_id", referencedColumnName = "month_id")
    @ManyToOne(optional = false)
    private Month monthId;
    @JoinColumn(name = "forecast_id", referencedColumnName = "forecast_id")
    @ManyToOne(optional = false)
    private Forecast forecastId;

    public ForecastDetail() {
    }

    public ForecastDetail(Long forecastDetailId) {
        this.forecastDetailId = forecastDetailId;
    }

    public Long getForecastDetailId() {
        return forecastDetailId;
    }

    public void setForecastDetailId(Long forecastDetailId) {
        this.forecastDetailId = forecastDetailId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Month getMonthId() {
        return monthId;
    }

    public void setMonthId(Month monthId) {
        this.monthId = monthId;
    }

    public Forecast getForecastId() {
        return forecastId;
    }

    public void setForecastId(Forecast forecastId) {
        this.forecastId = forecastId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forecastDetailId != null ? forecastDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForecastDetail)) {
            return false;
        }
        ForecastDetail other = (ForecastDetail) object;
        if ((this.forecastDetailId == null && other.forecastDetailId != null) || (this.forecastDetailId != null && !this.forecastDetailId.equals(other.forecastDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.ForecastDetail[ forecastDetailId=" + forecastDetailId + " ]";
    }
    
}
