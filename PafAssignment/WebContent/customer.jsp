<%@page import="service.CustomerService"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
 <style>
.content {
  max-width: 500px;
  margin: auto;
}
</style>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  border: 1px solid #e7e7e7;
  background-color: #f3f3f3;
}

li {
  float: left;
}

li a {
  display: block;
  color: #666;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #b3ccff;
}

li a.active {
  color: white;
  background-color: #002266;
}
</style>
        <title>Customer Details</title>
			<link rel="stylesheet" href="Views/bootstrap.min.css">
			<script src="Components/jquery-3.2.1.min.js"></script>
			<script src="Components/customer.js"></script>
			  
</head>
			<body>
			<!-- Navigation Bar -->
			<ul>
  <li><a class="active" href="#">GadgetBadget Home</a></li>
  <li><a href="#">My Account</a></li>
  <li><a href="#">Cart</a></li>
  <li><a href="#">About Us</a></li>
  <li style="float:right"><a href="#StaffLogin">StaffLogin</a></li>
</ul><br><br>
		<div class="content">
		
		<fieldset>

			<legend>
				<b>Add Customer Details</b>
			</legend>
		<form id="formCustomer" name="formCustomer" method="post" action="customer.jsp">
 				Name: 
				<input id="customerName" name="customerName" type="text" 
 				class="form-control form-control-sm">
		   <br> Phone Number: 
			    <input id="customerPhone" name="customerPhone" type="text" 
 				class="form-control form-control-sm">
		   <br> Email Address: 
				<input id="customerEmail" name="customerEmail" type="text" 
 				class="form-control form-control-sm">
		   <br> User Name: 
				<input id="customerUsername" name="customerUsername" type="text" 
 				class="form-control form-control-sm">
		   <br> Password: 
				<input id="customerPassword" name="customerPassword" type="text" 
 				class="form-control form-control-sm">
		   <br>
<input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
<input type="hidden" id="hidCustomerIDSave" name="hidCustomerIDSave" value="">
</form><br><br>

	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
	</fieldset>

	<br>
	<br>
	<div class="container" id="CustomersGrid">
		<fieldset>
			<legend>
				<b>View Customer Details</b>
			</legend>
			<form method="post" action="customer.jsp" class="table table-striped">
				<%
					Customer viewCustomer = new Customer();
					out.print(viewCustomer.readCustomer());
				%>
			</form>
			<br>
		</fieldset>
	</div>
	</div>

    </body>
</html>
