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

public class LobVO implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Long lobId;
   
    private String lobName;
   
    private BigInteger lobLocation;
    
    private String lobLocationName;
    
    private Long lobHeadId;
    
    private String lobHeadName;
   
    private String lobDesc;


    public Long getLobId() {
        return lobId;
    }

    public void setLobId(Long lobId) {
        this.lobId = lobId;
    }

    public String getLobName() {
        return lobName;
    }

    public void setLobName(String lobName) {
        this.lobName = lobName;
    }

    public BigInteger getLobLocation() {
        return lobLocation;
    }

    public void setLobLocation(BigInteger lobLocation) {
        this.lobLocation = lobLocation;
    }
    public String getLobDesc() {
        return lobDesc;
    }

    public void setLobDesc(String lobDesc) {
        this.lobDesc = lobDesc;
    }

	public Long getLobHeadId() {
		return lobHeadId;
	}

	public void setLobHeadId(Long lobHeadId) {
		this.lobHeadId = lobHeadId;
	}

	public String getLobHeadName() {
		return lobHeadName;
	}

	public void setLobHeadName(String lobHeadName) {
		this.lobHeadName = lobHeadName;
	}

	public String getLobLocationName() {
		return lobLocationName;
	}

	public void setLobLocationName(String lobLocationName) {
		this.lobLocationName = lobLocationName;
	}
    
}
