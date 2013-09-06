<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*,com.bluestar.fms.vo.*,com.bluestar.fms.bso.*,java.util.*" %>
<%String UserID="";%>

<HTML>
<head>
		<LINK href="css/styles.css" type="text/css" rel="stylesheet">
		<script LANGUAGE="Javascript" SRC="Images/calender.js"></script>
		<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>
		<script LANGUAGE="Javascript" SRC="Images/AjaxCall.js"></script>

<script LANGUAGE="Javascript" >
		function ChkMandatoryField(F,T){
			var val= F.value;
			alert('this is val==='+val);
			if(val==""){alert(T+" is mandatory");return false;}
		}
		function ChkNumField(F,T){
			var val = F.value;
			if(isNaN(val)==true||val==""){alert("Please enter numbers for "+T);return false;}
		}
		function DoPassWordValidation()
			{
			  var frm = document.forms(0);
			  if(frm.upassword.value != frm.retypepassword.value)
			  {
				alert('The Password and verified password does not match');
				frm.upassword.value='';
				frm.retypepassword.value='';
				return false;
			  }
			  else
			  {
				return true;
			  }
			}
		function ChkEmailField(F,T){
			var val = F.value;
			var pattern = /^[a-zA-Z0-9\_\.]+\@[a-zA-Z\.]+\.([a-z]{2,4})$/;
			if(!(pattern.test(val)==true)){alert("Please enter valid email for "+T);return false;}
		}
		function validate()
		{		
			alert(" validate 1");
			var frm = document.forms[0];
			//	MemberFee();
			var event = document.getElementById('event').value;
			if(event == null && event ==''){
			    if(ChkMandatoryField(frm.UserID,'User Id')==false) return false;
				var divObj = document.getElementById("nameid");
				alert(" validate 2");
				/*var Msg = divObj.innerHTML;
				if(Msg.indexOf("not available")>-1){
					alert("User name not available. Please choose another");
					frm.UserID.value="";
				}*/
				//not available
				if(ChkMandatoryField(frm.upassword,'password')==false) return false;
			    if(ChkMandatoryField(frm.retypepassword,'Re type password')==false) return false;
			}
			  //  if(DoPassWordValidation()==false) return false;
				if(ChkMandatoryField(frm.FirstName,'First Name')==false) return false;
			    if(ChkMandatoryField(frm.EmpId,'EmpId')==false) return false;
			//    if(ChkNumField(frm.EmpId,'EmpId')==false) return false;
			alert(" validate 3");
				if(ChkMandatoryField(frm.EmailAddress,'Email')==false) return false;
			    if(ChkEmailField(frm.EmailAddress,'Email')==false) return false;
				if(ChkMandatoryField(frm.Address,'Address')==false) return false;
				alert(" validate 4");
			    if(ChkMandatoryField(frm.ContactNumber,'Contact Number')==false) return false;
			    if(ChkMandatoryField(frm.designation,'designation')==false) return false;
			    if(ChkMandatoryField(frm.userType,'User Type')==false) return false;
			    alert(" validate 5");
			 //  	if(ChkMandatoryField(frm.AmountDeposited,'AmountDeposited ')==false) return false;
			//	if(ChkMandatoryField(frm.cardnum,'cardnum')==false) return false;
			//	if(ChkMandatoryField(frm.pin,'pin')==false) return false;
		//		if(ChkNumField(frm.cardnum,'Credit Card Number')==false) return false;
			   alert('after all validation');
			    document.getElementById('addmodule').value = "user";
				alert('addmodule---'+document.getElementById('addmodule').value);
				alert('after end validation');
		}
function MemberFee(){
			frm = document.forms(0);
			T= frm.MemberType.value;
			//alert(T);
			if(T=="Silver"){
			Amount=5000;
			
			}else if(T=="Gold"){
				
			Amount=10000;
			}else if(T=="Platinum"){
				
			Amount=15000;
			}
			
			//alert(Amount);
			frm.AmountDeposited.value =Amount;
			
		}

function fnCallChkAvailability(U)
	{
		var UserID = U.value;
		var divObj = document.getElementById("nameid");
		URL = "ChkUser.jsp?UserID="+UserID;
		ajaxFunction(URL,divObj);
	}
	</script>

<BODY  Class="SC">
<%
	LoginBSO loginBSO = new LoginBSOImpl();
	List<UserTypeVO> listUserType =  loginBSO.getUserType();
	
	UserVO userVO = (UserVO)request.getAttribute("detail");
	String event = (String) request.getAttribute("event");
	System.out.println(" event  in user edit jsp------------"+event);
	String designation = "";
	List<String> designationList = new ArrayList<String>();
	designationList.add("1|LOB Head");
	designationList.add("2|Account Head");
	designationList.add("3|Project Manager");
	
	if(event == null){
	%>
	
<h3 align=center>New User Registration</h3>
<%}else{ 
	designation = userVO.getDesignation()+"";
%>
<h3 align=center>Edit User </h3>
<%} %>
<!--<table align=right>-->
<!--<P align=right><A href="Login.jsp"><IMG SRC="Images/Login.jpg" WIDTH="106" HEIGHT="26" BORDER="0" ALT=""></A>-->
<!--<td><h6>If you are already a member</h6></td>-->
<!--</table>-->
<FORM NAME="RegUser" ACTION="Admin" onsubmit="return validate();">
	<input type='hidden' id='event' name ='event' value='<%=event%>'>
 <center>
 <TABLE width="60%">
	
<TR class="row_title">
	<%if(event == null){
	%>
	
	<Td align=center colspan='2'> New User Details<BR></Td>
<%}else{ %>
	<Td align=center colspan='2'> Edit User Details<BR></Td>
<%} %>

</TR>
		        <TR class=row_even><TH align="left">First Name
		<FONT COLOR="red">*</TH>
		<TD class=row_odd>&nbsp;&nbsp;<Input type="text"  name='FirstName' value='<%= userVO != null && userVO.getFirstName()!= null?userVO.getFirstName():"" %>'>
		</TR>

		<TR class=row_even><TH align="left">Last Name</TH>
		<TD class=row_odd>&nbsp;&nbsp;<Input type="text"  name='LastName' value='<%=userVO != null && userVO.getLastName()!= null?userVO.getLastName():"" %>'>
		</TR>

		<TR class=row_even><TH align="left">Employee Id</TH>
		<TD class=row_odd>&nbsp;&nbsp;<Input type="text"  name='EmpId' value='<%=userVO != null && userVO.getEmpId()!= null?userVO.getEmpId():"" %>'>
		</TR>
		<TR class=row_even><TH align="left">Email Address
		<FONT COLOR="red">*</TH>
		<TD class=row_odd>&nbsp;&nbsp;<Input type="text"  name='EmailAddress' value='<%=userVO != null && userVO.getEmailAddress()!= null?userVO.getEmailAddress():"" %>'>
		</TR>
		
		
		<TR class=row_even><TH align="left">Designation
		<FONT COLOR="red">*</TH>
		<TD class=row_odd>&nbsp;&nbsp;<SELECT
					id="designation" name='designation' >
						<OPTION Value="">Select</OPTION>
	<%
										
						for(String str :designationList){
							
						if(str.substring(0,str.lastIndexOf("|")).equals(designation)){
								
								
												%><OPTION Value=<%=str.substring(0,str.lastIndexOf("|"))%> selected="selected"><%=str.substring(str.lastIndexOf("|")+1)%></OPTION>
												<%}else  %>
												
												<OPTION Value=<%=str.substring(0,str.lastIndexOf("|"))%> ><%=str.substring(str.lastIndexOf("|")+1)%></OPTION>
													<%
												
											}
	%>
					
							</SELECT>
							</TD>
		</TR>

<TR class=row_even><TH align="left">Address
		<FONT COLOR="red">*</FONT></TH>
		<TD class=row_odd>&nbsp;&nbsp;<textarea name="Address" value='<%=userVO != null && userVO.getAddress()!= null?userVO.getAddress():""%>'></textarea>
		</TR>
		<TR class=row_even><TH align="left">Contact Number
		<FONT COLOR="red">*</TH>
		<TD class=row_odd>&nbsp;&nbsp;<Input type="text"  name='ContactNumber' value='<%=userVO != null && userVO.getContactNumber()!= null?userVO.getContactNumber():"" %>'>
		</TR>

<%if(event == null ) { %>
<TR class=row_even><TH align="left">Choose User Name
		<FONT COLOR="red">*</TH>
		<TD class=row_odd>&nbsp;&nbsp;<Input type=text name='UserID' value='' onchange='fnCallChkAvailability(this)'>
		<div id='nameid'></div>
		</TD>
		</TR>
		
		<TR class=row_even><TH align="left">Password
		<FONT COLOR="red">*</TH>
		<TD class=row_odd>&nbsp;&nbsp;<Input type='password' name='upassword'  value=''>
		</TR>

		<TR class=row_even><TH align="left">ReType Password
		<FONT COLOR="red">*</TH>
		<TD class=row_odd>&nbsp;&nbsp;<Input type='password' name='retypepassword'  value=''>
		</TR>
<%} else{%>
<input type="hidden" name='loginvo' id='loginvo' value = '<%= userVO.getLoginVO()%>' >
<input type="hidden" name='regid' id='regid' value = '<%= userVO.getRegID()%>' >
<input type="hidden" name='uidhid' id='uidhid' value = '<%= userVO.getUserName()%>' >
<%} %>
<TR class="row_even">
				<TH align="left">User Type</TH>
				<TD class="row_odd">&nbsp;&nbsp;<SELECT
					id="userType" name='userType' >
						<OPTION Value="">Select</OPTION>

						<%
	try{
		
		
				for(UserTypeVO userTypeVO :listUserType){
					if( userVO != null && userTypeVO.getUserTypeId() == userVO.getUserType())
					{
					%><OPTION Value=<%=userTypeVO.getUserTypeId()%> selected="selected"><%=userTypeVO.getUserType()%></OPTION>
						<%
					}else{
						%><OPTION Value=<%=userTypeVO.getUserTypeId()%> ><%=userTypeVO.getUserType()%></OPTION>
						<%
					}
				}
		}catch(Exception e){%><%=e%>
						<%}
%>
<!--	    -->
<!--		<TR class=row_even><TH align="left">Credit Card Number-->
<!--		<FONT COLOR="red">*</TH>-->
<!--		<TD class=row_odd>&nbsp;&nbsp;<Input type="text"  name='cardnum' value=''>-->
<!--		</TR>-->
<!---->
<!--		<TR class=row_even><TH align="left">PIN-->
<!--		<FONT COLOR="red">*</TH>-->
<!--		<TD class=row_odd>&nbsp;&nbsp;<Input type="password"  name='pin' value=''>-->
<!--		</TR>-->
<!---->
<!--		<TR class=row_even><TH align="left">AmountDeposited-->
<!--		<FONT COLOR="red">*</TH>-->
<!--		<TD class=row_odd>&nbsp;&nbsp;<Input type="text"  name='AmountDeposited' value='' readonly>-->
<!--		</TR>-->
	        <TR>
		<TH><INPUT TYPE="submit" value='Submit'></TH>
		<TH><INPUT TYPE="reset" value='Clear'></TH></TR>
		</TABLE>
		<input type='hidden' name="addmodule" id="addmodule">
</FORM>

</BODY>
</HEAD>
</HTML>