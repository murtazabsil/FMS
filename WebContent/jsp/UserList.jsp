<%@page import="com.bluestar.fms.vo.ManagerVO"%>
<%@page import="com.bluestar.fms.vo.UserVO"%>
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
<title>User List</title>
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
			List<UserVO> userList = adminBSO.getUserList();
			request.setAttribute("userList", userList);
		} catch (Exception exception) {
			PrintStackTraceLogger.getStackTrace(exception);
		}
	%>
	<div id="project-list">
		<div id="page-title">
			<h2>User List</h2>
		</div>

		<div id="add-button">
			<a href="AddUser.jsp"> <span
				style="background-color: #565656; padding: 7px; color: white;">Add
					New User</span>
			</a>
		</div>
		<div class="table-responsive">
			<table id="project-list-table" align="center">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Address</th>
						<th>Email Address</th>
						<th>Contact</th>
						<th>Role</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="element">
						<tr>
							<td>${element.regID}</td>
							<td>${element.firstName}${element.lastName}</td>
							<td>${element.address}</td>
							<td>${element.emailAddress}</td>
							<td>${element.contactNumber}</td>
							<td>${element.userTypeName}</td>
							<td><a
								href="<%=request.getContextPath()%>/Admin?action=edit&event=5&id=${element.regID}">Edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>