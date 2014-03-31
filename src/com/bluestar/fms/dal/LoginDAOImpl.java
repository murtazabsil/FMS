package com.bluestar.fms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bluestar.fms.constants.LoginConstants;
import com.bluestar.fms.entity.MenuUserType;
import com.bluestar.fms.entity.User;
import com.bluestar.fms.entity.UserType;
import com.bluestar.fms.util.ConfigReader;
import com.bluestar.fms.util.PrintStackTraceLogger;
import com.bluestar.fms.vo.AuthorizeVO;
import com.bluestar.fms.vo.UserTypeVO;
import com.bluestar.fms.vo.UserVO;
import com.fms.dao.ConnectionManager;

public class LoginDAOImpl implements LoginDAO {

	public AuthorizeVO validateUser(UserVO userVO) {
		AuthorizeVO authorizeVO = new AuthorizeVO();
		ResultSet rs = null;
		Map<String, String> menuAccess = null;
		Session session = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			// Validating User and getting information from db.
			Query validateQuery = session
					.createQuery(LoginConstants.SQL_VALIDATE_LOGIN);
			validateQuery.setString("userName", userVO.getUserName());
			validateQuery.setString("password", userVO.getPassword());
			validateQuery.setLong("userType", userVO.getUserType());
			if (validateQuery.list().size() > 0) {
				User userEntity = (User) validateQuery.list().get(0);
				authorizeVO.setResult(1);
				userVO = new UserVO();
				userVO.setUserType(userEntity.getUserType().getUserTypeId());
				userVO.setApprove(1);
				userVO.setRegID(userEntity.getRegid());
				authorizeVO.setUserVO(userVO);
				
				if(userVO.getUserType() == com.bluestar.fms.util.UserType.MANAGER.getUserType()){
					
				}

				// Setting Menu Access for the User..
				menuAccess = new LinkedHashMap<String, String>();
				Query menuAccessQuery = session
						.createQuery(LoginConstants.SQL_GET_MENU_ACCESS);
				menuAccessQuery.setLong("userType", userVO.getUserType());
				if (menuAccessQuery.list().size() > 0) {
					List<MenuUserType> menuUserTypes = menuAccessQuery.list();
					for (MenuUserType menuUserType : menuUserTypes)
						menuAccess.put(menuUserType.getMenu(),
								menuUserType.getPage());
					authorizeVO.setMenuAccess(menuAccess);
				}
			} else {
				authorizeVO.setResult(0);
			}
		} catch (Exception e) {
			PrintStackTraceLogger.getStackTrace(e);
		}
		return authorizeVO;

	}

	public static void debugLogger(String loggerString) {
		System.out.println(" ### LoginDAOImpl: " + loggerString);
	}

	public static void debugLogger(Exception e) {
		for (StackTraceElement element : e.getStackTrace()) {
			debugLogger(" ### LoginDAOImpl:" + element.toString());
		}

	}

	@Override
	public List<UserTypeVO> getUserType() {
		List<UserTypeVO> userTypeVOList = new ArrayList<UserTypeVO>();
		UserTypeVO userTypeVO = null;
		Session session = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			Query query = session.createQuery(LoginConstants.SQL_ALL_USERTYPE);
			if (query.list().size() > 0) {
				List<UserType> types = query.list();
				for (UserType userType : types) {
					userTypeVO = new UserTypeVO();
					userTypeVO.setUserTypeId(userType.getUserTypeId()
							.intValue());
					userTypeVO.setUserType(userType.getUserType());
					userTypeVO.setUserTypeDesc(userType
							.getUserTypeDescription());
					userTypeVOList.add(userTypeVO);
				}
			}
		} catch (Exception e) {
			PrintStackTraceLogger.getStackTrace(e);
		}
		return userTypeVOList;
	}

}
