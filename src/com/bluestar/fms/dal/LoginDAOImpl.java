package com.bluestar.fms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import com.bluestar.fms.constants.LoginConstants;
import com.bluestar.fms.vo.AuthorizeVO;
import com.bluestar.fms.vo.LoginVO;
import com.bluestar.fms.vo.UserTypeVO;
import com.bluestar.fms.vo.UserVO;

public class LoginDAOImpl implements LoginDAO {

	public AuthorizeVO validateUser(LoginVO loginVO) {

		AuthorizeVO authorizeVO = new AuthorizeVO();
		UserVO userVO = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Map<String, String> menuAccess = null;

		con = com.eResorts.ConnectionPool.getConnection();
		try {

			String Query = LoginConstants.SQL_VALIDATE_LOGIN;
			debugLogger("getLoginList query" + Query);
			stmt = con.prepareStatement(Query);
			stmt.setString(1, loginVO.getUserID() != null ? loginVO.getUserID()
					: "0");
			stmt.setString(2, loginVO.getPassword());
			stmt.setString(3, loginVO.getAuth());
			debugLogger("getLoginList stmt" + stmt);
			rs = stmt.executeQuery();

			Long id = 0l;

			debugLogger("getLoginList query" + Query);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					authorizeVO.setResult(1);
					id = rs.getLong(1);
				}
				authorizeVO.setLoginVO(loginVO);

				String userQuery = LoginConstants.SQL_GET_USER;
				rs = null;
				stmt = null;

				stmt = con.prepareStatement(userQuery);
				stmt.setLong(1, id);

				rs = stmt.executeQuery();
				debugLogger("getLoginList userQuery " + stmt);
				while (rs.next()) {
					userVO = new UserVO();
					userVO.setUserType(rs.getInt(9));
					userVO.setApprove(1);
					userVO.setRegID(id);
				}
				authorizeVO.setUserVO(userVO);

				menuAccess = new LinkedHashMap<String, String>();
				String menuAccessQuery = LoginConstants.SQL_GET_MENU_ACCESS;
				stmt = con.prepareStatement(menuAccessQuery);
				stmt.setLong(1, userVO.getUserType());
				debugLogger("getLoginList userQuery " + stmt);
				rs = stmt.executeQuery();
				while (rs.next()) {
					menuAccess.put(rs.getString(1), rs.getString(2));
				}
				authorizeVO.setMenuAccess(menuAccess);

			} else {
				authorizeVO.setResult(0);
			}

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
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;

		con = com.eResorts.ConnectionPool.getConnection();
		try {
			stmt = con.createStatement();

			String Query = LoginConstants.SQL_ALL_USERTYPE;
			rs = stmt.executeQuery(Query);

			Integer id;
			String name;
			String description;
			debugLogger("getUserTypeList query" + Query);

			while (rs.next()) {
				userTypeVO = new UserTypeVO();
				id = rs.getInt("user_type_id");
				name = rs.getString("user_type");
				description = rs.getString("user_type_description");

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
				if (con != null) {
					con.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}
		return userTypeVOList;
	}

}
