package com.bluestar.fms.vo;

public class AuthorizeVO {
	 private static final long serialVersionUID = 1L;
	
	private int result;
	private LoginVO loginVO;
	private UserVO userVO;
	
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	
	

}
