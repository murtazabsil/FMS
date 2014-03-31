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
<title>Manager List</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dataTables.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/module.js"></script>
</head>
<body>
	<jsp:include page="AdminMenu.jsp"></jsp:include>
	<%
		AdminBSO adminBSO = new AdminBSOImpl();
		try {
			List<ManagerVO> managerList = adminBSO
					.getManagerVOListForLob((Long) session
							.getAttribute("userRegId"));
			request.setAttribute("managerList", managerList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
	%>
	<div id="project-list">
		<div id="page-title">
			<h2>Manager List</h2>
		</div>

		<div class="table-responsive">
			<table id="project-list-table" align="center">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Code</th>
						<th>Lob</th>
						<th>Account</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${managerList}" var="element">
						<tr>
							<td>${element.managerId}</td>
							<td title="${element.managerDescrition}">${element.managerName}</td>
							<td>${element.managerEmpId}</td>
							<td>${element.managerLobName}</td>
							<td>${element.managerAccountName}</td>
							<td>${element.managerLocationName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div id="list-note">
		<span style="color: red;">Note:</span> <span
			style="font-weight: normal;"> Please keep mouse over Manager
			Name to get description.</span>
	</div>

	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>