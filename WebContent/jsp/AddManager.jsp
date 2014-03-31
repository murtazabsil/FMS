<%@ page language="java"%>
<%@ page session="true"%>
<%@page import="java.util.*"%>
<%@page import="com.bluestar.fms.bso.AdminBSOImpl"%>
<%@page import="com.bluestar.fms.bso.AdminBSO"%>
<%@page import="com.bluestar.fms.util.PrintStackTraceLogger"%>
<%@ page import="java.sql.*,java.io.*,com.eResorts.MyFunctions"%>
<%			String Condition = "LocationName";
%>

<HTML>
<HEAD>
<TITLE>Add New Manager</TITLE>
<LINK href="css/styles.css" type="text/css" rel="stylesheet">
<SCRIPT LANGUAGE="JavaScript">
<!--
	function validate() {
		var frm = document.forms(0);
		var LocationName = frm.LocationName.value;
		if (LocationName != "") {
			return true;
		} else {
			alert("Please select Location Name to proceed");
			return false;
		}
	}
//-->
</SCRIPT>
</HEAD>
<jsp:include page="AdminMenu.jsp"></jsp:include>
<%
	Map<String, List<String>> dropDownListMap = new HashMap<String, List<String>>();
	AdminBSO adminBSO = new AdminBSOImpl();
	try {
		dropDownListMap.putAll(adminBSO.initializeDropDown());
		dropDownListMap.putAll(adminBSO.initializeModuleDropDown());
		request.setAttribute("dropDownListMap", dropDownListMap);
		String error = (String) request.getAttribute("error");
	} catch (Exception exception) {
		PrintStackTraceLogger.getStackTrace(exception);
	}
%>
<BODY Class='SC'>
	<div id="page-title">
		<h2>Add New Manager</h2>
	</div>
	<div style="color: red; margin-left: 115px;">
		<c:out value="${error}"></c:out>
	</div>
	<form action="<%=request.getContextPath()%>/Admin" method="post">
		<div id="pmdiv">
			<input type="hidden" name="action" value="add">
			<input type="hidden" name="module" value="manager">
			<TABLE id="pm" width="30%" class="notepad" align="center">
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Name</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name="pmName"
						value='' maxlength="64"> </Input></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Employee Id</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name="pmEmpId"
						value='' maxlength="10"> </Input></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Department</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="pmdepartment"
						NAME="pmdepartment">
							<OPTION Value="">Select</OPTION>
							<OPTION Value="1">Product Development-Java</OPTION>
							<OPTION Value="2">Testing</OPTION>
							<OPTION Value="3">Product Development-.NET</OPTION>
							<OPTION Value="4">SAAS</OPTION>

					</SELECT></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>LOB</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="pmlob" NAME="pmlob">
							<OPTION Value="">Select</OPTION>
							<%
								try {
									List<String> list = dropDownListMap.get("lobList");

									for (String str : list) {
							%>
							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>

							<%
								}
								} catch (Exception e) {
									PrintStackTraceLogger.getStackTrace(e);
								}
							%>
							<!-- 							<OPTION Value="">BAP</OPTION> -->
							<!-- 							<OPTION Value="">PES</OPTION> -->
							<!-- 							<OPTION Value="">HR</OPTION> -->
					</SELECT></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Account</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="pmaccount"
						NAME="pmaccount">
							<OPTION Value="">Select</OPTION>
							<%
								try {
									List<String> list = dropDownListMap.get("accountList");

									for (String str : list) {
							%>
							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
								} catch (Exception e) {
									PrintStackTraceLogger.getStackTrace(e);
								}
							%>
							<!-- 							<OPTION Value="">TRISEPT</OPTION> -->
							<!-- 							<OPTION Value="">LPS</OPTION> -->
							<!-- 							<OPTION Value="">BLUESTAR</OPTION> -->
					</SELECT></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Location</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="pmlocation"
						NAME="pmlocation">
							<OPTION Value="">Select</OPTION>
							<%
								try {
									List<String> list = dropDownListMap.get("locationList");

									for (String str : list) {
							%>
							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
								} catch (Exception e) {
									PrintStackTraceLogger.getStackTrace(e);
								}
							%>
							<!-- 							<OPTION Value="">INDIA</OPTION> -->
							<!-- 							<OPTION Value="">USA</OPTION> -->
							<!-- 							<OPTION Value="">UK</OPTION> -->
					</SELECT></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Trade Currency</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="pmcurrency"
						NAME="pmcurrency">
							<OPTION Value="">Select</OPTION>
							<%
								try {
									List<String> list = dropDownListMap.get("currencyList");

									for (String str : list) {
							%>
							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
								} catch (Exception e) {
									PrintStackTraceLogger.getStackTrace(e);
								}
							%>
							<!-- 							<OPTION Value="">INR</OPTION> -->
							<!-- 							<OPTION Value="">USD</OPTION> -->
							<!-- 							<OPTION Value="">GBP</OPTION> -->
					</SELECT></TD>
				</tr>

				<tr class=row_odd>
					<TD align="left" valign='top'><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Comments<FONT COLOR="red">*</FONT></TD>
					<TD colspan='2' align='left'><textarea name='pmdesc' ROWS="5"
							COLS="50" value=''></textarea>
						</textarea></TD>

				</tr>


				<tr class=row_odd>
					<TH colspan='1'><INPUT class="sitewide-button" TYPE="submit"
						id="manager" onClick="return validate(this);" value='Add'></TH>
					<TH colspan='2'><INPUT class="sitewide-button" TYPE="reset"
						value='Clear'></TH>
				</TR>
			</TABLE>
		</div>
	</form>
</BODY>
<jsp:include page="Footer.html"></jsp:include>
</HTML>
