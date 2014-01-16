package com.bluestar.fms.constants;

public class AdminConstants {
	
	public final static String SQL_ALL_MODULE = "SELECT 	module_id, module_name, module_description from fms.module ";
			

	public final static String SQL_ALL_PROJECT = "SELECT  project_id, project_name, project_lob, project_account, project_base_currency,  " 
											+"project_priority, project_status, project_type, start_date, end_date, " 
											+"project_desc, pm_id "
											+" FROM 	fms.project ";
	
	public final static String SQL_PROJECT_BY_ID = "SELECT  project_id, project_name, project_lob, project_account, project_base_currency,  " 
												+"project_priority, project_status, project_type, start_date, end_date, " 
												+"project_desc, pm_id "
												+" FROM 	fms.project WHERE project_id = ?";

	public final static String SQL_ALL_MANAGER = "SELECT 	manager_id, 	manager_name, 	manager_emp_id, 	manager_dept_id, 	manager_lob_id,  " 
											+" 	manager_account_id, 	manager_location_id, 	manager_currency, 	manager_descrition " 
											+" FROM 	fms.manager  ";
	
	public final static String SQL_MANAGER_BY_ID = "SELECT 	manager_id, 	manager_name, 	manager_emp_id, 	manager_dept_id, 	manager_lob_id,  " 
												+" 	manager_account_id, 	manager_location_id, 	manager_currency, 	manager_descrition " 
													+" FROM 	fms.manager WHERE manager_id = ?";

	public final static String SQL_ALL_ACCOUNT = "SELECT 	account_id, 	account_name, 	account_lob, 	account_client, "
												+" 		account_location, 	account_head, 	account_desc"
												+" 		FROM 	fms.account ";
	
	public final static String SQL_ACCOUNT_BY_ID = "SELECT 	account_id, 	account_name, 	account_lob, 	account_client, "
		+" 		account_location, 	account_head, 	account_desc"
		+" 		FROM 	fms.account WHERE account_id=? ";

	
	public final static String SQL_ALL_LOB = "SELECT 	lob_id, 	lob_name, 	lob_location, 	lob_head, 	lob_desc "
												+"	FROM 	fms.lob ";
	
	public final static String SQL_LOB_BY_ID = "SELECT 	lob_id, 	lob_name, 	lob_location, 	lob_head, 	lob_desc "
											+"	FROM 	fms.lob  WHERE lob_id=?";

	public final static String SQL_ALL_CURRENCY = "SELECT 	currency_id, 	currency_code, 	currency_name, 	currency_symbol "
												+"	FROM 	fms.currency  ";
	
	public final static String SQL_ALL_STATUS = " SELECT 	status_id, 	status_code, 	status_desc"
												+"  FROM 	fms.status ";
	public final static String SQL_ALL_TYPE = " SELECT 	type_id, 	type_code, 	type_desc "
												+" FROM 	fms.type ";
	
	public final static String SQL_ALL_PRIORITY = " SELECT 	priority_id, 	priority_code, 	priority_desc "
												+" FROM 	fms.priority ";
	
	public final static String SQL_ALL_LOCATION = " SELECT 	location_id, 	location_name, 	location_code, 	location_desc "
													+" FROM 	fms.location ";
	
	public final static String SQL_INSERT_PROJECT = "  INSERT INTO fms.project 	( 	project_name, 	project_lob, 	project_account, 	project_base_currency, 	project_priority," 
													+" project_status, 	project_type, 	start_date, 	end_date, 	project_desc	)"
													+" VALUES					(?,?,?,?,?,?,?,?,?,?)";
	
	public final static String SQL_INSERT_USER = "  INSERT INTO fms.user 	( 	UserID, 	FirstName, 	LastName, 	Age, 	EmailAddress, 	Address," 
			+" ContactNumber, 	Occupation, 	MemberType, 	AmountDeposited, 	approve, 	user_type	)"
			+" VALUES	( ?,?,?,?,?,?,?,?,?,?,?,?)";

	public final static String SQL_INSERT_LOB = " INSERT INTO fms.lob 	( 	lob_name, 	lob_location, 	lob_head, 	lob_desc)  " 			
			+" VALUES	( 	?, 	?, 	?, 	?	)";
	
	
	public final static String SQL_INSERT_MANAGER = "  INSERT INTO fms.manager 	( 	manager_name    ,	manager_emp_id    ,	manager_dept_id    ,	manager_lob_id    ,	" 
			+" manager_account_id    ,	manager_location_id    ,	manager_currency    ,	manager_descrition	) "			
			+"VALUES	(?,?,?,?,?,?,?,?) ";
	
	public final static String SQL_INSERT_ACCOUNT = "  INSERT INTO fms.account 	(account_name, 	account_lob, 	account_client, 	account_location, 	account_head, 	account_desc	)	" 
					
			+" VALUES	( 	?, 	?, 	?, 	?, 	?, 	?	) ";


	public static final String ERROR_ADD_PROJECT = "Error While Adding Project.";
	
	public static final String ERROR_ADD_MANAGER = "Error While Adding Manager.";
	
	public static final String ERROR_ADD_ACCOUNT = "Error While Adding Account.";
	
	public static final String ERROR_ADD_LOB = "Error While Adding Lob.";
	
	public static final String ERROR_ADD_USER = "Error While Adding User.";

}
