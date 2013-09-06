package com.bluestar.fms.dal;

import java.util.List;

import com.bluestar.fms.vo.AuthorizeVO;
import com.bluestar.fms.vo.LoginVO;
import com.bluestar.fms.vo.UserTypeVO;

public interface LoginDAO {
	
	public AuthorizeVO validateUser(LoginVO loginVO);
	
	public List<UserTypeVO> getUserType();

}
