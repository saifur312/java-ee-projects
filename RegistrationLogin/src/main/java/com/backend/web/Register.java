package com.backend.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // Forward the request to the JSP page
	    RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
	    rd.forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		String gender = req.getParameter("gender");
		String city = req.getParameter("city");
		
		try {
			/** connect to mysql database */
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/cruddb", "root", "");
			
			/** prepare insert query */
			PreparedStatement ps = con.prepareStatement("insert into register (name, email, password, gender, city) values(?,?,?,?,?)");
			/* set positional values */
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, gender);
			ps.setString(5, city);
			
			/** execute sql statement */
			int count = ps.executeUpdate();
			if(count > 0) {
				/** query execution success*/
				/* show success message as html format */
				resp.setContentType("text/html");
				out.print("<h3 style='color:green'>User registered successfull</h3>");
				
				/*provide output/response page, reload same page after submit*/
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}else {
				/** query does not execute */
				/* show error message in html format */
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>User registered unsuccessfull</h3>");
				
				/*provide output/response page, reload same page after submit*/
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Exception occured: " + e.getMessage() +"</h3>");
			
			/*provide output/response page, reload same page after submit*/
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
		}
		
		
		
		
	}
}
