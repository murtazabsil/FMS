package com.bluestar.fms.bso;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.vo.AuthorizeVO;

import com.bluestar.fms.vo.UserTypeVO;


public interface LoginBSO {
	
		public AuthorizeVO validateUser(HttpServletRequest request);
		public List<UserTypeVO> getUserType();
}
