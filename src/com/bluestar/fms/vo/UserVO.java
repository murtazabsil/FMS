/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.vo;

import java.io.Serializable;


/**
 *
 * @author pankaj.amal
 */

public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Long regID;
    
    private Long loginID;
    
    private String userName;
    
    private String firstName;
    
    private String lastName;
    
    private String empId;
  
    private Integer designation;
   
    private String emailAddress;
    
    private String address;
    
    private String contactNumber;
  
    private Integer userType;
    
    private String userTypeName;
    
    private Integer approve;
    
    private LoginVO loginVO;
    
	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public Long getLoginID() {
		return loginID;
	}

	public void setLoginID(Long loginID) {
		this.loginID = loginID;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public Integer getApprove() {
		return approve;
	}

	public void setApprove(Integer approve) {
		this.approve = approve;
	}

	public Long getRegID() {
		return regID;
	}

	public void setRegID(Long regID) {
		this.regID = regID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Integer getDesignation() {
		return designation;
	}

	public void setDesignation(Integer designation) {
		this.designation = designation;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}
   

    
   }
