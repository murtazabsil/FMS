<HTML>

<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*" %>

<%@ page session="true" %>
<%String UserID=(String)session.getAttribute("UserID");%>
		
<head>
	<script LANGUAGE="Javascript" SRC="../Images/validate.js"></script>
	<script LANGUAGE="Javascript" SRC="../Images/AjaxCall.js"></script>
<head>
<body Class='SC'>
<jsp:include page="AdminMenu.jsp"></jsp:include>
<Form name =UserProfile>
	<!--	<fieldset style="padding: 3; width=15;height=200">
 <legend><FONT COLOR="#800040" Face='verdana' size='2'><B>Admin Home</B></FONT></Legend> 

	<TABLE align='Left' >
		<tr><TD><A HREF="Admin?action=viewproject" target="ResFrame"><FONT COLOR="#028BDC" Face='verdana' size='2'><B>View Project</B></FONT></A></TD>
                </tr><td></td><td></td>
		<tr><TD><A HREF="Admin?action=viewpm" target="ResFrame"><FONT COLOR="#028BDC" Face='verdana' size='2'><B>View PM Profile</B></FONT></A></TD>
                </tr><td></td><td></td>
				<tr><TD><A HREF="ApproveMembers.jsp" target="ResFrame"><FONT COLOR="#028BDC" Face='verdana' size='2'><B>Associate</B></FONT></A></TD>
                </tr><td></td><td></td>
-->
	<!--	<tr><TD><A HREF="UserBookings0.jsp" target="ResFrame"><FONT COLOR="#028BDC" Face='verdana' size='2'><B>UserBookings</B></FONT></A></TD>
                </tr><td></td><td></td>
		<tr><TD><A HREF="SendInvite0.jsp" target="ResFrame"><FONT COLOR="#028BDC" Face='verdana' size='2'><B>Invite a Guest</B></FONT></A></TD>
                </tr><td></td><td></td> -->
                	<!--
<tr><TD><A HREF="Register0.jsp" target="ResFrame"><FONT COLOR="#028BDC" Face='verdana' size='2'><B>Add User</B></FONT></A></TD>
                </tr><td></td><td></td>

		<tr><TD><A HREF="ChangePassword1.jsp" target="ResFrame"><FONT COLOR="#028BDC" Face='verdana' size='2'><B>Reset Password</B></FONT></A></TD>		
		</tr><br><td></td><td></td>
		<tr><TD><A HREF="Logout.jsp" target="BodyFrame"><FONT COLOR="#028BDC" Face='verdana' size='2'><B>Change User Password</B></FONT></A></TD>
                </tr><td></td><td></td>
                
                <ul>
		
		
		<li class="subfirst"><a HREF="Admin?action=viewproject" target="ResFrame" style="width:150px;height:19px;line-height:19px;">Project</a></li> 
		<li ><a  HREF="Admin?action=viewpm" target="ResFrame" style="width:150px;height:19px;line-height:19px;">PM Profile</a></li>
		
	</ul>
	
	
	-->
	
		<ul id="css3menu1" class="topmenu">
	<li class="topmenu"><a  target="BodyFrame" style="width:150px;height:19px;line-height:19px;"><span>View</span></a>
	<ul>
		<li class="subfirst"><a HREF="Admin?action=viewproject" target="ResFrame" style="width:100px;height:19px;line-height:19px;">Project</a></li> 
		<li ><a  HREF="Admin?action=viewpm" target="ResFrame" style="width:100px;height:19px;line-height:19px;">PM Profile</a></li>
		
	</ul></li>	
		
	<!--<li class="topfirst"><a HREF="Admin?action=viewproject" target="ResFrame" style="width:150px;height:19px;line-height:19px;">View Project</a></li>
	<li class="topmenu"><a  HREF="Admin?action=viewpm" target="ResFrame" style="width:150px;height:19px;line-height:19px;">View PM Profile</a></li> 
	<li class="topmenu"><a HREF="ApproveMembers.jsp" target="ResFrame" style="width:150px;height:19px;line-height:19px;">Associate</a></li> -->
	<li class="topmenu"><a HREF="Register0.jsp" target="ResFrame" style="width:150px;height:19px;line-height:19px;"><span>Add User</span></a></li>
	<li class="topmenu"><a HREF="ChangePassword1.jsp" target="ResFrame" style="width:150px;height:19px;line-height:19px;"><span>Reset Password</span></a></li>
<!-- 	<li class="topmenu"><a HREF="Logout.jsp" target="BodyFrame" style="width:150px;height:19px;line-height:19px;"><span>Change User Password</span></a>
	<ul>
		<li class="subfirst"><a href="#">Item 1 0</a></li> 
		<li><a href="#">Item 1 1</a></li>
		<li><a href="#">Item 1 2</a></li>
	</ul></li>  -->
	<li class="topmenu"><a HREF="Admin?action=add" target="ResFrame" style="width:150px;height:19px;line-height:19px;"><span>Add</span></a>
<ul>
		<li class="subfirst"><a HREF="Admin?action=add&viewmodule=1" target="ResFrame" style="width:100px;height:19px;line-height:19px;">Project</a></li> 
		<li ><a  HREF="Admin?action=add&viewmodule=2" target="ResFrame" style="width:100px;height:19px;line-height:19px;">Manager</a></li>
		<li ><a  HREF="Admin?action=add&viewmodule=3" target="ResFrame" style="width:100px;height:19px;line-height:19px;">LOB</a></li>
		<li ><a  HREF="Admin?action=add&viewmodule=4" target="ResFrame" style="width:100px;height:19px;line-height:19px;">Account</a></li>
			<li ><a  HREF="Register0.jsp" target="ResFrame" style="width:100px;height:19px;line-height:19px;">User</a></li>
	</ul></li>	



	<li class="topmenu"><a HREF="Admin?action=edit" target="ResFrame" style="width:150px;height:19px;line-height:19px;"><span>Edit</span></a>
		<ul>
		<li class="subfirst"><a HREF="Admin?action=edit&viewmodule=1" target="ResFrame" style="width:100px;height:19px;line-height:19px;">Project</a></li> 
		<li ><a  HREF="Admin?action=edit&viewmodule=2" target="ResFrame" style="width:100px;height:19px;line-height:19px;">Manager</a></li>
		<li ><a  HREF="Admin?action=edit&viewmodule=3" target="ResFrame" style="width:100px;height:19px;line-height:19px;">LOB</a></li>
		<li ><a  HREF="Admin?action=edit&viewmodule=4" target="ResFrame" style="width:100px;height:19px;line-height:19px;">Account</a></li>
			<li ><a  HREF="Admin?action=edit&viewmodule=5"  target="ResFrame" style="width:100px;height:19px;line-height:19px;">User</a></li>
	</ul>
	</li>
	<li class="topmenu"><a HREF="Admin?action=delete" target="ResFrame" style="width:150px;height:19px;line-height:19px;"><span>Delete</span></a></li>
	<li class="topmenu"><a HREF="Admin?action=edit" target="ResFrame" style="width:150px;height:19px;line-height:19px;"><span>Currency Exchange</span></a>
		<ul>
		<li class="topmenu"><a href="Admin?action=exchange&exmodule=1"  target="ResFrame" style="width:150px;height:19px;line-height:19px;"><span>Exchange Rate</span></a></li>
	<li class="topmenu"><a href="Admin?action=exchange&exmodule=2"  target="ResFrame" style="width:150px;height:19px;line-height:19px;"><span>Load Currency Rate</span></a></li>
	
	</ul>
	</li> 
</ul>
</li>
<!-- 	</fieldSet>  -->
	</TABLE>
	

</Form>

<jsp:include page="Welcome.jsp"></jsp:include>
<jsp:include page="Footer.html"></jsp:include>
</BODY>
</HTML>
