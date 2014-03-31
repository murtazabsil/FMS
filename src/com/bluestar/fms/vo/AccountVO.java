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

public class AccountVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long accountId;
    
    private String accountName;
   
    private BigInteger accountLob;
    
    private String accountLobName;
    
    private String accountClient;
   
    private BigInteger accountLocation;
    
    private String accountLocationName;
   
    private Long accountHeadId;
    
    private String accountHeadName;
   
    private String accountDesc;


    public String getAccountLobName() {
		return accountLobName;
	}

	public void setAccountLobName(String accountLobName) {
		this.accountLobName = accountLobName;
	}

	public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigInteger getAccountLob() {
        return accountLob;
    }

    public void setAccountLob(BigInteger accountLob) {
        this.accountLob = accountLob;
    }

    public String getAccountClient() {
        return accountClient;
    }

    public void setAccountClient(String accountClient) {
        this.accountClient = accountClient;
    }

    public BigInteger getAccountLocation() {
        return accountLocation;
    }

    public void setAccountLocation(BigInteger accountLocation) {
        this.accountLocation = accountLocation;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

	public Long getAccountHeadId() {
		return accountHeadId;
	}

	public void setAccountHeadId(Long accountHeadId) {
		this.accountHeadId = accountHeadId;
	}

	public String getAccountHeadName() {
		return accountHeadName;
	}

	public void setAccountHeadName(String accountHeadName) {
		this.accountHeadName = accountHeadName;
	}

	public String getAccountLocationName() {
		return accountLocationName;
	}

	public void setAccountLocationName(String accountLocationName) {
		this.accountLocationName = accountLocationName;
	}
}
