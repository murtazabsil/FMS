<%@page import="com.bluestar.fms.vo.MonthVO"%>
<%@page import="com.bluestar.fms.entity.Month"%>
<%@page import="com.bluestar.fms.bso.AdminBSOImpl"%>
<%@page import="com.bluestar.fms.bso.AdminBSO"%>
<%@page import="com.bluestar.fms.vo.ManagerVO"%>
<%@page import="java.util.List"%>
<%@page import="com.bluestar.fms.vo.ForecastVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Forecast</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no">
</head>
<body>
	<jsp:include page="AdminMenu.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#forecast-submit').click(function() {
				$('#forecast-year').removeAttr('disabled');
				$('#forecast-month').removeAttr('disabled');
			});
		});
	</script>
	<div id="page-title">
		<h2>Edit Forecast</h2>
	</div>
	<%
		AdminBSO adminBSO = new AdminBSOImpl();
		ForecastVO forecastVO = (ForecastVO) request
				.getAttribute("forecastVO");
		List<MonthVO> monthList = adminBSO.getMonthList();
		request.setAttribute("managerList", monthList);
	%>
	<div id="form-wrapper">
		<form action="<%=request.getContextPath()%>/ForecastServlet"
			method="post">
			<input type="hidden" name="requestFrom" value="AddForecast">
			<input type="hidden" name="projectId"
				value="<%=request.getParameter("projectId")%>"> <input
				type="hidden" name="forecastId"
				value=<%=forecastVO.getForecastId()%>>
			<div>
				<table align="center" cellpadding="10">
					<tr>
						<td>Forecast Name :</td>
						<td><input type="text" name="forecast-name"
							id="forecast-name" value=<%=forecastVO.getForecastName()%>>
						</td>
					</tr>
					<tr>
						<td>Select Year :</td>
						<td><select disabled="disabled" name="forecast-year"
							id="forecast-year">
								<option><%=forecastVO.getForecastYear()%></option>
						</select></td>
					</tr>
					<tr>
						<td>ForeCast for Month :</td>
						<c:set var="forecastVO" value="forecastVO"></c:set>
						<td><select name="forecast-month" id="forecast-month"
							disabled="disabled">
								<option value=<%=forecastVO.getForecastMonth()%>><%=forecastVO.getForecastMonthDesc()%></option>
						</select></td>
					</tr>
					<tr align="center" class="quarter-row quarter-row-common">
						<td>JANUARY</td>
						<td>FEBRUARY</td>
						<td>MARCH</td>
					<tr>
					<tr align="center" class="quarter-row quarter-row-common">
						<td><input name="1" id="1" type="text" size="10"
							value=<%=forecastVO.getForecastData()[1] != null ? forecastVO
					.getForecastData()[1] : 0%>></td>
						<td><input name="2" id="2" type="text" size="10"
							value=<%=forecastVO.getForecastData()[2] != null ? forecastVO
					.getForecastData()[2] : 0%>></td>
						<td><input name="3" id="3" type="text" size="10"
							value=<%=forecastVO.getForecastData()[3] != null ? forecastVO
					.getForecastData()[3] : 0%>></td>
					<tr>
					<tr></tr>
					<tr align="center" class="quarter-row-common">
						<td>APRIL</td>
						<td>MAY</td>
						<td>JUNE</td>
					<tr>
					<tr align="center" class="quarter-row-common">
						<td><input name="4" id="4" type="text" size="10"
							value=<%=forecastVO.getForecastData()[4] != null ? forecastVO
					.getForecastData()[4] : 0%>></td>
						<td><input name="5" id="5" type="text" size="10"
							value=<%=forecastVO.getForecastData()[5] != null ? forecastVO
					.getForecastData()[5] : 0%>></td>
						<td><input name="6" id="6" type="text" size="10"
							value=<%=forecastVO.getForecastData()[6] != null ? forecastVO
					.getForecastData()[6] : 0%>></td>
					<tr>
					<tr></tr>
					<tr align="center" class="quarter-row-common">
						<td>JULY</td>
						<td>AUGUST</td>
						<td>SEPTEMBER</td>
					<tr>
					<tr align="center" class="quarter-row-common">
						<td><input name="7" id="7" type="text" size="10"
							value=<%=forecastVO.getForecastData()[7] != null ? forecastVO
					.getForecastData()[7] : 0%>></td>
						<td><input name="8" id="8" type="text" size="10"
							value=<%=forecastVO.getForecastData()[8] != null ? forecastVO
					.getForecastData()[8] : 0%>></td>
						<td><input name="9" id="9" type="text" size="10"
							value=<%=forecastVO.getForecastData()[9] != null ? forecastVO
					.getForecastData()[9] : 0%>></td>
					<tr>
					<tr></tr>
					<tr align="center" class="quarter-row-common">
						<td>OCTOBER</td>
						<td>NOVEMBER</td>
						<td>DECEMBER</td>
					<tr>
					<tr align="center" class="quarter-row-common">
						<td id="monthly-td"><input name="10" id="10" type="text"
							size="10"
							value=<%=forecastVO.getForecastData()[10] != null ? forecastVO
					.getForecastData()[10] : 0%>></td>
						<td><input name="11" id="11" type="text" size="10"
							value=<%=forecastVO.getForecastData()[11] != null ? forecastVO
					.getForecastData()[11] : 0%>></td>
						<td><input name="12" id="12" type="text" size="10"
							value=<%=forecastVO.getForecastData()[12] != null ? forecastVO
					.getForecastData()[12] : 0%>></td>
					<tr>
					<tr align="center">
					<td colspan="3"><input class="sitewide-button" id="forecast-submit" type="submit"
					value="Submit" /> <input class="sitewide-button"
					id="forecast-reset" type="reset" value="Reset" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>