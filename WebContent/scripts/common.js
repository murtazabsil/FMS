/**
 * This File Contains Logic which is common on all pages. 
 */
var projectId = 0;
$(document).ready(function(){
	$('#pop-up-container').dialog({
	      autoOpen: false,
	      modal:true,
	      height:140,
	      width:445,
	    });
	$('.link-manager').click(function(){
		projectId = $(this).attr('id');
		$('#pop-up-container').dialog("open");
	});
	$('#manager-link-button').click(function(){
		var action = "action=linkmanager";
		var managerId = $('manager-project-id').val();
		var url = $('context-path').val() + "/Admin?"+action+"&managerId="+managerId+"&projectId="+projectId;
		$.ajax({
			url:url,
			success:function(data){
				$('#pop-up-container').dialog("close");
				alert('Saved Successfully!!!!');
			},
			error:function(error){
				$('#pop-up-container').dialog("close");
				alert('Error while saving.....');
			},
		});
	});
});