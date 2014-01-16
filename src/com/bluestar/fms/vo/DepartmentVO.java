  package com.bluestar.fms.vo;


public class DepartmentVO  {
    
    private Long departmentId;
   
    private String departmentName;
    
    private String description;
    
    private boolean enabled;
    
    private Long customerId;
    
    private Integer defaultDepartment;
    
    
	public DepartmentVO() {
    }

    public DepartmentVO(Long departmentId) {
        this.departmentId = departmentId;
    }

   

	public DepartmentVO(Long departmentId, String departmentName,
			String description, boolean enabled, Long customerId,
			Integer defaultDepartment) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.description = description;
		this.enabled = enabled;
		this.customerId = customerId;
		this.defaultDepartment = defaultDepartment;
	}

	public Integer getDefaultDepartment() {
		return defaultDepartment;
	}

	public void setDefaultDepartment(Integer defaultDepartment) {
		this.defaultDepartment = defaultDepartment;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentVO)) {
            return false;
        }
        DepartmentVO other = (DepartmentVO) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Department[ departmentId=" + departmentId + " ]";
    }
    
}
