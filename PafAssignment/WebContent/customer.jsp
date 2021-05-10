<%@page import="com.CustomerService"%>
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
<input type="hidden" id="hidcustomerIDSave" name="hidcustomerIDSave" value="">
</form><br><br>

	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
	</fieldset>

	<br>
	<br>
<div id="divCustomersGrid">
          <%
               Customer customerObj = new Customer(); 
               out.print(customerObj.readCustomers()); 
          %>
</div>
</div> </div> </div> 



</body>
        
        <!-- Footer-------------------------------------------------------------------------------->
        <footer class="py-5 s footer">
          <div class="container-fluid">
              
            <div class="row" >
              <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="card" style="background-color: black;">
                  <div class="card-body">
                    <h5 class="card-title" style="color:white; font-weight: bolder; font-size: 3.5rem;"></h5>
                    <p class="card-text" style="color: white; font-size: 1rem;"><span style="font-weight: bolder;color: yellow;">
                      </p>
                      
                  
        
                  </div>
                </div>
              </div>
  
              <div class="col-lg-6 col-md-12 col-sm-12">
  
                <img class="d-block img-fluid footer-gb" src="images/gb.jpg"/>
              
              </div>
  
          </div>
          
          </div>
         
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/341a24681e.js" crossorigin="anonymous"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script src="javaScript/index.js"></script>
        
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>
