package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/ApprovalLoginServlet.view")
public class ApprovalLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ApprovalLoginServlet() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String  url = "jdbc:mysql://localhost:3306/ebookstore";
		 String dbuser   = "root";
		 String dbuserpw = "#Daddy11";	
		 Connection Con = null;
		 response.setContentType("text/html");
		 
		  PrintWriter out = response.getWriter();
		try 
		{
			Con = DriverManager.getConnection( url, dbuser, dbuserpw);
			String  q      = "select * from userlogin";
			PreparedStatement   Pstobj  = Con.prepareStatement(q);
			 
				
			ResultSet RS =  Pstobj.executeQuery();
			out.println("<table width='60%' border='2'>");
			out.println("<tr> <th>user ID  </th><td>User Name </td>");
			out.println("<td>User Role </td><td> Registration Status</td></tr>");
			List<Long> UIDs = new ArrayList<>();
			while (RS.next())
			{ 
				out.println("<tr> <td> " + RS.getLong(1)  );
				UIDs.add(RS.getLong(1));
				out.println(" <td> " + RS.getString(2));
				out.println(" <td> " + RS.getString(3));
				out.println(" <td> " + RS.getString(4));
				out.println("</tr>"); 
			}
			out.println("</table>");			
			
		} 
		
		catch (SQLException e ) {
			out.println(e);  
		} 
		
		
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}
