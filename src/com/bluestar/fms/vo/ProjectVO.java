/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;


/**
 *
 * @author pankaj.amal
 */

public class ProjectVO implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private Long projectId;
    
    private String projectName;
    
    private BigInteger projectLob;
    private String projectLobName;
   
    private BigInteger projectAccount;
    private String projectAccountName;
    private BigInteger projectBaseCurrency;
    private String projectBCName;
    private BigInteger projectPriority;
    private String projectPriorityName;
    private BigInteger projectStatus;
    private String projectStatusName;
    private BigInteger projectType;
    private String projectTypeName;
    private Date startDate;
   
    private Date endDate;
   
    private String projectDesc;
   
    private BigInteger pmId;
    private String projectPMName;
    
    
    
    public String getProjectLobName() {
		return projectLobName;
	}

	public void setProjectLobName(String projectLobName) {
		this.projectLobName = projectLobName;
	}

	public String getProjectAccountName() {
		return projectAccountName;
	}

	public void setProjectAccountName(String projectAccountName) {
		this.projectAccountName = projectAccountName;
	}

	public String getProjectBCName() {
		return projectBCName;
	}

	public void setProjectBCName(String projectBCName) {
		this.projectBCName = projectBCName;
	}

	public String getProjectPriorityName() {
		return projectPriorityName;
	}

	public void setProjectPriorityName(String projectPriorityName) {
		this.projectPriorityName = projectPriorityName;
	}

	public String getProjectStatusName() {
		return projectStatusName;
	}

	public void setProjectStatusName(String projectStatusName) {
		this.projectStatusName = projectStatusName;
	}

	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}

	public String getProjectPMName() {
		return projectPMName;
	}

	public void setProjectPMName(String projectPMName) {
		this.projectPMName = projectPMName;
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

    public BigInteger getProjectLob() {
        return projectLob;
    }

    public void setProjectLob(BigInteger projectLob) {
        this.projectLob = projectLob;
    }

    public BigInteger getProjectAccount() {
        return projectAccount;
    }

    public void setProjectAccount(BigInteger projectAccount) {
        this.projectAccount = projectAccount;
    }

    public BigInteger getProjectBaseCurrency() {
        return projectBaseCurrency;
    }

    public void setProjectBaseCurrency(BigInteger projectBaseCurrency) {
        this.projectBaseCurrency = projectBaseCurrency;
    }

    public BigInteger getProjectPriority() {
        return projectPriority;
    }

    public void setProjectPriority(BigInteger projectPriority) {
        this.projectPriority = projectPriority;
    }

    public BigInteger getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(BigInteger projectStatus) {
        this.projectStatus = projectStatus;
    }

    public BigInteger getProjectType() {
        return projectType;
    }

    public void setProjectType(BigInteger projectType) {
        this.projectType = projectType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public BigInteger getPmId() {
        return pmId;
    }

    public void setPmId(BigInteger pmId) {
        this.pmId = pmId;
    }

    
   
}
