package com.bluestar.fms.vo;

public class LinkVO {
	
private static final long serialVersionUID = 1L;
    
    private Long linkId;
   
    private Long pmId;
   
    private Long projectId;

	public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public Long getPmId() {
		return pmId;
	}

	public void setPmId(Long pmId) {
		this.pmId = pmId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

    
}
