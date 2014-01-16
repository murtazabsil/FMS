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
$(document).ready(function(){

	var viewmodule = <%=request.getParameter("viewmodule")%>//$(this).val();
if(viewmodule != null)
{
	directModuleCall();
}
else
{
	 $("#projectdiv").hide();
    $("#pmdiv").hide();
    $("#accountdiv").hide();
    $("#lobdiv").hide();
    $("#userdiv").hide();
    
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
	      $("#userdiv").hide();
	      alert('inside project hide');
		}
	    else if (selection == '2') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").show();
		      $("#accountdiv").hide();
		      $("#lobdiv").hide();
		      $("#userdiv").hide();
		      alert('inside project hide');
			}
	    else if (selection == '3') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").hide();
		      $("#accountdiv").show();
		      $("#lobdiv").hide();
		      $("#userdiv").hide();
		      alert('inside project hide');
			}
	    else if (selection == '4') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").hide();
		      $("#accountdiv").hide();
		      $("#lobdiv").show();
		      $("#userdiv").hide();
		      alert('inside project hide');
			}
	    else if (selection == '5') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").hide();
		      $("#accountdiv").hide();
		      $("#lobdiv").hide();
		      $("#userdiv").show();
		      alert('inside project hide');
			}
	});

}


function directModuleCall(){
	$("#modulediv").hide();
	  var selection = <%=request.getParameter("viewmodule")%>//$(this).val();
	    alert('selection '+selection);
	    if (selection == '1') {   
	    alert('inside project hide');
	     // $("#project").hide();
	      $("#projectdiv").show();
	      $("#pmdiv").hide();
	      $("#accountdiv").hide();
	      $("#lobdiv").hide();
	      $("#userdiv").hide();
	      alert('inside project hide');
		}
	    else if (selection == '2') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").show();
		      $("#accountdiv").hide();
		      $("#lobdiv").hide();
		      $("#userdiv").hide();
		      alert('inside project hide');
			}
	    else if (selection == '3') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").hide();
		      $("#accountdiv").show();
		      $("#lobdiv").hide();
		      $("#userdiv").hide();
		      alert('inside project hide');
			}
	    else if (selection == '4') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").hide();
		      $("#accountdiv").hide();
		      $("#lobdiv").show();
		      $("#userdiv").hide();
		      alert('inside project hide');
			}
	    else if (selection == '5') {   
		    alert('inside project hide');
		     // $("#project").hide();
		      $("#projectdiv").hide();
		      $("#pmdiv").hide();
		      $("#accountdiv").hide();
		      $("#lobdiv").hide();
		      $("#userdiv").show();
		      alert('inside project hide');
			}
	
}
});

</SCRIPT>
</HEAD>

<BODY Class='SC'>

<%
Map<String,List<String>> dropDownListMap = (Map<String,List<String>> )request.getAttribute("dropDownListMap");
System.out.println(" dropDownListMap ------------"+dropDownListMap.toString());

%>
<HR><br>
<FORM Name='Resorts' Id="Resort" method="GET"  >
<div id='modulediv'>
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
		
		List<String> listU = null;
		
		
			 listP = dropDownListMap.get("projectList");
			
			 listM = dropDownListMap.get("managerList");
			
			 listL = dropDownListMap.get("lobList");
			
			 listA = dropDownListMap.get("accountList");
			 
			 listU = dropDownListMap.get("userList");
			
		 
			%>
	</div>		
	<div id='projectdiv'>		
		<table align="center" width="65%">
		<TR class="row_title">
					<TH align="center" colspan=2><FONT SIZE="4" COLOR="#AA2504"
						face='verdana'>Project List</FONT>
					</TH>
				</TR>
		<%
		
		try{
		for(int i=0;i<listP.size();i++){	
		
			if(i==0){
			str1=listP.get(i);
			%>
			
			
			<TR class= "row_even">
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B> Name </B></th>
			
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><a href="Admin?action=edit&event=1&id=<%=str1.substring(0,str1.lastIndexOf("|"))%>">
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</a></td>
			
			
			
			</tr>
				
			
			
	<%}else{ str1=listP.get(i); %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><a href="Admin?action=edit&event=1&id=<%=str1.substring(0,str1.lastIndexOf("|"))%>"><%=str1.substring(str1.lastIndexOf("|")+1)%></a></td>
			
			
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
	
	<div id='pmdiv'>		
		<table align="center" width="65%">
		<TR class="row_title">
					<TH align="center" colspan=2><FONT SIZE="4" COLOR="#AA2504"
						face='verdana'>Manager List</FONT>
					</TH>
				</TR>
		<%
		
		try{
		for(int i=0;i<listM.size();i++){	
		
			if(i==0){
			str1=listM.get(i);
			%>
			
			
			<TR class= "row_even">
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B> Name </B></th>
			
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><a href="Admin?action=edit&event=2&id=<%=str1.substring(0,str1.lastIndexOf("|"))%>">
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</a></td>
			
			
			
			</tr>
				
			
			
	<%}else{ str1=listM.get(i); %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><a href="Admin?action=edit&event=2&id=<%=str1.substring(0,str1.lastIndexOf("|"))%>"><%=str1.substring(str1.lastIndexOf("|")+1)%></a></td>
			
			
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
		<TR class="row_title">
					<TH align="center" colspan=2><FONT SIZE="4" COLOR="#AA2504"
						face='verdana'>Account List</FONT>
					</TH>
				</TR>
		<%
		
		try{
		for(int i=0;i<listA.size();i++){	
		
			if(i==0){
			str1=listA.get(i);
			%>
			
			
			<TR class= "row_even">
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B> Name </B></th>
			
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><a href="Admin?action=edit&event=3&id=<%=str1.substring(0,str1.lastIndexOf("|"))%>">
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</a></td>
			
			
			
			</tr>
				
			
			
	<%}else{ str1=listA.get(i); %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><a href="Admin?action=edit&event=3&id=<%=str1.substring(0,str1.lastIndexOf("|"))%>"><%=str1.substring(str1.lastIndexOf("|")+1)%></a></td>
			
			
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
		<TR class="row_title">
					<TH align="center" colspan=2><FONT SIZE="4" COLOR="#AA2504"
						face='verdana'>Lob List</FONT>
					</TH>
				</TR>
		<%
		
		try{
		for(int i=0;i<listL.size();i++){	
		
			if(i==0){
			str1=listL.get(i);
			%>
			
			
			<TR class= "row_even">
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B> Name </B></th>
			
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><a href="Admin?action=edit&event=4&id=<%=str1.substring(0,str1.lastIndexOf("|"))%>">
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</a></td>
			
			
			
			</tr>
				
			
			
	<%}else{ str1=listL.get(i); %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><a href="Admin?action=edit&event=4&id=<%=str1.substring(0,str1.lastIndexOf("|"))%>"><%=str1.substring(str1.lastIndexOf("|")+1)%></a></td>
			
			
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
	
	<div id='userdiv'>		
		<table align="center" width="65%">
		<TR class="row_title">
					<TH align="center" colspan=3><FONT SIZE="4" COLOR="#AA2504"
						face='verdana'>User List</FONT>
					</TH>
				</TR>
		<%
		
		try{
			System.out.println("list U"+listU.toString());
		for(int i=0;i<listU.size();i++){	
	
			if(i==0){
			str1=listU.get(i);
			%>
			
			
			<TR class= "row_even">
			<th align="center" ><B>Sr. No. </B></th>
			<th align="center" ><B> Name </B></th>
			<th align="center" ><B>User Name </B></th>
			
			</tr>
			
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><a href="Admin?action=edit&event=5&id=<%=str1.substring(0,str1.indexOf("|"))%>">
			<%=str1.substring(str1.indexOf("|")+1,str1.lastIndexOf("|"))%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</a></td>
			
			<td align="center" ><a href="Admin?action=edit&event=5&id=<%=str1.substring(0,str1.lastIndexOf("|"))%>">
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</a></td>
			
			
			</tr>
				
			
			
	<%}else{ str1=listU.get(i); %>		
	
			<TR class= "row_odd">
<td align="center" ><B> <%=i+1%></B></td>
			<td align="center" ><a href="Admin?action=edit&event=5&id=<%=str1.substring(0,str1.indexOf("|"))%>"><%=str1.substring(str1.indexOf("|")+1,str1.lastIndexOf("|"))%></a></td>
			<td align="center" ><a href="Admin?action=edit&event=5&id=<%=str1.substring(0,str1.indexOf("|"))%>">
			<%=str1.substring(str1.lastIndexOf("|")+1)%>
<!--			<input type="button" class="myButton" value='Edit'>-->
			</a></td>
			
			
			</tr>


		<%
	}
		
		
		}
		
			%>	
				

				
	<%		
			
			
		
				if( listU.size()  == 0)	{%><P align=center>
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
	</FORM>
	</BODY>

</HTML>
 