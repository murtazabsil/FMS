package com.bluestar.fms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.bluestar.fms.constants.LoginConstants;
import com.bluestar.fms.vo.AuthorizeVO;
import com.bluestar.fms.vo.LoginVO;
import com.bluestar.fms.vo.UserTypeVO;
import com.bluestar.fms.vo.UserVO;

public class LoginDAOImpl implements LoginDAO{
	
	public AuthorizeVO validateUser(LoginVO loginVO){
		
		AuthorizeVO authorizeVO = new AuthorizeVO();
		UserVO userVO = null;
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		con = com.eResorts.ConnectionPool.getConnection();
		try {
			
		
		String Query = LoginConstants.SQL_VALIDATE_LOGIN;
		debugLogger("getLoginList query"+Query);
		stmt =  con.prepareStatement(Query);
		stmt.setString(1, loginVO.getUserID()!=null?loginVO.getUserID():"0");
		stmt.setString(2, loginVO.getPassword());
		stmt.setString(3, loginVO.getAuth()); 
		debugLogger("getLoginList stmt"+stmt);
		rs = stmt.executeQuery();
		
		Integer  count = null;
		
		debugLogger("getLoginList query"+Query);
	
			while(rs.next()){
			
				count= rs.getInt(1);
			}
			authorizeVO.setLoginVO(loginVO);
			authorizeVO.setResult(count);
			
			
			String userQuery = LoginConstants.SQL_GET_USER;
			rs=null;
			stmt= null;
			
			stmt =  con.prepareStatement(userQuery);
			stmt.setString(1, loginVO.getUserID());
			
			rs = stmt.executeQuery();
			debugLogger("getLoginList userQuery "+stmt);
			while(rs.next()){
				userVO = new UserVO();
				
				userVO.setUserType( rs.getInt(9));
				userVO.setApprove(1);
				
			}
			authorizeVO.setUserVO(userVO);
			con.close();
			stmt.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			try {
				con.close();
				stmt.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}
		return authorizeVO;
		
	}
	public static void debugLogger(String loggerString){
        System.out.println(" ### LoginDAOImpl: "+loggerString);
    }
    

    public static void debugLogger(Exception e){
        for(StackTraceElement element : e.getStackTrace()){
            debugLogger(" ### LoginDAOImpl:" + element.toString());   
        }
        
    }
    
	@Override
	public List<UserTypeVO> getUserType() {
		List<UserTypeVO> userTypeVOList = new ArrayList<UserTypeVO>();
		UserTypeVO userTypeVO = null; 
		Connection con=null;
		ResultSet rs=null;
		Statement stmt=null;
		
		con = com.eResorts.ConnectionPool.getConnection();
		try {
			stmt =  con.createStatement();
		
		String Query = LoginConstants.SQL_ALL_USERTYPE;
		rs = stmt.executeQuery(Query);
		
		Integer  id ;
		String name;
		String description;
		debugLogger("getUserTypeList query"+Query);
	
			while(rs.next()){
				userTypeVO = new UserTypeVO();
				id= rs.getInt("user_type_id");
				name= rs.getString("user_type");
				description= rs.getString("user_type_description");
				
				
				userTypeVO.setUserTypeId(id);
				userTypeVO.setUserType(name);
				userTypeVO.setUserTypeDesc(description);
				userTypeVOList.add(userTypeVO);
			}
			con.close();
			stmt.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			try {
			if(con!= null)	{
				con.close();
			}
			if(con!= null)	{
				stmt.close();
			}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}
		return userTypeVOList;
	}

}
