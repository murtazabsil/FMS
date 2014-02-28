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
			if (auth != null && auth.equals("3")) {

				if (memberType != null && memberType == 2) {
					System.out.println("auth" + auth);
	%>
	<jsp:forward page="BlockUser.jsp" />
	<%
		}
				if (appStr == 0) {
					System.out.println("app==0");
	%>
	<jsp:forward page="reqprocess.jsp" />
	<%
		}
				if (appStr == -1) {
					System.out.println("app==-1");
	%>
	<jsp:forward page="reqreject.jsp" />
	<%
		}
	%>
	<jsp:forward page="GuestMenu.jsp" />
	<%
		} else if (auth.equals("1")) {
				//Show Admin Menu
	%>
	<jsp:forward page="AdminMenu.jsp" />
	<%
		} else if (auth.equals("2")) {
				//Show Admin Menu
	%>
	<jsp:forward page="AdminMenu.jsp" />
	<%
		} else {
	%>
	<jsp:forward page="Login.jsp">
		<jsp:param name="ErrCode" value="1" />
	</jsp:forward>
	<%
		}
		}
	%>
</BODY>
