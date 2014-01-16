/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author murtaza.khan
 */
@Entity
@Table(name = "menu_user_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuUserType.findAll", query = "SELECT m FROM MenuUserType m"),
    @NamedQuery(name = "MenuUserType.findByMenuSeqId", query = "SELECT m FROM MenuUserType m WHERE m.menuSeqId = :menuSeqId"),
    @NamedQuery(name = "MenuUserType.findByMenu", query = "SELECT m FROM MenuUserType m WHERE m.menu = :menu"),
    @NamedQuery(name = "MenuUserType.findByPage", query = "SELECT m FROM MenuUserType m WHERE m.page = :page")})
public class MenuUserType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_seq_id")
    private Long menuSeqId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "menu")
    private String menu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "page")
    private String page;
    @JoinColumn(name = "user_type_id", referencedColumnName = "user_type_id")
    @ManyToOne(optional = false)
    private UserType userTypeId;

    public MenuUserType() {
    }

    public MenuUserType(Long menuSeqId) {
        this.menuSeqId = menuSeqId;
    }

    public MenuUserType(Long menuSeqId, String menu, String page) {
        this.menuSeqId = menuSeqId;
        this.menu = menu;
        this.page = page;
    }

    public Long getMenuSeqId() {
        return menuSeqId;
    }

    public void setMenuSeqId(Long menuSeqId) {
        this.menuSeqId = menuSeqId;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public UserType getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(UserType userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuSeqId != null ? menuSeqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuUserType)) {
            return false;
        }
        MenuUserType other = (MenuUserType) object;
        if ((this.menuSeqId == null && other.menuSeqId != null) || (this.menuSeqId != null && !this.menuSeqId.equals(other.menuSeqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.MenuUserType[ menuSeqId=" + menuSeqId + " ]";
    }
    
}
