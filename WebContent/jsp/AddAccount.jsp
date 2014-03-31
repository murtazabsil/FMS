<%@page import="com.bluestar.fms.vo.UserVO"%>
<%@ page language="java"%>
<%@ page session="true"%>
<%@page import="java.util.*"%>
<%@page import="com.bluestar.fms.bso.AdminBSOImpl"%>
<%@page import="com.bluestar.fms.bso.AdminBSO"%>
<%@page import="com.bluestar.fms.util.PrintStackTraceLogger"%>
<%@ page import="java.sql.*,java.io.*,com.eResorts.MyFunctions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String Condition = "LocationName";
%>

<HTML>
<HEAD>
<TITLE>Add New Account</TITLE>
<LINK href="css/styles.css" type="text/css" rel="stylesheet">
<SCRIPT LANGUAGE="JavaScript">
<!--
	function validate() {
		var frm = document.forms(0);
		var ResortID = frm.ResortID.value;
		if (ResortID != "") {
			return true;
		} else {
			alert("Please select Location Name to proceed");
			return false;
		}
	}
//-->
</SCRIPT>
<title>Add New Account</title>
</HEAD>
<jsp:include page="AdminMenu.jsp"></jsp:include>
<%
	Map<String, List<String>> dropDownListMap = new HashMap<String, List<String>>();
	AdminBSO adminBSO = new AdminBSOImpl();
	List<UserVO> userVOList = null;
	try {
		dropDownListMap.putAll(adminBSO.initializeDropDown());
		dropDownListMap.putAll(adminBSO.initializeModuleDropDown());
		request.setAttribute("dropDownListMap", dropDownListMap);
		userVOList = adminBSO.getUserAccountHeadList();
		request.setAttribute("userVOList", userVOList);
		String error = (String) request.getAttribute("error");
	} catch (Exception exception) {
		PrintStackTraceLogger.getStackTrace(exception);
	}
%>
<BODY Class='SC'>
	<div id="page-title">
		<h2>Add New Account</h2>
	</div>
	<div style="color: red; margin-left: 115px;">
		<c:out value="${error}"></c:out>
	</div>
	<form action="<%=request.getContextPath()%>/Admin" method="post">
		<div id="accountdiv">
			<input type="hidden" name="action" value="add"> <input
				type="hidden" name="module" value="account">
			<TABLE id="account" width="30%" class="notepad" align="center">
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> Name </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name='accountName'
						value='' maxlength='64'></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> LOB </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="accountlob"
						NAME="accountlob">
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
						face='verdana'> Client Name </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name='accountClient'
						value='' maxlength='10'></TD>
				</tr>

				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> Location </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="accountlocation"
						NAME="accountlocation">
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
						face='verdana'> Account Head </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left>
					<% if(userVOList.size() > 0) {%>
					<Select id="accountHead"
						name='accountHead' value="" maxlength='10'>
							<option value="">Select</option>
							<c:forEach items="${userVOList}" var="user">
							<option value="${user.regID}">${user.firstName} ${user.lastName}</option>
							</c:forEach>
					</Select></TD>
					<% } else { %>
						<span style="color: red;">Please create a user with type as Account head to Proceed.</span><br>
						<span>Follow link to create user : </span><a href="AddUser.jsp">Add New User</a>
					<% } %>
				</tr>


				<tr class=row_odd>
					<TD align="left"><FONT SIZE="2" COLOR="#AA2504" face='verdana'>Account
							Description </TD>
					<TD colspan='2' align='left'><textarea
							name='accountDescription' ROWS="5" COLS="50" value=''></textarea></TD>

				</tr>


				<tr class=row_odd>
					<TH colspan=1><INPUT <%if(userVOList.size() == 0){ %> disabled="disabled" <%} %> class="sitewide-button" TYPE="submit"
						id="account" onClick="return validate(this)" value='Add'></TH>
					<TH colspan=2><INPUT class="sitewide-button" TYPE="reset"
						value='Clear'></TH>
				</TR>
			</TABLE>
		</div>
	</form>
</BODY>
<jsp:include page="Footer.html"></jsp:include>
</HTML>
