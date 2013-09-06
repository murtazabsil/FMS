package com.bluestar.fms.vo;

public class LocationVO {

	 private static final long serialVersionUID = 1L;
	 private Long locationId;
	   
	    private String locationDesc;
	   
	    private String locationCode;
	    
	    private String locationName;

		public Long getLocationId() {
			return locationId;
		}

		public void setLocationId(Long locationId) {
			this.locationId = locationId;
		}

		public String getLocationDesc() {
			return locationDesc;
		}

		public void setLocationDesc(String locationDesc) {
			this.locationDesc = locationDesc;
		}

		public String getLocationCode() {
			return locationCode;
		}

		public void setLocationCode(String locationCode) {
			this.locationCode = locationCode;
		}

		public String getLocationName() {
			return locationName;
		}

		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}
	    
	    
}
