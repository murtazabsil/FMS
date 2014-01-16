package com.bluestar.fms.vo;

import java.io.Serializable;

public class CityListVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private CityVO cityVO;
	private Long totalLocations;
	
	public CityVO getCityVO() {
		return cityVO;
	}
	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}
	public Long getTotalLocations() {
		return totalLocations;
	}
	public void setTotalLocations(Long totalLocations) {
		this.totalLocations = totalLocations;
	}
	
	
	

}
