package com.bluestar.fms.constants;

public class LoginConstants {
	
	public final static String SQL_VALIDATE_LOGIN = " Select u from User u WHERE userid=:userName AND password=:password AND userType=:userType ";
	
	public final static String SQL_ALL_USERTYPE = " SELECT u FROM UserType u";
	
	public final static String SQL_GET_USER = " select RegID, UserID, FirstName, LastName, EmailAddress, Address, ContactNumber, designation, user_type, empid 	" 
												+" FROM 	fms.user  where regid = ? ";

	public static final String SQL_GET_MENU_ACCESS = "SELECT m FROM MenuUserType m WHERE userTypeId.userTypeId=:userType";	
}
