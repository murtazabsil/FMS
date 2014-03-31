package com.bluestar.fms.bso;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bluestar.fms.entity.Account;
import com.bluestar.fms.entity.Lob;
import com.bluestar.fms.entity.Manager;
import com.bluestar.fms.entity.Month;
import com.bluestar.fms.entity.Project;
import com.bluestar.fms.entity.ProjectManagerLink;
import com.bluestar.fms.entity.User;
import com.bluestar.fms.entity.UserType;
import com.bluestar.fms.vo.AccountVO;
import com.bluestar.fms.vo.ExchageRateVO;
import com.bluestar.fms.vo.LobVO;
import com.bluestar.fms.vo.ManagerVO;
import com.bluestar.fms.vo.MonthVO;
import com.bluestar.fms.vo.ProjectVO;
import com.bluestar.fms.vo.ResponseVO;
import com.bluestar.fms.vo.UserVO;

public interface AdminBSO {

	public ResponseVO processAddModule(HttpServletRequest request);

	public Map<String, List<String>> initializeDropDown();

	public List<ProjectVO> getProjectList();

	public List<ProjectVO> getProjectList(Long userType, Long userId);

	public List<ManagerVO> getManagerList();

	public List<AccountVO> getAccountList();

	public List<LobVO> getLobList();

	public List<UserVO> getUserList();

	public List<MonthVO> getMonthList();

	public ProjectVO getProjectDetails(String idToEdit);

	public LobVO getLobDetails(String idToEdit);

	public ManagerVO getManagerDetails(String idToEdit);

	public AccountVO getAccountDetails(String idToEdit);

	public boolean deleteProject(String ids);

	public boolean deleteLob(String ids);

	public boolean deleteAccount(String ids);

	public boolean deleteManager(String ids);

	public boolean deleteUser(String ids);

	public Map<String, List<String>> initializeModuleDropDown();

	public UserVO getUserDetails(String idToEdit);

	public List<ExchageRateVO> getExchangeRateVOList(String exmodule);

	public Account getAccountFromAccountId(Long accountId);

	public Project getProjectFromProjectId(Long projectId);

	public Manager getManagerFromManagerId(Long managerId);

	public Lob getLobFromLobId(Long lobId);

	public User getUserFromUserID(Long userId);

	public List<UserVO> getUserAccountHeadList();

	public List<UserVO> getUserLobHeadList();

	public ProjectManagerLink linkManagerToProject(Long managerId,
			Long projectId);

	public List<ProjectVO> getProjectVOListForAccount(Long accountHeadId);
	public List<ManagerVO> getManagerListForAccount(Long accountHeadId);
	public List<ProjectVO> getProjectVOListForLob(Long lobHeadId);
	public List<ManagerVO> getManagerVOListForLob(Long lobHeadId);
	public List<AccountVO> getAccountVOListForLob(Long lobHeadId);
}
