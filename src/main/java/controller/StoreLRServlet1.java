package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/StoreLRServlet1.do")
public class StoreLRServlet1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public StoreLRServlet1() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 
			response.setContentType("text/html");		 
		  PrintWriter out = response.getWriter();
		 
		   
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");  // Loading the Driver
	        Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/ebookstore", "root", "#Daddy11");  
	        
			if (con != null) {
	            out.println("Connected to the database!");
	        } else {
	            out.println("Failed to make connection!");
	        }

	    }
		catch (SQLException e) 
		{
	        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	    } 
		catch (Exception e) 
		{
	        e.printStackTrace();
	    }
	}
 }

