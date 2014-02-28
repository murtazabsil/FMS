package com.bluestar.fms.helper;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.vo.UserVO;

public class LoginHelper {

	public static UserVO convertRequestToUserVO(HttpServletRequest request) {

		UserVO userVO = new UserVO();
		;

		userVO.setFirstName(null); // setUserName(request.getParameter("userName"));
		userVO.setLastName(null);// (request.getParameter("userName"));
		userVO.setAddress(null);
		// userVO.setAge("100");
		// userVO.setAmountDeposited(new Float(1.0));
		// userVO.setApprove(0);
		userVO.setContactNumber(null);
		userVO.setEmailAddress(null);
		// userVO.setMemberType(null);
		// userVO.setContactNumber(null);
		// userVO.setOccupation(null);

		return userVO;
	}

	public static UserVO convertRequestToLoginVO(HttpServletRequest request) {
		UserVO userVO = new UserVO();
		System.out.println(" UserId===================="
				+ request.getParameter("UserID"));
		userVO.setUserName(request.getParameter("UserID")); // setLoginName(request.getParameter("loginName"));
		userVO.setPassword(request.getParameter("Password"));// (request.getParameter("loginName"));
		userVO.setUserType(Long.parseLong(request.getParameter("Auth")));
		return userVO;
	}
}
