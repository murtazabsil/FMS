function ChkMandatoryField(F,T){
			
			var val= F.value;
			
			if(val==""){alert(T+" is mandatory");return false;}
		}
		function ChkNumField(F,T){
			var val = F.value;
			if(isNaN(val)==true||val==""){alert("Please enter numbers for "+T);return false;}
		}
		function ChkAlphaNumericField(F,T){
			var val = F.value;
			var pattern = /^([a-zA-Z0-9]{1,250})$/;
			if(!(pattern.test(val)==true)){alert("Please enter alphabets or numbers for "+T);return false;}
		}
		function ChkAlphaField(F,T){
			var val = F.value;
			var pattern = /^([a-zA-Z ]{1,250})$/;
			if(!(pattern.test(val)==true)){alert("Please enter text for "+T);return false;}
		}
		function ChkEmailField(F,T){
			var val = F.value;
			var pattern = /^([a-zA-Z0-9\_\.]{4,25})$/;
			if(!(pattern.test(val)==true)){alert("Please enter valid email for "+T);return false;}
		}
		function ChkDateField(F,T)
		{
			var val = F.value;
		    var pattern = /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
		    if(!(pattern.test(val)==true)){alert("Please enter valid date format (yyyy-mm-dd) for "+T);return false;}
		}
		
function ChkDropDownField(F,T){
			
			var val= F.value;
			
			if(val==""){alert("Please select "+T);return false;}
		}
		
function ChkDateField(F,T){
	
	var val= F.value;
	
	if(val==""){alert("Please select  "+T+" date");return false;}
}

function DateCheck()
{
	alert('DateCheck ');
	var StartDate= document.getElementById('startdate').value;
  var EndDate= document.getElementById('enddate').value;
  alert('StartDate '+StartDate);
  alert('enddate '+EndDate);
  var eDate = Date.parse(EndDate);
  var sDate = Date.parse(StartDate);
  alert('eDate '+eDate);
  alert('sDate '+sDate);
  if(StartDate!= '' && EndDate!= '' && sDate> eDate)
    {
    alert("Please ensure that the End Date is greater than or equal to the Start Date.");
    return false;
    }
}





function loadContent(str,urlval)
{
//alert('urlVal--'+urlval);
 xmlhttp=GetXmlHttpObject();
 //alert('url---'+urlval);
  if (xmlhttp==null)
  {
   alert ("Your browser does not support Ajax HTTP");
   return;
  }

    var url=urlval;
    url=url+"&q="+str;
    //alert('urlVal--'+url);
    xmlhttp.onreadystatechange=getOutput;
    xmlhttp.open("GET",url,true);
    xmlhttp.send(null);
}

function getOutput()
{
  if (xmlhttp.readyState==4)
  {
  document.getElementById("prtCnt").innerHTML=xmlhttp.responseText;
  }
}

function GetXmlHttpObject()
{
    if (window.XMLHttpRequest)
    {
       return new XMLHttpRequest();
    }
    if (window.ActiveXObject)
    {
      return new ActiveXObject("Microsoft.XMLHTTP");
    }
 return null;
}
