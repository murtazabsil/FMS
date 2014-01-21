package com.bluestar.fms.constants;

public class LoginConstants {
	
	public final static String SQL_VALIDATE_LOGIN = " SELECT id FROM login WHERE UserID=? AND Password=? AND user_type=? ";
	
	public final static String SQL_ALL_USERTYPE = " SELECT  user_type_id,user_type, user_type_description  FROM user_type ";
	
	public final static String SQL_GET_USER = " select RegID, UserID, FirstName, LastName, EmailAddress, Address, ContactNumber, designation, user_type, empid 	" 
												+" FROM 	fms.user  where regid = ? ";

	public static final String SQL_GET_MENU_ACCESS = "SELECT menu,page FROM menu_user_type WHERE user_type_id=?";	
}
