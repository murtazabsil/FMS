<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.util.*,com.bluestar.fms.vo.*"%>
<%			String Condition = "LocationName";
%>

<HTML>
<HEAD>
<TITLE>Edit</TITLE>
    <LINK href="css/styles.css" type="text/css" rel="stylesheet">
    
    <script type="text/javascript"    src="scripts/jquery-1.8.2.js"></script>
<script type="text/javascript"  src="scripts/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.js"></script>
 <script LANGUAGE="Javascript" SRC="scripts/validation.js"></script>
 
<SCRIPT LANGUAGE="JavaScript">
var flag=false;

$(document).ready(function(){
	

	 $("#projectdiv").hide();
    $("#pmdiv").hide();
    $("#accountdiv").hide();
    $("#lobdiv").hide();
    
	$('#view').on('click',function(){
	    var selection = $('#MuduleName').val();
	    alert('selection '+selection);
	    if (selection == '1') {   
	    alert('inside project hide');
	     // $("#project").hide();
	      $("#projectdiv").show();
	      $("#pmdiv").hide();
	      $("#accountdiv").hide();
	      $("#lobdiv").hide();
	      alert('inside project hide');
		}
	    else if (selection == '2') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").show();
		      $("#accountdiv").hide();
		      $("#lobdiv").hide();
		      alert('inside project hide');
			}
	    else if (selection == '3') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").hide();
		      $("#accountdiv").show();
		      $("#lobdiv").hide();
		      alert('inside project hide');
			}
	    else if (selection == '4') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").hide();
		      $("#accountdiv").hide();
		      $("#lobdiv").show();
		      alert('inside project hide');
			}
	});

	

	});

function confirmDelete(val){
	   
    alert('delete val '+val);
    
   var frm = document.forms[0];
    var r=confirm("Do you really want to delete?");
    if (r==true)
      {
    
	var  message ='';

	  if(val=='1'){
	        message = getProjectSelectedValues();	        
	        }
	    else if(val == '2'){
	    	 message = getPMSelectedValues();	    	 
	        }
	    else if(val == '3'){
	    	 message = getAccountSelectedValues();
	    }
	    else if(val == '4'){
	    	 message = getLobSelectedValues();
	    }
	  	
	   if(flag)
		{
		alert('selected '+message);
		   document.getElementById("selectval").value = message;
			document.getElementById("action").value = 'delete';
			document.getElementById("event").value = val;

			alert(' before submit');
			document.frm.action ="Admin";
		//	return true;
		   }
	   else{
		   alert(' You must select atleast one record');
		   }
      }
    else
      {
      return false;
      }
    
    alert('x ====='+x); 
  //  document.getElementById("demo").innerHTML=x;
    
}

function getProjectSelectedValues(){
	var frm = document.forms[0];
	 flag=false;
	var  message ='';
    //For each checkbox see if it has been checked, record the value.
	   for (var i = 0; i < frm.projectid.length; i++){

		//   alert(" i "+i);
		  alert('value---'+ frm.projectid[i].value);
	      if (frm.projectid[i].checked == true){
	         message = message + frm.projectid[i].value + ",";
	         alert(' message  '  +message);
	         flag = true;
	      }
	   }

	 return message;  
}

function  getLobSelectedValues(){
	var frm = document.forms[0];
	 flag=false;
	var  message ='';
   //For each checkbox see if it has been checked, record the value.
	   for (var i = 0; i < frm.lobid.length; i++){

		//   alert(" i "+i);
		  alert('value---'+ frm.lobid[i].value);
	      if (frm.lobid[i].checked == true){
	         message = message + frm.lobid[i].value + ",";
	         alert(' message  '  +message);
	         flag = true;
	      }
	   }

	 return message;  
}

function getPMSelectedValues(){
	var frm = document.forms[0];
	 flag=false;
	var  message ='';
   //For each checkbox see if it has been checked, record the value.
	   for (var i = 0; i < frm.pmid.length; i++){

		//   alert(" i "+i);
		  alert('value---'+ frm.pmid[i].value);
	      if (frm.pmid[i].checked == true){
	         message = message + frm.pmid[i].value + ",";
	         alert(' message  '  +message);
	         flag = true;
	      }
	   }

	 return message;  
}

function getAccountSelectedValues(){
	var frm = document.forms[0];
	 flag=false;
	var  message ='';
   //For each checkbox see if it has been checked, record the value.
	   for (var i = 0; i < frm.accountid.length; i++){

		//   alert(" i "+i);
		  alert('value---'+ frm.accountid[i].value);
	      if (frm.accountid[i].checked == true){
	         message = message + frm.accountid[i].value + ",";
	         alert(' message  '  +message);
	         flag = true;
	      }
	   }

	 return message;  
}
	</SCRIPT>
</HEAD>

<BODY Class='SC'>

<%
Map<String,List<String>> dropDownListMap = (Map<String,List<String>> )request.getAttribute("dropDownListMap");
System.out.println(" dropDownListMap ------------"+dropDownListMap.toString());

%>
<HR><br>
<FORM Name='Resorts' Id="Resort" method="GET"  >

	<TABLE align=center width="30%">
			<TR class="row_title">
				<TD colspan=2 align=center><B><CENTER>Select Module To Edit
							</CENTER> </B>
				</TD>
			<TR class="row_even">
				<TH>Module Name</TH>
				<TD><INPUT TYPE="hidden" NAME="LName" value=""><SELECT
					id="MuduleName" >
						<OPTION Value="">Select</OPTION>

						<%
	try{
		List<String> list = dropDownListMap.get("moduleList");
		
				for(String str :list){
					

					%><OPTION Value=<%=str.substring(0,str.lastIndexOf("|"))%>><%=str.substring(str.lastIndexOf("|")+1)%></OPTION>
						<%
					
				}
		}catch(Exception e){%><%=e%>
						<%}
%>
				
<!--			<TR>-->
<!--				<TH align=center colspan=2><INPUT TYPE="submit" value='View'>-->
<!--				</TH>-->
<!--			</TR>-->
		
		<TR><TH align=center colspan=2><INPUT TYPE="button"  id='view' value='View Records'></TH></TR>
	</TABLE>
	<%

	
		String event = (String)request.getAttribute("event");
		
	//	System.out.println("project list"+list.toString());
		String strTitle =""; 
		String str1 = "";
		
		List<String> listP = null;
		
		List<String> listM = null; 
		
		List<String> listL = null;
		
		List<String> listA = null;
		
		
			 listP = dropDownListMap.get("projectList");
			
			 listM = dropDownListMap.get("managerList");
			
			 listL = dropDownListMap.get("lobList");
			
			 listA = dropDownListMap.get("accountList");
			
		 
			%>
			
	<div id='projectdiv'>		
		<table align="center" width="65%">
		<TR class= "row_even" class="row_title">
			<th align="center" colspan='3'><B>Project List</B></th>
		
			
			</tr>
		<%
		
		try{
		for(int i=0;i<listP.size();i++){	
		
			if(i==0){
			str1=listP.get(i);
			%>
			
			
			<TR class= "row_even" >
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B> Name </B></th>
			<th align="center" ><B> Select </B></th>
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" >
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</td>
			
			<td align="center" >
			<input type="checkbox" id="projectid" value='<%=str1.substring(0,str1.lastIndexOf("|"))%>'>
			</td>
			
			</tr>
				
			
			
	<%}else{ str1=listP.get(i); %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><%=str1.substring(str1.lastIndexOf("|")+1)%></td>
			<td align="center" >
			<input type="checkbox" id="projectid" value='<%=str1.substring(0,str1.lastIndexOf("|"))%>'>
			</td>
			
			</tr>


		<%
	}
		
		
		}
		
			%>	
				
			<TR class= "row_even" class="row_title">
			<td align="center" colspan='3'>
			<input type="submit" id="delete"  value='Delete Records' onClick='confirmDelete(1)'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT TYPE="reset" value='Clear'>
			</td>
		
			
			</tr>

				
	<%		
			
			
		
				if( listP.size()  == 0)	{%><P align=center>
		<h6 align=center>Sorry No records Found</h6>
		<% }
		
			
		}	catch(Exception e){
			e.printStackTrace();
			%><%=e%>
		<%
		}
		%>
	</table>
	</div>
	
	<div id='pmdiv'>		
		<table align="center" width="65%">
		<TR class= "row_even" class="row_title">
			<th align="center" colspan='3'><B>Manager List</B></th>
			
			
			</tr>
		<%
		
		try{
		for(int i=0;i<listM.size();i++){	
		
			if(i==0){
			str1=listM.get(i);
			%>
			
			
			<TR class= "row_even" >
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B> Name </B></th>
			<th align="center" ><B> Select </B></th>
			
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" >
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</td>
			
			<td align="center" >
			<input type="checkbox" id="pmid" value='<%=str1.substring(0,str1.lastIndexOf("|"))%>'>
			</td>
			
			</tr>
				
			
			
	<%}else{ str1=listM.get(i); %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><%=str1.substring(str1.lastIndexOf("|")+1)%></td>
			
			<td align="center" >
			<input type="checkbox" id="pmid" value='<%=str1.substring(0,str1.lastIndexOf("|"))%>'>
			</td>
			</tr>


		<%
	}
		
		
		}
		
			%>	
				
			

				
	<%		
			
			
		
				if( listM.size()  == 0)	{%><P align=center>
		<h6 align=center>Sorry No records Found</h6>
		<% }
		
			
		}	catch(Exception e){
			e.printStackTrace();
			%><%=e%>
		<%
		}
		%>
	</table>
	</div>
	
	
	<div id='accountdiv'>		
		<table align="center" width="65%">
		<TR class= "row_even" class="row_title">
			<th align="center" colspan='3'><B>Account List</B></th>
			
			
			</tr>
		<%
		
		try{
		for(int i=0;i<listA.size();i++){	
		
			if(i==0){
			str1=listA.get(i);
			%>
			
			
			<TR class= "row_even" >
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B> Name </B></th>
			<th align="center" ><B> Select </B></th>
			
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" >
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</td>
			
			<td align="center" >
			<input type="checkbox" id="accountid" value='<%=str1.substring(0,str1.lastIndexOf("|"))%>'>
			</td>
			
			</tr>
				
			
			
	<%}else{ str1=listA.get(i); %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><%=str1.substring(str1.lastIndexOf("|")+1)%></td>
			
			<td align="center" >
			<input type="checkbox" id="accountid" value='<%=str1.substring(0,str1.lastIndexOf("|"))%>'>
			</td>
			</tr>


		<%
	}
		
		
		}
		
			%>	
				
			

				
	<%		
			
			
		
				if( listA.size()  == 0)	{%><P align=center>
		<h6 align=center>Sorry No records Found</h6>
		<% }
		
			
		}	catch(Exception e){
			e.printStackTrace();
			%><%=e%>
		<%
		}
		%>
	</table>
	</div>
	
	
	<div id='lobdiv'>		
		<table align="center" width="65%">
		<TR class= "row_even" class="row_title"> 
			<th align="center" colspan='3'><B>Lob List</B></th>
		
			
			</tr>
		<%
		
		try{
		for(int i=0;i<listL.size();i++){	
		
			if(i==0){
			str1=listL.get(i);
			%>
			
			
			<TR class= "row_even" >
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B> Name </B></th>
			<th align="center" ><B> Select </B></th>
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" >
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</td>
			
			<td align="center" >
			<input type="checkbox" id="lobid" value='<%=str1.substring(0,str1.lastIndexOf("|"))%>'>
			</td>
			
			</tr>
				
			
			
	<%}else{ str1=listL.get(i); %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><%=str1.substring(str1.lastIndexOf("|")+1)%></td>
			
			<td align="center" >
			<input type="checkbox" id="lobid" value='<%=str1.substring(0,str1.lastIndexOf("|"))%>'>
			</td>
			</tr>


		<%
	}
		
		
		}
		
			%>	
				

				
	<%		
			
			
		
				if( listL.size()  == 0)	{%><P align=center>
		<h6 align=center>Sorry No records Found</h6>
		<% }
		
			
		}	catch(Exception e){
			e.printStackTrace();
			%><%=e%>
		<%
		}
		%>
	</table>
	</div>
		<input type='hidden'  name ='selectval' id='selectval' value="">
	<input type='hidden'  name ='action' id='action' value="">
	<input type='hidden'  name ='event' id='event' value="">
	
	</FORM>
	</BODY>

</HTML>
 