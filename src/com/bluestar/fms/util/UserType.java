package com.bluestar.fms.util;

public enum UserType {

	PROJECT(1), MANAGER(2), ACCOUNT(3), LOB(4);
   
	private int value;

    private UserType(int value) {
            this.value = value;
    }
    
    public int getUserType(){
    	return value;
    }
}
