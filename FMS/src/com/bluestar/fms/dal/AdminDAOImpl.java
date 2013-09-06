package com.bluestar.fms.dal;

import java.math.BigInteger;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bluestar.fms.entity.Account;
import com.bluestar.fms.entity.Currency;
import com.bluestar.fms.entity.Lob;
import com.bluestar.fms.entity.Location;
import com.bluestar.fms.entity.Login;
import com.bluestar.fms.entity.Manager;
import com.bluestar.fms.entity.Module;
import com.bluestar.fms.entity.Priority;
import com.bluestar.fms.entity.Status;
import com.bluestar.fms.entity.Type;
import com.bluestar.fms.entity.User;
import com.bluestar.fms.constants.AdminConstants;
import com.bluestar.fms.entity.Project;
import com.bluestar.fms.vo.AccountVO;
import com.bluestar.fms.vo.CurrencyVO;
import com.bluestar.fms.vo.DepartmentVO;
import com.bluestar.fms.vo.LinkVO;
import com.bluestar.fms.vo.LobVO;
import com.bluestar.fms.vo.LocationVO;
import com.bluestar.fms.vo.ManagerVO;
import com.bluestar.fms.vo.ModuleVO;
import com.bluestar.fms.vo.PriorityVO;
import com.bluestar.fms.vo.ProjectVO;
import com.bluestar.fms.vo.ResponseVO;
import com.bluestar.fms.vo.StatusVO;
import com.bluestar.fms.vo.TypeVO;
import com.bluestar.fms.vo.UserVO;


import com.bluestar.fms.util.AdminUtil;
import com.bluestar.fms.util.ConfigReader;
import com.fms.dao.ConnectionManager;
import com.fms.dao.DAOManager;


public class AdminDAOImpl implements AdminDAO{

	/*@Override
	public List<ModuleVO> getModuleList() {
		List<ModuleVO> moduleVOList = new ArrayList<ModuleVO>();
		ModuleVO moduleVO ; 
		Connection con=null;
		ResultSet rs=null;
		Statement stmt=null;
		
		
		con = com.eResorts.ConnectionPool.getConnection();
		try {
			stmt =  con.createStatement();
		
		String Query = AdminConstants.SQL_ALL_MODULE;
		rs = stmt.executeQuery(Query);
		
		Integer  id ;
		String name;
		String description;
		debugLogger("getModuleList query"+Query);
	
			while(rs.next()){
				moduleVO = new ModuleVO();
				id= rs.getInt("module_id");
				name= rs.getString("module_name");
				description= rs.getString("module_description");
				
				moduleVO.setModuleId(id);
				moduleVO.setModuleName(name);
				moduleVO.setModuleDescrition(description);
				moduleVOList.add(moduleVO);
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
		return moduleVOList;
	}
		
	*/
	@Override
	public List<ModuleVO> getModuleList() {

		Transaction trn = null;
		Session session = null;
		List<Module> listModule =  new ArrayList<Module>();
		List<ModuleVO> listModuleVO =  new ArrayList<ModuleVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		 
		       trn = session.getTransaction();
		       trn.begin();
		     //  listModule =  daoMgr.findAll("Module");
		       Query query = session.createQuery("from " + " Module ");
		       listModule = query.list();
		       listModuleVO = AdminUtil.getModuleVOListFromEntityList(listModule);
		       System.out.println("listModuleVO ++++++ "+listModuleVO.size());
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
		List<Project> listProject =  new ArrayList<Project>();
		List<ProjectVO> listProjectVO =  new ArrayList<ProjectVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		      
		       trn = session.getTransaction();
		       trn.begin();
		     //  listProject =  daoMgr.findAll("Project");
		       Query query = session.createQuery("from " + " Project ");
		       listProject = query.list();
		       listProjectVO = AdminUtil.getProjectVOListFromEntityList(listProject);
		       System.out.println("listProjectVO ++++++ "+listProjectVO.size());
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
		List<Manager> listManager =  new ArrayList<Manager>();
		List<ManagerVO> listManagerVO =  new ArrayList<ManagerVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		      
		       trn = session.getTransaction();
		       trn.begin();
		     //  listManager =  daoMgr.findAll("Manager");
		       Query query = session.createQuery("from " + " Manager ");
		       listManager = query.list();
		       listManagerVO = AdminUtil.getManagerVOListFromEntityList(listManager);
		       System.out.println("listManagerVO ++++++ "+listManagerVO.size());
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
		List<Account> listAccount =  new ArrayList<Account>();
		List<AccountVO> listAccountVO =  new ArrayList<AccountVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		      
		       trn = session.getTransaction();
		       trn.begin();
		     //  listAccount =  daoMgr.findAll("Account");
		       Query query = session.createQuery("from " + " Account ");
		       listAccount = query.list();
		       listAccountVO = AdminUtil.getAccountVOListFromEntityList(listAccount);
		       System.out.println("listAccountVO ++++++ "+listAccountVO.size());
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
		List<Lob> listLob =  new ArrayList<Lob>();
		List<LobVO> listLobVO =  new ArrayList<LobVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		      
		       trn = session.getTransaction();
		       trn.begin();
		     //  listLob =  daoMgr.findAll("Lob");
		       Query query = session.createQuery("from " + " Lob ");
		       listLob = query.list();
		       listLobVO = AdminUtil.getLobVOListFromEntityList(listLob);
		       System.out.println("listLobVO ++++++ "+listLobVO.size());
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
		List<Currency> listCurrency =  new ArrayList<Currency>();
		List<CurrencyVO> listCurrencyVO =  new ArrayList<CurrencyVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		      
		       trn = session.getTransaction();
		       trn.begin();
		     //  listCurrency =  daoMgr.findAll("Currency");
		       Query query = session.createQuery("from " + " Currency ");
		       listCurrency = query.list();
		       listCurrencyVO = AdminUtil.getCurrencyVOListFromEntityList(listCurrency);
		       System.out.println("listCurrencyVO ++++++ "+listCurrencyVO.size());
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
		List<Status> listStatus =  new ArrayList<Status>();
		List<StatusVO> listStatusVO =  new ArrayList<StatusVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		      
		       trn = session.getTransaction();
		       trn.begin();
		     //  listStatus =  daoMgr.findAll("Status");
		       Query query = session.createQuery("from " + " Status ");
		       listStatus = query.list();
		       listStatusVO = AdminUtil.getStatusVOListFromEntityList(listStatus);
		       System.out.println("listStatusVO ++++++ "+listStatusVO.size());
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
		List<Type> listType =  new ArrayList<Type>();
		List<TypeVO> listTypeVO =  new ArrayList<TypeVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		      
		       trn = session.getTransaction();
		       trn.begin();
		     //  listType =  daoMgr.findAll("Type");
		       Query query = session.createQuery("from " + " Type ");
		       listType = query.list();
		       listTypeVO = AdminUtil.getTypeVOListFromEntityList(listType);
		       System.out.println("listTypeVO ++++++ "+listTypeVO.size());
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
		List<Priority> listPriority =  new ArrayList<Priority>();
		List<PriorityVO> listPriorityVO =  new ArrayList<PriorityVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		      
		       trn = session.getTransaction();
		       trn.begin();
		     //  listPriority =  daoMgr.findAll("Priority");
		       Query query = session.createQuery("from " + " Priority ");
		       listPriority = query.list();
		       listPriorityVO = AdminUtil.getPriorityVOListFromEntityList(listPriority);
		       System.out.println("listPriorityVO ++++++ "+listPriorityVO.size());
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
		List<Location> listLocation =  new ArrayList<Location>();
		List<LocationVO> listLocationVO =  new ArrayList<LocationVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		      
		       trn = session.getTransaction();
		       trn.begin();
		     //  listLocation =  daoMgr.findAll("Location");
		       Query query = session.createQuery("from " + " Location ");
		       listLocation = query.list();
		       listLocationVO = AdminUtil.getLocationVOListFromEntityList(listLocation);
		       System.out.println("listLocationVO ++++++ "+listLocationVO.size());
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
	
	public static void debugLogger(String loggerString){
        System.out.println(" ### AdminDAOImpl: "+loggerString);
    }
    

    public static void debugLogger(Exception e){
        for(StackTraceElement element : e.getStackTrace()){
            debugLogger(" ### AdminDAOImpl:" + element.toString());   
        }    
    }



	@Override
	public ResponseVO addProject(ProjectVO projectvo) {
		
		
		ResponseVO responseVO = new ResponseVO(); 
		Transaction trn = null;
	
		try {
			
		Project projectEntity = AdminUtil.convertProjectVOtoEntity(projectvo);
			
        Session session = ConnectionManager.getSession(ConfigReader.getMastersConfig());

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
                //    logger.info("Error occured, rolling back all transaction");
                    // add error message into the entity and send
                }
            }
           
        }

		int insertRecordCount =projectEntity.getProjectId().intValue();// stmt.executeUpdate();
		
		debugLogger("  insertRecordCount ===="+insertRecordCount);
		
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
		Session session =  null;
		Long insertLoginId = null;

		try {
			  session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
			DAOManager daoMgr = new DAOManager(session);
            trn = session.getTransaction();
            trn.begin();
            if(userVO.getRegID() == null) {
			Login loginEntity = AdminUtil.convertLoginVOtoEntity(userVO.getLoginVO());
			
			 daoMgr.create(loginEntity);
			 
			 insertLoginId =loginEntity.getId();// stmt.executeUpdate();
            }else{
            	insertLoginId = userVO.getRegID();
            }
			  User userEntity = AdminUtil.convertUserVOtoEntity(userVO,insertLoginId);
			
			 // userEntity.setRegid(insertLoninId);
    
            daoMgr.createOrUpdate(userEntity);
            session.beginTransaction().commit();
            // ActivityVO activityVo = getActivityVO(activity);
        
		int insertRecordCount =userEntity.getRegid().intValue();// stmt.executeUpdate();
		
		debugLogger("  insertRecordCount ===="+insertRecordCount);
		
		responseVO.setResult(insertRecordCount);
		} catch (Exception e) {
			
			e.printStackTrace();
			 if (session != null) {
	                if (session.isOpen()) {
	                    session.beginTransaction().rollback();
	                //    logger.info("Error occured, rolling back all transaction");
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
			
			  Session session = ConnectionManager.getSession(ConfigReader.getMastersConfig());

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

		
		int insertRecordCount = lobEntity.getLobId().intValue();//stmt.executeUpdate();
		
		debugLogger("  insertRecordCount ===="+insertRecordCount);
		
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
			
			  Session session = ConnectionManager.getSession(ConfigReader.getMastersConfig());

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


		
		int insertRecordCount = accountEntity.getAccountId().intValue();//stmt.executeUpdate();
		
		debugLogger("  insertRecordCount ===="+insertRecordCount);
		
		responseVO.setResult(insertRecordCount);
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return responseVO;

		
	}



	@Override
	public ResponseVO addManager(ManagerVO managerVO) {ResponseVO responseVO = new ResponseVO(); 
	Transaction trn = null;
	Manager managerEntity = AdminUtil.convertManagerVOtoEntity(managerVO);

	try {
		
		  Session session = ConnectionManager.getSession(ConfigReader.getMastersConfig());

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


	
	int insertRecordCount = managerEntity.getManagerId().intValue();//stmt.executeUpdate();
	
	debugLogger("  insertRecordCount ===="+insertRecordCount);
	
	responseVO.setResult(insertRecordCount);
		
	
	} catch (Exception e) {
		
		e.printStackTrace();
		
	}
	
	return responseVO;

	
}


	@Override
	public Object getEntityDetails(String idToEdit,String entityName) {
		Transaction trn = null;
		Session session = null;
		Object object =  null;
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		       DAOManager daoMgr = new DAOManager(session);
	
		       trn = session.getTransaction();
		       trn.begin();
		       object =  daoMgr.find(new Long(idToEdit), entityName);
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
		     Project project = (Project)getEntityDetails(idToEdit, "Project") ;
		     projectVO = AdminUtil.convertProjectEntityToVO(project);
      	
		} catch (Exception e) {			
			e.printStackTrace();			
		}		
		return projectVO;
	}



	@Override
	public AccountVO getAccountDetails(String idToEdit) 
	{		
		AccountVO accountVO = null;

		try {		            
			Account account = (Account)getEntityDetails(idToEdit, "Account") ;
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
			Lob lob = (Lob)getEntityDetails(idToEdit, "Lob") ;
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
		Manager manager = (Manager)getEntityDetails(idToEdit, "Manager") ;
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
		User user = (User)getEntityDetails(idToEdit, "User") ;
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
			flag = deleteRecord("Project",ids);
	    	
		} catch (Exception e) {		
			 e.printStackTrace();         		
		}
			
			return flag;
		}



	@Override
	public boolean deleteLob(String ids) {			
		boolean flag = false;
		try {		
			flag = deleteRecord("Lob",ids);
	    	
		} catch (Exception e) {		
			 e.printStackTrace();         		
		}
			
			return flag;
		}



	@Override
	public boolean deleteAccount(String ids) {			
		boolean flag = false;
		try {		
			flag = deleteRecord("Account",ids);
	    	
		} catch (Exception e) {		
			 e.printStackTrace();         		
		}
			
			return flag;
		}



	@Override
	public boolean deleteManager(String ids) {			
	boolean flag = false;
	try {		
		flag = deleteRecord("Manager",ids);
    	
	} catch (Exception e) {		
		 e.printStackTrace();         		
	}
		
		return flag;
	}



	@Override
	public boolean deleteRecord(String entityName,String ids) {		
		Transaction trn = null;
		Session session = null;
		boolean flag = false;
		
	try {
		debugLogger("entityName ----"+entityName);
		debugLogger("ids ----"+ids);
		List<String> list = AdminUtil.getListFromCommaString(ids);
		   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());

	       
	            DAOManager daoMgr = new DAOManager(session);
	            
	   
	           trn = session.getTransaction();
	            trn.begin();
	            int i=0;
	            int l=0;
	            debugLogger("list ----"+list);
	            session.beginTransaction();
	            	for (String string : list) {
	            		debugLogger("string ----"+string);
	            		l=  daoMgr.remove(new Long(string), entityName);
	            		i++;
	            	}
	         //   Manager manager =  daoMgr.remove(id, "Project");
	            	trn.commit();
	            	if(i == list.size()){
	          //  
	            flag = true;
	        }else{
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
			flag = deleteRecord("User",ids);
	    	
		} catch (Exception e) {		
			 e.printStackTrace();         		
		}
			
			return flag;
		}


	@Override
	public List<UserVO> getUserList() {

		Transaction trn = null;
		Session session = null;
		List<User> listUser =  new ArrayList<User>();
		List<UserVO> listUserVO =  new ArrayList<UserVO>();
		
		try {
			
			   session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
		        
		       DAOManager daoMgr = new DAOManager(session);
	
		       trn = session.getTransaction();
		       trn.begin();
		     //  listUser =  daoMgr.findAll("User");
		       Query query = session.createQuery("from " + " User ");
		       listUser = query.list();
		       listUserVO = AdminUtil.getUserVOListFromEntityList(listUser);
		       System.out.println("listUserVO ++++++ "+listUserVO.size());
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




        
}
