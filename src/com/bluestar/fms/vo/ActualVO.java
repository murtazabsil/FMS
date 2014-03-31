package com.bluestar.fms.vo;

import java.util.Date;

public class ActualVO {

	private Long actualId;
	private String actualName;
	private Long projectId;
	private String projectName;
	private Long forecastId;
	private String forecastName;
	private Double[] actualData;
	private String monthName;
	private Long createdBy;
	private String createdByName;
	private Date createdOn;

	public Long getActualId() {
		return actualId;
	}

	public void setActualId(Long actualId) {
		this.actualId = actualId;
	}

	public String getActualName() {
		return actualName;
	}

	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getForecastId() {
		return forecastId;
	}

	public void setForecastId(Long forecastId) {
		this.forecastId = forecastId;
	}

	public String getForecastName() {
		return forecastName;
	}

	public void setForecastName(String forecastName) {
		this.forecastName = forecastName;
	}

	public Double[] getActualData() {
		return actualData;
	}

	public void setActualData(Double[] actualData) {
		this.actualData = actualData;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
