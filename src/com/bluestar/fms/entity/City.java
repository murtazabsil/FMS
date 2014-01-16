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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "city")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findByCityCode", query = "SELECT c FROM City c WHERE c.cityCode = :cityCode"),
    @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName"),
    @NamedQuery(name = "City.findByCityId", query = "SELECT c FROM City c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "City.findByLatitude", query = "SELECT c FROM City c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "City.findByLongitude", query = "SELECT c FROM City c WHERE c.longitude = :longitude"),
    @NamedQuery(name = "City.findByCityImage", query = "SELECT c FROM City c WHERE c.cityImage = :cityImage")})
public class City implements Serializable {
    private static final long serialVersionUID = 1L;
    @Lob
    @Size(max = 65535)
    @Column(name = "city_info")
    private String cityInfo;
    @Size(max = 5)
    @Column(name = "city_code")
    private String cityCode;
    @Size(max = 64)
    @Column(name = "city_name")
    private String cityName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "city_id")
    private Long cityId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Size(max = 128)
    @Column(name = "city_image")
    private String cityImage;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(optional = false)
    private Country countryId;

    public City() {
    }

    public City(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(String cityInfo) {
        this.cityInfo = cityInfo;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCityImage() {
        return cityImage;
    }

    public void setCityImage(String cityImage) {
        this.cityImage = cityImage;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.City[ cityId=" + cityId + " ]";
    }
    
}
