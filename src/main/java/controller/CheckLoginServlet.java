package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/CheckLoginServlet.do")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CheckLoginServlet() {
        super();
        
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		long id = Long.parseLong(request.getParameter("uid"));		
		String ro = request.getParameter("role");
		String pw = request.getParameter("pwd");
	 
		String  url = "jdbc:mysql://localhost:3306/ebookstore";
		 String dbuser   = "root";
		 String dbuserpw = "#Daddy11";	
		 Connection Con = null;
		 response.setContentType("text/html");
		 
		  PrintWriter out = response.getWriter();
		try 
		{
			Con = DriverManager.getConnection( url, dbuser, dbuserpw);
			String  q      = "select * from  userlogin where uid= ? and pwd=? and role=?";
			PreparedStatement   Pstobj  = Con.prepareStatement(q);
			
			Pstobj.setLong(1, id);
			Pstobj.setString(2, pw);
			Pstobj.setString(3, ro);
			ResultSet RS =  Pstobj.executeQuery();
			if (RS.next())
			{
				out.println("You are logged in Successfully..");
				if (ro.equals("Admin"))
				{
					RequestDispatcher RD = request.getRequestDispatcher("adminPage.jsp");
					RD.forward(request, response);
				}
				 else if (ro.equals("Customer"))				 
				{
					if(RS.getString("reg_status").equals("waiting"))
					{ 
					request.setAttribute("LRAF", "Your Login Registration not yet approved by Admin");
					RequestDispatcher RD = request.getRequestDispatcher("index.jsp");
					RD.forward(request, response);
					}
					else
					{
						request.setAttribute("LS", "success");
						RequestDispatcher RD = request.getRequestDispatcher("ViewBuyBooks.jsp");
						RD.forward(request, response);						
					}					
				}
				
				//out.println("You are log in Details valid");
				//out.println("<a href='index.jsp'> Home Page </a>");			 	 
			}
			else
			{
				request.setAttribute("LErr", "Your log in Details are invalid");
				RequestDispatcher RD1 = request.getRequestDispatcher("login.jsp");
				RD1.forward(request, response);
			}
		}
		catch(Exception e)
		{
			
		}
		
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
