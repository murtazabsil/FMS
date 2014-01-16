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
@Table(name = "resortsinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resortsinfo.findAll", query = "SELECT r FROM Resortsinfo r"),
    @NamedQuery(name = "Resortsinfo.findByResortID", query = "SELECT r FROM Resortsinfo r WHERE r.resortID = :resortID"),
    @NamedQuery(name = "Resortsinfo.findByLocationName", query = "SELECT r FROM Resortsinfo r WHERE r.locationName = :locationName"),
    @NamedQuery(name = "Resortsinfo.findByResortImage", query = "SELECT r FROM Resortsinfo r WHERE r.resortImage = :resortImage"),
    @NamedQuery(name = "Resortsinfo.findByNoOfRooms", query = "SELECT r FROM Resortsinfo r WHERE r.noOfRooms = :noOfRooms"),
    @NamedQuery(name = "Resortsinfo.findByNoOfRoomsAvailable", query = "SELECT r FROM Resortsinfo r WHERE r.noOfRoomsAvailable = :noOfRoomsAvailable"),
    @NamedQuery(name = "Resortsinfo.findByRestaurant", query = "SELECT r FROM Resortsinfo r WHERE r.restaurant = :restaurant"),
    @NamedQuery(name = "Resortsinfo.findBySwimmingpool", query = "SELECT r FROM Resortsinfo r WHERE r.swimmingpool = :swimmingpool"),
    @NamedQuery(name = "Resortsinfo.findByGamesRoom", query = "SELECT r FROM Resortsinfo r WHERE r.gamesRoom = :gamesRoom"),
    @NamedQuery(name = "Resortsinfo.findByCasino", query = "SELECT r FROM Resortsinfo r WHERE r.casino = :casino"),
    @NamedQuery(name = "Resortsinfo.findByYogaandMeditation", query = "SELECT r FROM Resortsinfo r WHERE r.yogaandMeditation = :yogaandMeditation"),
    @NamedQuery(name = "Resortsinfo.findBySteamBath", query = "SELECT r FROM Resortsinfo r WHERE r.steamBath = :steamBath"),
    @NamedQuery(name = "Resortsinfo.findByGymandHealthCenter", query = "SELECT r FROM Resortsinfo r WHERE r.gymandHealthCenter = :gymandHealthCenter")})
public class Resortsinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ResortID")
    private String resortID;
    @Size(max = 100)
    @Column(name = "LocationName")
    private String locationName;
    @Size(max = 200)
    @Column(name = "ResortImage")
    private String resortImage;
    @Column(name = "NoOfRooms")
    private Integer noOfRooms;
    @Column(name = "NoOfRoomsAvailable")
    private Integer noOfRoomsAvailable;
    @Size(max = 100)
    @Column(name = "Restaurant")
    private String restaurant;
    @Size(max = 100)
    @Column(name = "Swimmingpool")
    private String swimmingpool;
    @Size(max = 100)
    @Column(name = "GamesRoom")
    private String gamesRoom;
    @Size(max = 100)
    @Column(name = "Casino")
    private String casino;
    @Size(max = 100)
    @Column(name = "YogaandMeditation")
    private String yogaandMeditation;
    @Size(max = 100)
    @Column(name = "SteamBath")
    private String steamBath;
    @Size(max = 100)
    @Column(name = "GymandHealthCenter")
    private String gymandHealthCenter;

    public Resortsinfo() {
    }

    public Resortsinfo(String resortID) {
        this.resortID = resortID;
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

    public String getResortImage() {
        return resortImage;
    }

    public void setResortImage(String resortImage) {
        this.resortImage = resortImage;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Integer getNoOfRoomsAvailable() {
        return noOfRoomsAvailable;
    }

    public void setNoOfRoomsAvailable(Integer noOfRoomsAvailable) {
        this.noOfRoomsAvailable = noOfRoomsAvailable;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getSwimmingpool() {
        return swimmingpool;
    }

    public void setSwimmingpool(String swimmingpool) {
        this.swimmingpool = swimmingpool;
    }

    public String getGamesRoom() {
        return gamesRoom;
    }

    public void setGamesRoom(String gamesRoom) {
        this.gamesRoom = gamesRoom;
    }

    public String getCasino() {
        return casino;
    }

    public void setCasino(String casino) {
        this.casino = casino;
    }

    public String getYogaandMeditation() {
        return yogaandMeditation;
    }

    public void setYogaandMeditation(String yogaandMeditation) {
        this.yogaandMeditation = yogaandMeditation;
    }

    public String getSteamBath() {
        return steamBath;
    }

    public void setSteamBath(String steamBath) {
        this.steamBath = steamBath;
    }

    public String getGymandHealthCenter() {
        return gymandHealthCenter;
    }

    public void setGymandHealthCenter(String gymandHealthCenter) {
        this.gymandHealthCenter = gymandHealthCenter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resortID != null ? resortID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resortsinfo)) {
            return false;
        }
        Resortsinfo other = (Resortsinfo) object;
        if ((this.resortID == null && other.resortID != null) || (this.resortID != null && !this.resortID.equals(other.resortID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Resortsinfo[ resortID=" + resortID + " ]";
    }
    
}
