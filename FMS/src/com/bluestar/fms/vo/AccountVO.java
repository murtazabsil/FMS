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
    
    private String accountClient;
   
    private BigInteger accountLocation;
   
    private String accountHead;
   
    private String accountDesc;

   

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

    public String getAccountHead() {
        return accountHead;
    }

    public void setAccountHead(String accountHead) {
        this.accountHead = accountHead;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

   
}
