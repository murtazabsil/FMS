<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,java.util.Random,com.bluestar.fms.vo.*;"%>

<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


	<LINK href="css/styles.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY class='SC'>
<%! String moduleName = "";
String message = "";
boolean flag = true;%>
<table align=center class="notepad">

			
			<%
			ResponseVO responseVO = (ResponseVO)request.getAttribute("response");
			int rCount=responseVO.getResult();	
			if(rCount > 0){
		%>
			
			
			<P align=center><h4 align=center>
			<% if(responseVO.getModule() != null){ 
				 moduleName = responseVO.getModule().toUpperCase(); 
				 if(moduleName.equals("project"))
				 {
					 message = " Please click on Link button to assign it to Project Manager";
					 flag = false;
				 }else if(moduleName.equals("manager")){
					 message = " Please click on Link button to assign Project";
					 flag = false;
				 }
		} else{
			moduleName = "";
		}%>
			<B><%= moduleName %> Added Successfully</B><br><br><br>
		<%	if(!flag){ %>
		 <input type="button" value="Link"></input>
		 
			 <h4>
			 <%=message %>
			  </h4> 
			<% }  %>
			

		<%							
		}	
		else{%><P align=center><h6 align=center>Error occured while adding, Please try again later</h6><% }
			
			%>
			<INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;">
</table>
</BODY>
