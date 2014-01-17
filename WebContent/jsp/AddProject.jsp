<%@page import="com.bluestar.fms.bso.AdminBSOImpl"%>
<%@page import="com.bluestar.fms.bso.AdminBSO"%>
<%@page import="com.bluestar.fms.util.PrintStackTraceLogger"%>
<%@page import="java.util.*" %>
<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.lang.*,java.util.Vector,java.util.StringTokenizer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String UserID = (String) session.getAttribute("UserID");
%>
<jsp:include page="AdminMenu.jsp"></jsp:include>
<HTML>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery-ui.css">
<script LANGUAGE="Javascript" SRC="<%=request.getContextPath() %>/scripts/jquery-ui.js"></script>
<script LANGUAGE="Javascript" SRC="<%=request.getContextPath() %>/scripts/datetimepicker.js"></script> 
<script LANGUAGE="Javascript" SRC="../Images/validate.js"></script>
<script LANGUAGE="Javascript" SRC="../Images/AjaxCall.js"></script>

<script LANGUAGE="Javascript" SRC="">
	function ChkMandatoryField(F, T) {
		var val = F.value;
		if (val == "") {
			alert(T + " is mandatory");
			return false;
		}
	}
	function validate() {
		var frm = document.forms(0);
		if (ChkMandatoryField(frm.LocationName, 'Location Name') == false)
			return false;
		if (ChkMandatoryField(frm.LocationImage, 'LocationImage') == false)
			return false;
		if (ChkMandatoryField(frm.LocationDesc, 'Location Description') == false)
			return false;

	}
	function fnUpload() {
		var userid = document.forms(0).userid;
		fnEmpPopUp('UploadPhoto1.jsp?userid=' + userid, 80, 400);
	}
</script>
<title>Add New Project</title>
</head>
<!--  Creating Master Data Map -->
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

<BODY Class="SC">
	<div id="page-title">
		<h2>Add New Project</h2>
	</div>
	<div style="color: red; margin-left: 115px;"><c:out value="${error}"></c:out></div>
	<form action="<%=request.getContextPath() %>/Admin" method="post">
		<div id="projectdiv">
			<input type="hidden" name="action" value="add">
			<input type="hidden" name="module" value="project">
			<TABLE id="project" width="30%" class="notepad" align="center">
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project name </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name='projectName'
						value="" maxlength="64"></TD>
				</tr>

				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project LOB </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="projectLob"
						NAME="projectLob">
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
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Account</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="projectAccount"
						NAME="projectAccount">
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
					</SELECT></TD>
				</TR>

				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Base Currency </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="basecurrency"
						NAME="basecurrency">
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
					</SELECT></TD>
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> Priority </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="priority" NAME="priority">
							<OPTION Value="">Select</OPTION>
							<%
								try {
									List<String> list = dropDownListMap.get("priorityList");
									System.out.println("555 list-----------" + list.toString());
									for (String str : list) {
							%>
							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
								} catch (Exception e) {
									PrintStackTraceLogger.getStackTrace(e);
								}
							%>
					</SELECT></TD>
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project Status </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="projectStatus"
						NAME="projectStatus">
							<OPTION Value="">Select</OPTION>
							<%
								try {
									List<String> list = dropDownListMap.get("statusList");
									for (String str : list) {
							%>
							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
								} catch (Exception e) {
									PrintStackTraceLogger.getStackTrace(e);
								}
							%>
					</SELECT></TD>
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project Type</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="projectType"
						NAME="projectType">
							<OPTION Value="">Select</OPTION>
							<%
								try {
									List<String> list = dropDownListMap.get("typeList");
									for (String str : list) {
							%>
							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
								} catch (Exception e) {
									PrintStackTraceLogger.getStackTrace(e);
								}
							%>
					</SELECT></TD>
				</TR>

				<tr class=row_even>
					<TD align="left" width="40%" style="width: 181px;"><FONT
						SIZE="2" COLOR="#AA2504" face='verdana'>Start Date </FONT><FONT
						COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><p>
							<!--  <input type="text" id="startdatepicker" /> -->
							<input id="startdate" type="text" size="15">
						</p></TD>
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%" style="width: 181px;"><FONT
						SIZE="2" COLOR="#AA2504" face='verdana'>End Date </FONT><FONT
						COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><p>
							<!-- <input type="text" id="enddatepicker" /> -->
							<input id="enddate" type="text" size="15">
						</p></TD>
				</TR>

				<tr class=row_odd>
					<TD align="left" valign="top"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project Description </TD>
					<TD colspan=2 align=left><textarea name='projectDesc'
							ROWS="5
							COLS=" 50" value=""></textarea></TD>

				</tr>


				<tr class=row_odd>
					<TH colspan=1><INPUT class="sitewide-button" TYPE="submit" id="project"
						onClick="return validate(this)" onClick="return validate(this)"
						value='Add'></TH>
					<TH colspan=2><INPUT class="sitewide-button" TYPE="reset" value='Clear'></TH>
				</TR>
			</TABLE>
		</div>
	</form>
</BODY>
<jsp:include page="Footer.html"></jsp:include>
</HTML>