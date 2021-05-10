//hide alert
$(document).ready(function() {

	$("#alertSuccess").hide();
	$("#alertError").hide();
	$("#hidCustomerIDSave").val("");
	$("#CUSTOMER")[0].reset();
});

$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	
	// If valid------------------------
	var type = ($("#hidCustomerIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "CustomersAPI",
		type : type,
		data : $("#CUSTOMER").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onCustomerSaveComplete(response.responseText, status);
		}
	});

});

function onCustomerSaveComplete(response, status) {
	
	if (status == "success") {
		
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success") {
			
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#CustomersGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error") {
			
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} 
	else if (status == "error") {
		
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
		
	} else {
		
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	
	$("#hidCustomerIDSave").val("");
	$("#CUSTOMER")[0].reset();
}

$(document).on("click", ".btnDelete", function(event) {
	
	$.ajax({
		url : "CustomersAPI",
		type : "DELETE",
		data : "customerID=" + $(this).data("customerID"),
		dataType : "text",
		complete : function(response, status) {
			onCustomerDeleteComplete(response.responseText, status);
		}
	});
});

function onCustomerDeleteComplete(response, status) {
	
	if (status == "success") {
		
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success") {
			
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#CustomersGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error") {
			
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		
	} else if (status == "error") {
		
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
		
	} else {
		
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event)
		{
			$("#hidCustomerIDSave").val($(this).data("customerID"));
			$("#customerName").val($(this).closest("tr").find('td:eq(0)').text());
			$("#customerPhone").val($(this).closest("tr").find('td:eq(1)').text());
			$("#customerEmail").val($(this).closest("tr").find('td:eq(2)').text());
			$("#customerUsername").val($(this).closest("tr").find('td:eq(3)').text());
			$("#customerPassword").val($(this).closest("tr").find('td:eq(4)').text());
				
		});


// CLIENTMODEL=========================================================================
function validateItemForm() {
	
	// Name
	if ($("#customerName").val().trim() == "") {
		return "Please insert customerName.";
	}
	
	// phone
	if ($("#customerPhone").val().trim() == "") {
		return "Please insert customerPhone.";
	}
	
	// email
	if ($("#customerEmail").val().trim() == "") {
		return "Please insert customerEmail.";
	}

	// username
	if ($("#customerUsername").val().trim() == "") {
		return "Please insert customerUsername.";
	}
	
	// password
	if ($("#customerPassword").val().trim() == "") {
		return "Please insert customerPassword.";
	}
	
	
	return true;
}