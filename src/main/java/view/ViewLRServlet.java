package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/ViewLRServlet.com")
public class ViewLRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ViewLRServlet() {         
    } 
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		 	String id = request.getParameter("uid");
			String na = request.getParameter("uname");
			String ro = request.getParameter("role");
			String pw = request.getParameter("pwd");
		 
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		out.println(" Your Registration Details <br/>  <br/>");
		 
		out.println(" Your User ID   " + id + "<br/>");		 
		out.println(" Your name 	 " + na + "<br/>");
		out.println(" Your User Role " + ro + "<br/>");
		out.println(" Your Password  " + pw + "<br/>");
		
		out.println("<h4> <a href='StoreLRServlet.do'> Confirm the Registratin Details </a> </h4>");
		
		out.println("<h4> <a href='register.jsp'> To change the Registratin Details </a> </h4>");
		
	}

}
