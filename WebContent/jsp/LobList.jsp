<%@page import="com.bluestar.fms.vo.LobVO"%>
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
<title>Lob List</title>
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
			List<LobVO> lobList = adminBSO.getLobList();
			request.setAttribute("lobList", lobList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
	%>
	<div id="project-list">
		<div id="page-title">
			<h2>Lob List</h2>
		</div>

		<div id="add-button">
			<a href="AddLob.jsp"> <span
				style="background-color: #565656; padding: 7px; color: white;">Add
					New Lob</span>
			</a>
		</div>
		<div class="table-responsive">
			<table id="project-list-table" align="center">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Location</th>
						<th>Head</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lobList}" var="element">
						<tr>
							<td>${element.lobId}</td>
							<td title="${element.lobDesc}">${element.lobName}</td>
							<td>${element.lobLocationName}</td>
							<td>${element.lobHeadName}</td>
							<td><a
								href="<%=request.getContextPath()%>/Admin?action=edit&event=4&id=${element.lobId}">Edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div id="list-note">
		<span style="color: red;">Note:</span> <span
			style="font-weight: normal;"> Please keep mouse over Lob Name
			to get description.</span>
	</div>

	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>