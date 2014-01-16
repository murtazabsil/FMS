
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

<Title>Guest Menu</Title>
<font face="Times New ROman" color=blue >
<center>




<!--Retreiving user id using Session-->

<%  System.out.println("in guestmenu.jsp 2");
String Userid=(String)session.getAttribute("UserID");

System.out.println("in guestmenu.jsp Userid"+Userid);%>

	<TABLE align=right>
	<TR>
		<TD><A HREF="GuestHome.jsp" target="RFrame"><img border="0" name="Home" src="Images/Home0.jpg" onmouseover="document['Home'].src='Images/Home01.jpg'" onmouseout="document['Home'].src='Images/Home0.jpg'" ></A></TD>
		
		<TD><A HREF="Accommodation0.jsp" target="RFrame"><img border="0" name="Accommodation" src="Images/Accommodation0.jpg" onmouseover="document['Accommodation'].src='Images/Accommodation1.jpg'" onmouseout="document['Accommodation'].src='Images/Accommodation0.jpg'" ></A></TD>
		
		<TD><A HREF="Resorts0.jsp" target="RFrame"><img border="0" name="Resorts" src="Images/ViewResorts1.jpg" onmouseover="document['Resorts'].src='Images/ViewResorts0.jpg'" onmouseout="document['Resorts'].src='Images/ViewResorts1.jpg'" ></A></TD>

		<TD><A HREF="ReserveRooms0.jsp" target="RFrame"><img border="0" name="AddRooms" src="Images/AddRooms0.jpg" onmouseover="document['AddRooms'].src='Images/AddRooms01.jpg'" onmouseout="document['AddRooms'].src='Images/AddRooms0.jpg'" ></A></TD>
		
		<TD><A HREF="MemberReviews0.jsp" target="RFrame"><img border="0" name="MemberReviews" src="Images/MemberReviews0.jpg" onmouseover="document['MemberReviews'].src='Images/MemberReviews01.jpg'" onmouseout="document['MemberReviews'].src='Images/MemberReviews0.jpg'" ></A></TD>

		<TD><A HREF="Logout.jsp" target="BodyFrame"><img border="0" name="Logout" src="Images/Logout0.jpg" onmouseover="document['Logout'].src='Images/Logout1.jpg'" onmouseout="document['Logout'].src='Images/Logout0.jpg'" ></A></TD>

	<td></td>	
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

<jsp:include page="Welcome.jsp"></jsp:include>
</body>
</html>