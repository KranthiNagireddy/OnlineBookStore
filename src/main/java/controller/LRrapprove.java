package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBConnectionOBS;

@WebServlet("/LRrapprove.do")
public class LRrapprove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Connection C = DBConnectionOBS.cc();
			Long uid = Long.parseLong(request.getParameter("nuid"));
			String sql = "update userLogin set  reg_status= 'accepted' where uid= ?";
			PreparedStatement PS =  C.prepareStatement(sql);
				PS.setLong(1, uid);
			PS.executeUpdate();		 
			RequestDispatcher RD = request.getRequestDispatcher("LoginApproval.jsp");
			RD.forward(request, response);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
