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
    
    private String lobHead;
   
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

    public String getLobHead() {
        return lobHead;
    }

    public void setLobHead(String lobHead) {
        this.lobHead = lobHead;
    }

    public String getLobDesc() {
        return lobDesc;
    }

    public void setLobDesc(String lobDesc) {
        this.lobDesc = lobDesc;
    }

   
    
}
