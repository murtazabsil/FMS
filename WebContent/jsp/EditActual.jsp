<%@page import="com.bluestar.fms.vo.ActualVO"%>
<%@page import="com.bluestar.fms.vo.ForecastVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Actual</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no">
</head>
<body>
	<jsp:include page="AdminMenu.jsp"></jsp:include>
	<div id="page-title">
		<h2>Edit Actual</h2>
	</div>
	<%
		ForecastVO forecastVO = (ForecastVO) request
				.getAttribute("forecastVO");
		ActualVO actualVO = (ActualVO) request.getAttribute("actualVO");
	%>
	<div id="form-wrapper">
		<form action="<%=request.getContextPath()%>/ActualServlet"
			method="post">
			<input type="hidden" name="requestFrom" value="AddActual"> <input
				type="hidden" name="projectId"
				value="<%=request.getParameter("projectId")%>"> <input
				type="hidden" name="forecastId"
				value="<%=forecastVO.getForecastId()%>">
				<input
				type="hidden" name="actualId"
				value="<%=actualVO.getActualId()%>"> 
			<div>
				<table align="center" cellpadding="10">
					<tr>
						<td>Forecast Name :</td>
						<td><%=forecastVO.getForecastName()%></td>
					</tr>
					<tr>
						<td>Forecast Year :</td>
						<td><%=forecastVO.getForecastYear()%></td>
					</tr>
					<tr>
						<td>ForeCast Month :</td>
						<td><%=forecastVO.getForecastMonthDesc()%></td>
					</tr>
					<tr>
						<td>Actual Name :</td>
						<td>Actual_<%=forecastVO.getForecastName()%></td>
					</tr>
					<tr class="quarter-row quarter-row-common">
						<td>JANUARY</td>
						<td>FEBRUARY</td>
						<td>MARCH</td>
					<tr>
					<tr class="quarter-row quarter-row-common">
						<td><input name="1" id="1" type="text" size="10"
							value=<%=actualVO.getActualData()[1] != null ? actualVO
					.getActualData()[1] : 0%>></td>
						<td><input name="2" id="2" type="text" size="10"
							value=<%=actualVO.getActualData()[2] != null ? actualVO
					.getActualData()[2] : 0%>></td>
						<td><input name="3" id="3" type="text" size="10"
							value=<%=actualVO.getActualData()[3] != null ? actualVO
					.getActualData()[3] : 0%>></td>
					<tr>
					<tr></tr>
					<tr class="quarter-row-common">
						<td>APRIL</td>
						<td>MAY</td>
						<td>JUNE</td>
					<tr>
					<tr class="quarter-row-common">
						<td><input name="4" id="4" type="text" size="10"
							value=<%=actualVO.getActualData()[4] != null ? actualVO
					.getActualData()[4] : 0%>></td>
						<td><input name="5" id="5" type="text" size="10"
							value=<%=actualVO.getActualData()[5] != null ? actualVO
					.getActualData()[5] : 0%>></td>
						<td><input name="6" id="6" type="text" size="10"
							value=<%=actualVO.getActualData()[6] != null ? actualVO
					.getActualData()[6] : 0%>></td>
					<tr>
					<tr></tr>
					<tr class="quarter-row-common">
						<td>JULY</td>
						<td>AUGUST</td>
						<td>SEPTEMBER</td>
					<tr>
					<tr class="quarter-row-common">
						<td><input name="7" id="7" type="text" size="10"
							value=<%=actualVO.getActualData()[7] != null ? actualVO
					.getActualData()[7] : 0%>></td>
						<td><input name="8" id="8" type="text" size="10"
							value=<%=actualVO.getActualData()[8] != null ? actualVO
					.getActualData()[8] : 0%>></td>
						<td><input name="9" id="9" type="text" size="10"
							value=<%=actualVO.getActualData()[9] != null ? actualVO
					.getActualData()[9] : 0%>></td>
					<tr>
					<tr></tr>
					<tr class="quarter-row-common">
						<td>OCTOBER</td>
						<td>NOVEMBER</td>
						<td>DECEMBER</td>
					<tr>
					<tr class="quarter-row-common">
						<td id="monthly-td"><input name="10" id="10" type="text"
							size="10"
							value=<%=actualVO.getActualData()[10] != null ? actualVO
					.getActualData()[10] : 0%>></td>
						<td><input name="11" id="11" type="text" size="10"
							value=<%=actualVO.getActualData()[11] != null ? actualVO
					.getActualData()[11] : 0%>></td>
						<td><input name="12" id="12" type="text" size="10"
							value=<%=actualVO.getActualData()[12] != null ? actualVO
					.getActualData()[12] : 0%>></td>
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