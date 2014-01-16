package com.bluestar.fms.vo;

import java.io.Serializable;

public class CityVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long cityId;
   
    private String cityName;
   
    private String cityInfo;
    
    private String cityCode;

    private Long countryId;
      
    private Double latitude;
   
    private Double longitude;

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

	public CityVO() {
    }

    public CityVO(Long cityId) {
        this.cityId = cityId;
    }
    
    public CityVO(Long cityId,String cityName ,String cityInfo,String cityCode,Long countryId) {
    	
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityInfo =	cityInfo;
        this.cityCode = cityCode;
        this.countryId = countryId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

  
    public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
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
        if (!(object instanceof CityVO)) {
            return false;
        }
        CityVO other = (CityVO) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "City[ cityId=" + cityId + " ]";
    }
    
}
