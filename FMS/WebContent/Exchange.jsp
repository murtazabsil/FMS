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

<HR><br>
<FORM Name='Resorts' Id="Resort" method="GET"  >

	<TABLE align=center width="65%">
			<TR class="row_title">
					<TH align="center" colspan=2><FONT SIZE="4" COLOR="#AA2504"
						face='verdana'>Exchage rate</FONT>
					</TH>
				</TR>

	</TABLE>
	<%

	
		String event = (String)request.getAttribute("event");
		
	//	System.out.println("project list"+list.toString());
		String strTitle =""; 
		String str1 = "";
		
		List<String> listP = new ArrayList<String>();
		listP.add("1|USD|55");
		listP.add("1|USD|55");
		listP.add("1|USD|55");
		listP.add("1|USD|55");
		listP.add("1|USD|55");
		
		 
			%>
			
	<div id='projectdiv'>		
		<table align="center" width="65%">
		<TR class= "row_even" class="row_title">
			<th align="center" colspan='3'><B>Exchange Rate List</B></th>
		
			
			</tr>
		<%
		
		try{
		for(int i=0;i<listP.size();i++){	
		
			if(i==0){
			str1=listP.get(i);
			%>
			
			
			<TR class= "row_even" >
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B> Currency  </B></th>
			<th align="center" ><B> Rate (in INR) </B></th>
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" >
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</td>
			
			<td align="center" >
			<%=str1.substring(0,str1.lastIndexOf("|"))%>
			</td>
			
			</tr>
				
			
			
	<%}else{ str1=listP.get(i); %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><%=str1.substring(str1.lastIndexOf("|")+1)%></td>
			<td align="center" >
			<%=str1.substring(0,str1.lastIndexOf("|"))%>
			</td>
			
			</tr>


		<%
	}
		
		
		}
		
			%>	
				
			
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
	
	
		<input type='hidden'  name ='selectval' id='selectval' value="">
	<input type='hidden'  name ='action' id='action' value="">
	<input type='hidden'  name ='event' id='event' value="">
	
	</FORM>
	</BODY>

</HTML>
 