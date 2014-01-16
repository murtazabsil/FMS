package com.bluestar.fms.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bluestar.fms.entity.Currency;
import com.bluestar.fms.entity.Location;
import com.bluestar.fms.entity.Login;
import com.bluestar.fms.entity.Manager;
import com.bluestar.fms.entity.Account;
import com.bluestar.fms.entity.Lob;
import com.bluestar.fms.entity.Module;
import com.bluestar.fms.entity.Priority;
import com.bluestar.fms.entity.Project;
import com.bluestar.fms.entity.Status;
import com.bluestar.fms.entity.Type;
import com.bluestar.fms.entity.User;
import com.bluestar.fms.entity.UserType;
import com.bluestar.fms.vo.AccountVO;
import com.bluestar.fms.vo.CurrencyVO;
import com.bluestar.fms.vo.LobVO;
import com.bluestar.fms.vo.LocationVO;
import com.bluestar.fms.vo.LoginVO;
import com.bluestar.fms.vo.ManagerVO;
import com.bluestar.fms.vo.ModuleVO;
import com.bluestar.fms.vo.PriorityVO;
import com.bluestar.fms.vo.ProjectVO;
import com.bluestar.fms.vo.StatusVO;
import com.bluestar.fms.vo.TypeVO;
import com.bluestar.fms.vo.UserVO;

public class AdminUtil {

	public static Project convertProjectVOtoEntity(ProjectVO projectvo) {
		Project project = null;
		
		if (projectvo != null) {
			project = new Project();
			
			project.setProjectId(projectvo.getProjectId());	
			project.setProjectName(projectvo.getProjectName());	
			
			project.setProjectDesc(projectvo.getProjectDesc());
			Lob lob = new Lob();
			lob.setLobId(converBigItegerToLong(projectvo.getProjectLob()));
			project.setProjectLob(lob);
			
			Account account = new Account();
			account.setAccountId(converBigItegerToLong(projectvo.getProjectAccount()));
			project.setProjectAccount(account);
			Currency currency = new Currency();
			currency.setCurrencyId(converBigItegerToLong(projectvo.getProjectBaseCurrency()));
			project.setProjectBaseCurrency(currency);
			
			Priority priority = new Priority();
			priority.setPriorityId(converBigItegerToLong(projectvo.getProjectPriority()));
			project.setProjectPriority(priority);
			
			Status status = new Status();
			status.setStatusId(converBigItegerToLong(projectvo.getProjectStatus()));
			project.setProjectStatus(status);
			Type type = new Type();
			type.setTypeId(converBigItegerToLong(projectvo.getProjectType()));
			project.setProjectType(type);
			
			Manager manager = new Manager();
			System.out.println("pm id in util"+projectvo.getPmId());
			//manager.setManagerId(new Long(projectvo.getPmId()+""));
			//project.setManager(manager);
		//	project.setProjectPriority(new BigInteger(projectvo.getParameter("priority")));
		//	project.setStartDate(null);//projectvo.getParameter("projectName"));
		//	project.setEndDate(null);//projectvo.getParameter("projectName"));
		}
		
		return project;
	}

	public static Long converBigItegerToLong(BigInteger id){
		
		Long longVal = new Long(id.intValue());
		
		return longVal;
		
	}
	
	public static BigInteger converLongToBigInteger(Long id){
		
		BigInteger bgVal = new BigInteger(id+"");
		
		return bgVal;
		
	}
	
	public static Lob convertLobVOtoEntity(LobVO lobVO) {
		
		Lob lob = null;
		
		if (lobVO != null) {
			lob = new Lob();
			lob.setLobId(lobVO.getLobId());
			lob.setLobName(lobVO.getLobName());	
			
			lob.setLobDesc(lobVO.getLobDesc());
			lob.setLobHead(lobVO.getLobHead());
			
			Location location = new Location();
			location.setLocationId(converBigItegerToLong(lobVO.getLobLocation()));
			lob.setLobLocation(location);
		}
		
		return lob;
			}

	
	public static Account convertAccountVOtoEntity(
			AccountVO accountVO) {
			Account account = null;
		
		if (accountVO != null) {
			account = new Account();
			account.setAccountId(accountVO.getAccountId());
			account.setAccountName(accountVO.getAccountName());	
			
			account.setAccountDesc(accountVO.getAccountDesc());
			account.setAccountHead(accountVO.getAccountHead());  
			Location location = new Location();
			location.setLocationId(converBigItegerToLong(accountVO.getAccountLocation()));
			account.setAccountLocation(location);
			account.setAccountClient(accountVO.getAccountClient());
			Lob lob = new Lob();
			lob.setLobId(converBigItegerToLong(accountVO.getAccountLob()));
			account.setAccountLob(lob);
			
		}
		
		return account;
		
	}

	public static Manager convertManagerVOtoEntity(ManagerVO managervo) {
		
Manager manager = null;
		
		if (managervo != null) {
			manager = new Manager();
			
			manager.setManagerId(managervo.getManagerId());
			manager.setManagerName(managervo.getManagerName());	
			
			Lob lob = new Lob();
			lob.setLobId(converBigItegerToLong(managervo.getManagerLobId()));
			
			
			Account account = new Account();
			account.setAccountId(converBigItegerToLong(managervo.getManagerAccountId()));
			
			Currency currency = new Currency();
			currency.setCurrencyId(converBigItegerToLong(managervo.getManagerCurrency()));
			
			
			manager.setManagerDescrition(managervo.getManagerDescrition());
			manager.setManagerLobId(lob);
			manager.setManagerAccountId(account);
			manager.setManagerCurrency(currency);
			//manager.setManagerAccountId(managervo.getManagerAccountId());
			manager.setManagerDeptId(managervo.getManagerDeptId());
			manager.setManagerEmpId(managervo.getManagerEmpId());
			
			Location location = new Location();
			location.setLocationId(converBigItegerToLong(managervo.getManagerLocationId()));
			manager.setManagerLocationId(location);
		//	manager.setManagerPriority(new BigInteger(managervo.getParameter("priority")));
		//	manager.setStartDate(null);//managervo.getParameter("managerName"));
		//	manager.setEndDate(null);//managervo.getParameter("managerName"));
		}
		
		return manager;
	}

	public static User convertUserVOtoEntity(UserVO userVO, Long loginEntity) {
		
		User user = null;
		
		if(userVO != null){
			
			user = new User();
			Login login = new Login();
			login.setId(loginEntity);
			user.setLogin(login);
			user.setRegid(userVO.getRegID());
			user.setUserid(userVO.getUserName());
			user.setFirstName(userVO.getFirstName());
			user.setLastName(userVO.getLastName());
			user.setAddress(userVO.getAddress());
			user.setContactnumber(userVO.getContactNumber());
			user.setDesignation(new BigInteger(userVO.getDesignation()+""));
			user.setEmailaddress(userVO.getEmailAddress());
			user.setEmpid(userVO.getEmpId());
			UserType usertType = new UserType();
			usertType.setUserTypeId(converBigItegerToLong(new BigInteger(userVO.getUserType()+"")));
			user.setUserType(usertType);
			user.setDesignation(new BigInteger(userVO.getDesignation()+""));
			
			
		}
		return user;
	}

	public static Login convertLoginVOtoEntity(LoginVO loginVO) {
		
		Login login = null;
		
		if(loginVO != null){
			
			login = new Login();
		//	login.setId(loginVO.getId());
			login.setUserID(loginVO.getUserID());
			login.setPassword(loginVO.getPassword());
			
			UserType usertType = new UserType();
			usertType.setUserTypeId(converBigItegerToLong(new BigInteger(loginVO.getUserType()+"")));
			login.setUserType(usertType);
			login.setAuth("1");
		}
		return login;
		
	}

	public static ProjectVO convertProjectEntityToVO(Project project) {
		ProjectVO projectVO = null;
		
		if (project != null) {
			projectVO = new ProjectVO();
			projectVO.setProjectId(project.getProjectId());
			projectVO.setProjectName(project.getProjectName());	
			
			projectVO.setProjectDesc(project.getProjectDesc());
			projectVO.setProjectLob(converLongToBigInteger(project.getProjectLob().getLobId()));
			projectVO.setProjectLobName(project.getProjectLob().getLobName());
			
			projectVO.setProjectAccount(converLongToBigInteger(project.getProjectAccount().getAccountId()));
			projectVO.setProjectAccountName(project.getProjectAccount().getAccountName());
			
			projectVO.setProjectBaseCurrency(converLongToBigInteger(project.getProjectBaseCurrency().getCurrencyId()));
			projectVO.setProjectBCName(project.getProjectBaseCurrency().getCurrencyName()+","+project.getProjectBaseCurrency().getCurrencyCode());
			
			projectVO.setProjectPriority(converLongToBigInteger(project.getProjectPriority().getPriorityId()));
			projectVO.setProjectPriorityName(project.getProjectPriority().getPriorityCode());
			
			projectVO.setProjectStatus(converLongToBigInteger(project.getProjectStatus().getStatusId()));
			projectVO.setProjectStatusName(project.getProjectStatus().getStatusCode());
			
			projectVO.setProjectType(converLongToBigInteger(project.getProjectType().getTypeId()));
			projectVO.setProjectTypeName(project.getProjectType().getTypeCode());
			
			//projectVO.setPmId(converLongToBigInteger(project.getManager().getManagerId()));
			//projectVO.setProjectPMName(project.getManager().getManagerName());
			
			projectVO.setStartDate(project.getStartDate());
			projectVO.setEndDate(project.getEndDate());
		//	projectVO.setProjectPriority(new BigInteger(project.getParameter("priority")));
		//	projectVO.setStartDate(null);//project.getParameter("projectName"));
		//	projectVO.setEndDate(null);//project.getParameter("projectName"));
		}
		
		
		return projectVO;
	}

	public static AccountVO convertAccountEntityToVO(Account account) {
AccountVO accountVO = null;
		
		if (account != null) {
			accountVO = new AccountVO();
			accountVO.setAccountId(account.getAccountId());
			accountVO.setAccountName(account.getAccountName());	
			
			accountVO.setAccountDesc(account.getAccountDesc());
			accountVO.setAccountHead(account.getAccountHead());  
			accountVO.setAccountLocation(converLongToBigInteger(account.getAccountLocation().getLocationId()));
			accountVO.setAccountClient(account.getAccountClient());
			accountVO.setAccountLob(converLongToBigInteger(account.getAccountLob().getLobId()));
			accountVO.setAccountLobName(account.getAccountLob().getLobName());
		}
		
		return accountVO;
	}

	public static ManagerVO convertManagerEntityToVO(Manager manager) {

		
		ManagerVO managerVO = null;
				
				if (manager != null) {
					managerVO = new ManagerVO();
					managerVO.setManagerId(manager.getManagerId());
					managerVO.setManagerName(manager.getManagerName());	
					
					managerVO.setManagerDescrition(manager.getManagerDescrition());
					
					managerVO.setManagerLobId(converLongToBigInteger(manager.getManagerLobId().getLobId()));
					managerVO.setManagerLobName(manager.getManagerLobId().getLobName());
					
					managerVO.setManagerAccountId(converLongToBigInteger(manager.getManagerAccountId().getAccountId()));
					managerVO.setManagerAccountName(manager.getManagerAccountId().getAccountName());
					
					managerVO.setManagerCurrency(converLongToBigInteger(manager.getManagerCurrency().getCurrencyId()));
					managerVO.setManagerCurrenceName(manager.getManagerCurrency().getCurrencyName()+","+manager.getManagerCurrency().getCurrencyCode());
					
				//	managerVO.setManagerAccountId(converLongToBigInteger(manager.getManagerAccountId().getAccountId()));
					
					
					managerVO.setManagerDeptId(manager.getManagerDeptId());
					
					
					managerVO.setManagerEmpId(manager.getManagerEmpId());
					
					
					managerVO.setManagerLocationId(converLongToBigInteger(manager.getManagerLocationId().getLocationId()));
					managerVO.setManagerLocationName(manager.getManagerLocationId().getLocationName());
				//	managerVO.setManagerPriority(new BigInteger(manager.getParameter("priority")));
				//	managerVO.setStartDate(null);//manager.getParameter("managerName"));
				//	managerVO.setEndDate(null);//manager.getParameter("managerName"));
				}
				
				return managerVO;
			
	}

	public static LobVO convertLobEntityToVO(Lob lob) {

		
		LobVO lobVO = null;
		
		if (lob != null) {
			lobVO = new LobVO();
			lobVO.setLobId(lob.getLobId());
			lobVO.setLobName(lob.getLobName());	
			
			lobVO.setLobDesc(lob.getLobDesc());
			lobVO.setLobHead(lob.getLobHead());
			lobVO.setLobLocation(converLongToBigInteger(lob.getLobLocation().getLocationId()));
		}
		
		return lobVO;
			
	}

	public static List<String> getListFromCommaString(String ids) {
		List<String> container = null;
		if(ids != null && ids.length() > 0){

		    String [] items = ids.split(",");
		   container = Arrays.asList(items);

		}
		return container;
	}

	public static UserVO convertUserEntityToVO(User user) {
			
		UserVO userVO = null;
		// System.out.println("start convertUserEntityToVO");
		if(user != null){
		//	System.out.println("in convertUserEntityToVO user not null");
			userVO = new UserVO();
			LoginVO loginVO = new LoginVO();
			loginVO.setId(user.getLogin().getId());
			loginVO.setPassword(user.getLogin().getPassword());
			loginVO.setUserID(user.getLogin().getUserID());
			loginVO.setUserType(user.getLogin().getUserType().getUserTypeId().intValue());
			
			userVO.setLoginVO(loginVO);
			
			userVO.setRegID(user.getRegid());
			userVO.setUserName(user.getUserid());
			userVO.setFirstName(user.getFirstName());
			userVO.setLastName(user.getLastName());
			userVO.setAddress(user.getAddress());
			userVO.setContactNumber(user.getContactnumber());
			userVO.setDesignation(new Integer(user.getDesignation()+""));
			userVO.setEmailAddress(user.getEmailaddress());
			userVO.setEmpId(user.getEmpid());
			userVO.setUserType(user.getUserType().getUserTypeId().intValue());
			userVO.setUserType(user.getUserType().getUserTypeId().intValue());
			userVO.setUserTypeName(user.getUserType().getUserType());
			userVO.setDesignation(new Integer(user.getDesignation()+""));
			
		//	System.out.println("in convertUserEntityToVO user not null end");
		}
		// System.out.println("end convertUserEntityToVO user not null");
		return userVO;
	}

	public static List<UserVO> getUserVOListFromEntityList(List<User> listUser) {
		List<UserVO> listUserVO = new ArrayList<UserVO>();
		UserVO userVO = null;
		for (User user : listUser) {
		//	System.out.println("in getUserVOListFromEntityList user not null");
			userVO = new UserVO();
			userVO = convertUserEntityToVO(user);
			listUserVO.add(userVO);
		//	System.out.println("in getUserVOListFromEntityList user not null"+listUserVO.size());
		}
		
		return listUserVO;
	}

	public static List<ModuleVO> getModuleVOListFromEntityList(
			List<Module> listModule) {
		List<ModuleVO> listModuleVO = new ArrayList<ModuleVO>();
		ModuleVO moduleVO = null;
		for (Module module : listModule) {
			// System.out.println("in getModuleVOListFromEntityList module not null");
			moduleVO = new ModuleVO();
			moduleVO = convertModuleEntityToVO(module);
			listModuleVO.add(moduleVO);
			// System.out.println("in getModuleVOListFromEntityList module not null"+listModuleVO.size());
		}
		
		return listModuleVO;
	}

	private static ModuleVO convertModuleEntityToVO(Module module) {

		ModuleVO moduleVO = null;
		
		if(module != null){
			
			moduleVO = new ModuleVO();
			
			
			
			moduleVO.setModuleId(module.getModuleId().intValue());
			moduleVO.setModuleName(module.getModuleName());
			moduleVO.setModuleDescrition(module.getModuleDescription());
			
			
		}
	
		return moduleVO;
	
	}

	public static List<ProjectVO> getProjectVOListFromEntityList(
			List<Project> listProject) {

		List<ProjectVO> listProjectVO = new ArrayList<ProjectVO>();
		ProjectVO projectVO = null;
		for (Project project : listProject) {
			// System.out.println("in getProjectVOListFromEntityList project not null");
			projectVO = new ProjectVO();
			projectVO = convertProjectEntityToVO(project);
			listProjectVO.add(projectVO);
			// System.out.println("in getProjectVOListFromEntityList project not null"+listProjectVO.size());
		}
		
		return listProjectVO;
	
	}

	public static List<ManagerVO> getManagerVOListFromEntityList(
			List<Manager> listManager) {


		List<ManagerVO> listManagerVO = new ArrayList<ManagerVO>();
		ManagerVO managerVO = null;
		for (Manager manager : listManager) {
			// System.out.println("in getManagerVOListFromEntityList manager not null");
			managerVO = new ManagerVO();
			managerVO = convertManagerEntityToVO(manager);
			listManagerVO.add(managerVO);
			// System.out.println("in getManagerVOListFromEntityList manager not null"+listManagerVO.size());
		}
		
		return listManagerVO;
	
	
	}

	public static List<AccountVO> getAccountVOListFromEntityList(
			List<Account> listAccount) {

		List<AccountVO> listAccountVO = new ArrayList<AccountVO>();
		AccountVO accountVO = null;
		for (Account account : listAccount) {
			// System.out.println("in getAccountVOListFromEntityList account not null");
			accountVO = new AccountVO();
			accountVO = convertAccountEntityToVO(account);
			listAccountVO.add(accountVO);
			// System.out.println("in getAccountVOListFromEntityList account not null"+listAccountVO.size());
		}
		
		return listAccountVO;

	}

	public static List<LobVO> getLobVOListFromEntityList(List<Lob> listLob) {


		List<LobVO> listLobVO = new ArrayList<LobVO>();
		LobVO lobVO = null;
		for (Lob lob : listLob) {
			// System.out.println("in getLobVOListFromEntityList lob not null");
			lobVO = new LobVO();
			lobVO = convertLobEntityToVO(lob);
			listLobVO.add(lobVO);
			// System.out.println("in getLobVOListFromEntityList lob not null"+listLobVO.size());
		}
		
		return listLobVO;

	
	}

	public static List<CurrencyVO> getCurrencyVOListFromEntityList(
			List<Currency> listCurrency) {
		List<CurrencyVO> listCurrencyVO = new ArrayList<CurrencyVO>();
		CurrencyVO currencyVO = null;
		for (Currency currency : listCurrency) {
			// System.out.println("in getCurrencyVOListFromEntityList currency not null");
			currencyVO = new CurrencyVO();
			currencyVO = convertCurrencyEntityToVO(currency);
			listCurrencyVO.add(currencyVO);
			// System.out.println("in getCurrencyVOListFromEntityList currency not null"+listCurrencyVO.size());
		}
		
		return listCurrencyVO;
	}

	private static CurrencyVO convertCurrencyEntityToVO(Currency currency) {



		CurrencyVO currencyVO = null;
		
		if(currency != null){
			currencyVO = new CurrencyVO();
			currencyVO.setCurrencyId(currency.getCurrencyId());
			currencyVO.setCurrencyCode(currency.getCurrencyCode());
			currencyVO.setCurrencySymbol(currency.getCurrencySymbol());
			currencyVO.setCurrencyName(currency.getCurrencyName());
		}
			
			return currencyVO;
	
	}

	public static List<LocationVO> getLocationVOListFromEntityList(
			List<Location> listLocation) {
		
		List<LocationVO> listLocationVO = new ArrayList<LocationVO>();
		LocationVO locationVO = null;
		for (Location location : listLocation) {
			 System.out.println("in getLocationVOListFromEntityList location not null");
			locationVO = new LocationVO();
			locationVO = convertLocationEntityToVO(location);
			listLocationVO.add(locationVO);
			System.out.println("in getLocationVOListFromEntityList location not null"+listLocationVO.size());
		}
		
		return listLocationVO;
	}

	private static LocationVO convertLocationEntityToVO(Location location) {



		LocationVO locationVO = null;
		
		if(location != null){
			locationVO = new LocationVO();
			locationVO.setLocationId(location.getLocationId());
			locationVO.setLocationCode(location.getLocationCode());
			locationVO.setLocationName(location.getLocationName());
			locationVO.setLocationDesc(location.getLocationDesc());
		}
		
			
			return locationVO;
	
	}

	public static List<PriorityVO> getPriorityVOListFromEntityList(
			List<Priority> listPriority) {
		List<PriorityVO> listPriorityVO = new ArrayList<PriorityVO>();
		PriorityVO priorityVO = null;
		for (Priority priority : listPriority) {
			// System.out.println("in getPriorityVOListFromEntityList priority not null");
			priorityVO = new PriorityVO();
			priorityVO = convertPriorityEntityToVO(priority);
			listPriorityVO.add(priorityVO);
			// System.out.println("in getPriorityVOListFromEntityList priority not null"+listPriorityVO.size());
		}
		
		return listPriorityVO;
	}

	private static PriorityVO convertPriorityEntityToVO(Priority priority) {


		PriorityVO priorityVO = null;
		
		if(priority != null){
			priorityVO = new PriorityVO();
			priorityVO.setPriorityId(priority.getPriorityId());
			priorityVO.setPriorityCode(priority.getPriorityCode());
			priorityVO.setPriorityDesc(priority.getPriorityDesc().toString());
		}
		
			
			return priorityVO;
	}

	public static List<TypeVO> getTypeVOListFromEntityList(List<Type> listType) {
		List<TypeVO> listTypeVO = new ArrayList<TypeVO>();
		TypeVO typeVO = null;
		for (Type type : listType) {
			// System.out.println("in getTypeVOListFromEntityList type not null");
			typeVO = new TypeVO();
			typeVO = convertTypeEntityToVO(type);
			listTypeVO.add(typeVO);
			// System.out.println("in getTypeVOListFromEntityList type not null"+listTypeVO.size());
		}
		
		return listTypeVO;
	}

	private static TypeVO convertTypeEntityToVO(Type type) {



		TypeVO typeVO = null;
		
		if(type != null){
			typeVO = new TypeVO();
			typeVO.setTypeId(type.getTypeId());
			typeVO.setTypeCode(type.getTypeCode());
			typeVO.setTypeDesc(type.getTypeDesc());
		}
		
			
			return typeVO;
	
	}

	public static List<StatusVO> getStatusVOListFromEntityList(
			List<Status> listStatus) {
		List<StatusVO> listStatusVO = new ArrayList<StatusVO>();
		StatusVO statusVO = null;
		for (Status status : listStatus) {
			// System.out.println("in getStatusVOListFromEntityList status not null");
			statusVO = new StatusVO();
			statusVO = convertStatusEntityToVO(status);
			listStatusVO.add(statusVO);
			// System.out.println("in getStatusVOListFromEntityList status not null"+listStatusVO.size());
		}
		
		return listStatusVO;
	}

	private static StatusVO convertStatusEntityToVO(Status status) {


		StatusVO statusVO = null;
		
		if(status != null){
			statusVO = new StatusVO();
			statusVO.setStatusId(status.getStatusId());
			statusVO.setStatusCode(status.getStatusCode());
			statusVO.setStatusDesc(status.getStatusDesc());
		}
		
			
			return statusVO;
	}

}
