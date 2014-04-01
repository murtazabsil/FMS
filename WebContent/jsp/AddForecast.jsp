<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Forecast</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no">
<script LANGUAGE="Javascript" SRC="<%=request.getContextPath() %>/Images/validate.js"></script>
</head>
<body>
	<jsp:include page="AdminMenu.jsp"></jsp:include>
	<div id="page-title">
		<h2>Add Forecast</h2>
	</div>
	<div id="form-wrapper">
		<form action="<%=request.getContextPath()%>/ForecastServlet"
			method="post">
			<input type="hidden" name="requestFrom" value="AddForecast">
			<input type="hidden" name="projectId"
				value="<%=request.getParameter("projectId")%>">
			<div>
				<table align="center" cellpadding="10">
					<tr>
						<td>Forecast Name <FONT COLOR="red">*</FONT>
						</td>
						<td><input type="text" name="forecast-name"
							id="forecast-name"></td>
					</tr>
					<tr>
						<td>Select Year <FONT COLOR="red">*</FONT>
						</td>
						<td><select name="forecast-year" id="forecast-year">
								<option>2013</option>
								<option>2014</option>
								<option>2015</option>
						</select></td>
					</tr>
					<tr>
						<td>ForeCast for Month <FONT COLOR="red">*</FONT>
						</td>
						<td><select name="forecast-month" id="forecast-month">
								<option value="1">JANUARY</option>
								<option value="2">FEBRUARY</option>
								<option value="3">MARCH</option>
								<option value="4">APRIL</option>
								<option value="5">MAY</option>
								<option value="6">JUNE</option>
								<option value="7">JULY</option>
								<option value="8">AUGUST</option>
								<option value="9">SEPTEMBER</option>
								<option value="10">OCTOBER</option>
								<option value="11">NOVEMBER</option>
								<option value="12">DECEMBER</option>
						</select></td>
					</tr>
					<tr align="center" class="quarter-row quarter-row-common">
						<td>JANUARY</td>
						<td>FEBRUARY</td>
						<td>MARCH</td>
					<tr>
					<tr align="center" class="quarter-row quarter-row-common">
						<td><input name="1" id="1" type="text" size="10"></td>
						<td><input name="2" id="2" type="text" size="10"></td>
						<td><input name="3" id="3" type="text" size="10"></td>
					<tr>
					<tr></tr>
					<tr align="center" class="quarter-row-common">
						<td>APRIL</td>
						<td>MAY</td>
						<td>JUNE</td>
					<tr>
					<tr align="center" class="quarter-row-common">
						<td><input name="4" id="4" type="text" size="10"></td>
						<td><input name="5" id="5" type="text" size="10"></td>
						<td><input name="6" id="6" type="text" size="10"></td>
					<tr>
					<tr></tr>
					<tr align="center" class="quarter-row-common">
						<td>JULY</td>
						<td>AUGUST</td>
						<td>SEPTEMBER</td>
					<tr>
					<tr align="center" class="quarter-row-common">
						<td><input name="7" id="7" type="text" size="10"></td>
						<td><input name="8" id="8" type="text" size="10"></td>
						<td><input name="9" id="9" type="text" size="10"></td>
					<tr>
					<tr></tr>
					<tr align="center" class="quarter-row-common">
						<td>OCTOBER</td>
						<td>NOVEMBER</td>
						<td>DECEMBER</td>
					<tr>
					<tr align="center" class="quarter-row-common">
						<td id="monthly-td"><input name="10" id="10" type="text"
							size="10"></td>
						<td><input name="11" id="11" type="text" size="10"></td>
						<td><input name="12" id="12" type="text" size="10"></td>
					<tr>
					<tr align="center">
						<td colspan="3"><input class="sitewide-button"
							id="forecast-submit" type="submit" value="Submit" onclick="return validateForecast(this)" /> <input
							class="sitewide-button" id="forecast-reset" type="reset"
							value="Reset" /></td>
					</tr>
					<tr>
						<td colspan="3"><FONT COLOR="red">Note : </FONT>Please enter value of at least one month.</td>
					</tr>
				</table>
				<div></div>
		</form>
	</div>
	<jsp:include page="Footer.html"></jsp:include>
</body>
</html>