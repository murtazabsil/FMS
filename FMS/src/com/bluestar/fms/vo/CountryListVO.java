package com.bluestar.fms.vo;

import java.io.Serializable;

public class CountryListVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	  private Long countryId;
	  private String countryInfo;
	  
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public String getCountryInfo() {
		return countryInfo;
	}
	public void setCountryInfo(String countryInfo) {
		this.countryInfo = countryInfo;
	}
	  

}
