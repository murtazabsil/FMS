<%@ page language="java"%>
<%@ page session="true"%>
<%@ page
	import="java.sql.*,java.io.*,java.util.*,com.bluestar.fms.vo.*;"%>
<HEAD>


<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>
<script LANGUAGE="Javascript">



function submitForm(frm){
	
		
		var object = frm.projectId.length;
		//alert(" object "+object);
var  message ='';
		 //For each checkbox see if it has been checked, record the value.
		   for (var i = 0; i < frm.projectId.length; i++){

			//   alert(" i "+i);
			//  alert('value---'+ frm.projectId[i].value);
		      if (frm.projectId[i].checked == true){
		       var  message = message + frm.projectId[i].value + ",";
		    //     alert(' message  '  +message);
		      }
		   }
		   alert(message);
		var flag = true;
	//	document.getElementById('selectval').value=message;
			
		document.getElementById("selectval").value = message;
		document.getElementById("action").value = 'link';
		document.getElementById("event").value = '2';
		
	//		var frm = document.forms[0];
			
			
			alert('this is inside submitform pmid---'+pmid);
			document.frm.action ="Admin";
			//document.F.submit;
			
		//	if(ChkAlphaField(frm.UserID,'UserID')==false) return false;
		//	if(ChkMandatoryField(frm.Password,'Password')==false) return false;
		//	if(ChkAlphaNumericField(frm.Password,'Password')==false) return false;
			
		
}

</script>

<LINK href="css/styles.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY class='SC'>
<FORM Name='ProjectList' Id="ProjectList" method="Get">
	
<%!
		String projectName="";
 		String pmName="";
		String lob="";
		String account="";
		String currency="";
		String status="";
		Long projectid = null;
	%>

<h3 align=center>Project List</h3>
<table align=center>
	<%

		
	try{
		String event = (String)request.getAttribute("event");
		System.out.println("event ---------------"+event);	
		List<ProjectVO>		listProjectVO = (List<ProjectVO>)request.getAttribute("listProjectVO");
			ProjectVO  projectVO = null;
			%>
	<table align="center" width="65%">
		<%
			System.out.println("listProjectVO ---------------"+listProjectVO.size());
			if(listProjectVO != null && listProjectVO.size() > 0)
			{	
				
		
for(int i=0;i<listProjectVO.size();i++){	
				
	projectVO = listProjectVO.get(i);
				if ( projectVO != null) {			
			projectid = projectVO.getProjectId();
			projectName=projectVO.getProjectName();
			pmName=projectVO.getPmId()+"";
			lob=projectVO.getProjectLob()+"";
			account=projectVO.getProjectAccount()+"";
			currency=projectVO.getProjectBaseCurrency()+"";
			status=projectVO.getProjectStatus()+"";
		if(event==null)	
		{
		%>
		<TR class="row_even">
			<td align="left" colspan=2><B>Project Name: </B><%=projectName%></td>

			<td align="left" colspan=2><a
				href="Admin?action=viewpm&event=assignproject&id=<%=projectid%>">
			<input type="button" class="myButton" value='Link to Manager'></a>

			</td>
		</tr>

		<TR class="row_even">
			<td align="left"><B>Manager Name: </B><%=pmName%></td>
			<td align="left"2><B>LOB:</B><%=lob%></td>
		</tr>


		<tr class="row_even">
			<td class="row_even" align="left" colspan=2><B>Account: </B><%=account%></td>
			<td align="left" colspan=2><B>Currency: </B><%=currency%></td>
		</tr>

		<tr class=row_odd>
			<th align="left" colspan=4>
			<hr color='#F3E1BC'>
			</th>
		</tr>



		<%
		}else if(event != null && event.equals("assignpm")){
			if(i==0){%>
			
			
			<TR class= "row_even">
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B>Project Name </B></th>
			<th align="center" ><B>Account </B></th>
			<th align="center" ><B>LOB</B></th>
			<th  align="center" > <B>Select</B></th>
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="left" ><%=projectName%></td>
			
			<td align="center" ><%=account%></td>
			<td align="center" ><%=lob%></td>
			<td  align="center" >
			
			<input type="checkbox" name='projectId' id='projectId' value=<%=projectid %>></a>
			</td>
			</tr>
				
			
			
	<%}else{ %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="left" ><%=projectName%></td>
			
			<td align="center" ><%=account%></td>
			<td align="center" ><%=lob%></td>
			<td  align="center" >
			
			<input type="checkbox" name='projectId' value=<%=projectid %>></a>
			</td>
			</tr>


		<%
	}
		}
		}
}			%>	
				
			
<TR class= "row_even">
				<td align="center" colspan='5'><a><input type="submit" class="myButton" onclick='return submitForm(this.form)' value='Submit'></a> </td>
				
				</tr>
				
	<%		}
			
			
		
			else	if( listProjectVO.size()  == 0)	{%><P align=center>
		<h6 align=center>Sorry No records Found</h6>
		<% }
		
			
	}		catch(Exception e){
			e.printStackTrace();
			%><%=e%>
		<%
		}
		
	
%>
	</table>
</table>
	<input type='hidden'  name ='id' id='id' value="<%=request.getParameter("id") %>">
	<input type='hidden'  name ='selectval' id='selectval' value="">
	<input type='hidden'  name ='action' id='action' value="">
	<input type='hidden'  name ='event' id='event' value="">
</FORM>	
</BODY>
