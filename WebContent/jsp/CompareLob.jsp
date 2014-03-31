<%@page import="com.bluestar.fms.vo.ProjectVO"%>
<%@page import="com.bluestar.fms.vo.ForecastVO"%>
<%@page import="com.bluestar.fms.bso.ActualBSOImpl"%>
<%@page import="com.bluestar.fms.bso.ActualBSO"%>
<%@page import="com.bluestar.fms.bso.ForecastBSOImpl"%>
<%@page import="com.bluestar.fms.bso.ForecastBSO"%>
<%@page import="com.bluestar.fms.bso.AdminBSOImpl"%>
<%@page import="com.bluestar.fms.bso.AdminBSO"%>
<%@page import="com.bluestar.fms.util.PrintStackTraceLogger"%>
<%@page import="java.util.*"%>
<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.lang.*,java.util.Vector,java.util.StringTokenizer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String UserID = (String) session.getAttribute("UserID");
%>
<jsp:include page="AdminMenu.jsp"></jsp:include>
<HTML>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery-ui.css">
<script LANGUAGE="Javascript"
	SRC="<%=request.getContextPath()%>/scripts/jquery-ui.js"></script>
<script LANGUAGE="Javascript"
	SRC="<%=request.getContextPath()%>/scripts/datetimepicker.js"></script>
<script LANGUAGE="Javascript" SRC="../Images/validate.js"></script>
<script LANGUAGE="Javascript" SRC="../Images/AjaxCall.js"></script>

<title>Compare</title>
</head>
<table align="center">

</table>
<%
	AdminBSO adminBSO = new AdminBSOImpl();
	ForecastBSO forecastBSO = new ForecastBSOImpl();
	ActualBSO actualBSO = new ActualBSOImpl();
	try {
		List<ProjectVO> projectList = adminBSO
				.getProjectVOListForLob((Long) session
						.getAttribute("userRegId"));
		request.setAttribute("projectList", projectList);
	} catch (Exception exception) {
		PrintStackTraceLogger.getStackTrace(exception);
	}
%>
<BODY Class="SC">
	<div style="margin-top: 5%;" id="page-title">
		<h2>Compare</h2>
	</div>
	<input type="hidden" id="context-path"
		value="<%=request.getContextPath()%>">
	<table border="1" cellpadding="10px" align="center">
		<tr align="center">
			<td colspan="3"><select id="compare-select">
					<option value="1">Compare Forecast</option>
					<option value="2">Compare Actual</option>
			</select>
		</tr>
		<tr align="center">
			<td><select id="project1">
					<option value="0">Select Project</option>
					<c:forEach items="${projectList}" var="project">
						<option value="${project.projectId}">${project.projectName}</option>
					</c:forEach>
			</select></td>
			<td></td>
			<td><select id="project2">
					<option value="0">Select Project</option>
					<c:forEach items="${projectList}" var="project">
						<option value="${project.projectId}">${project.projectName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr align="center" id="forecast-tr">
			<td><select id="select-forecast-1">
					<option value="0">Select Forecast</option>
			</select></td>
			<td>
				<div id="compare-forecast">
					<span
						style="background-color: #565656; padding: 7px; color: white; cursor: pointer;">Add
						Compare Forecast</span>
				</div>
			</td>
			<td><select id="select-forecast-2">
					<option value="0">Select Forecast</option>
			</select></td>
		</tr>
		<tr align="center" id="actual-tr" style="display: none;">
			<td><select id="select-actual-1">
					<option value="0">Select Actual</option>
			</select></td>
			<td>
				<div id="compare-actual">
					<span
						style="background-color: #565656; padding: 7px; color: white; cursor: pointer;">Add
						Compare Actual</span>
				</div>
			</td>
			<td><select id="select-actual-2">
					<option value="0">Select Actual</option>
			</select></td>
		</tr>
		<tr align="center">
			<td>
				<table id="compare1" align="center" cellpadding="10" border="1">
					<tr align="center">
						<td>JANUARY</td>
						<td>FEBRUARY</td>
						<td>MARCH</td>
					</tr>
					<tr align="center">
						<td><label id="1"></label></td>
						<td><label id="2"></label></td>
						<td><label id="3"></label></td>
					</tr>
					<tr align="center">
						<td>APRIL</td>
						<td>MAY</td>
						<td>JUNE</td>
					</tr align="center">
					<tr align="center">
						<td><label id="4"></label></td>
						<td><label id="5"></label></td>
						<td><label id="6"></label></td>
					</tr>
					<tr align="center">
						<td>JULY</td>
						<td>AUGUST</td>
						<td>SEPTEMBER</td>
					</tr>
					<tr align="center">
						<td><label id="7"></label></td>
						<td><label id="8"></label></td>
						<td><label id="9"></label></td>
					</tr>
					<tr align="center">
						<td>OCTOBER</td>
						<td>NOVEMBER</td>
						<td>DECEMBER</td>
					</tr>
					<tr align="center">
						<td><label id="10"></label></td>
						<td><label id="11"></label></td>
						<td><label id="12"></label></td>
					</tr>
				</table>
			</td>
			<td></td>
			<td>
				<table id="compare2" align="center" cellpadding="10" border="1">
					<tr align="center">
						<td>JANUARY</td>
						<td>FEBRUARY</td>
						<td>MARCH</td>
					</tr>
					<tr align="center">
						<td><label id="1"></label></td>
						<td><label id="2"></label></td>
						<td><label id="3"></label></td>
					</tr>
					<tr align="center">
						<td>APRIL</td>
						<td>MAY</td>
						<td>JUNE</td>
					</tr align="center">
					<tr align="center">
						<td><label id="4"></label></td>
						<td><label id="5"></label></td>
						<td><label id="6"></label></td>
					</tr>
					<tr align="center">
						<td>JULY</td>
						<td>AUGUST</td>
						<td>SEPTEMBER</td>
					</tr>
					<tr align="center">
						<td><label id="7"></label></td>
						<td><label id="8"></label></td>
						<td><label id="9"></label></td>
					</tr>
					<tr align="center">
						<td>OCTOBER</td>
						<td>NOVEMBER</td>
						<td>DECEMBER</td>
					</tr>
					<tr align="center">
						<td><label id="10"></label></td>
						<td><label id="11"></label></td>
						<td><label id="12"></label></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</BODY>
<jsp:include page="Footer.html"></jsp:include>
</HTML>