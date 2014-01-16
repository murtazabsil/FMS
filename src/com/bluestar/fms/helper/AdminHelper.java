package com.bluestar.fms.helper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



import com.bluestar.fms.vo.CurrencyVO;
import com.bluestar.fms.vo.LinkVO;
import com.bluestar.fms.vo.LobVO;
import com.bluestar.fms.vo.AccountVO;
import com.bluestar.fms.vo.LocationVO;
import com.bluestar.fms.vo.LoginVO;
import com.bluestar.fms.vo.ManagerVO;
import com.bluestar.fms.vo.ModuleVO;
import com.bluestar.fms.vo.PriorityVO;
import com.bluestar.fms.vo.ProjectVO;
import com.bluestar.fms.vo.StatusVO;
import com.bluestar.fms.vo.TypeVO;
import com.bluestar.fms.vo.UserVO;

public class AdminHelper {
	
	public static ProjectVO convertRequestToProjectVO(HttpServletRequest request){
		
		ProjectVO projectVO = new ProjectVO();;
//		projectName projectLob projectAccount baselocation basecurrency priority	
		//      projectStatus projectType startdate  enddate projectDesc
		if((request.getParameter("id")!=null))
			projectVO.setProjectId(new Long(request.getParameter("id")));
		projectVO.setProjectName(request.getParameter("projectName"));
		projectVO.setProjectDesc(request.getParameter("projectDesc"));
		projectVO.setProjectLob(new BigInteger(request.getParameter("projectLob")));
		projectVO.setProjectAccount(new BigInteger(request.getParameter("projectAccount")));
		projectVO.setProjectBaseCurrency(new BigInteger(request.getParameter("basecurrency")));
		projectVO.setProjectPriority(new BigInteger(request.getParameter("priority")));
		projectVO.setProjectStatus(new BigInteger(request.getParameter("projectStatus")));
		projectVO.setProjectType(new BigInteger(request.getParameter("projectType")));
		projectVO.setProjectPriority(new BigInteger(request.getParameter("priority")));
		projectVO.setPmId(request.getParameter("priority")!=null?new BigInteger(request.getParameter("priority")):new BigInteger("1"));
		projectVO.setStartDate(null);//request.getParameter("projectName"));
		projectVO.setEndDate(null);//request.getParameter("projectName"));
	
		
		
		return projectVO;
	}

	public static ManagerVO convertRequestToManagerVO(HttpServletRequest request) {

		ManagerVO managerVO = new ManagerVO();
		
		// pmEmpId pmdepartment pmlob pmaccount pmlocation pmcurrency pmdesc
		managerVO.setManagerName(request.getParameter("pmName"));
		managerVO.setManagerDescrition(request.getParameter("pmdesc"));
		managerVO.setManagerLobId(new BigInteger(request.getParameter("pmlob")));
		managerVO.setManagerAccountId(new BigInteger(request.getParameter("pmaccount")));
		managerVO.setManagerCurrency(new BigInteger(request.getParameter("pmcurrency")));
		managerVO.setManagerDeptId(new BigInteger(request.getParameter("pmdepartment")));
		managerVO.setManagerEmpId(request.getParameter("pmEmpId"));
		managerVO.setManagerLocationId(new BigInteger(request.getParameter("pmlocation")));
		
			
		return managerVO;
	
	}

	public static AccountVO convertRequestToAccountVO(HttpServletRequest request) {
		
		AccountVO accountVO = new AccountVO();;
		// accountlob accountClient accountlocation accountHead accountDescription
		accountVO.setAccountName(request.getParameter("accountName"));
		accountVO.setAccountDesc(request.getParameter("accountDescription"));
		accountVO.setAccountLob(new BigInteger(request.getParameter("accountlob")));
		accountVO.setAccountLocation(new BigInteger(request.getParameter("accountlocation")));
		accountVO.setAccountClient(request.getParameter("accountClient"));
		accountVO.setAccountHead(request.getParameter("accountHead"));
		
		
			
		return accountVO;
	}

	public static LobVO convertRequestToLobVO(HttpServletRequest request) {
		LobVO lobVO = new LobVO();;
		// lobName  loblocation lobHead lobdesc
		lobVO.setLobName(request.getParameter("lobName"));
		lobVO.setLobDesc(request.getParameter("lobName"));
		lobVO.setLobLocation(new BigInteger(request.getParameter("loblocation")));	
		lobVO.setLobHead(request.getParameter("lobHead"));
		
		
			
		return lobVO;
	}

	public static UserVO convertRequestToUserVO(HttpServletRequest request) {
		UserVO userVO = new UserVO();;
		// userName  userlocation userHead userdesc
	if(request.getParameter("regid") != null){
		userVO.setRegID(new Long(request.getParameter("regid")));
	}else{
		userVO.setRegID(null);
	}
		userVO.setLoginVO((LoginVO)(request.getAttribute("loginvo")));
		if(request.getParameter("regid") == null){
		userVO.setUserName(request.getParameter("UserID"));
		}else{
		userVO.setUserName(request.getParameter("uidhid"));
		}
		userVO.setFirstName(request.getParameter("FirstName"));
		userVO.setLastName(request.getParameter("LastName"));
		userVO.setEmpId(request.getParameter("EmpId"));	
		userVO.setUserType(new Integer(request.getParameter("userType")));
		userVO.setAddress(request.getParameter("Address"));
		userVO.setContactNumber(request.getParameter("ContactNumber"));
		userVO.setDesignation(new Integer(request.getParameter("designation")+""));
		userVO.setEmailAddress(request.getParameter("EmailAddress"));
		
		LoginVO loginVO = new LoginVO();
		loginVO.setUserID(request.getParameter("UserID"));
		loginVO.setPassword(request.getParameter("upassword"));
		loginVO.setUserType(new Integer(request.getParameter("userType")));
		//userVO.setUserName(request.getParameter("userName"));
		userVO.setLoginVO(loginVO);
		
		
			
		return userVO;
	
	}

	public static List<String> getListStringFromModuleListVO(
			List<ModuleVO> listModuleVO) {
		List<String> lst = new ArrayList<String>();
		for (ModuleVO moduleVO : listModuleVO) {
			lst.add(moduleVO.getModuleId()+"|"+moduleVO.getModuleName());
		}
		return lst;
	}

	public static List<String> getListStringFromManagerListVO(
			List<ManagerVO> listManagerVO) {
		List<String> lst = new ArrayList<String>();
		for (ManagerVO managerVO : listManagerVO) {
			lst.add(managerVO.getManagerId()+"|"+managerVO.getManagerName());
		}
		
		
		return lst;
	}

	public static List<String> getListStringFromAccountListVO(
			List<AccountVO> listAccountVO) {
		List<String> lst = new ArrayList<String>();
		for (AccountVO accountVO : listAccountVO) {
			lst.add(accountVO.getAccountId()+"|"+accountVO.getAccountName());
		}
		
		return lst;
	}

	public static List<String> getListStringFromLobListVO(List<LobVO> listLobVO) {
		List<String> lst = new ArrayList<String>();
		for (LobVO lobVO : listLobVO) {
			lst.add(lobVO.getLobId()+"|"+lobVO.getLobName());
		}
		System.out.println(" LOb list "+lst);		
		return lst;
	}

	public static List<String> getListStringFromCurrencyListVO(
			List<CurrencyVO> listCurrencyVO) {
		
		List<String> lst = new ArrayList<String>();
		for (CurrencyVO currencyVO : listCurrencyVO) {
			lst.add(currencyVO.getCurrencyId()+"|"+currencyVO.getCurrencyName()+"-"+currencyVO.getCurrencyCode());
		}
		
		return lst;
	}

	
	public static List<String> getListStringFromStatusListVO(
			List<StatusVO> listStatusVO) {
		
		List<String> lst = new ArrayList<String>();
		for (StatusVO statusVO : listStatusVO) {
			lst.add(statusVO.getStatusId()+"|"+statusVO.getStatusCode());
		}
		
		return lst;
	}

	public static List<String> getListStringFromTypeListVO(
			List<TypeVO> listTypeVO) {
		List<String> lst = new ArrayList<String>();
		for (TypeVO typeVO : listTypeVO) {
			lst.add(typeVO.getTypeId()+"|"+typeVO.getTypeCode());
		}
		
		return lst;
	}

	public static List<String> getListStringFromPriotiryListVO(
			List<PriorityVO> listPriorityVO) {
		List<String> lst = new ArrayList<String>();
		for (PriorityVO priorityVO : listPriorityVO) {
			lst.add(priorityVO.getPriorityId()+"|"+priorityVO.getPriorityCode());
		}
		
		return lst;
	}

	public static List<String> getListStringFromLocationListVO(
			List<LocationVO> listLocationVO) {
		List<String> lst = new ArrayList<String>();
		for (LocationVO locationVO : listLocationVO) {
			lst.add(locationVO.getLocationId()+"|"+locationVO.getLocationName());
		}
		
		return lst;
	}

	public static List<String> getListStringFromLinkListVO(
			List<LinkVO> listLinkVO) {
		
		List<String> lst = new ArrayList<String>();
		for (LinkVO linkVO : listLinkVO) {
		lst.add(linkVO.getLinkId()+"|"+linkVO.getPmId()+"|"+linkVO.getProjectId());
		}
		
		return lst;
	}

	public static List<String> getListStringFromProjectListVO(
			List<ProjectVO> listProjectVO) {
		List<String> lst = new ArrayList<String>();
		for (ProjectVO projectVO : listProjectVO) {
			lst.add(projectVO.getProjectId()+"|"+projectVO.getProjectName());

		}
		return lst;
	}

	public static List<String> getListStringFromUserListVO(
			List<UserVO> listUserVO) {

		List<String> lst = new ArrayList<String>();
		for (UserVO userVO : listUserVO) {
			lst.add(userVO.getRegID()+"|"+(userVO.getFirstName()!=null?userVO.getFirstName():"")+" "+(userVO.getLastName()!=null?userVO.getLastName():"")+"|"+userVO.getLoginVO().getUserID());

		}
		return lst;
	
	}
	
	
	
}
