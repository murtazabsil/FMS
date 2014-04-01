<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<%@ page
	import="java.lang.*,com.bluestar.fms.vo.*,com.bluestar.fms.bso.*,java.util.*"%>
<%
	String UserID = "";
%>

<HTML>
<head>
<title>Add New User</title>
<LINK href="css/styles.css" type="text/css" rel="stylesheet">
<script LANGUAGE="Javascript" SRC="<%=request.getContextPath() %>/Images/validate.js"></script>
<jsp:include page="AdminMenu.jsp"></jsp:include>
<BODY Class="SC">
	<%
		LoginBSO loginBSO = new LoginBSOImpl();
		List<UserTypeVO> listUserType = loginBSO.getUserType();

		UserVO userVO = (UserVO) request.getAttribute("detail");
		String event = (String) request.getAttribute("event");
		System.out.println(" event  in user edit jsp------------" + event);
		String designation = "";
		List<String> designationList = new ArrayList<String>();
		designationList.add("4|LOB Head");
		designationList.add("3|Account Head");
		designationList.add("2|Project Manager");

		if (event == null) {
	%>

	<div id="page-title">
		<h2>Add New User</h2>
	</div>
	<%
		} else {
	%>
	<div id="page-title">
		<h2>Edit User Details</h2>
	</div>
	<%
		}
	%>
	<FORM NAME="RegUser" ACTION="<%=request.getContextPath()%>/Admin"
		onsubmit="return validate();" method="post">
		<input type='hidden' id='event' name='event' value='<%=event%>'>
		<input type="hidden" name="action" value="add"> <input
			type="hidden" name="module" value="user">
		<TABLE width="60%" align="center">
			<TR class=row_even>
				<TH align="left">First Name <FONT COLOR="red">*</TH>
				<TD class=row_odd>&nbsp;&nbsp;<Input type="text"
					name='FirstName'
					value='<%=userVO != null && userVO.getFirstName() != null ? userVO
					.getFirstName() : ""%>'>
			</TR>

			<TR class=row_even>
				<TH align="left">Last Name</TH>
				<TD class=row_odd>&nbsp;&nbsp;<Input type="text"
					name='LastName'
					value='<%=userVO != null && userVO.getLastName() != null ? userVO
					.getLastName() : ""%>'>
			</TR>

			<TR class=row_even>
				<TH align="left">Employee Id</TH>
				<TD class=row_odd>&nbsp;&nbsp;<Input type="text" name='EmpId'
					value='<%=userVO != null && userVO.getEmpId() != null ? userVO
					.getEmpId() : ""%>'>
			</TR>
			<TR class=row_even>
				<TH align="left">Email Address <FONT COLOR="red">*</TH>
				<TD class=row_odd>&nbsp;&nbsp;<Input type="text"
					name='EmailAddress'
					value='<%=userVO != null && userVO.getEmailAddress() != null ? userVO
					.getEmailAddress() : ""%>'>
			</TR>


			<TR class=row_even>
				<TH align="left">Designation <FONT COLOR="red">*</TH>
				<TD class=row_odd>&nbsp;&nbsp;<SELECT id="designation"
					name='designation'>
						<OPTION Value="">Select</OPTION>
						<%
							for (String str : designationList) {

								if (str.substring(0, str.lastIndexOf("|")).equals(userVO != null ? userVO.getDesignation().toString() : "")) {
						%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
							selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
						<%
							} else
						%>

						<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
						<%
							}
						%>

				</SELECT>
				</TD>
			</TR>

			<TR class=row_even>
				<TH align="left">Address <FONT COLOR="red">*</FONT></TH>
				<TD class=row_odd>&nbsp;&nbsp;<textarea name="Address"><%=userVO != null && userVO.getAddress() != null ? userVO
					.getAddress() : ""%></textarea>
			</TR>
			<TR class=row_even>
				<TH align="left">Contact Number <FONT COLOR="red">*</TH>
				<TD class=row_odd>&nbsp;&nbsp;<Input type="text"
					name='ContactNumber'
					value='<%=userVO != null && userVO.getContactNumber() != null ? userVO
					.getContactNumber() : ""%>'>
			</TR>

			<%
				if (event == null) {
			%>
			<TR class=row_even>
				<TH align="left">Choose User Name <FONT COLOR="red">*</TH>
				<TD class=row_odd>&nbsp;&nbsp;<Input type=text name='UserID'
					value='' onchange='fnCallChkAvailability(this)'>
					<div id='nameid'></div>
				</TD>
			</TR>
			<%
				} else {
			%>
			<%-- <input type="hidden" name='loginvo' id='loginvo'
				value='<%=userVO.getLoginVO()%>'> --%>
			<input type="hidden" name='regid' id='regid'
				value='<%=userVO.getRegID()%>'>
			<input type="hidden" name='uidhid' id='uidhid'
				value='<%=userVO.getUserName()%>'>
			<%
				}
			%>
			<TR class=row_even>
				<TH align="left">Password <FONT COLOR="red">*</TH>
				<TD class=row_odd>&nbsp;&nbsp;<Input type='password'
					name='upassword' value=<%=userVO != null ? userVO.getPassword() : ""%>>
			</TR>

			<TR class=row_even>
				<TH align="left">ReType Password <FONT COLOR="red">*</TH>
				<TD class=row_odd>&nbsp;&nbsp;<Input type='password'
					name='retypepassword' value=<%=userVO != null ? userVO.getPassword() : ""%>>
			</TR>
			<TR class="row_even">
				<TH align="left">User Type</TH>
				<TD class="row_odd">&nbsp;&nbsp;<SELECT id="userType"
					name='userType'>
						<OPTION Value="">Select</OPTION>

						<%
							try {

								for (UserTypeVO userTypeVO : listUserType) {
									if (userVO != null
											&& userTypeVO.getUserTypeId() == userVO
													.getUserType().intValue()) {
						%><OPTION Value=<%=userTypeVO.getUserTypeId()%>
							selected="selected"><%=userTypeVO.getUserType()%></OPTION>
						<%
							} else {
						%><OPTION Value=<%=userTypeVO.getUserTypeId()%>><%=userTypeVO.getUserType()%></OPTION>
						<%
							}
								}
							} catch (Exception e) {
						%><%=e%>
						<%
							}
						%>
						<TR>
							<TH><INPUT class="sitewide-button" TYPE="submit"
								value='Submit' onClick="return validateUser(this)"></TH>
							<TH><INPUT class="sitewide-button" TYPE="reset"
								value='Clear'></TH>
						</TR>
		</TABLE>
		<input type='hidden' name="addmodule" id="addmodule">
	</FORM>
</BODY>
<jsp:include page="Footer.html"></jsp:include>
</HEAD>
</HTML>