<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,java.util.*,com.bluestar.fms.vo.*;"%>
<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>

<script  LANGUAGE="Javascript">

function submitForm(frm){
	
	
	var object = frm.managerId.length;
	alert(" object "+object);
var  message ='';
	 //For each checkbox see if it has been checked, record the value.
	   for (var i = 0; i < frm.managerId.length; i++){

		//   alert(" i "+i);
		  alert('value---'+ frm.managerId[i].value);
	      if (frm.managerId[i].checked == true){
	       var  message = message + frm.managerId[i].value + ",";
	         alert(' message  '  +message);
	      }
	   }
	   alert(message);
	var flag = true;
//	document.getElementById('selectval').value=message;
	
	document.getElementById("selectval").value = message;
	document.getElementById("action").value = 'link';
	document.getElementById("event").value = '1';
	
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
<FORM Name='ManagerList' Id="ManagerList" method="Get">
<%!
		String managerName="";
 		
		String lob="";
		String account="";
		String currency="";
		Long managerId =null;
		
	%>
<h3 align=center>Manager List</h3>
<table align=center border=0>

<%

	
	try{
		String event = (String)request.getAttribute("event");
		System.out.println("event ---------------"+event);
		List<ManagerVO>		listManagerVO = (List<ManagerVO>)request.getAttribute("listPMVO");
		ManagerVO	managerVO = null;
			%>
			<table align="center" width="75%" border=0> 
			<%
			System.out.println("listManagerVO ---------------"+listManagerVO.size());
			if(listManagerVO != null && listManagerVO.size() > 0)
			{	
				int counter = 0;		
		
		for(int i=0;i<listManagerVO.size();i++){	
				
				managerVO = listManagerVO.get(i);
				if ( managerVO != null) {
			 		
			managerId= managerVO.getManagerId();
			managerName=managerVO.getManagerName();
		
			lob=managerVO.getManagerLobId()+"";
			account=managerVO.getManagerAccountId()+"";
			currency=managerVO.getManagerCurrency()+"";
			
			if(event == null )
			{
		%>
			<TR class= "row_even">
			<td align="left" colspan=2><B>Manager Name: </B><%=managerName%></td>
			
			<td align="left" colspan=2>
			<a href="Admin?action=viewproject&event=assignpm&id=<%=managerId%>">
			<input type="button" class="myButton" value='Associate Project'></a>
			</td>
			</tr>
			
			<TR class= "row_even">
			<td align="left" colspan=2><B>Manager Name: </B><%=managerName%></td>
			<td align="left" colspan=2><B>LOB:</B><%=lob%></td></tr>
		
			<TR class= "row_even">
			<td align="left" colspan=2><B>Account: </B><%=account%></td><td align="left" colspan=2><B>Currency: </B><%=currency%></td></tr>
						
			<tr class=row_odd>	
			<th align="left" colspan=4><hr color='#F3E1BC'></th></tr>
<%
}
else if(event != null && event.equals("assignproject")) {
if(i == 0){
%>
			
			
			<TR class= "row_even">
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B>Manager Name </B></th>
			<th align="center" ><B>LOB</B></th>
			<th  align="center" > <B>Select</B></th>
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="left" ><%=managerName%></td>
			<td align="center" ><%=lob%></td>
			<td  align="center" >
			
			<input type="radio" name='managerId'  id ='managerId' value=<%=managerId %>></a>
			</td>
			</tr>
			<tr class=row_odd>	
			
			
	<%}else{ %>		
<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="left" ><%=managerName%></td>
			<td align="center" ><%=lob%></td>
			<td  align="center" >
			
			<input type="radio" name='managerId' id ='managerId' value=<%=managerId %>></a>
			</td>
			</tr>
<!--			<tr class=row_odd>	
			<th align="left" colspan='4'><hr color='#F3E1BC'></th></tr>-->
		<%
}
}
				
			}
		}
	%>	
		<TR class= "row_even">
						<td align="center" colspan='5'><a><input type="submit" class="myButton" onclick='return submitForm(this.form)' value='Submit'></a> </td>
						
						</tr>
	<%	}
			else	if( listManagerVO.size()  == 0)	{%><P align=center><h6 align=center>Sorry No records Found</h6><% }
			
			
	}catch(Exception e){
			e.printStackTrace();
			%><%=e%><%
		}
		
	
%>
</table>
</table>
<input type='hidden'  name ='id' id='id' value="<%=request.getParameter("id") %>">
	<input type='hidden'  name ='selectval' id='selectval' value="">
	<input type='hidden'  name ='action' id='action' value="">
	<input type='hidden'  name ='event' id='event' value="">
</form>
</BODY>
