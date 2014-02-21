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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/dataTables.css">
<LINK href="<%=request.getContextPath()%>/css/styles.css"
	type="text/css" rel="stylesheet">
<LINK href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<LINK href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css3menu1/style.css"
	type="text/css" />
<style type="text/css">
._css3m {
	display: none
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/menu.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/module.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/bootstrap.min.js"></script>
</head>
<body>
	<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav">
		<div id="body-wrapper" class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target=".bs-navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">FMS</a>
			</div>
			<nav class="bs-navbar-collapse" role="navigation">
				<ul class="nav navbar-nav">
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
						/* out.print("<div id='main-menu'>"); */
						while (iterator.hasNext()) {
							Map.Entry currentMenu = (Map.Entry) iterator.next();
							if (testJspAlreadyPresent
									&& request.getAttribute("Path") == null) {
								newPage = (String) currentMenu.getValue();
								addJspInLogout = false;
							} else {
								newPage = "jsp/" + currentMenu.getValue();
							}
							out.print("<li><A HREF='" + newPage + "'>"
									+ currentMenu.getKey() + "</A></li>");
						}
						if (addJspInLogout) {
							out.print("<li><A HREF='jsp/Logout.jsp' >Logout</A></li>");
						} else {
							out.print("<li><A HREF='Logout.jsp' >Logout</A></li>");
						}
					%>
				</ul>
		</div>
		</nav>
		</div>
	</header>
</body>
</html>