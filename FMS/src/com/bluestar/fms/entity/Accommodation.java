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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pankaj.amal
 */
@Entity
@Table(name = "accommodation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accommodation.findAll", query = "SELECT a FROM Accommodation a"),
    @NamedQuery(name = "Accommodation.findByLocationID", query = "SELECT a FROM Accommodation a WHERE a.locationID = :locationID"),
    @NamedQuery(name = "Accommodation.findByLocationName", query = "SELECT a FROM Accommodation a WHERE a.locationName = :locationName"),
    @NamedQuery(name = "Accommodation.findByLocationImage", query = "SELECT a FROM Accommodation a WHERE a.locationImage = :locationImage"),
    @NamedQuery(name = "Accommodation.findByLocationDesc", query = "SELECT a FROM Accommodation a WHERE a.locationDesc = :locationDesc")})
public class Accommodation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LocationID")
    private String locationID;
    @Column(name = "LocationName")
    private String locationName;
    @Column(name = "LocationImage")
    private String locationImage;
    @Column(name = "LocationDesc")
    private String locationDesc;

    public Accommodation() {
    }

    public Accommodation(String locationID) {
        this.locationID = locationID;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationImage() {
        return locationImage;
    }

    public void setLocationImage(String locationImage) {
        this.locationImage = locationImage;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationID != null ? locationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accommodation)) {
            return false;
        }
        Accommodation other = (Accommodation) object;
        if ((this.locationID == null && other.locationID != null) || (this.locationID != null && !this.locationID.equals(other.locationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Accommodation[ locationID=" + locationID + " ]";
    }
    
}
