/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.vo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author pankaj.amal
 */

public class ManagerVO implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Long managerId;
    
    private String managerName;
    
    private String managerEmpId;
   
    private BigInteger managerDeptId;
    private String managerDeptName;
    private BigInteger managerLobId;
    private String managerLobName;
    private BigInteger managerAccountId;
    private String managerAccountName;
    private BigInteger managerLocationId;
    private String managerLocationName;
    private BigInteger managerCurrency;
    private String managerCurrenceName;
    private String managerDescrition;

    public ManagerVO() {
    }

    public ManagerVO(Long managerId) {
        this.managerId = managerId;
    }

    
    
    
    public String getManagerDeptName() {
		return managerDeptName;
	}

	public void setManagerDeptName(String managerDeptName) {
		this.managerDeptName = managerDeptName;
	}

	public String getManagerLobName() {
		return managerLobName;
	}

	public void setManagerLobName(String managerLobName) {
		this.managerLobName = managerLobName;
	}

	public String getManagerAccountName() {
		return managerAccountName;
	}

	public void setManagerAccountName(String managerAccountName) {
		this.managerAccountName = managerAccountName;
	}

	public String getManagerLocationName() {
		return managerLocationName;
	}

	public void setManagerLocationName(String managerLocationName) {
		this.managerLocationName = managerLocationName;
	}

	public String getManagerCurrenceName() {
		return managerCurrenceName;
	}

	public void setManagerCurrenceName(String managerCurrenceName) {
		this.managerCurrenceName = managerCurrenceName;
	}

	public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmpId() {
        return managerEmpId;
    }

    public void setManagerEmpId(String managerEmpId) {
        this.managerEmpId = managerEmpId;
    }

    public BigInteger getManagerDeptId() {
        return managerDeptId;
    }

    public void setManagerDeptId(BigInteger managerDeptId) {
        this.managerDeptId = managerDeptId;
    }

    public BigInteger getManagerLobId() {
        return managerLobId;
    }

    public void setManagerLobId(BigInteger managerLobId) {
        this.managerLobId = managerLobId;
    }

    public BigInteger getManagerAccountId() {
        return managerAccountId;
    }

    public void setManagerAccountId(BigInteger managerAccountId) {
        this.managerAccountId = managerAccountId;
    }

    public BigInteger getManagerLocationId() {
        return managerLocationId;
    }

    public void setManagerLocationId(BigInteger managerLocationId) {
        this.managerLocationId = managerLocationId;
    }

    public BigInteger getManagerCurrency() {
        return managerCurrency;
    }

    public void setManagerCurrency(BigInteger managerCurrency) {
        this.managerCurrency = managerCurrency;
    }

    public String getManagerDescrition() {
        return managerDescrition;
    }

    public void setManagerDescrition(String managerDescrition) {
        this.managerDescrition = managerDescrition;
    }

   
}
