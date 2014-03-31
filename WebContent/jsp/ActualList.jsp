<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bluestar.fms.vo.ForecastVO"%>
<%@page import="com.bluestar.fms.vo.AccountVO"%>
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
<title>Account List</title>
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
	<div id="project-list">
		<div id="page-title">
			<h2>Actual List</h2>
		</div>
		<div id="add-button">
			<a
				href="<%=request.getContextPath()%>/jsp/AddActual.jsp?projectId=<%=request.getParameter("projectId")%>&forecastId=<%=request.getParameter("forecastId")%>">
				<span style="background-color: #565656; padding: 7px; color: white;">Add
					New Forecast</span>
			</a>
		</div>
		<div class="table-responsive">
			<table id="project-list-table" align="center">
				<thead>
					<tr>
						<th>Name</th>
						<th>Forecast Name</th>
						<th>Month</th>
						<th>Created By</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${actualList}" var="element">
						<tr>
							<td>${element.actualName}</td>
							<td>${element.forecastName}</td>
							<td>${element.actualMonth}</td>
							<td>${element.createdByName}</td>
							<td><a
								href="<%=request.getContextPath()%>/ForecastServlet?requestFrom=ForecastEdit&projectId=${element.projectId}&id=${element.forecastId}">Edit</a></td>
							<td>${element.createdOnDesc}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div id="list-note">
		<span style="color: red;">Note:</span> <span
			style="font-weight: normal;"> Please keep mouse over Account
			Name to get description.</span>
	</div>
	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>
