<%@page import="com.bluestar.fms.vo.ManagerVO"%>
<%@page import="com.bluestar.fms.vo.ProjectVO"%>
<%@page import="java.util.List"%>
<%@page import="com.bluestar.fms.util.PrintStackTraceLogger"%>
<%@page import="com.bluestar.fms.bso.AdminBSOImpl"%>
<%@page import="com.bluestar.fms.bso.AdminBSO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project List</title>
</head>
<body>
	<jsp:include page="AdminMenu.jsp"></jsp:include>
	<%
		AdminBSO adminBSO = new AdminBSOImpl();
		try {
			List<ProjectVO> projectList = adminBSO.getProjectList();
			List<ManagerVO> managerList = adminBSO.getManagerList();
			request.setAttribute("projectList", projectList);
			request.setAttribute("managerList", managerList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
	%>
	<div id="project-list">
		<div id="page-title">
			<h2>Project List</h2>
		</div>

		<div id="add-button">
			<a href="AddProject.jsp"> <span
				style="background-color: #565656; padding: 7px; color: white;">Add
					New Project</span>
			</a>
		</div>
		<div class="table-responsive">
			<table id="project-list-table" class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Lob</th>
						<th>Account</th>
						<th>Type</th>
						<th>Status</th>
						<th>Edit</th>
						<th>Assign to Manager</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${projectList}" var="element">
						<tr>
							<td>${element.projectId}</td>
							<td title="${element.projectDesc}">${element.projectName}</td>
							<td>${element.projectLobName}</td>
							<td>${element.projectAccountName}</td>
							<td>${element.projectTypeName}</td>
							<td>${element.projectStatusName}</td>
							<td><a
								href="<%=request.getContextPath()%>/Admin?action=edit&event=1&id=${element.projectId}">Edit</a></td>
							<td><span class="link-manager" id="${element.projectId}">Link To Manager</span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div id="list-note">
		<span style="color: red;">Note:</span> <span
			style="font-weight: normal;"> Please keep mouse over Project
			Name to get description.</span>
	</div>
	<div id="pop-up-container" title="Link Manager">
		Select manager to link to project : 
		<select id="manager-project-id">
			<c:forEach items="${managerList}" var="element">
				<option value="${element.managerId}">${element.managerName}</option>
			</c:forEach>
		</select>
		<button id="manager-link-button">Submit</button>
	</div>
	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>