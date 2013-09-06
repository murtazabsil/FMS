
<html>
<%@ page language="java" %>
<%@ page session="true" %>
<%@page import="java.sql.*,java.io.*,java.util.Random"%>
<SCRIPT LANGUAGE="JavaScript">
<!--
history.go(+1);

//-->
</SCRIPT>
<Head>
	<LINK href="css/styles.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="css3menu1/style.css" type="text/css" /><style type="text/css">._css3m{display:none}</style>
</head>
<body Class='SC'>

<Title>Admin Menu</Title>
<font face="Times New ROman" color=blue >
<center>




<!--Retreiving user id using Session-->

<% String Userid=(String)session.getAttribute("UserID");%>

	<TABLE align='right'>
	<TR>
		<TD><A HREF="AdminHome.jsp" target="RFrame"><input type="button" class="buttonstyle" value="Home&nbsp;"></A></TD>
		
		<TD><A HREF="AddAccommodation0.jsp" target="RFrame"><input type="button" class="buttonstyle" value="Project&nbsp;"></A></TD>
		
		<TD><A HREF="AddResorts0.jsp" target="RFrame"><input type="button" class="buttonstyle" value="Manager&nbsp;"></A></TD>

		<TD><A HREF="AddRooms0.jsp" target="RFrame"><input type="button" class="buttonstyle" value="Account&nbsp;"></A></TD>
		
		<TD><A HREF="MemberReviews0.jsp" target="RFrame"><input type="button" class="buttonstyle" value="Lob&nbsp;"></A></TD>
		
		<TD><A HREF="MemberReviews0.jsp" target="RFrame"><input type="button" class="buttonstyle" value="User&nbsp;"></A></TD>

		<TD><A HREF="Logout.jsp" target="BodyFrame"><input type="button" class="buttonstyle" value="Logout&nbsp;"></A></TD>

		<TD></td>
		
</TR> 
<!-- 
<tr><td colspan='7' >
<ul id="topmenu1" class="topmenu">
	<li class="topfirst"><a target="RFrame" href="AdminHome.jsp"  style="height:18px;line-height:18px;">&nbsp;&nbsp;Home&nbsp;&nbsp;&nbsp;</a></li>
	<li class="topfirst"><a target="RFrame" href="AddAccommodation0.jsp" style="height:18px;line-height:18px;">&nbsp;&nbsp;Project&nbsp;&nbsp;&nbsp;</a></li>
	<li class="topmenu"><a target="RFrame" href="AddResorts0.jsp"  style="height:18px;line-height:18px;"><span>&nbsp;&nbsp;Manager&nbsp;&nbsp;&nbsp;</span></a>
	<ul>
		<li><a href="#">Item 1 0</a></li>
		<li><a href="#">Item 1 1</a></li>
		<li><a href="#">Item 1 2</a></li>
	</ul></li>

	<li class="toplast"><a  target="RFrame"  href="AddRooms0.jsp" style="height:18px;line-height:18px;">&nbsp;&nbsp;Account&nbsp;&nbsp;&nbsp;</a></li>
	<li class="toplast"><a  target="RFrame" href="MemberReviews0.jsp" style="height:18px;line-height:18px;">&nbsp;&nbsp;Lob&nbsp;&nbsp;&nbsp;</a></li>
	<li class="toplast"><a  target="RFrame" href="MemberReviews0.jsp" style="height:18px;line-height:18px;">&nbsp;&nbsp;User&nbsp;&nbsp;&nbsp;</a></li>
	<li class="toplast"><a  target="BodyFrame" href="Logout.jsp" style="height:18px;line-height:18px;">&nbsp;&nbsp;Logout&nbsp;&nbsp;&nbsp;</a></li>
</ul>

</td></tr> -->
</table>

</center>
</font>
</body>
</html>