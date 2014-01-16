<%@ page language="java"%>
<%@ page session="true"%>
<%@ page
	import="java.sql.*,java.io.*,com.eResorts.MyFunctions,com.bluestar.fms.vo.*,java.util.*;"%>
<%			String Condition = "MuduleName";
%>

<HTML>
<HEAD>
<TITLE>Accommodation</TITLE>
<LINK href="css/styles.css" type="text/css" rel="stylesheet">

<script language="javascript" type="text/javascript"
	src="scripts/datetimepicker.js"></script>

<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
<script type="text/javascript" src="scripts/jquery-1.8.0.min.js"></script>
<script src="scripts/jquery-ui.js"></script>
<script LANGUAGE="Javascript" SRC="scripts/validation.js"></script>

<SCRIPT LANGUAGE="JavaScript">		



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
     
	    var selection =  "<%=request.getAttribute("event")%>
	";
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

	<FORM Name='Accommodation' Id="Accommodation" method="Get">
		<%
			if (event != null && event.equals("1")) {
				System.out.println(" in ifff after projectVO------------"
						+ projectVO.getProjectName());
		%>

		<div id="projectdiv">

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
							<input id="startdate" type="text" size="15"><a
								href="javascript:NewCal('startdate','ddmmyyyy')"><img
								src="Images/cal.gif" width="16" height="16" border="0"
								alt="Pick a date"> </a>
						</p></TD>
				</TR>
				<tr class=row_even>
					<TD align="left" width="40%" style="width: 181px;"><FONT
						SIZE="2" COLOR="#AA2504" face='verdana'>End Date </FONT><FONT
						COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><p>
							<!-- <input type="text" id="enddatepicker" /> -->
							<input id="enddate" type="text" size="15"><a
								href="javascript:NewCal('enddate','ddmmyyyy')"><img
								src="Images/cal.gif" width="16" height="16" border="0"
								alt="Pick a date"> </a>
						</p></TD>
				</TR>

				<tr class=row_odd>
					<TD align="left" valign="top"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Project Description </TD>
					<TD colspan=2 align=left><textarea name='projectDesc'
							ROWS="5
							COLS="
							50" value="<%=projectVO.getProjectDesc()%>"
							style="width: 360px;"></textarea></TD>

				</tr>


				<tr class=row_odd>
					<TH colspan=1><INPUT TYPE="submit" id="project"
						onClick="return validate(this)"	value='Add'></TH>
					<TH colspan=2><INPUT TYPE="reset" value='Clear'></TH>
				</TR>
			</TABLE>
		</div>
		<%
			} else if (event != null && event.equals("2")) {
		%>
		<div id="pmdiv">
			<TABLE id="pm" width="30%" class="notepad" align="center">
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Name</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name="pmName"
						value='<%=managerVO.getManagerName()%>' maxlength="64"> </Input>
					</TD>
				</tr>
				<tr class=row_odd>
					<TD align="left" width="40%"><FONT SIZE="2" COLOR="#AA2504"
						face='verdana'>Employee Id</FONT><FONT COLOR="red">*</FONT></TD>
					<TD colspan=2 align=left><Input type=text name="pmEmpId"
						value='<%=managerVO.getManagerEmpId()%>' maxlength="10">
						</Input></TD>
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
													managerVO.getManagerLobId())) {
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
							COLS="50"
							value='<%=managerVO.getManagerDescrition()%>></textarea>'></textarea>
					</TD>

				</tr>


				<tr class=row_odd>
					<TH colspan='1'><INPUT TYPE="submit" id="manager"
						onClick="return validate(this);" value='Add'></TH>
					<TH colspan='2'><INPUT TYPE="reset" value='Clear'></TH>
				</TR>
			</TABLE>
		</div>
		<%
			} else if (event != null && event.equals("3")) {
		%>

		<div id="accountdiv">
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
					<TD colspan=2 align=left><Input type=text name='accountHead'
						value="<%=accountVO.getAccountHead()%>" maxlength='10'></TD>
				</tr>


				<tr class=row_odd>
					<TD align="left"><FONT SIZE="2" COLOR="#AA2504" face='verdana'>Account
							Description </TD>
					<TD colspan='2' align='left'><textarea
							name='accountDescription' ROWS="5" COLS="50"
							value='<%=accountVO.getAccountDesc()%>'></textarea></TD>

				</tr>


				<tr class=row_odd>
					<TH colspan=1><INPUT TYPE="submit" id="account"
						onClick="return validate(this)" value='Add'></TH>
					<TH colspan=2><INPUT TYPE="reset" value='Clear'></TH>
				</TR>
			</TABLE>
		</div>
		<%
			} else if (event != null && event.equals("4")) {
		%>
		<div id="lobdiv">
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
					<TD colspan=2 align=left><Input type=text name='lobHead'
						value='<%=lobVO.getLobHead()%>' maxlength='10'></TD>
				</tr>


				<tr class=row_odd>
					<TD align="left"><FONT SIZE="2" COLOR="#AA2504" face='verdana'>LOB
							Description </TD>
					<TD colspan='2' align='left'><textarea name='lobdesc' ROWS="5"
							COLS="50" value='<%=lobVO.getLobDesc()%>'></textarea></TD>

				</tr>


				<tr class=row_odd>
					<TH colspan=1><INPUT TYPE="submit" id="lob"
						onClick="return validate(this)" value='Add'></TH>
					<TH colspan=2><INPUT TYPE="reset" value='Clear'></TH>
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
