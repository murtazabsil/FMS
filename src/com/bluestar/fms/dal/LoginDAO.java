package com.bluestar.fms.dal;

import java.util.List;

import com.bluestar.fms.vo.AuthorizeVO;
import com.bluestar.fms.vo.UserTypeVO;
import com.bluestar.fms.vo.UserVO;

public interface LoginDAO {
	
	public AuthorizeVO validateUser(UserVO userVO);
	
	public List<UserTypeVO> getUserType();

}
