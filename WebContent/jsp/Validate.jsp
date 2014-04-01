<%@ page language="java"%>
<%@ page session="true"%>
<%@ page import="java.sql.*,com.bluestar.fms.vo.*"%>
<%@ page isErrorPage="false"%>

<%
	Integer memberType = null;
%>

<HEAD>


<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>
<LINK href="css/styles.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY class="Sess">
	<%
		AuthorizeVO authorizeVO = (AuthorizeVO) request
				.getAttribute("authorize");
		Integer result = authorizeVO.getResult();
		if (result > 0) {
			String userId = authorizeVO.getUserVO().getRegID().toString();

			String auth = authorizeVO.getUserVO().getUserType().toString();
			memberType = authorizeVO.getUserVO().getUserType().intValue();

			Integer appStr = authorizeVO.getUserVO().getApprove();

			System.out.println("auth 1" + auth);
			session.setAttribute("userId", userId);
			session.setAttribute("auth", new Integer(auth));
			System.out.println("auth 2" + auth);
			if (auth != null) {
	%>
	<jsp:forward page="AdminMenu.jsp" />
	<%
		}
		} else {
	%>
	<jsp:forward page="Login.jsp">
		<jsp:param name="ErrCode" value="1" />
	</jsp:forward>
	<%
		}
	%>
</BODY>
