/**
 * This File Contains Logic which is common on all pages.
 */
var projectId = 0;
$(document)
		.ready(
				function() {
					$('#pop-up-container').dialog({
						autoOpen : false,
						modal : true,
						height : 140,
						width : 445,
					});
					$('.link-manager').click(function() {
						projectId = $(this).attr('id');
						$('#pop-up-container').dialog("open");
					});
					$('#manager-link-button').click(
							function() {
								var action = "action=linkmanager";
								var managerId = $('#manager-project-id').val();
								var url = $('#context-path').val() + "/Admin?"
										+ action + "&managerId=" + managerId
										+ "&projectId=" + projectId;
								$.ajax({
									url : url,
									success : function(data) {
										$('#pop-up-container').dialog("close");
										alert('Saved Successfully!!!!');
									},
									error : function(error) {
										$('#pop-up-container').dialog("close");
										alert('Error while saving.....');
									},
								});
							});

					$('#compare-select').bind('change', function() {
						if ($(this).val() === "1") {
							$('#actual-tr').hide();
							$('#forecast-tr').show();
						} else {
							$('#actual-tr').show();
							$('#forecast-tr').hide();
						}
					});

					$('#project1')
							.bind(
									'change',
									function() {
										if ($('#project1').val() !== "0") {
											/* Update forecast options */
											var url = $('#context-path').val()
													+ "/ForecastServlet?requestFrom=forecastListFromProjectId&projectId="
													+ $('#project1').val();
											ajaxCall("GET", url, '',
													'createForecastoption1');
											/* Update actual options */
											var url = $('#context-path').val()
													+ "/ActualServlet?requestFrom=actualListFromProjectId&projectId="
													+ $('#project1').val();
											ajaxCall("GET", url, '',
													'createActualoption1');
										} else {

										}
									});

					$('#project2')
							.bind(
									'change',
									function() {
										if ($('#project2').val() !== "0") {
											/* Update forecast options */
											var url = $('#context-path').val()
													+ "/ForecastServlet?requestFrom=forecastListFromProjectId&projectId="
													+ $('#project2').val();
											ajaxCall("GET", url, '',
													'createForecastoption2');

											/* Update actual options */
											var url = $('#context-path').val()
													+ "/ActualServlet?requestFrom=actualListFromProjectId&projectId="
													+ $('#project1').val();
											ajaxCall("GET", url, '',
													'createActualoption2');
										} else {

										}
									});

					$('#compare-forecast')
							.bind(
									'click',
									function() {
										if ($('#select-forecast-1').val() === "0") {
											alert('Please select Forecast on left side to compare.');
											return false;
										}
										if ($('#select-forecast-2').val() === "0") {
											alert('Please select Forecast on right side to compare.');
											return false;
										}

										if ($('#select-forecast-1').val() === $(
												'#select-forecast-2').val()) {
											alert('You are comparing same forecast.');
											return false;
										}

										/* Ajax to get Forecast on left side */
										var url = $('#context-path').val()
												+ "/ForecastServlet?requestFrom=ForecastForCompare&forecastId="
												+ $('#select-forecast-1').val();
										ajaxCall("GET", url, '',
												'compareForecast1');

										/* Ajax to get Forecast on left side */
										var url = $('#context-path').val()
												+ "/ForecastServlet?requestFrom=ForecastForCompare&forecastId="
												+ $('#select-forecast-2').val();
										ajaxCall("GET", url, '',
												'compareForecast2');
									});

					$('#compare-actual')
							.bind(
									'click',
									function() {
										if ($('#select-actual-1').val() === "0") {
											alert('Please select Actual left side to compare.');
											return false;
										}
										if ($('#select-actual-2').val() === "0") {
											alert('Please select Actual on right side to compare.');
											return false;
										}

										if ($('#select-actual-1').val() === $(
												'#select-actual-2').val()) {
											alert('You are comparing same actual.');
											return false;
										}

										/* Ajax to get actual on left side */
										var url = $('#context-path').val()
												+ "/ActualServlet?requestFrom=actualForCompare&actualId="
												+ $('#select-actual-1').val();
										ajaxCall("GET", url, '',
												'compareActual1');

										/* Ajax to get actual on left side */
										var url = $('#context-path').val()
												+ "/ActualServlet?requestFrom=actualForCompare&actualId="
												+ $('#select-actual-2').val();
										ajaxCall("GET", url, '',
												'compareActual2');
									});
				});

function ajaxCall(method, url, data, callback) {
	$.ajax({
		type : method,
		url : url,
		data : data,
		dataType : "json",
		success : function(result) {
			if (callback === "createForecastoption1") {
				createForecastOption("1", result);
			} else if (callback === "createForecastoption2") {
				createForecastOption("2", result);
			}

			if (callback === "createActualoption1") {
				createActualoption("1", result);
			} else if (callback === "createActualoption2") {
				createActualoption("2", result);
			}

			if (callback === "compareForecast1") {
				compareForecast("1", result);
			} else if (callback === "compareForecast2") {
				compareForecast("2", result);
			}

			if (callback === "compareActual1") {
				compareActual("1", result);
			} else if (callback === "compareActual2") {
				compareActual("2", result);
			}
		},
		error : function(error) {
			console.log(error);
		},
	});
}

function createForecastOption(option, data) {
	if ($.isEmptyObject(data) && $("#forecast-tr").css('display') !== "none") {
		alert('This project has no forecast. Please select another project.');
		$('#project' + option).val("0");
		return false;
	}
	var options = '<option value="0">Select Forecast</option>';
	$.each(data, function(index) {
		options = options + '<option value="' + index + '">' + data[index]
				+ '</option>';
	});
	$("#select-forecast-" + option).html('');
	$("#select-forecast-" + option).html(options);
}

function createActualoption(option, data) {
	if ($.isEmptyObject(data) && $("#actual-tr").css('display') !== "none") {
		alert('This project has no actual. Please select another project.');
		$('#project' + option).val("0");
		return false;
	}
	var options = '<option value="0">Select Actual</option>';
	$.each(data, function(index) {
		options = options + '<option value="' + index + '">' + data[index]
				+ '</option>';
	});
	$("#select-actual-" + option).html('');
	$("#select-actual-" + option).html(options);

}

function compareForecast(option, data) {
	if ($.isEmptyObject(data)) {
		alert("Monthly data is not Added.");
		return false;
	}
	$('#compare' + option).find(
			'#1, #2, #3, #4, #5, #6, #7, #8, #9, #10, #11, #12').html('');
	$.each(data, function(index) {
		$('#compare' + option + ' #' + index).html(data[index]);
	});
}

function compareActual(option, data) {
	if ($.isEmptyObject(data)) {
		alert("Monthly data is not Added.");
		return false;
	}
	$('#compare' + option).find(
			'#1, #2, #3, #4, #5, #6, #7, #8, #9, #10, #11, #12').html('');
	$.each(data, function(index) {
		$('#compare' + option + ' #' + index).html(data[index]);
	});
}
