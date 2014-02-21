package com.bluestar.fms.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bluestar.fms.bso.AdminBSO;
import com.bluestar.fms.bso.AdminBSOImpl;
import com.bluestar.fms.constants.AdminConstants;
import com.bluestar.fms.entity.Project;
import com.bluestar.fms.helper.AdminHelper;
import com.bluestar.fms.util.AdminUtil;
import com.bluestar.fms.util.ConfigReader;
import com.bluestar.fms.util.PrintStackTraceLogger;
import com.bluestar.fms.vo.AccountVO;
import com.bluestar.fms.vo.ExchageRateVO;
import com.bluestar.fms.vo.LobVO;
import com.bluestar.fms.vo.ManagerVO;
import com.bluestar.fms.vo.ProjectVO;
import com.bluestar.fms.vo.ResponseVO;
import com.bluestar.fms.vo.UserVO;
import com.fms.dao.ConnectionManager;
import com.fms.dao.DAOManager;

public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Map<String, List<String>> dropDownListMap = null;
	Map<String, List<String>> dropModuleDownListMap = null;
	
	AdminBSO adminBSO = new AdminBSOImpl();

	public void init() throws ServletException {

		try {
			dropDownListMap = adminBSO.initializeDropDown();
			
			// debugLogger("dropDownListMap ---"+dropDownListMap);
		} catch (Exception es) {
			es.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		ResponseVO responseVO = null;

		String action = request.getParameter("action");
		String addmodule = request.getParameter("addmodule");
		
		debugLogger("addmodule in servlet " + addmodule);
		String id = request.getParameter("id");
		System.out.println("id ---------------" + id);

		debugLogger("----- AdminServlet ----- ");
		request.setAttribute("id", id);
		RequestDispatcher view = null;
		try {
			if (addmodule != null && addmodule.trim().length() > 0) {
				responseVO = adminBSO.processAddModule(request);
				request.setAttribute("response", responseVO);
				view = request.getRequestDispatcher("ViewLocations.jsp");

			} else {
				debugLogger("----- action -----" + action);
				if (action != null && action.equals("viewproject")) {

					String event = request.getParameter("event");
					System.out.println("event ---------------" + event);

					List<ProjectVO> list = adminBSO.getProjectList();
					debugLogger("----- list --" + list.size() + "---"
							+ list.toString());
					request.setAttribute("listProjectVO", list);
					request.setAttribute("event", event);
					view = request.getRequestDispatcher("ViewMembers.jsp");
				} 
				
				else if (action != null && action.equals("link")) {

					String event = request.getParameter("event");
					String projid = request.getParameter("selectval");

					// System.out.println("event -------projid--------"+event+"----"+projid);
					if (event != null && event.equals("1")) {
						System.out.println("event -------projid--------"
								+ event + "----" + projid);
					} else {
						System.out.println("event -------projid--------"
								+ event + "----" + projid);
					}
					List<ProjectVO> list = adminBSO.getProjectList();
					debugLogger("----- list --" + list.size() + "---"
							+ list.toString());
					request.setAttribute("listProjectVO", list);
					request.setAttribute("event", event);
					view = request.getRequestDispatcher("ViewMembers.jsp");
				}				
				else if (action != null && action.equals("viewpm")) {
					String event = request.getParameter("event");
					System.out.println("event ---------------" + event);
					List<ManagerVO> list = adminBSO.getManagerList();
					debugLogger("----- list --" + list.size() + "---"
							+ list.toString());
					request.setAttribute("listPMVO", list);
					request.setAttribute("event", event);
					view = request
							.getRequestDispatcher("ViewBlockedMembers.jsp");
				} 
				
				else if (action != null && action.equals("add")) {
					dropModuleDownListMap = adminBSO.initializeModuleDropDown();
					
					dropDownListMap.putAll(dropModuleDownListMap);
					request.setAttribute("dropDownListMap", dropDownListMap);

					view = request.getRequestDispatcher("Accommodation0.jsp");
				} 
				
				else if (action != null && action.equals("edit")) {
					dropModuleDownListMap = adminBSO.initializeModuleDropDown();
					
					dropDownListMap.putAll(dropModuleDownListMap);
					request.setAttribute("dropDownListMap", dropDownListMap);
					String editEvent = request.getParameter("event");
					String idToEdit = request.getParameter("id");
					
					request.setAttribute("event", editEvent);
					if (editEvent != null && editEvent.equals("1")) {

						ProjectVO projectVO = adminBSO
								.getProjectDetails(idToEdit);
						request.setAttribute("detail", projectVO);
						request.setAttribute("Path", "EditModuleDetails");
					}
					
					else if (editEvent != null && editEvent.equals("2")) {
						ManagerVO managerVO = adminBSO
								.getManagerDetails(idToEdit);
						request.setAttribute("detail", managerVO);
						request.setAttribute("Path", "EditModuleDetails");
					} 
					
					else if (editEvent != null && editEvent.equals("3")) {
						AccountVO accountVO = adminBSO
								.getAccountDetails(idToEdit);
						request.setAttribute("detail", accountVO);
						request.setAttribute("Path", "EditModuleDetails");
					}
					
					else if (editEvent != null && editEvent.equals("4")) {
						LobVO lobVO = adminBSO.getLobDetails(idToEdit);
						request.setAttribute("detail", lobVO);
						request.setAttribute("Path", "EditModuleDetails");
					}
					
					else if (editEvent != null && editEvent.equals("5")) {
						UserVO userVO = adminBSO.getUserDetails(idToEdit);
						request.setAttribute("detail", userVO);
						request.setAttribute("Path", "AddUser");
					}
					
					else {
						request.setAttribute("Path", "Resorts0");
					}

				} 
				
				else if (action != null && action.equals("delete")) {
					// view = request.getRequestDispatcher("ReserveRooms0.jsp");
					
					dropModuleDownListMap = adminBSO.initializeModuleDropDown();
					
					dropDownListMap.putAll(dropModuleDownListMap);
					
					request.setAttribute("dropDownListMap", dropDownListMap);
					String event = request.getParameter("event");
					String ids = request.getParameter("selectval");

					if (event != null && event.equals("1")) {
						System.out.println("event -------projid--------"
								+ event + "----" + ids);
						
						boolean flag = adminBSO.deleteProject(ids);
						System.out.println("flag   "	+ flag );
					} 
					
					else if (event != null && event.equals("2")) {
						System.out.println("event -------projid--------"
								+ event + "----" + ids);
						boolean flag = adminBSO.deleteManager(ids);
						System.out.println("flag   "	+ flag );
					}
					
					else if (event != null && event.equals("3")) {
						System.out.println("event -------projid--------"
								+ event + "----" + ids);
						boolean flag = adminBSO.deleteAccount(ids);
						System.out.println("flag   "	+ flag );
					} 
					
					else if (event != null && event.equals("4")) {
						System.out.println("event -------projid--------"
								+ event + "----" + ids);
						boolean flag = adminBSO.deleteLob(ids);
						System.out.println("flag   "	+ flag );
					}

					
					view = request.getRequestDispatcher("DeleteRecords.jsp");

				} 
				
				else if (action != null && action.equals("editlink")) {
					view = request.getRequestDispatcher("MemberSpeak0.jsp");
				}
				else if (action != null && action.equals("exchange")) {
					
					String exmodule = request.getParameter("exmodule");
					
					
						List<ExchageRateVO> exchangeRateVOList = adminBSO.getExchangeRateVOList(exmodule);
					
					view = request.getRequestDispatcher("Exchange.jsp");
				}

			}

			request.setAttribute("action", action);

			//view.forward(request, response);

		/*} catch (ServletException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
*/
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response){
		AdminBSO adminBSO = new AdminBSOImpl();
		DAOManager daoManager = null;
		Session session = null;
		Transaction transaction = null;
		try{
			session = ConnectionManager.getSession(ConfigReader.getMastersConfig());
			daoManager = new DAOManager(session);
			Map<String, String[]> map = request.getParameterMap();
			transaction = session.beginTransaction();
			String action = request.getParameter("action");
			String module = request.getParameter("module");
			if("add".equalsIgnoreCase(action)){
				if("project".equalsIgnoreCase(module)){
					ProjectVO projectVO = AdminHelper.convertRequestToProjectVO(request);
					Project project =  AdminUtil.convertProjectVOtoEntity(projectVO);
					if(daoManager.create(project) != null){
						request.setAttribute("Path", "ProjectList");
					} else {
						request.setAttribute("Path", "AddProject");
						request.setAttribute("error", AdminConstants.ERROR_ADD_PROJECT);
					}
				} 
				if("manager".equalsIgnoreCase(module)){
					ProjectVO projectVO = AdminHelper.convertRequestToProjectVO(request);
					Project project =  AdminUtil.convertProjectVOtoEntity(projectVO);
					if(daoManager.create(project) != null){
						request.setAttribute("Path", "ManagerList");
					} else {
						request.setAttribute("Path", "AddManager");
						request.setAttribute("error", AdminConstants.ERROR_ADD_MANAGER);
					}
				}
				if("account".equalsIgnoreCase(module)){
					ProjectVO projectVO = AdminHelper.convertRequestToProjectVO(request);
					Project project =  AdminUtil.convertProjectVOtoEntity(projectVO);
					if(daoManager.create(project) != null){
						request.setAttribute("Path", "AccountList");
					} else {
						request.setAttribute("Path", "AddAccount");
						request.setAttribute("error", AdminConstants.ERROR_ADD_ACCOUNT);
					}
				}
				if("lob".equalsIgnoreCase(module)){
					ProjectVO projectVO = AdminHelper.convertRequestToProjectVO(request);
					Project project =  AdminUtil.convertProjectVOtoEntity(projectVO);
					if(daoManager.create(project) != null){
						request.setAttribute("Path", "LobList");
					} else {
						request.setAttribute("Path", "AddLob");
						request.setAttribute("error", AdminConstants.ERROR_ADD_LOB);
					}
				}
				if("user".equalsIgnoreCase(module)){
					ProjectVO projectVO = AdminHelper.convertRequestToProjectVO(request);
					Project project =  AdminUtil.convertProjectVOtoEntity(projectVO);
					if(daoManager.create(project) != null){
						request.setAttribute("Path", "UserList");
					} else {
						request.setAttribute("Path", "AddUser");
						request.setAttribute("error", AdminConstants.ERROR_ADD_USER);
					}
				}
			}
		}catch(Exception exception){
			PrintStackTraceLogger.getStackTrace(exception);
		} finally{
			if(transaction != null){
				transaction.commit();
				session.flush();
			}
		}
	}
	
	public static void debugLogger(String loggerString) {
		System.out.println(" ### AdminServlet: " + loggerString);
	}

	public static void debugLogger(Exception e) {
		for (StackTraceElement element : e.getStackTrace()) {
			debugLogger(" ### AdminServlet:" + element.toString());
		}
	}

}
