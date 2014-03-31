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
			List<ProjectVO> projectList = adminBSO
					.getProjectVOListForAccount((Long) session
							.getAttribute("userRegId"));
			request.setAttribute("projectList", projectList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
	%>
	<div id="project-list">
		<div id="page-title">
			<h2>Project List</h2>
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
						<th>Forecast List</th>
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
								href="<%=request.getContextPath()%>/ForecastServlet?requestFrom=ForecastList&projectId=${element.projectId}">List</a></td>
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

	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>