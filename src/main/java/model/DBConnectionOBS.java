package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionOBS {
	
	public static Connection cc() throws SQLException
	{
		String  url = "jdbc:mysql://localhost:3306/ebookstore";
		 String dbuser   = "root";
		 String dbuserpw = "#Daddy11";	
		 Connection Con = null;
		return DriverManager.getConnection( url, dbuser, dbuserpw);
		
	}
}
