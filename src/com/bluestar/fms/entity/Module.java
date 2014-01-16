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
@Table(name = "module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByModuleId", query = "SELECT m FROM Module m WHERE m.moduleId = :moduleId"),
    @NamedQuery(name = "Module.findByModuleName", query = "SELECT m FROM Module m WHERE m.moduleName = :moduleName"),
    @NamedQuery(name = "Module.findByModuleDescription", query = "SELECT m FROM Module m WHERE m.moduleDescription = :moduleDescription")})
public class Module implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "module_id")
    private Long moduleId;
    @Size(max = 20)
    @Column(name = "module_name")
    private String moduleName;
    @Size(max = 100)
    @Column(name = "module_description")
    private String moduleDescription;

    public Module() {
    }

    public Module(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduleId != null ? moduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.moduleId == null && other.moduleId != null) || (this.moduleId != null && !this.moduleId.equals(other.moduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.Module[ moduleId=" + moduleId + " ]";
    }
    
}
