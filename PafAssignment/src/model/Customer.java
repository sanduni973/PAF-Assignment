package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class Customer {
	
	public Connection connect()
	{
		Connection con=null;
		try
		{
			//creating database connection
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/abc", "root", "root1234"); 
			System.out.print("Successfully connected"); 
			
			
		}
		catch(Exception e)
		{
			System.out.print("error");
			e.printStackTrace(); 
		}
		return con;
	}

	public String insertCustomer(String customerName, String customerPhone, String customerEmail, String customerUsername, String customerPassword)
	{
		String output = "";
		
		try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for the insert operation."; } 
		 
		 // create query
		 // create a prepared statement and insert values into the customer table 
		 String query ="insert into customer values(?,?,?,?,?,?)";
		 
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 
		 //binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, customerName); 
		 preparedStmt.setString(3, customerPhone); 
		 preparedStmt.setString(4, customerEmail); 
		 preparedStmt.setString(5, customerUsername); 
		 preparedStmt.setString(6, customerPassword); 
		 
		 preparedStmt.execute();
		 con.close();

		 String newCustomer = readCustomer(); 
		 output = "{\"status\":\"success\", \"data\": \"" + 
		 newCustomer + "\"}"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "{\"status\":\"error\", \"data\": \"Error while inserting the customer.\"}"; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 }
	
	//retrieve query
	//retrieving records into the grid view
	public String readCustomer() {
		
		String output = "";
		try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 { 
		 return "Error while connecting to the database for reading."; 
		 } 
		 
		 //prepare the html table
		 output = "<table border='1'><tr><th>Customer ID</th>" 
		 +"<th>Customer Name</th>"
		 +"<th>Customer Phone</th>"
		 +"<th>Customer Email</th>"
		 + "<th>Customer Username</th>" 
		 + "<th>Customer Password</th>" 
		 + "<th>Update</th><th>Delete</th></tr>"; 
		 
		 String query = "select * from customer"; 
		 Statement stmt = con.createStatement(); 
		 ResultSet rs = stmt.executeQuery(query); 
		 
		// iterate through the rows in the result set
		 while (rs.next()) 
		 { 
		 
		 String customerID = Integer.toString(rs.getInt("customerID")); 
		 String customerName = rs.getString("customerName"); 
		 String customerPhone = rs.getString("customerPhone");
		 String customerEmail = rs.getString("customerEmail");
		 String customerUsername = rs.getString("customerUsername");
		 String customerPassword = rs.getString("customerPassword");
		 

		//output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='"+ customerID +"'></td>";
		// Add into the html table
	//	 output += "<tr><td><input id='hidcustomerIDUpdate'   value='" + customerID +"'></td>";
	     output += "<td>" + customerID + "</td>";
		 output += "<td>" + customerName + "</td>";
		 output += "<td>" + customerPhone + "</td>";
		 output += "<td>" + customerEmail + "</td>";
		 output += "<td>" + customerUsername + "</td>";
		 output += "<td>" + customerPassword + "</td>";
				 
		 
		 //creating action buttons
		 output += "<td><input name='btnUpdate' " 
				 + " type='button' value='Update'class='btnUpdate btn btn-secondary' data-customerid='" + customerID + "'></td>"
				 + "<td><form method='post' action='customers.jsp'>"
				 + "<input name='btnDelete' " 
				 + " type='button' value='Delete' class='btn btn-danger' data-customerid='" + customerID + "'></td></tr>"; 
		 
		
	}
		 con.close(); 
		 // Complete the html table
		 output += "</table>"; 
		 } 
		catch (Exception e) 
		 { 
		 output = "Error while reading the items."; 
		 System.err.println(e.getMessage()); 
		 } 
		return output; 

  }	 	    
	//update query
	//update the records in the table
	public String updateCustomer(String customerID, String customerName,String customerPhone, String customerEmail, String customerUsername, String customerPassword)
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {
		 return "Error while connecting to the database for the update operation."; 
	 } 
	 
	
	 // create a prepared statement
	 String query = "UPDATE customer SET customerName=?,customerPhone=?,customerEmail=?,customerUsername=?,customerPassword=? WHERE customerID=?"; 
	 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	 //binding values
	 preparedStmt.setString(1, customerName); 
	 preparedStmt.setString(2, customerPhone); 
	 preparedStmt.setString(3, customerEmail);  
	 preparedStmt.setString(4, customerUsername); 
	 preparedStmt.setString(5, customerPassword); 
	 preparedStmt.setInt(6, Integer.parseInt(customerID)); 
	 
	 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 
	 String newCustomer = readCustomer(); 
	 output = "{\"status\":\"success\", \"data\": \"" + 
	 newCustomer + "\"}"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "{\"status\":\"error\", \"data\": \"Error while updating the customer.\"}"; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	
	//delete query
	public String deleteCustomer(String customerID) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for the delete operation"; } 
	 
	 // create a prepared statement
	 String query = "delete from customer where customerID=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(customerID));
	 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close();
	 
	 String newCustomer = readCustomer(); 
	 output = "{\"status\":\"success\", \"data\": \"" + 
	 newCustomer + "\"}"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "{\"status\":\"error\", \"data\": \"Error while deleting the customer.\"}"; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	 

	 
}

