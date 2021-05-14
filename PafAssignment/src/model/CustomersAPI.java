package model;

import service.CustomerService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomersAPI
 */
@WebServlet("/CustomersAPI")
public class CustomersAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Customer customerObj = new Customer();
	
    public CustomersAPI() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String outputString = customerObj.insertCustomer(request.getParameter("customerName"), 
				request.getParameter("customerPhone"),
				request.getParameter("customerEmail"), 
				request.getParameter("customerUsername"), 
				request.getParameter("customerPassword"));
				

		response.getWriter().write(outputString);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
        
        
		String outputString = customerObj.updateCustomer(
				paras.get("customerID").toString(),
				paras.get("customerName").toString(),
				paras.get("customerPhone").toString(),
				paras.get("customerEmail").toString(), 
				paras.get("customerUsername").toString(),
				paras.get("customerPassword").toString());
				

		response.getWriter().write(outputString);
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		String output = customerObj.deleteCustomer(paras.get("customerID").toString());
		response.getWriter().write(output);
		
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {			
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
			
		} catch (Exception e) {
		  }
		
		return map;
	}

}
