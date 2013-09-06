package com.bluestar.fms.bso;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.dal.LoginDAO;
import com.bluestar.fms.dal.LoginDAOImpl;
import com.bluestar.fms.helper.LoginHelper;
import com.bluestar.fms.vo.AuthorizeVO;
import com.bluestar.fms.vo.LoginVO;

import com.bluestar.fms.vo.UserTypeVO;


public class LoginBSOImpl implements LoginBSO{

	LoginDAO loginDAO = new LoginDAOImpl();
	@Override
	public AuthorizeVO validateUser(HttpServletRequest request) {
		
		
		LoginVO loginVO= LoginHelper.convertRequestToLoginVO(request);
		AuthorizeVO authorizeVO = loginDAO.validateUser(loginVO);
		
		return authorizeVO;
	}

	@Override
	public List<UserTypeVO> getUserType() {
	
		List<UserTypeVO> userTypeVOList = loginDAO.getUserType();
		
		return userTypeVOList;
	}
	
	

}
