package com.bluestar.fms.constants;

public class LoginConstants {
	
	public final static String SQL_VALIDATE_LOGIN = " SELECT COUNT(*)  FROM login WHERE UserID=? AND Password=? AND Auth=? ";
	
	public final static String SQL_ALL_USERTYPE = " SELECT  user_type_id,user_type, user_type_description  FROM user_type ";
	
	public final static String SQL_GET_USER = " select RegID, UserID, FirstName, LastName, EmailAddress, Address, ContactNumber, designation, user_type, empid 	" 
												+" FROM 	fms.user  where UserID = ? ";	
}
