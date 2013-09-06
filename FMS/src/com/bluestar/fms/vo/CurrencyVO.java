
package com.bluestar.fms.vo;

import java.io.Serializable;

public class CurrencyVO implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Long currencyId;
   
    private String currencyCode;
    
    private String currencyName;
    
    private String currencySymbol;
    
    

    public CurrencyVO() {
    }

    public CurrencyVO(Long currencyId) {
        this.currencyId = currencyId;
    }

    public CurrencyVO(Long currencyId, String currencyCode, String currencyName, String currencySymbol) {
        this.currencyId = currencyId;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyId != null ? currencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrencyVO)) {
            return false;
        }
        CurrencyVO other = (CurrencyVO) object;
        if ((this.currencyId == null && other.currencyId != null) || (this.currencyId != null && !this.currencyId.equals(other.currencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Currency[ currencyId=" + currencyId + " ]";
    }
    
}
