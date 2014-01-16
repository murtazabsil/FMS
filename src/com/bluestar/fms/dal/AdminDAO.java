package com.bluestar.fms.dal;


import java.util.List;

import com.bluestar.fms.vo.AccountVO;
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
import com.bluestar.fms.vo.CurrencyVO;
import com.bluestar.fms.vo.DepartmentVO;
import com.bluestar.fms.vo.UserVO;

public interface AdminDAO {

	public List<ModuleVO> getModuleList();
	public List<ProjectVO> getProjectList();
	public List<ManagerVO> getManagerList();
	public List<AccountVO> getAccountList();
	public List<LobVO> getLobList();
	public List<CurrencyVO> getCurrencyList();
	public List<StatusVO> getStatusList();
	public List<TypeVO> getTypeList();
	public List<PriorityVO> getPriorityList();
	public List<LocationVO> getLocationList();
	public List<DepartmentVO> getDepartmentList();
	public List<LinkVO> getPmProjectLinkList();

	
	public ResponseVO addProject(ProjectVO projectvo);
	public ResponseVO addUser(UserVO userVO);
	public ResponseVO addLob(LobVO lobVO);
	public ResponseVO addAccount(AccountVO accountVO);
	public ResponseVO addManager(ManagerVO managerVO);
	public ProjectVO getProjectDetails(String idToEdit);
	public AccountVO getAccountDetails(String idToEdit);
	public LobVO getLobDetails(String idToEdit);
	public ManagerVO getManagerDetails(String idToEdit);
	public boolean deleteProject(String ids);
	public boolean deleteLob(String ids);
	public boolean deleteAccount(String ids);
	public boolean deleteManager(String ids);
	public boolean deleteUser(String ids);
	public boolean  deleteRecord(String entityName,String ids);
	public  Object getEntityDetails(String entityName, String idToEdit);
	public UserVO getUserDetails(String idToEdit);
	public List<UserVO> getUserList();
	
	
}
