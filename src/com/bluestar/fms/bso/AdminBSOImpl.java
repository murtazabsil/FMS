package com.bluestar.fms.bso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.dal.AdminDAO;
import com.bluestar.fms.dal.AdminDAOImpl;
import com.bluestar.fms.entity.Account;
import com.bluestar.fms.entity.Lob;
import com.bluestar.fms.entity.Manager;
import com.bluestar.fms.entity.Month;
import com.bluestar.fms.entity.Project;
import com.bluestar.fms.entity.ProjectManagerLink;
import com.bluestar.fms.entity.User;
import com.bluestar.fms.helper.AdminHelper;
import com.bluestar.fms.util.PrintStackTraceLogger;
import com.bluestar.fms.util.UserType;
import com.bluestar.fms.vo.AccountVO;
import com.bluestar.fms.vo.CurrencyVO;
import com.bluestar.fms.vo.ExchageRateVO;
import com.bluestar.fms.vo.LinkVO;
import com.bluestar.fms.vo.LobVO;
import com.bluestar.fms.vo.LocationVO;
import com.bluestar.fms.vo.ManagerVO;
import com.bluestar.fms.vo.ModuleVO;
import com.bluestar.fms.vo.MonthVO;
import com.bluestar.fms.vo.PriorityVO;
import com.bluestar.fms.vo.ProjectManagerLinkVO;
import com.bluestar.fms.vo.ProjectVO;
import com.bluestar.fms.vo.ResponseVO;
import com.bluestar.fms.vo.StatusVO;
import com.bluestar.fms.vo.TypeVO;
import com.bluestar.fms.vo.UserVO;

public class AdminBSOImpl implements AdminBSO {

	AdminDAO adminDAOImpl = new AdminDAOImpl();

	@Override
	public ResponseVO processAddModule(HttpServletRequest request) {

		String module = request.getParameter("addmodule");
		ResponseVO responseVO = null;

		System.out.println(" processAddModule-----" + module);
		if (module != null && module.trim().length() > 0
				&& module.equals("project")) {
			ProjectVO projectVO = AdminHelper
					.convertRequestToProjectVO(request);
			responseVO = adminDAOImpl.addProject(projectVO);
		} else if (module != null && module.trim().length() > 0
				&& module.equals("manager")) {
			ManagerVO managerVO = AdminHelper
					.convertRequestToManagerVO(request);
			responseVO = adminDAOImpl.addManager(managerVO);
		} else if (module != null && module.trim().length() > 0
				&& module.equals("account")) {
			AccountVO accountVO = AdminHelper
					.convertRequestToAccountVO(request);
			responseVO = adminDAOImpl.addAccount(accountVO);
		} else if (module != null && module.trim().length() > 0
				&& module.equals("lob")) {
			LobVO lobVO = AdminHelper.convertRequestToLobVO(request);
			responseVO = adminDAOImpl.addLob(lobVO);
		} else if (module != null && module.trim().length() > 0
				&& module.equals("user")) {
			Integer userType = new Integer(request.getParameter("userType"));
			UserVO userVO = AdminHelper.convertRequestToUserVO(request);
			if (userType == UserType.MANAGER.getUserType()) {
				ManagerVO managerVO = AdminHelper
						.getMAnagerVOFromUserVO(userVO);
				adminDAOImpl.addManagerFromUser(managerVO);
			}
			responseVO = adminDAOImpl.addUser(userVO);
		}

		responseVO.setModule(module);
		return responseVO;
	}

	@Override
	public Map<String, List<String>> initializeDropDown() {
		Map<String, List<String>> allDropDownListMap = new HashMap<String, List<String>>();
		List<String> stringList = null;

		List<ModuleVO> listModuleVO = adminDAOImpl.getModuleList();
		stringList = AdminHelper.getListStringFromModuleListVO(listModuleVO);
		allDropDownListMap.put("moduleList", stringList);

		List<CurrencyVO> listCurrencyVO = adminDAOImpl.getCurrencyList();
		stringList = AdminHelper
				.getListStringFromCurrencyListVO(listCurrencyVO);
		allDropDownListMap.put("currencyList", stringList);

		List<StatusVO> listStatusVO = adminDAOImpl.getStatusList();
		stringList = AdminHelper.getListStringFromStatusListVO(listStatusVO);
		allDropDownListMap.put("statusList", stringList);

		List<TypeVO> listTypeVO = adminDAOImpl.getTypeList();
		stringList = AdminHelper.getListStringFromTypeListVO(listTypeVO);
		allDropDownListMap.put("typeList", stringList);

		List<PriorityVO> listPriorityVO = adminDAOImpl.getPriorityList();
		stringList = AdminHelper
				.getListStringFromPriotiryListVO(listPriorityVO);
		allDropDownListMap.put("priorityList", stringList);

		List<LocationVO> listLocationVO = adminDAOImpl.getLocationList();
		stringList = AdminHelper
				.getListStringFromLocationListVO(listLocationVO);
		allDropDownListMap.put("locationList", stringList);

		// List<DepartmentVO> listDepartmentVO
		// =adminDAOImpl.getDepartmentList();
		/*
		 * List<LinkVO> listLinkVO =adminDAOImpl.getPmProjectLinkList();
		 * stringList = AdminHelper.getListStringFromLinkListVO(listLinkVO);
		 * allDropDownListMap.put("linkList",stringList);
		 */

		return allDropDownListMap;
	}

	@Override
	public Map<String, List<String>> initializeModuleDropDown() {
		Map<String, List<String>> allModuleDropDownListMap = new HashMap<String, List<String>>();
		List<String> stringList = null;

		List<ProjectVO> listProjectVO = adminDAOImpl.getProjectList();
		stringList = AdminHelper.getListStringFromProjectListVO(listProjectVO);
		allModuleDropDownListMap.put("projectList", stringList);

		List<ManagerVO> listManagerVO = adminDAOImpl.getManagerList();
		stringList = AdminHelper.getListStringFromManagerListVO(listManagerVO);
		allModuleDropDownListMap.put("managerList", stringList);

		List<AccountVO> listAccountVO = adminDAOImpl.getAccountList();
		stringList = AdminHelper.getListStringFromAccountListVO(listAccountVO);
		allModuleDropDownListMap.put("accountList", stringList);

		List<LobVO> listLobVO = adminDAOImpl.getLobList();
		stringList = AdminHelper.getListStringFromLobListVO(listLobVO);
		allModuleDropDownListMap.put("lobList", stringList);

		// List<DepartmentVO> listDepartmentVO
		// =adminDAOImpl.getDepartmentList();
		/*
		 * List<LinkVO> listLinkVO =adminDAOImpl.getPmProjectLinkList();
		 * stringList = AdminHelper.getListStringFromLinkListVO(listLinkVO);
		 * allModuleDropDownListMap.put("linkList",stringList);
		 */
		List<UserVO> listUserVO = adminDAOImpl.getUserList();
		stringList = AdminHelper.getListStringFromUserListVO(listUserVO);
		System.out.println(" User List " + stringList);
		allModuleDropDownListMap.put("userList", stringList);

		return allModuleDropDownListMap;
	}

	@Override
	public List<AccountVO> getAccountList() {
		List<AccountVO> listAccountVO = adminDAOImpl.getAccountList();
		return listAccountVO;
	}

	@Override
	public List<LobVO> getLobList() {
		List<LobVO> listLobVO = adminDAOImpl.getLobList();
		return listLobVO;
	}

	@Override
	public List<ManagerVO> getManagerList() {
		List<ManagerVO> listManagerVO = adminDAOImpl.getManagerList();
		return listManagerVO;
	}

	@Override
	public List<ProjectVO> getProjectList() {
		List<ProjectVO> listProjectVO = adminDAOImpl.getProjectList();
		return listProjectVO;
	}

	@Override
	public List<UserVO> getUserList() {
		List<UserVO> listUserVO = adminDAOImpl.getUserList();
		return listUserVO;
	}

	@Override
	public ProjectVO getProjectDetails(String idToEdit) {

		ProjectVO projectVO = adminDAOImpl.getProjectDetails(idToEdit);
		return projectVO;
	}

	@Override
	public AccountVO getAccountDetails(String idToEdit) {
		AccountVO accountVO = adminDAOImpl.getAccountDetails(idToEdit);
		return accountVO;
	}

	@Override
	public LobVO getLobDetails(String idToEdit) {
		LobVO lobVO = adminDAOImpl.getLobDetails(idToEdit);
		return lobVO;
	}

	@Override
	public ManagerVO getManagerDetails(String idToEdit) {
		ManagerVO managerVO = adminDAOImpl.getManagerDetails(idToEdit);
		return managerVO;
	}

	@Override
	public boolean deleteProject(String ids) {
		boolean flag = adminDAOImpl.deleteProject(ids);
		return flag;
	}

	@Override
	public boolean deleteLob(String ids) {
		boolean flag = adminDAOImpl.deleteLob(ids);
		return flag;
	}

	@Override
	public boolean deleteAccount(String ids) {
		boolean flag = adminDAOImpl.deleteAccount(ids);
		return flag;
	}

	@Override
	public boolean deleteManager(String ids) {
		boolean flag = adminDAOImpl.deleteManager(ids);
		return flag;
	}

	@Override
	public boolean deleteUser(String ids) {
		boolean flag = adminDAOImpl.deleteUser(ids);
		return flag;
	}

	@Override
	public UserVO getUserDetails(String idToEdit) {
		UserVO userVO = adminDAOImpl.getUserDetails(idToEdit);

		return userVO;
	}

	@Override
	public List<ExchageRateVO> getExchangeRateVOList(String exmodule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectVO> getProjectList(Long userType, Long userId) {
		List<ProjectVO> listProjectVO = adminDAOImpl.getProjectList(userType,
				userId);
		return listProjectVO;
	}

	@Override
	public Account getAccountFromAccountId(Long accountId) {
		// TODO Auto-generated method stub
		AdminDAO adminDAO = null;
		Account account = null;
		try {
			adminDAO = new AdminDAOImpl();
			account = adminDAO.getAccountFromAccountId(accountId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return account;
	}

	@Override
	public Lob getLobFromLobId(Long lobId) {
		// TODO Auto-generated method stub
		AdminDAO adminDAO = null;
		Lob lob = null;
		try {
			adminDAO = new AdminDAOImpl();
			lob = adminDAO.getLobFromLobId(lobId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return lob;
	}

	@Override
	public ProjectManagerLink linkManagerToProject(Long managerId,
			Long projectId) {
		// TODO Auto-generated method stub
		ProjectManagerLinkVO projectManagerLinkVO = new ProjectManagerLinkVO();
		AdminDAO adminDAO = null;
		ProjectManagerLink projectManagerLink = null;
		try {
			adminDAO = new AdminDAOImpl();
			projectManagerLinkVO.setManagerId(managerId);
			projectManagerLinkVO.setProjectId(projectId);
			adminDAO.linkManagerToProject(projectManagerLinkVO);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return projectManagerLink;
	}

	@Override
	public Project getProjectFromProjectId(Long projectId) {
		// TODO Auto-generated method stub
		AdminDAO adminDAO = null;
		Project project = null;
		try {
			adminDAO = new AdminDAOImpl();
			project = adminDAO.getProjectFromProjectId(projectId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return project;
	}

	@Override
	public Manager getManagerFromManagerId(Long managerId) {
		// TODO Auto-generated method stub
		AdminDAO adminDAO = null;
		Manager manager = null;
		try {
			adminDAO = new AdminDAOImpl();
			manager = adminDAO.getManagerFromManagerId(managerId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return manager;
	}

	@Override
	public List<MonthVO> getMonthList() {
		List<MonthVO> listMonthVO = adminDAOImpl.getMonthList();
		return listMonthVO;
	}

	@Override
	public User getUserFromUserID(Long userId) {
		// TODO Auto-generated method stub
		AdminDAO adminDAO = null;
		User user = null;
		try {
			adminDAO = new AdminDAOImpl();
			user = adminDAO.getUserFromUserId(userId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return user;
	}

	@Override
	public List<UserVO> getUserAccountHeadList() {
		AdminDAO adminDAO = new AdminDAOImpl();
		List<UserVO> userList = null;
		try {
			userList = adminDAO.getUserAccountHeadList();
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return userList;
	}

	@Override
	public List<UserVO> getUserLobHeadList() {
		AdminDAO adminDAO = new AdminDAOImpl();
		List<UserVO> userList = null;
		try {
			userList = adminDAO.getUserLobHeadList();
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return userList;
	}

	@Override
	public List<ProjectVO> getProjectVOListForAccount(Long accountHeadId) {
		List<ProjectVO> projectVOList = null;
		AdminDAO adminDAO = null;
		try {
			adminDAO = new AdminDAOImpl();
			projectVOList = adminDAO.getProjectVOListForAccount(accountHeadId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return projectVOList;
	}

	@Override
	public List<ManagerVO> getManagerListForAccount(Long accountHeadId) {
		List<ManagerVO> managerVOList = null;
		AdminDAO adminDAO = null;
		try {
			adminDAO = new AdminDAOImpl();
			managerVOList = adminDAO.getManagerListForAccount(accountHeadId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return managerVOList;
	}

	@Override
	public List<ProjectVO> getProjectVOListForLob(Long lobHeadId) {
		List<ProjectVO> projectVOList = null;
		AdminDAO adminDAO = null;
		try {
			adminDAO = new AdminDAOImpl();
			projectVOList = adminDAO.getProjectVOListForLob(lobHeadId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return projectVOList;
	}

	@Override
	public List<ManagerVO> getManagerVOListForLob(Long lobHeadId) {
		List<ManagerVO> managerVOList = null;
		AdminDAO adminDAO = null;
		try {
			adminDAO = new AdminDAOImpl();
			managerVOList = adminDAO.getManagerListForLob(lobHeadId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return managerVOList;
	}

	@Override
	public List<AccountVO> getAccountVOListForLob(Long lobHeadId) {
		List<AccountVO> accountVOList = null;
		AdminDAO adminDAO = null;
		try {
			adminDAO = new AdminDAOImpl();
			accountVOList = adminDAO.getAccountVOListForLob(lobHeadId);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return accountVOList;
	}
}
