<%@page import="com.bluestar.fms.bso.AdminBSOImpl"%>
<%@page import="com.bluestar.fms.bso.AdminBSO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java"%>
<%@ page session="true"%>
<%@ page
	import="java.sql.*,java.io.*,com.eResorts.MyFunctions,com.bluestar.fms.vo.*,java.util.*;"%>
<%
	String Condition = "MuduleName";
%>

<HTML>
<HEAD>
<LINK href="css/styles.css" type="text/css" rel="stylesheet">
<script LANGUAGE="Javascript"
	SRC="<%=request.getContextPath()%>/Images/validate.js"></script>
<script type="text/javascript">		
function validate(O){
	
		
		var object = O.id;
		alert(" object "+object);
		
		var flag = true;
		
			
			var frm = document.forms[0];
			
			
			if(validateFormFields(frm,object)){
				alert('flag------'+flag);
				submitForm(frm);
			}else{
				return false;
			}
				
			
			
		//	if(ChkAlphaField(frm.UserID,'UserID')==false) return false;
		//	if(ChkMandatoryField(frm.Password,'Password')==false) return false;
		//	if(ChkAlphaNumericField(frm.Password,'Password')==false) return false;
			
		
}

function validateFormFields(frm,object){
//	projectName projectLob projectAccount baselocation basecurrency priority	
	//      projectStatus projectType startdate  enddate projectDesc
	alert(" object "+object);
	if(object != null && object == 'project')
	{
		
		document.getElementById('addmodule').value = "project";
		alert('addmodule---'+document.getElementById('addmodule').value);
			
			if(ChkMandatoryField(frm.projectName,'Project Name')==false) return false;
			if(ChkDropDownField(frm.projectLob,'Lob')==false) 	return false;
			if(ChkDropDownField(frm.projectAccount,'Account')==false) 	return false;
			if(ChkDropDownField(frm.baselocation,'Location')==false) 	return false;
			if(ChkDropDownField(frm.basecurrency,'Currency')==false) 	return false;
			if(ChkDropDownField(frm.priority,'Priority')==false) 	return false;
			if(ChkDropDownField(frm.projectStatus,'Status')==false) 	return false;
			if(ChkDropDownField(frm.projectType,'Type')==false) 	return false;
			if(ChkDateField(frm.startdate,'Start')==false) 	return false;
			if(ChkDateField(frm.enddate,'End')==false) 
				{return false;}
			else{
				return true;
			}
			
		////	alert('before date chewck');
		//	if(DateCheck()==false) 	return false;
		//	alert('after date chewck');
			alert(" end object "+object);
	}
	else if(object != null && object == 'manager')
	{
		document.getElementById('addmodule').value = "manager";
		alert('addmodule---'+document.getElementById('addmodule').value);
		
		// pmName pmEmpId pmdepartment pmlob pmaccount pmlocation pmcurrency
		if(ChkMandatoryField(frm.pmName,'Manager Name')==false) return false;
	//	if(ChkMandatoryField(frm.pmEmpId,'Employee Id')==false) 	return false;
		if(ChkDropDownField(frm.pmdepartment,'Department')==false) 	return false;
		if(ChkDropDownField(frm.pmlob,'Lob')==false) 	return false;
		if(ChkDropDownField(frm.pmaccount,'Account')==false) 	return false;
		//if(ChkDropDownField(frm.priority,'Priority')==false) 	return false;
		if(ChkDropDownField(frm.pmlocation,'Location')==false) 	return false;
		if(ChkDropDownField(frm.pmcurrency,'Currency')==false)		 
		{return false;}
	else{
		return true;
	}
		
		
	}
	else if(object != null && object == 'account')
	{
		document.getElementById('addmodule').value = "account";
		alert('addmodule---'+document.getElementById('addmodule').value);
		
		if(ChkMandatoryField(frm.accountName,'Account Name')==false) return false;
		if(ChkDropDownField(frm.accountlob,'Lob')==false) 	return false;
		if(ChkMandatoryField(frm.accountClient,'Client Name')==false) return false;
		if(ChkDropDownField(frm.accountlocation,'Location')==false) 	return false;
		if(ChkMandatoryField(frm.accountHead,'Account Head')==false) {return false;}
		else{
			return true;
		}
	}
	else if(object != null && object == 'lob')
	{
		document.getElementById('addmodule').value = "lob";
		alert('addmodule---'+document.getElementById('addmodule').value);
		

		if(ChkMandatoryField(frm.lobName,'Lob Name')==false) return false;
		
		if(ChkDropDownField(frm.loblocation,'Location')==false) 	return false;
		if(ChkMandatoryField(frm.lobHead,'Lob Head')==false) {return false;}
		else{
			return true;
		}
	}
	else
	{
		return false;
	}
	
}


function submitForm(F){
	
	alert('this is inside submitform');
	document.F.action ="Admin";
	//document.F.submit;
}

$(document).ready(function(){
	

	// $("#projectdiv").hide();
    // $("#pmdiv").hide();
    // $("#accountdiv").hide();
    // $("#lobdiv").hide();
     
	    var selection =  "<%=request.getAttribute("event")%>";
		//   alert('selection '+selection);
		if (selection == '1') {
			//   alert('inside project hide');
			// $("#project").hide();
			$("#projectdiv").show();
			$("#pmdiv").hide();
			$("#accountdiv").hide();
			$("#lobdiv").hide();
			//    alert('inside project hide');
		} else if (selection == '2') {
			alert('inside project hide');
			// $("#project").hide();
			$("#projectdiv").hide();
			$("#pmdiv").show();
			$("#accountdiv").hide();
			$("#lobdiv").hide();
			alert('inside project hide');
		} else if (selection == '3') {
			alert('inside project hide');
			// $("#project").hide();
			$("#projectdiv").hide();
			$("#pmdiv").hide();
			$("#accountdiv").show();
			$("#lobdiv").hide();
			alert('inside project hide');
		} else if (selection == '4') {
			alert('inside project hide');
			// $("#project").hide();
			$("#projectdiv").hide();
			$("#pmdiv").hide();
			$("#accountdiv").hide();
			$("#lobdiv").show();
			alert('inside project hide');
		}
	});
</SCRIPT>
</HEAD>

<BODY Class='SC'>
	<jsp:include page="AdminMenu.jsp"></jsp:include>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#startdate").datepicker({
			showOn : "button",
			buttonImage : "<%=request.getContextPath()%>/Images/cal.gif",
			buttonImageOnly : true
		});
		$("#enddate").datepicker({
			showOn : "button",
			buttonImage : "<%=request.getContextPath()%>
		/Images/cal.gif",
				buttonImageOnly : true
			});
		});
	</script>
	<%
		Map<String, List<String>> dropDownListMap = (Map<String, List<String>>) request
			.getAttribute("dropDownListMap");
			System.out.println(" dropDownListMap ------------"
			+ dropDownListMap.toString());

			String event = (String) request.getAttribute("event");
			System.out.println(" event  in edit jsp------------" + event);
			ProjectVO projectVO = null;
			AccountVO accountVO = null;
			LobVO lobVO = null;
			ManagerVO managerVO = null;
			Long id = null;
			if (event != null && event.equals("1")) {
		projectVO = (ProjectVO) request.getAttribute("detail");
		out.print("<div id='page-title'><h2>Edit Project</h2></div>");
		if (projectVO != null) {
			id = projectVO.getProjectId();
		}
			} else if (event != null && event.equals("3")) {
		accountVO = (AccountVO) request.getAttribute("detail");
		out.print("<div id='page-title'><h2>Edit Accout</h2></div>");
		if (accountVO != null) {
			id = accountVO.getAccountId();
		}
			} else if (event != null && event.equals("4")) {
		lobVO = (LobVO) request.getAttribute("detail");
		out.print("<div id='page-title'><h2>Edit Lob</h2></div>");
		if (lobVO != null) {
			id = lobVO.getLobId();
		}
			} else if (event != null && event.equals("2")) {
		managerVO = (ManagerVO) request.getAttribute("detail");
		out.print("<div id='page-title'><h2>Edit Manager</h2></div>");
		if (managerVO != null) {
			id = managerVO.getManagerId();
		}
			}
	%>

	<FORM Name='Accommodation' Id="Accommodation"
		action="<%=request.getContextPath()%>/Admin" method="POST">
		<input type="hidden" value="edit" name="action">
		<%
			if (event != null && event.equals("1")) {
				System.out.println(" in ifff after projectVO------------"
						+ projectVO.getProjectName());
		%>
		<title>Edit Project</title>
		<div id="projectdiv">
			<input type="hidden" value="project" name="module"> <input
				type="hidden" value="<%=projectVO.getProjectId()%>" name="projectId">
			<TABLE id="project" width="30%" class="notepad" align="center">
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project name </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name='projectName'
						value="<%=projectVO.getProjectName()%>" maxlength="64"></TD>
				</tr>

				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project LOB </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="projectLob"
						NAME="projectLob">
							<OPTION Value="">Select</OPTION>
							<%
								try {
																									List<String> list = dropDownListMap.get("lobList");
																									System.out.println("111 list-----------" + list.toString());
																									for (String str : list) {

																										if (str.substring(0, str.lastIndexOf("|")).equals(
																												projectVO.getProjectLob() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
																								} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">BAP</OPTION> -->
							<!-- 							<OPTION Value="">PES</OPTION> -->
							<!-- 							<OPTION Value="">HR</OPTION> -->
					</SELECT></TD>
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Account</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="projectAccount"
						NAME="projectAccount">
							<OPTION Value="">Select</OPTION>
							<%
								try {
																									List<String> list = dropDownListMap.get("accountList");
																									System.out.println("222 list-----------" + list.toString());
																									for (String str : list) {

																										if (str.substring(0, str.lastIndexOf("|")).equals(
																												projectVO.getProjectAccount() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
																								} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">TRISEPT</OPTION> -->
							<!-- 							<OPTION Value="">TRAVACO</OPTION> -->
							<!-- 							<OPTION Value="">BLUESTAR</OPTION> -->
					</SELECT></TD>
				</TR>

				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Base Currency </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="basecurrency"
						NAME="basecurrency">
							<OPTION Value="">Select</OPTION>
							<%
								try {
																									List<String> list = dropDownListMap.get("currencyList");
																									System.out.println("444 list-----------" + list.toString());
																									for (String str : list) {

																										if (str.substring(0, str.lastIndexOf("|")).equals(
																												projectVO.getProjectBaseCurrency() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
																								} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">INR</OPTION> -->
							<!-- 							<OPTION Value="">USD</OPTION> -->
							<!-- 							<OPTION Value="">GBP</OPTION> -->
					</SELECT></TD>
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> Priority </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="priority" NAME="priority">
							<OPTION Value="">Select</OPTION>
							<%
								try {
																									List<String> list = dropDownListMap.get("priorityList");
																									System.out.println("555 list-----------" + list.toString());
																									for (String str : list) {

																										if (str.substring(0, str.lastIndexOf("|")).equals(
																												projectVO.getProjectPriority() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
																								} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">TIME</OPTION> -->
							<!-- 							<OPTION Value="">COST</OPTION> -->
							<!-- 							<OPTION Value="">PERFORMANCE</OPTION> -->

					</SELECT></TD>
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project Status </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="projectStatus"
						NAME="projectStatus">
							<OPTION Value="">Select</OPTION>
							<%
								try {
																									List<String> list = dropDownListMap.get("statusList");
																									System.out.println("666 list-----------" + list.toString());
																									for (String str : list) {

																										if (str.substring(0, str.lastIndexOf("|")).equals(
																												projectVO.getProjectStatus() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
																								} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">Active</OPTION> -->
							<!-- 							<OPTION Value="">Running</OPTION> -->
							<!-- 							<OPTION Value="">On Hold</OPTION> -->
							<!-- 							<OPTION Value="">Dropped</OPTION> -->
							<!-- 							<OPTION Value="">Completed</OPTION> -->
					</SELECT></TD>
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project Type</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="projectType"
						NAME="projectType">
							<OPTION Value="">Select</OPTION>
							<%
								try {
																									List<String> list = dropDownListMap.get("typeList");
																									System.out.println("77 list-----------" + list.toString());
																									for (String str : list) {

																										if (str.substring(0, str.lastIndexOf("|")).equals(
																												projectVO.getProjectType() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
																								} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">Single action</OPTION> -->
							<!-- 							<OPTION Value="">Sequential</OPTION> -->
							<!-- 							<OPTION Value="">Parallel</OPTION> -->
							<!-- 							<OPTION Value="">Development</OPTION> -->
							<!-- 							<OPTION Value="">Testing</OPTION> -->
							<!-- 							<OPTION Value="">Enhancement</OPTION> -->
					</SELECT></TD>
				</TR>

				<tr class=row_even>
					<TD align="left" width="40%" style="width: 181px;"><FONT
						SIZE="2" COLOR="#AA2504" face='verdana'>Start Date </FONT><FONT
						COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><p>
							<!--  <input type="text" id="startdatepicker" /> -->
							<%
								SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
							%>
							<input name="startdate" id="startdate" type="text" size="15"
								value=<%if (projectVO.getStartDate() != null)%>
								<%=dateFormat.format(projectVO.getStartDate())%>>
						</p></TD>
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%" style="width: 181px;"><FONT
						SIZE="2" COLOR="#AA2504" face='verdana'>End Date </FONT><FONT
						COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><p>
							<!-- <input type="text" id="enddatepicker" /> -->
							<input name="enddate" id="enddate" type="text" size="15"
								value=<%if (projectVO.getEndDate() != null)%>
								<%=dateFormat.format(projectVO.getEndDate())%>>
						</p></TD>
				</TR>

				<tr class=row_odd>
					<TD align="left" valign="top"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project Description </TD>
					<TD colspan=2 align=left><textarea name='projectDesc'
							ROWS="5
							COLS="
							50" value="<%=projectVO.getProjectDesc()%>" style="width: 360px;"></textarea></TD>

				</tr>


				<tr class=row_odd>
					<TH colspan=1><INPUT class="sitewide-button" TYPE="submit" id="project"
						onClick="return validateProject(this)" value='Add'></TH>
					<TH colspan=2><INPUT class="sitewide-button" TYPE="reset" value='Clear'></TH>
				</TR>
			</TABLE>
		</div>
		<%
			} else if (event != null && event.equals("2")) {
		%>
		<title>Edit Manager</title>
		<div id="pmdiv">
			<input type="hidden" value="manager" name="module"> <input
				type="hidden" value="<%=managerVO.getManagerId()%>" name="managerId">
			<TABLE id="pm" width="30%" class="notepad" align="center">
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Name</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name="pmName"
						value='<%=managerVO.getManagerName()%>' maxlength="64"> </Input></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Employee Id</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name="pmEmpId"
						value='<%=managerVO.getManagerEmpId()%>' maxlength="10"> </Input></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Department</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="pmdepartment"
						NAME="pmdepartment">
							<OPTION Value="">Select</OPTION>
							<OPTION Value="1">Product Development-Java</OPTION>
							<OPTION Value="2">Testing</OPTION>
							<OPTION Value="3">Product Development-.NET</OPTION>
							<OPTION Value="4">SAAS</OPTION>

					</SELECT></TD>
					<script type="text/javascript">
						$(document).ready(
								function() {
									$('#pmdepartment').val(
					<%=managerVO.getManagerDeptId()%>
						);
								});
					</script>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>LOB</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="pmlob" NAME="pmlob">
							<OPTION Value="">Select</OPTION>
							<%
								try {
										List<String> list = dropDownListMap.get("lobList");

										for (String str : list) {

											if (str.substring(0, str.lastIndexOf("|")).equals(
													managerVO.getManagerLobId().toString())) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
									} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">BAP</OPTION> -->
							<!-- 							<OPTION Value="">PES</OPTION> -->
							<!-- 							<OPTION Value="">HR</OPTION> -->
					</SELECT></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Account</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="pmaccount"
						NAME="pmaccount">
							<OPTION Value="">Select</OPTION>
							<%
								try {
										List<String> list = dropDownListMap.get("accountList");

										for (String str : list) {

											if (str.substring(0, str.lastIndexOf("|")).equals(
													managerVO.getManagerAccountId() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
									} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">TRISEPT</OPTION> -->
							<!-- 							<OPTION Value="">LPS</OPTION> -->
							<!-- 							<OPTION Value="">BLUESTAR</OPTION> -->
					</SELECT></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Location</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="pmlocation"
						NAME="pmlocation">
							<OPTION Value="">Select</OPTION>
							<%
								try {
										List<String> list = dropDownListMap.get("locationList");

										for (String str : list) {

											if (str.substring(0, str.lastIndexOf("|")).equals(
													managerVO.getManagerLocationId() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
									} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">INDIA</OPTION> -->
							<!-- 							<OPTION Value="">USA</OPTION> -->
							<!-- 							<OPTION Value="">UK</OPTION> -->
					</SELECT></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Trade Currency</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="pmcurrency"
						NAME="pmcurrency">
							<OPTION Value="">Select</OPTION>
							<%
								try {
										List<String> list = dropDownListMap.get("currencyList");

										for (String str : list) {

											if (str.substring(0, str.lastIndexOf("|")).equals(
													managerVO.getManagerCurrency() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
									} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">INR</OPTION> -->
							<!-- 							<OPTION Value="">USD</OPTION> -->
							<!-- 							<OPTION Value="">GBP</OPTION> -->
					</SELECT></TD>
				</tr>

				<tr class=row_odd>
					<TD align="left" valign='top'><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Comments<FONT COLOR="red">*</FONT></TD>
					<TD colspan='2' align='left'><textarea name='pmdesc' ROWS="5"
							COLS="50"><%=managerVO.getManagerDescrition()%></textarea>
					</TD>

				</tr>


				<tr class=row_odd>
					<TH colspan='1'><INPUT class="sitewide-button" TYPE="submit" id="manager"
						onClick="return validateManager(this);" value='Add'></TH>
					<TH colspan='2'><INPUT class="sitewide-button" TYPE="reset" value='Clear'></TH>
				</TR>
			</TABLE>
		</div>
		<%
			} else if (event != null && event.equals("3")) {
		%>
		<%
			AdminBSO adminBSO = new AdminBSOImpl();
				List<UserVO> userVOList = adminBSO.getUserAccountHeadList();
		%>
		<title>Edit Account</title>
		<div id="accountdiv">
			<input type="hidden" value="account" name="module"> <input
				type="hidden" value="<%=accountVO.getAccountId()%>" name="accountId">
			<TABLE id="account" width="30%" class="notepad" align="center">
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> Name </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name='accountName'
						value='<%=accountVO.getAccountName()%>' maxlength='64'></TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> LOB </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="accountlob"
						NAME="accountlob">
							<OPTION Value="">Select</OPTION>
							<%
								try {
										List<String> list = dropDownListMap.get("lobList");

										for (String str : list) {

											if (str.substring(0, str.lastIndexOf("|")).equals(
													accountVO.getAccountLob() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
									} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">BAP</OPTION> -->
							<!-- 							<OPTION Value="">PES</OPTION> -->
							<!-- 							<OPTION Value="">HR</OPTION> -->
					</SELECT></TD>
				</tr>

				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> Client Name </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name='accountClient'
						value='<%=accountVO.getAccountClient()%>' maxlength='10'>
					</TD>
				</tr>

				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> Location </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="accountlocation"
						NAME="accountlocation">
							<OPTION Value="">Select</OPTION>
							<%
								try {
										List<String> list = dropDownListMap.get("locationList");

										for (String str : list) {

											if (str.substring(0, str.lastIndexOf("|")).equals(
													accountVO.getAccountLocation() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
									} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">INDIA</OPTION> -->
							<!-- 							<OPTION Value="">USA</OPTION> -->
							<!-- 							<OPTION Value="">UK</OPTION> -->
					</SELECT></TD>
				</tr>

				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> Account Head </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Select id="accountHead"
						name='accountHead' maxlength='10'>
							<option value="">Select</option>
							<%
								for (UserVO userVO : userVOList) {
							%>
							<%
								if (userVO.getRegID() == accountVO.getAccountHeadId()) {
							%>
							<option selected="selected" value=<%=userVO.getRegID()%>><%=userVO.getFirstName()%>
								<%=userVO.getLastName()%></option>
							<%
								} else {
							%>
							<option value=<%=userVO.getRegID()%>><%=userVO.getFirstName()%>
								<%=userVO.getLastName()%></option>
							<%
								}
							%>
							<%
								}
							%>
					</Select></TD>
				</tr>


				<tr class=row_odd>
					<TD align="left"><FONT SIZE="2" COLOR="#AA2504" face='verdana'>Account
							Description </TD>
					<TD colspan='2' align='left'><textarea
							name='accountDescription' ROWS="5" COLS="50"><%=accountVO.getAccountDesc()%></textarea></TD>

				</tr>


				<tr class=row_odd>
					<TH colspan=1><INPUT class="sitewide-button" TYPE="submit" id="account"
						onClick="return validateAccount(this)" value='Add'></TH>
					<TH colspan=2><INPUT class="sitewide-button" TYPE="reset" value='Clear'></TH>
				</TR>
			</TABLE>
		</div>
		<%
			} else if (event != null && event.equals("4")) {
		%>
		<%
			AdminBSO adminBSO = new AdminBSOImpl();
				List<UserVO> userVOList = adminBSO.getUserLobHeadList();
		%>
		<title>Edit Lob</title>
		<div id="lobdiv">
			<input type="hidden" value="lob" name="module"> <input
				type="hidden" value="<%=lobVO.getLobId()%>" name="lobId">
			<TABLE id="lob" width="30%" class="notepad" align="center">

				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> Name </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name='lobName'
						value='<%=lobVO.getLobName()%>' maxlength='64'></TD>
				</tr>




				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> Location </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><SELECT id="loblocation"
						NAME="loblocation">
							<OPTION Value="">Select</OPTION>
							<%
								try {
										List<String> list = dropDownListMap.get("locationList");

										for (String str : list) {

											if (str.substring(0, str.lastIndexOf("|")).equals(
													lobVO.getLobLocation() + "")) {
							%><OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>
								selected="selected"><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								} else
							%>

							<OPTION Value=<%=str.substring(0, str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|") + 1)%></OPTION>
							<%
								}
									} catch (Exception e) {
							%><%=e%>
							<%
								}
							%>
							<!-- 							<OPTION Value="">INDIA</OPTION> -->
							<!-- 							<OPTION Value="">USA</OPTION> -->
							<!-- 							<OPTION Value="">UK</OPTION> -->
					</SELECT></TD>
				</tr>

				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'> LOB Head </FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Select id="lobHead" name='lobHead' maxlength='10'>
							<option value="">Select</option>
							<%
								for (UserVO userVO : userVOList) {
							%>
							<%
								if (userVO.getRegID() == lobVO.getLobHeadId()) {
							%>
							<option selected="selected" value=<%=userVO.getRegID()%>><%=userVO.getFirstName()%>
								<%=userVO.getLastName()%></option>
							<%
								} else {
							%>
							<option value=<%=userVO.getRegID()%>><%=userVO.getFirstName()%>
								<%=userVO.getLastName()%></option>
							<%
								}
							%>
							<%
								}
							%>
					</Select></TD>
				</tr>


				<tr class=row_odd>
					<TD align="left"><FONT SIZE="2" COLOR="#AA2504" face='verdana'>LOB
							Description </TD>
					<TD colspan='2' align='left'><textarea name='lobdesc' ROWS="5"
							COLS="50"><%=lobVO.getLobDesc()%></textarea></TD>

				</tr>


				<tr class=row_odd>
					<TH colspan=1><INPUT class="sitewide-button" TYPE="submit" id="lob"
						onClick="return validateLob(this)" value='Add'></TH>
					<TH colspan=2><INPUT class="sitewide-button" TYPE="reset" value='Clear'></TH>
				</TR>
			</TABLE>
		</div>
		<%
			}
		%>
		<input type='hidden' name="addmodule" id="addmodule"> <input
			type='hidden' id='id' name='id' value='<%=id%>'>
	</FORM>

	<jsp:include page="Footer.html"></jsp:include>
</BODY>

</HTML>
