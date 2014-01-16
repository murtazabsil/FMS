<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no">
</head>
<body>
<div>Add Forecast</div>
<form action="/ForecastServlet" method="post"></form>
<input type="hidden" name="requestFrom" value="AddForecast">
<div>
<span>Forecast Type :</span>
<span>
<select>
<option>Monthly</option>
<option>Quarterly</option>
<option>Yearly</option>
</select></span>
</div>
<div>
<span>Select Year :</span>
<span>
<select>
<option>2013</option>
<option>2014</option>
<option>2015</option>
</select></span>
</div>
<div>
<table>
<tr class="quarter-row quarter-row-common">
<td class="monthly-td">JAN</td>
<td>FEB</td>
<td>MAR</td>
<tr>
<tr class="quarter-row quarter-row-common">
<td class="monthly-td"><input type="text" size="10"></td>
<td><input type="text" size="10"></td>
<td><input type="text" size="10"></td>
<tr>
<tr></tr>
<tr class="quarter-row-common">
<td class="monthly-td">APRIL</td>
<td>MAY</td>
<td>JUNE</td>
<tr>
<tr class="quarter-row-common">
<td id="monthly-td"><input type="text" size="10"></td>
<td><input type="text" size="10"></td>
<td><input type="text" size="10"></td>
<tr>
<tr></tr>
<tr class="quarter-row-common">
<td class="monthly-td">JULY</td>
<td>AUG</td>
<td>SEP</td>
<tr>
<tr class="quarter-row-common">
<td id="monthly-td"><input type="text" size="10"></td>
<td><input type="text" size="10"></td>
<td><input type="text" size="10"></td>
<tr>
<tr></tr>
<tr class="quarter-row-common">
<td class="monthly-td">OCT</td>
<td>NOV</td>
<td>DEC</td>
<tr>
<tr class="quarter-row-common">
<td id="monthly-td"><input type="text" size="10"></td>
<td><input type="text" size="10"></td>
<td><input type="text" size="10"></td>
<tr>
</table>
</div>
</table>
</body>
</html>