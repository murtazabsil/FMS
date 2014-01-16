/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author murtaza.khan
 */
@Entity
@Table(name = "bookingsinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookingsinfo.findAll", query = "SELECT b FROM Bookingsinfo b"),
    @NamedQuery(name = "Bookingsinfo.findByBookingID", query = "SELECT b FROM Bookingsinfo b WHERE b.bookingID = :bookingID"),
    @NamedQuery(name = "Bookingsinfo.findByResortID", query = "SELECT b FROM Bookingsinfo b WHERE b.resortID = :resortID"),
    @NamedQuery(name = "Bookingsinfo.findByRoomID", query = "SELECT b FROM Bookingsinfo b WHERE b.roomID = :roomID"),
    @NamedQuery(name = "Bookingsinfo.findByLocationName", query = "SELECT b FROM Bookingsinfo b WHERE b.locationName = :locationName"),
    @NamedQuery(name = "Bookingsinfo.findByUserID", query = "SELECT b FROM Bookingsinfo b WHERE b.userID = :userID"),
    @NamedQuery(name = "Bookingsinfo.findByMemberType", query = "SELECT b FROM Bookingsinfo b WHERE b.memberType = :memberType"),
    @NamedQuery(name = "Bookingsinfo.findByRoomCharges", query = "SELECT b FROM Bookingsinfo b WHERE b.roomCharges = :roomCharges"),
    @NamedQuery(name = "Bookingsinfo.findByFrom", query = "SELECT b FROM Bookingsinfo b WHERE b.from = :from"),
    @NamedQuery(name = "Bookingsinfo.findByTo", query = "SELECT b FROM Bookingsinfo b WHERE b.to = :to"),
    @NamedQuery(name = "Bookingsinfo.findByBookingStatus", query = "SELECT b FROM Bookingsinfo b WHERE b.bookingStatus = :bookingStatus")})
public class Bookingsinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BookingID")
    private String bookingID;
    @Size(max = 100)
    @Column(name = "ResortID")
    private String resortID;
    @Size(max = 100)
    @Column(name = "RoomID")
    private String roomID;
    @Size(max = 100)
    @Column(name = "LocationName")
    private String locationName;
    @Size(max = 100)
    @Column(name = "UserID")
    private String userID;
    @Size(max = 100)
    @Column(name = "MemberType")
    private String memberType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RoomCharges")
    private Float roomCharges;
    @Column(name = "From")
    @Temporal(TemporalType.DATE)
    private Date from;
    @Column(name = "To")
    @Temporal(TemporalType.DATE)
    private Date to;
    @Size(max = 100)
    @Column(name = "BookingStatus")
    private String bookingStatus;

    public Bookingsinfo() {
    }

    public Bookingsinfo(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getResortID() {
        return resortID;
    }

    public void setResortID(String resortID) {
        this.resortID = resortID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public Float getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(Float roomCharges) {
        this.roomCharges = roomCharges;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingID != null ? bookingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookingsinfo)) {
            return false;
        }
        Bookingsinfo other = (Bookingsinfo) object;
        if ((this.bookingID == null && other.bookingID != null) || (this.bookingID != null && !this.bookingID.equals(other.bookingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Bookingsinfo[ bookingID=" + bookingID + " ]";
    }
    
}
