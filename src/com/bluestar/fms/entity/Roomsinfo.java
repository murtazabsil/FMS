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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author murtaza.khan
 */
@Entity
@Table(name = "roomsinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roomsinfo.findAll", query = "SELECT r FROM Roomsinfo r"),
    @NamedQuery(name = "Roomsinfo.findBySno", query = "SELECT r FROM Roomsinfo r WHERE r.sno = :sno"),
    @NamedQuery(name = "Roomsinfo.findByRoomID", query = "SELECT r FROM Roomsinfo r WHERE r.roomID = :roomID"),
    @NamedQuery(name = "Roomsinfo.findByResortID", query = "SELECT r FROM Roomsinfo r WHERE r.resortID = :resortID"),
    @NamedQuery(name = "Roomsinfo.findByLocationName", query = "SELECT r FROM Roomsinfo r WHERE r.locationName = :locationName"),
    @NamedQuery(name = "Roomsinfo.findByRoomType", query = "SELECT r FROM Roomsinfo r WHERE r.roomType = :roomType"),
    @NamedQuery(name = "Roomsinfo.findByRoomArea", query = "SELECT r FROM Roomsinfo r WHERE r.roomArea = :roomArea"),
    @NamedQuery(name = "Roomsinfo.findByDryKitchenette", query = "SELECT r FROM Roomsinfo r WHERE r.dryKitchenette = :dryKitchenette"),
    @NamedQuery(name = "Roomsinfo.findBySofacumBed", query = "SELECT r FROM Roomsinfo r WHERE r.sofacumBed = :sofacumBed"),
    @NamedQuery(name = "Roomsinfo.findByDoubleBeds", query = "SELECT r FROM Roomsinfo r WHERE r.doubleBeds = :doubleBeds"),
    @NamedQuery(name = "Roomsinfo.findByTelephone", query = "SELECT r FROM Roomsinfo r WHERE r.telephone = :telephone"),
    @NamedQuery(name = "Roomsinfo.findByTelevision", query = "SELECT r FROM Roomsinfo r WHERE r.television = :television"),
    @NamedQuery(name = "Roomsinfo.findByRoomCharges", query = "SELECT r FROM Roomsinfo r WHERE r.roomCharges = :roomCharges")})
public class Roomsinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Sno")
    private String sno;
    @Size(max = 100)
    @Column(name = "RoomID")
    private String roomID;
    @Size(max = 100)
    @Column(name = "ResortID")
    private String resortID;
    @Size(max = 100)
    @Column(name = "LocationName")
    private String locationName;
    @Size(max = 100)
    @Column(name = "RoomType")
    private String roomType;
    @Size(max = 100)
    @Column(name = "RoomArea")
    private String roomArea;
    @Size(max = 100)
    @Column(name = "DryKitchenette")
    private String dryKitchenette;
    @Size(max = 100)
    @Column(name = "SofacumBed")
    private String sofacumBed;
    @Size(max = 100)
    @Column(name = "DoubleBeds")
    private String doubleBeds;
    @Size(max = 100)
    @Column(name = "Telephone")
    private String telephone;
    @Size(max = 100)
    @Column(name = "Television")
    private String television;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RoomCharges")
    private Float roomCharges;

    public Roomsinfo() {
    }

    public Roomsinfo(String sno) {
        this.sno = sno;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getResortID() {
        return resortID;
    }

    public void setResortID(String resortID) {
        this.resortID = resortID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea;
    }

    public String getDryKitchenette() {
        return dryKitchenette;
    }

    public void setDryKitchenette(String dryKitchenette) {
        this.dryKitchenette = dryKitchenette;
    }

    public String getSofacumBed() {
        return sofacumBed;
    }

    public void setSofacumBed(String sofacumBed) {
        this.sofacumBed = sofacumBed;
    }

    public String getDoubleBeds() {
        return doubleBeds;
    }

    public void setDoubleBeds(String doubleBeds) {
        this.doubleBeds = doubleBeds;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelevision() {
        return television;
    }

    public void setTelevision(String television) {
        this.television = television;
    }

    public Float getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(Float roomCharges) {
        this.roomCharges = roomCharges;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sno != null ? sno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomsinfo)) {
            return false;
        }
        Roomsinfo other = (Roomsinfo) object;
        if ((this.sno == null && other.sno != null) || (this.sno != null && !this.sno.equals(other.sno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Roomsinfo[ sno=" + sno + " ]";
    }
    
}
