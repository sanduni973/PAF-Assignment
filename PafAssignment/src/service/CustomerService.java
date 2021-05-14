package service;

//For REST Service
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Customer;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Customer") 
public class CustomerService 
{ 
	Customer customerObj = new Customer(); 
	
@GET
@Path("/") 
@Produces(MediaType.TEXT_HTML) 
public String readCustomers() 
{ 
	return customerObj.readCustomer(); 
} 

//insert operation
@POST
@Path("/") 
@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
@Produces(MediaType.TEXT_PLAIN) 
public String insertCustomer(@FormParam("customerName") String customerName, 
 @FormParam("customerPhone") String customerPhone, 
 @FormParam("customerEmail") String customerEmail, 
 @FormParam("customerUsername") String customerUsername, 
 @FormParam("customerPassword") String customerPassword) 
{ 
 String output = customerObj.insertCustomer(customerName, customerPhone,customerEmail, customerUsername, customerPassword); 
return output; 
}

//update operation
@PUT
@Path("/") 
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.TEXT_PLAIN) 
public String updateCustomer(String customerData) 
{ 
//Convert the input string to a JSON object 
 JsonObject customerObject = new JsonParser().parse(customerData).getAsJsonObject(); 
//Read the values from the JSON object
 String customerID = customerObject.get("customerID").getAsString(); 
 String customerName = customerObject.get("customerName").getAsString(); 
 String customerPhone = customerObject.get("customerPhone").getAsString(); 
 String customerEmail = customerObject.get("customerEmail").getAsString(); 
 String customerUsername = customerObject.get("customerUsername").getAsString(); 
 String customerPassword = customerObject.get("customerPassword").getAsString(); 
 
 String output = customerObj.updateCustomer(customerID, customerName, customerPhone, customerEmail,customerUsername, customerPassword); 
return output; 
}

//delete operation
@DELETE
@Path("/") 
@Consumes(MediaType.APPLICATION_XML) 
@Produces(MediaType.TEXT_PLAIN) 
public String deleteCustomer(String customerData) 
{ 
//Convert the input string to an XML document
 Document doc = Jsoup.parse(customerData, "", Parser.xmlParser()); 
 
//Read the value from the element <customerID>
 String customerID = doc.select("customerID").text(); 
 String output = customerObj.deleteCustomer(customerID); 
return output; 
}
}
