package com.bluestar.fms.helper;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.vo.LoginVO;
import com.bluestar.fms.vo.UserVO;

public class LoginHelper {
	
public static UserVO convertRequestToUserVO(HttpServletRequest request){
		
	UserVO userVO = new UserVO();;

	userVO.setFirstName(null); //setUserName(request.getParameter("userName"));
	userVO.setLastName(null);// (request.getParameter("userName"));
	userVO.setAddress(null);
	//userVO.setAge("100");
//	userVO.setAmountDeposited(new Float(1.0));
//	userVO.setApprove(0);
	userVO.setContactNumber(null);
	userVO.setEmailAddress(null);
//	userVO.setMemberType(null);
	//userVO.setContactNumber(null);
	//userVO.setOccupation(null);
	
	
	return userVO;
	}

	public static LoginVO convertRequestToLoginVO(HttpServletRequest request){
			LoginVO loginVO = new LoginVO();;
			System.out.println(" UserId===================="+request.getParameter("UserID"));
			loginVO.setUserID(request.getParameter("UserID")); //setLoginName(request.getParameter("loginName"));
			loginVO.setPassword(request.getParameter("Password"));// (request.getParameter("loginName"));
			loginVO.setAuth(request.getParameter("Auth"));
			
			
			
			return loginVO;
		}
}
