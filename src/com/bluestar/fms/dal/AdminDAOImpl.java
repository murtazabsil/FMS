package com.bluestar.fms.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bluestar.fms.bso.AdminBSO;
import com.bluestar.fms.bso.AdminBSOImpl;
import com.bluestar.fms.entity.Account;
import com.bluestar.fms.entity.Currency;
import com.bluestar.fms.entity.Lob;
import com.bluestar.fms.entity.Location;
import com.bluestar.fms.entity.Manager;
import com.bluestar.fms.entity.Module;
import com.bluestar.fms.entity.Month;
import com.bluestar.fms.entity.Priority;
import com.bluestar.fms.entity.Project;
import com.bluestar.fms.entity.ProjectManagerLink;
import com.bluestar.fms.entity.Status;
import com.bluestar.fms.entity.Type;
import com.bluestar.fms.entity.User;
import com.bluestar.fms.util.AdminUtil;
import com.bluestar.fms.util.ConfigReader;
import com.bluestar.fms.util.PrintStackTraceLogger;
import com.bluestar.fms.util.UserType;
import com.bluestar.fms.vo.AccountVO;
import com.bluestar.fms.vo.CurrencyVO;
import com.bluestar.fms.vo.DepartmentVO;
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
import com.fms.dao.ConnectionManager;
import com.fms.dao.DAOCustom;
import com.fms.dao.DAOManager;

public class AdminDAOImpl implements AdminDAO {

	/*
	 * @Override public List<ModuleVO> getModuleList() { List<ModuleVO>
	 * moduleVOList = new ArrayList<ModuleVO>(); ModuleVO moduleVO ; Connection
	 * con=null; ResultSet rs=null; Statement stmt=null;
	 * 
	 * 
	 * con = com.eResorts.ConnectionPool.getConnection(); try { stmt =
	 * con.createStatement();
	 * 
	 * String Query = AdminConstants.SQL_ALL_MODULE; rs =
	 * stmt.executeQuery(Query);
	 * 
	 * Integer id ; String name; String description;
	 * debugLogger("getModuleList query"+Query);
	 * 
	 * while(rs.next()){ moduleVO = new ModuleVO(); id= rs.getInt("module_id");
	 * name= rs.getString("module_name"); description=
	 * rs.getString("module_description");
	 * 
	 * moduleVO.setModuleId(id); moduleVO.setModuleName(name);
	 * moduleVO.setModuleDescrition(description); moduleVOList.add(moduleVO); }
	 * con.close(); stmt.close(); } catch (Exception e) {
	 * 
	 * e.printStackTrace(); try { con.close(); stmt.close(); } catch
	 * (SQLException e1) {
	 * 
	 * e1.printStackTrace(); }
	 * 
	 * } return moduleVOList; }
	 */
	@Override
	public List<ModuleVO> getModuleList() {

		Transaction trn = null;
		Session session = null;
		List<Module> listModule = new ArrayList<Module>();
		List<ModuleVO> listModuleVO = new ArrayList<ModuleVO>();

		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			trn = session.getTransaction();
			trn.begin();
			// listModule = daoMgr.findAll("Module");
			Query query = session.createQuery("from " + " Module ");
			listModule = query.list();
			listModuleVO = AdminUtil.getModuleVOListFromEntityList(listModule);
			System.out.println("listModuleVO ++++++ " + listModuleVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listModuleVO;

	}

	@Override
	public List<ProjectVO> getProjectList() {

		Transaction trn = null;
		Session session = null;
		List<Project> listProject = new ArrayList<Project>();
		List<ProjectVO> listProjectVO = new ArrayList<ProjectVO>();

		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			trn = session.getTransaction();
			trn.begin();
			// listProject = daoMgr.findAll("Project");
			Query query = session.createQuery("from " + " Project ");
			listProject = query.list();
			listProjectVO = AdminUtil
					.getProjectVOListFromEntityList(listProject);
			System.out.println("listProjectVO ++++++ " + listProjectVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listProjectVO;

	}

	@Override
	public List<ManagerVO> getManagerList() {

		Transaction trn = null;
		Session session = null;
		List<Manager> listManager = new ArrayList<Manager>();
		List<ManagerVO> listManagerVO = new ArrayList<ManagerVO>();

		try {

			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			trn = session.getTransaction();
			trn.begin();
			// listManager = daoMgr.findAll("Manager");
			Query query = session.createQuery("from " + " Manager ");
			listManager = query.list();
			listManagerVO = AdminUtil
					.getManagerVOListFromEntityList(listManager);
			System.out.println("listManagerVO ++++++ " + listManagerVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listManagerVO;

	}

	@Override
	public List<AccountVO> getAccountList() {

		Transaction trn = null;
		Session session = null;
		List<Account> listAccount = new ArrayList<Account>();
		List<AccountVO> listAccountVO = new ArrayList<AccountVO>();

		try {

			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			trn = session.getTransaction();
			trn.begin();
			// listAccount = daoMgr.findAll("Account");
			Query query = session.createQuery("from " + " Account ");
			listAccount = query.list();
			listAccountVO = AdminUtil
					.getAccountVOListFromEntityList(listAccount);
			System.out.println("listAccountVO ++++++ " + listAccountVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listAccountVO;
	}

	@Override
	public List<LobVO> getLobList() {

		Transaction trn = null;
		Session session = null;
		List<Lob> listLob = new ArrayList<Lob>();
		List<LobVO> listLobVO = new ArrayList<LobVO>();

		try {

			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			trn = session.getTransaction();
			trn.begin();
			// listLob = daoMgr.findAll("Lob");
			Query query = session.createQuery("from " + " Lob ");
			listLob = query.list();
			listLobVO = AdminUtil.getLobVOListFromEntityList(listLob);
			System.out.println("listLobVO ++++++ " + listLobVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listLobVO;
	}

	@Override
	public List<CurrencyVO> getCurrencyList() {

		Transaction trn = null;
		Session session = null;
		List<Currency> listCurrency = new ArrayList<Currency>();
		List<CurrencyVO> listCurrencyVO = new ArrayList<CurrencyVO>();

		try {

			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			trn = session.getTransaction();
			trn.begin();
			// listCurrency = daoMgr.findAll("Currency");
			Query query = session.createQuery("from " + " Currency ");
			listCurrency = query.list();
			listCurrencyVO = AdminUtil
					.getCurrencyVOListFromEntityList(listCurrency);
			System.out
					.println("listCurrencyVO ++++++ " + listCurrencyVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listCurrencyVO;
	}

	@Override
	public List<StatusVO> getStatusList() {

		Transaction trn = null;
		Session session = null;
		List<Status> listStatus = new ArrayList<Status>();
		List<StatusVO> listStatusVO = new ArrayList<StatusVO>();

		try {

			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			trn = session.getTransaction();
			trn.begin();
			// listStatus = daoMgr.findAll("Status");
			Query query = session.createQuery("from " + " Status ");
			listStatus = query.list();
			listStatusVO = AdminUtil.getStatusVOListFromEntityList(listStatus);
			System.out.println("listStatusVO ++++++ " + listStatusVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listStatusVO;
	}

	@Override
	public List<TypeVO> getTypeList() {

		Transaction trn = null;
		Session session = null;
		List<Type> listType = new ArrayList<Type>();
		List<TypeVO> listTypeVO = new ArrayList<TypeVO>();

		try {

			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			trn = session.getTransaction();
			trn.begin();
			// listType = daoMgr.findAll("Type");
			Query query = session.createQuery("from " + " Type ");
			listType = query.list();
			listTypeVO = AdminUtil.getTypeVOListFromEntityList(listType);
			System.out.println("listTypeVO ++++++ " + listTypeVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listTypeVO;
	}

	@Override
	public List<PriorityVO> getPriorityList() {

		Transaction trn = null;
		Session session = null;
		List<Priority> listPriority = new ArrayList<Priority>();
		List<PriorityVO> listPriorityVO = new ArrayList<PriorityVO>();

		try {

			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			trn = session.getTransaction();
			trn.begin();
			// listPriority = daoMgr.findAll("Priority");
			Query query = session.createQuery("from " + " Priority ");
			listPriority = query.list();
			listPriorityVO = AdminUtil
					.getPriorityVOListFromEntityList(listPriority);
			System.out
					.println("listPriorityVO ++++++ " + listPriorityVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listPriorityVO;
	}

	@Override
	public List<LocationVO> getLocationList() {

		Transaction trn = null;
		Session session = null;
		List<Location> listLocation = new ArrayList<Location>();
		List<LocationVO> listLocationVO = new ArrayList<LocationVO>();

		try {

			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			trn = session.getTransaction();
			trn.begin();
			// listLocation = daoMgr.findAll("Location");
			Query query = session.createQuery("from " + " Location ");
			listLocation = query.list();
			listLocationVO = AdminUtil
					.getLocationVOListFromEntityList(listLocation);
			System.out
					.println("listLocationVO ++++++ " + listLocationVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listLocationVO;
	}

	@Override
	public List<DepartmentVO> getDepartmentList() {

		return null;
	}

	@Override
	public List<LinkVO> getPmProjectLinkList() {

		return null;
	}

	public static void debugLogger(String loggerString) {
		System.out.println(" ### AdminDAOImpl: " + loggerString);
	}

	public static void debugLogger(Exception e) {
		for (StackTraceElement element : e.getStackTrace()) {
			debugLogger(" ### AdminDAOImpl:" + element.toString());
		}
	}

	@Override
	public ResponseVO addProject(ProjectVO projectvo) {

		ResponseVO responseVO = new ResponseVO();
		Transaction trn = null;

		try {

			Project projectEntity = AdminUtil
					.convertProjectVOtoEntity(projectvo);

			Session session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			try {
				DAOManager daoMgr = new DAOManager(session);
				trn = session.getTransaction();
				trn.begin();

				daoMgr.createOrUpdate(projectEntity);
				session.beginTransaction().commit();
				// ActivityVO activityVo = getActivityVO(activity);
			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) {
					if (session.isOpen()) {
						session.beginTransaction().rollback();
						// logger.info("Error occured, rolling back all transaction");
						// add error message into the entity and send
					}
				}

			}

			int insertRecordCount = projectEntity.getProjectId().intValue();// stmt.executeUpdate();

			debugLogger("  insertRecordCount ====" + insertRecordCount);

			responseVO.setResult(insertRecordCount);
		} catch (Exception e) {

			e.printStackTrace();

		}

		return responseVO;
	}

	@Override
	public ResponseVO addUser(UserVO userVO) {
		ResponseVO responseVO = new ResponseVO();
		Transaction trn = null;
		Session session = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			DAOManager daoMgr = new DAOManager(session);
			trn = session.getTransaction();
			trn.begin();
			User userEntity = AdminUtil.convertUserVOtoEntity(userVO);

			// userEntity.setRegid(insertLoninId);

			daoMgr.createOrUpdate(userEntity);
			session.beginTransaction().commit();
			// ActivityVO activityVo = getActivityVO(activity);

			int insertRecordCount = userEntity.getRegid().intValue();// stmt.executeUpdate();

			debugLogger("  insertRecordCount ====" + insertRecordCount);

			responseVO.setResult(insertRecordCount);
		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
					// logger.info("Error occured, rolling back all transaction");
					// add error message into the entity and send
				}
			}
		}

		return responseVO;

	}

	@Override
	public ResponseVO addLob(LobVO lobVO) {
		ResponseVO responseVO = new ResponseVO();
		Transaction trn = null;
		Lob lobEntity = AdminUtil.convertLobVOtoEntity(lobVO);

		try {

			Session session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			try {
				DAOManager daoMgr = new DAOManager(session);
				trn = session.getTransaction();
				trn.begin();

				daoMgr.createOrUpdate(lobEntity);
				session.beginTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) {
					if (session.isOpen()) {
						session.beginTransaction().rollback();
					}
				}

			}

			int insertRecordCount = lobEntity.getLobId().intValue();// stmt.executeUpdate();

			debugLogger("  insertRecordCount ====" + insertRecordCount);

			responseVO.setResult(insertRecordCount);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return responseVO;
	}

	@Override
	public ResponseVO addAccount(AccountVO accountVO) {

		ResponseVO responseVO = new ResponseVO();
		Transaction trn = null;
		Account accountEntity = AdminUtil.convertAccountVOtoEntity(accountVO);

		try {

			Session session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			try {
				DAOManager daoMgr = new DAOManager(session);
				trn = session.getTransaction();
				trn.begin();

				daoMgr.createOrUpdate(accountEntity);
				session.beginTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) {
					if (session.isOpen()) {
						session.beginTransaction().rollback();
					}
				}

			}

			int insertRecordCount = accountEntity.getAccountId().intValue();// stmt.executeUpdate();

			debugLogger("  insertRecordCount ====" + insertRecordCount);

			responseVO.setResult(insertRecordCount);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return responseVO;

	}

	@Override
	public ResponseVO addManager(ManagerVO managerVO) {
		ResponseVO responseVO = new ResponseVO();
		Transaction trn = null;
		Manager managerEntity = AdminUtil.convertManagerVOtoEntity(managerVO);

		try {

			Session session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			try {
				DAOManager daoMgr = new DAOManager(session);
				trn = session.getTransaction();
				trn.begin();

				daoMgr.createOrUpdate(managerEntity);
				session.beginTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) {
					if (session.isOpen()) {
						session.beginTransaction().rollback();
					}
				}

			}

			int insertRecordCount = managerEntity.getManagerId().intValue();// stmt.executeUpdate();

			debugLogger("  insertRecordCount ====" + insertRecordCount);

			responseVO.setResult(insertRecordCount);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return responseVO;

	}

	@Override
	public Object getEntityDetails(String idToEdit, String entityName) {
		Transaction trn = null;
		Session session = null;
		Object object = null;
		try {

			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			DAOManager daoMgr = new DAOManager(session);

			trn = session.getTransaction();
			trn.begin();
			object = daoMgr.find(new Long(idToEdit), entityName);
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return object;
	}

	@Override
	public ProjectVO getProjectDetails(String idToEdit) {

		ProjectVO projectVO = null;
		try {
			Project project = (Project) getEntityDetails(idToEdit, "Project");
			projectVO = AdminUtil.convertProjectEntityToVO(project);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectVO;
	}

	@Override
	public AccountVO getAccountDetails(String idToEdit) {
		AccountVO accountVO = null;

		try {
			Account account = (Account) getEntityDetails(idToEdit, "Account");
			accountVO = AdminUtil.convertAccountEntityToVO(account);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return accountVO;

	}

	@Override
	public LobVO getLobDetails(String idToEdit) {

		LobVO lobVO = null;
		try {
			Lob lob = (Lob) getEntityDetails(idToEdit, "Lob");
			lobVO = AdminUtil.convertLobEntityToVO(lob);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lobVO;

	}

	@Override
	public ManagerVO getManagerDetails(String idToEdit) {

		ManagerVO managerVO = null;

		try {
			Manager manager = (Manager) getEntityDetails(idToEdit, "Manager");
			managerVO = AdminUtil.convertManagerEntityToVO(manager);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return managerVO;

	}

	@Override
	public UserVO getUserDetails(String idToEdit) {

		UserVO userVO = null;

		try {
			User user = (User) getEntityDetails(idToEdit, "User");
			userVO = AdminUtil.convertUserEntityToVO(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO;

	}

	@Override
	public boolean deleteProject(String ids) {
		boolean flag = false;
		try {
			flag = deleteRecord("Project", ids);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean deleteLob(String ids) {
		boolean flag = false;
		try {
			flag = deleteRecord("Lob", ids);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean deleteAccount(String ids) {
		boolean flag = false;
		try {
			flag = deleteRecord("Account", ids);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean deleteManager(String ids) {
		boolean flag = false;
		try {
			flag = deleteRecord("Manager", ids);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean deleteRecord(String entityName, String ids) {
		Transaction trn = null;
		Session session = null;
		boolean flag = false;

		try {
			debugLogger("entityName ----" + entityName);
			debugLogger("ids ----" + ids);
			List<String> list = AdminUtil.getListFromCommaString(ids);
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			DAOManager daoMgr = new DAOManager(session);

			trn = session.getTransaction();
			trn.begin();
			int i = 0;
			int l = 0;
			debugLogger("list ----" + list);
			session.beginTransaction();
			for (String string : list) {
				debugLogger("string ----" + string);
				l = daoMgr.remove(new Long(string), entityName);
				i++;
			}
			// Manager manager = daoMgr.remove(id, "Project");
			trn.commit();
			if (i == list.size()) {
				//
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}

		}

		return flag;
	}

	@Override
	public boolean deleteUser(String ids) {
		boolean flag = false;
		try {
			flag = deleteRecord("User", ids);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public List<UserVO> getUserList() {

		Transaction trn = null;
		Session session = null;
		List<User> listUser = new ArrayList<User>();
		List<UserVO> listUserVO = new ArrayList<UserVO>();

		try {

			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());

			DAOManager daoMgr = new DAOManager(session);

			trn = session.getTransaction();
			trn.begin();
			// listUser = daoMgr.findAll("User");
			Query query = session.createQuery("from " + " User ");
			listUser = query.list();
			listUserVO = AdminUtil.getUserVOListFromEntityList(listUser);
			System.out.println("listUserVO ++++++ " + listUserVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listUserVO;

	}

	@Override
	public List<ProjectVO> getProjectList(Long userType, Long userId) {

		Transaction trn = null;
		Session session = null;
		List<Project> listProject = new ArrayList<Project>();
		List<ProjectVO> listProjectVO = new ArrayList<ProjectVO>();

		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			trn = session.getTransaction();
			trn.begin();
			// listProject = daoMgr.findAll("Project");
			Query query = session
					.createQuery(DAOCustom.GET_PROJECT_AS_PER_MANAGER);
			query.setLong("managerId", userId);
			listProject = query.list();
			if (listProject.size() > 0) {
				listProjectVO = AdminUtil
						.getProjectVOListFromEntityList(listProject);
				System.out.println("listProjectVO ++++++ "
						+ listProjectVO.size());
				session.beginTransaction().commit();
			}
		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}

		return listProjectVO;

	}

	@Override
	public void addManagerFromUser(ManagerVO managerVO) {
		Transaction trn = null;
		Manager managerEntity = null;
		AdminBSO adminBSO = null;
		Session session = null;
		DAOManager daoManager = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			adminBSO = new AdminBSOImpl();
			managerEntity = new Manager();
			managerEntity.setManagerName(managerVO.getManagerName());
			managerEntity.setManagerEmpId(managerVO.getManagerEmpId());
			managerEntity.setManagerAccountId(adminBSO
					.getAccountFromAccountId(managerVO.getManagerAccountId()
							.longValue()));
			managerEntity.setManagerLobId(adminBSO.getLobFromLobId(managerVO
					.getManagerLobId().longValue()));
			managerEntity.setManagerCurrency((Currency) daoManager.find(
					managerVO.getManagerCurrency().longValue(), "Currency"));
			managerEntity.setManagerLocationId((Location) daoManager.find(
					managerVO.getManagerLocationId().longValue(), "Location"));
			DAOManager daoMgr = new DAOManager(session);
			trn = session.getTransaction();
			trn.begin();
			daoMgr.createOrUpdate(managerEntity);
			trn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}
	}

	@Override
	public Account getAccountFromAccountId(Long accountId) {
		// TODO Auto-generated method stub
		Session session = null;
		DAOManager daoManager = null;
		Account account = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			account = daoManager.find(accountId, "Account");
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return account;
	}

	@Override
	public Lob getLobFromLobId(Long lobId) {
		// TODO Auto-generated method stub
		Session session = null;
		DAOManager daoManager = null;
		Lob lob = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			lob = daoManager.find(lobId, "Lob");
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return lob;
	}

	@Override
	public ProjectManagerLink linkManagerToProject(
			ProjectManagerLinkVO projectManagerLinkVO) {
		// TODO Auto-generated method stub
		Session session = null;
		DAOManager daoManager = null;
		ProjectManagerLink projectManagerLink = null;
		Transaction transaction = null;
		try {
			projectManagerLink = AdminUtil
					.convertProjectManagerLinkVOToProjectManagerLinkEntity(projectManagerLinkVO);
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			transaction = session.beginTransaction();
			daoManager = new DAOManager(session);
			daoManager.createOrUpdate(projectManagerLink);
			transaction.commit();
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
			if (transaction != null)
				transaction.rollback();
		}
		return projectManagerLink;
	}

	@Override
	public Project getProjectFromProjectId(Long projectId) {
		// TODO Auto-generated method stub
		Session session = null;
		DAOManager daoManager = null;
		Project project = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			project = daoManager.find(projectId, "Project");
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return project;
	}

	@Override
	public Manager getManagerFromManagerId(Long managerId) {
		// TODO Auto-generated method stub
		Session session = null;
		DAOManager daoManager = null;
		Manager manager = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			manager = daoManager.find(managerId, "Manager");
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return manager;
	}

	@Override
	public List<MonthVO> getMonthList() {
		Transaction trn = null;
		Session session = null;
		List<Month> listMonth = new ArrayList<Month>();
		List<MonthVO> listMonthVO = new ArrayList<MonthVO>();
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			trn = session.getTransaction();
			trn.begin();
			// listProject = daoMgr.findAll("Project");
			Query query = session.createQuery("from " + " Month ");
			listMonth = query.list();
			listMonthVO = AdminUtil.getMonthVOListFromEntityList(listMonth);
			System.out.println("listProjectVO ++++++ " + listMonthVO.size());
			session.beginTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (session != null) {
				if (session.isOpen()) {
					session.beginTransaction().rollback();
				}
			}
		}
		return listMonthVO;
	}

	@Override
	public User getUserFromUserId(Long userId) {
		// TODO Auto-generated method stub
		Session session = null;
		DAOManager daoManager = null;
		User user = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			daoManager = new DAOManager(session);
			user = daoManager.find(userId, "User");
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return user;
	}

	@Override
	public List<UserVO> getUserAccountHeadList() {
		Session session = null;
		List<UserVO> userVOList = null;
		try {
			userVOList = new ArrayList<UserVO>();
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			Query uerListQuery = session
					.createQuery("SELECT u FROM User u WHERE u.userType.userTypeId = :userTypeId");
			uerListQuery.setLong("userTypeId", UserType.ACCOUNT.getUserType());
			List<User> userList = uerListQuery.list();
			userVOList = AdminUtil.getUserVOListFromEntityList(userList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return userVOList;
	}

	@Override
	public List<UserVO> getUserLobHeadList() {
		Session session = null;
		List<UserVO> userVOList = null;
		try {
			userVOList = new ArrayList<UserVO>();
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			Query uerListQuery = session
					.createQuery("SELECT u FROM User u WHERE u.userType.userTypeId = :userTypeId");
			uerListQuery.setLong("userTypeId", UserType.LOB.getUserType());
			List<User> userList = uerListQuery.list();
			userVOList = AdminUtil.getUserVOListFromEntityList(userList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return userVOList;
	}

	@Override
	public List<ProjectVO> getProjectVOListForAccount(Long accountHeadId) {
		List<ProjectVO> projectVOList = null;
		Session session = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			Query projectListQuery = session
					.createSQLQuery(
							"SELECT * FROM project WHERE project_account IN (SELECT account_id FROM account WHERE account_head = :accountHeadId)")
					.addEntity(Project.class);
			projectListQuery.setLong("accountHeadId", accountHeadId);
			List<Project> projectList = projectListQuery.list();
			projectVOList = AdminUtil
					.getProjectVOListFromEntityList(projectList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return projectVOList;
	}

	@Override
	public List<ManagerVO> getManagerListForAccount(Long accountHeadId) {
		List<ManagerVO> managerVOList = null;
		Session session = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			Query managerListQuery = session
					.createSQLQuery(
							"SELECT * FROM manager WHERE manager_account_id IN (SELECT account_id FROM account WHERE account_head = :accountHeadId)")
					.addEntity(Manager.class);
			managerListQuery.setLong("accountHeadId", accountHeadId);
			List<Manager> managerList = managerListQuery.list();
			managerVOList = AdminUtil
					.getManagerVOListFromEntityList(managerList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return managerVOList;
	}

	@Override
	public List<ProjectVO> getProjectVOListForLob(Long lobHeadId) {
		List<ProjectVO> projectVOList = null;
		Session session = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			Query projectListQuery = session
					.createSQLQuery(
							"SELECT * FROM project WHERE project_lob IN (SELECT lob_id FROM lob WHERE lob_head = :lobHeadId)")
					.addEntity(Project.class);
			projectListQuery.setLong("lobHeadId", lobHeadId);
			List<Project> projectList = projectListQuery.list();
			projectVOList = AdminUtil
					.getProjectVOListFromEntityList(projectList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return projectVOList;
	}

	@Override
	public List<ManagerVO> getManagerListForLob(Long lobHeadId) {
		List<ManagerVO> managerVOList = null;
		Session session = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			Query managerListQuery = session
					.createSQLQuery(
							"SELECT * FROM manager WHERE manager_lob_id IN (SELECT lob_id FROM lob WHERE lob_head = :lobHeadId)")
					.addEntity(Manager.class);
			managerListQuery.setLong("lobHeadId", lobHeadId);
			List<Manager> managerList = managerListQuery.list();
			managerVOList = AdminUtil
					.getManagerVOListFromEntityList(managerList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return managerVOList;
	}

	@Override
	public List<AccountVO> getAccountVOListForLob(Long lobHeadId) {
		List<AccountVO> accountVOList = null;
		Session session = null;
		try {
			session = ConnectionManager.getSession(ConfigReader
					.getMastersConfig());
			Query accountListQuery = session
					.createSQLQuery(
							"SELECT * FROM account WHERE account_lob IN (SELECT lob_id FROM lob WHERE lob_head = :lobHeadId)")
					.addEntity(Account.class);
			accountListQuery.setLong("lobHeadId", lobHeadId);
			List<Account> accountList = accountListQuery.list();
			accountVOList = AdminUtil.getAccountVOListFromEntityList(accountList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
		return accountVOList;
	}

}
