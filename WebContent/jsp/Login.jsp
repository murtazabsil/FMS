
<%@ page language="java" import="java.util.*,com.bluestar.fms.bso.*,com.bluestar.fms.vo.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>User Login</title>
    
 <!--    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page"> -->
    <script LANGUAGE="Javascript" SRC="Images/validate.js"></script>
    <LINK href="css/styles.css" type="text/css" rel="stylesheet">
    
    <script LANGUAGE="Javascript" SRC="Images/calender.js"></script>
    <script LANGUAGE="Javascript" SRC="scripts/validation.js"></script>
    
    <script LANGUAGE="Javascript">
    function validate()
	{
		
		var frm = document.forms[0];
		
		if(ChkMandatoryField(frm.UserID,'UserID')==false) 
			{
			return false;
			};
		
		if(ChkAlphaField(frm.UserID,'UserID')==false) return false;
		if(ChkMandatoryField(frm.Password,'Password')==false) return false;
		if(ChkAlphaNumericField(frm.Password,'Password')==false) return false;
		
	}
    </script>
  </head>
	<%! String ErrCode="0",LoginCode="A";%>
 	<Body>
	<BR><BR><BR><BR>
	<FORM ACTION="Login" method="POST" onsubmit="return validate()">
	<%
		ErrCode = request.getParameter("ErrCode");
		LoginCode = request.getParameter("LoginCode");	
		if(ErrCode!=null){
			if(ErrCode.equals("1")){
			  %><script>alert("Login failed..please try again");</script><%
			}
		}
		
		LoginBSO loginBSO = new LoginBSOImpl();
		List<UserTypeVO> userTypeVOList = loginBSO.getUserType();
		
	%>
	<fieldset style="padding: 3;width:'40%';" align=center>
	    <legend><FONT COLOR="" Face='verdana' size='2'><B>Login</B></FONT></Legend>
		<TABLE align=center width="40%" class="notepad">
			<TR class="row_title">
			  <TH align="center" colspan=3><FONT SIZE="4" COLOR="#AA2504" face='monotype corsiva'>Login</FONT></TH>
			</TR>
			<TR>
			  <TD align="left"><FONT SIZE="2" COLOR="#AA2504" face='monotype corsiva'>User ID</FONT><FONT COLOR="red">*</FONT></TD>
			  <TD><Input type='text' name='UserID' value='' ></TD></tr>
			  <TR><TD align="left"><FONT SIZE="2" COLOR="#AA2504" face='monotype corsiva'>Password<FONT COLOR="red">*</FONT></TD>
			  <TD><Input type='password' name='Password' value='' ></TD>
			  <TR><TD align="left"><FONT SIZE="2" COLOR="#AA2504" face='monotype corsiva'>Login as<FONT COLOR="red">*</FONT></TD>
			  <TD>
			  <select name="Auth" value='0'> <%
					  for(UserTypeVO userTypeVO : userTypeVOList){
			  %>
			  
			  <option value=<%=userTypeVO.getUserTypeId() %>><%=userTypeVO.getUserType() %></option>
			 
			  <%
			  }%>
			  </select>
			  
			  </TD>
			  <TD><INPUT TYPE="submit" value='Go'></TD></TR>
		</TABLE>
	</fieldset>
	<BR><BR>
<!-- 	<fieldset style="padding: 3;width:'40%'"  align=center>
	   <legend><FONT COLOR="" Face='verdana' size='2'><B>Register</B></FONT></Legend>
		<P align=center><FONT SIZE="4" COLOR="#AA2504" face='monotype corsiva'>If you are not a registered user <Font COLOR="#AE0000"><B>Register Now</B></Font> its free</FONT></P>
		<Table align=center width='40%'>
		 <TR align=center>
		  <TD>
		   <A HREF="Register0.jsp" target="BodyFrame"><IMG SRC="Images/RegisterNow.jpg" WIDTH="137" HEIGHT="29" BORDER="0" ALT=""></A>
		  </TD>
		 </TR>
		</Table>

	</fieldset> -->
</FORM>
</BODY>
</html>
