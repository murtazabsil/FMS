<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page language="java"%>
<%@ page session="true"%>
<%@page import="java.sql.*,java.io.*,java.util.Random"%>
<Head>
<meta name="viewport" content="width=device-width, user-scalable=no">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/jquery.dataTables.min.js"></script>
<LINK href="<%=request.getContextPath()%>/mobile/css/styles.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/mobile/style.css"
	type="text/css" />
<style type="text/css">
._css3m {
	display: none
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/menu.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dataTables.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/module.js"></script>
</head>
<body>
	<div id="body-wrapper">
		<Title>Admin Menu</Title>

		<!--Retreiving user id using Session-->

		<%
			String Userid = (String) session.getAttribute("UserID");
		%>

		<%
			Map<String, String> menuAccess = (Map) session
					.getAttribute("menuAccess");
			Iterator iterator = menuAccess.entrySet().iterator();
			String referer = request.getRequestURL().toString();
			boolean testJspAlreadyPresent = false;
			if (referer.indexOf("/jsp") != -1) {
				testJspAlreadyPresent = true;
			}
			if (request.getParameter("UserID") != null) {
				testJspAlreadyPresent = false;
			}
			String newPage = null;
			boolean addJspInLogout = true;
			out.print("<div id='main-menu'>");
			while (iterator.hasNext()) {
				Map.Entry currentMenu = (Map.Entry) iterator.next();
				if (testJspAlreadyPresent
						&& request.getAttribute("Path") == null) {
					newPage = (String) currentMenu.getValue();
					addJspInLogout = false;
				} else {
					newPage = "jsp/" + currentMenu.getValue();
				}
				out.print("<A HREF='" + newPage + "'><span>"
						+ currentMenu.getKey() + "</span></A>");
			}
			if (addJspInLogout) {
				out.print("<A HREF='jsp/Logout.jsp' ><span>Logout</span></A>");
			} else {
				out.print("<A HREF='Logout.jsp' ><span>Logout</span></A>");
			}
		%>
	</div>
</body>
</html>