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
@Table(name = "actual_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActualDetail.findAll", query = "SELECT a FROM ActualDetail a"),
    @NamedQuery(name = "ActualDetail.findByActualDetailId", query = "SELECT a FROM ActualDetail a WHERE a.actualDetailId = :actualDetailId"),
    @NamedQuery(name = "ActualDetail.findByCost", query = "SELECT a FROM ActualDetail a WHERE a.cost = :cost")})
public class ActualDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "actual_detail_id")
    private Long actualDetailId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;
    @JoinColumn(name = "actual_id", referencedColumnName = "actual_id")
    @ManyToOne(optional = false)
    private Actual actualId;
    @JoinColumn(name = "month_id", referencedColumnName = "month_id")
    @ManyToOne(optional = false)
    private Month monthId;

    public ActualDetail() {
    }

    public ActualDetail(Long actualDetailId) {
        this.actualDetailId = actualDetailId;
    }

    public Long getActualDetailId() {
        return actualDetailId;
    }

    public void setActualDetailId(Long actualDetailId) {
        this.actualDetailId = actualDetailId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Actual getActualId() {
        return actualId;
    }

    public void setActualId(Actual actualId) {
        this.actualId = actualId;
    }

    public Month getMonthId() {
        return monthId;
    }

    public void setMonthId(Month monthId) {
        this.monthId = monthId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actualDetailId != null ? actualDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActualDetail)) {
            return false;
        }
        ActualDetail other = (ActualDetail) object;
        if ((this.actualDetailId == null && other.actualDetailId != null) || (this.actualDetailId != null && !this.actualDetailId.equals(other.actualDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.ActualDetail[ actualDetailId=" + actualDetailId + " ]";
    }
    
}
