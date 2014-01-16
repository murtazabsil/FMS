package com.bluestar.fms.vo;

public class ResponseVO {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private String module;
	private int result;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	
}
