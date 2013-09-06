
<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,java.util.*,java.util.Random,com.eResorts.MemberReviewsVO,com.eResorts.ReportBean"%>

<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


	<LINK href="css/styles.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY class="SC">
<h4 align=center>Member Reviews</h4>

<%

	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	try{
			
			con = com.eResorts.ConnectionPool.getConnection();
			stmt =  con.createStatement();
			String Query = "Select * from feedback order by `FId`";
			rs = stmt.executeQuery(Query);
			MemberReviewsVO memberReviewsVO = null;
			List<MemberReviewsVO> memberReviewsVOList = new ArrayList<MemberReviewsVO>();
			ReportBean reportBean = new ReportBean();
			%>
						<table align="center" width="60%">
						<tr ><a href="genratePdfReport2.jsp">Click here to generate pdf</a></tr>
							<tr class=row_title>
							<th align="left">FId</th><th align="left">UserID</th><th align="center">Feedback</th><th align="left">Date Of Submittion</th>
							</tr>
					<%
			int rCount=0;
			while(rs.next())
			{
				memberReviewsVO = new MemberReviewsVO(); 
				memberReviewsVO.setDateOfSubmittion(rs.getString(4));
				memberReviewsVO.setFeedback(rs.getString(3));
				memberReviewsVO.setUserID(rs.getString(2));
				memberReviewsVO.setfId(rs.getString(1));
				
				%>
					<tr class= <%=(rCount%2!=0)? "row_even" : "row_odd"%>>
						<td><%=rs.getString(1)%></td>
						<td><%=rs.getString(2)%></td>
						<td><%=rs.getString(3)%></td>
						<td><%=rs.getString(4)%></td>
					</tr>
					<%
				rCount++;
					memberReviewsVOList.add(memberReviewsVO);
			}
			
			
			%><%
			if( rCount == 0)	{%><h3 align=center>Sorry No records Found</h3><% }
			rs.close();
			stmt.close();
			con.close();
			reportBean.setMemberReviewsVOList(memberReviewsVOList);
			session.setAttribute("reportBean", reportBean);
		}catch(Exception e){
			rs.close();
			stmt.close();
			con.close();
			%><%=e%><%
		}
	
%>
</BODY>

</PRE>