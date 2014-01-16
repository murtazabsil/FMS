package com.bluestar.fms.vo;

public class StatusVO {
	

    private static final long serialVersionUID = 1L;
    
    private Long statusId;
   
    private String statusDesc;
   
    private String statusCode;

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
    
    

  
	
}
