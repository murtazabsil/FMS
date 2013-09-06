package com.bluestar.fms.vo;

import java.io.Serializable;

public class CountryVO implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Long countryId;
    
    private String countryName;
   
    private String countryCode;
    
    private String countryInfo;
   
    private Long zoneId;
    
    

    public CountryVO() {
    }

    public CountryVO(Long countryId) {
        this.countryId = countryId;
    }
    
    public CountryVO(Long countryId,String countryName,String countryCode,String countryInfo) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryInfo = countryInfo;
    }


    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(String countryInfo) {
        this.countryInfo = countryInfo;
    }

   
    
    public Long getZoneId() {
		return zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryVO)) {
            return false;
        }
        CountryVO other = (CountryVO) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Country[ countryId=" + countryId + " ]";
    }
    
}
