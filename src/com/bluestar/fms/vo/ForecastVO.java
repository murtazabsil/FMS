package com.bluestar.fms.vo;

import java.util.Date;
import java.util.Map;

/**
 * @author murtaza.khan
 *
 */
public class ForecastVO {
	
	private Long forecastId;
	private String forecastName;
	private int forecastYear;
	private int forecastMonth;
	private String forecastMonthDesc;
	private long projectId;
	private String projectName;
	private long createdBy;
	private String createdByName;
	private Date createdOn;
	private String createdOnDesc;
	private Double[] forecastData;
	
	public String getCreatedOnDesc() {
		return createdOnDesc;
	}
	public void setCreatedOnDesc(String createdOnDesc) {
		this.createdOnDesc = createdOnDesc;
	}
	public String getForecastMonthDesc() {
		return forecastMonthDesc;
	}
	public void setForecastMonthDesc(String forecastMonthDesc) {
		this.forecastMonthDesc = forecastMonthDesc;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public Long getForecastId() {
		return forecastId;
	}
	public void setForecastId(Long forecastId) {
		this.forecastId = forecastId;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getForecastName() {
		return forecastName;
	}
	public void setForecastName(String forecastName) {
		this.forecastName = forecastName;
	}
	public int getForecastYear() {
		return forecastYear;
	}
	public void setForecastYear(int forecastYear) {
		this.forecastYear = forecastYear;
	}
	public int getForecastMonth() {
		return forecastMonth;
	}
	public void setForecastMonth(int forecastMonth) {
		this.forecastMonth = forecastMonth;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Double[] getForecastData() {
		return forecastData;
	}
	public void setForecastData(Double[] forecastData) {
		this.forecastData = forecastData;
	}
}
