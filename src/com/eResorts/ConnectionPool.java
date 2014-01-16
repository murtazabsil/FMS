package com.eResorts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool  {

 public ConnectionPool() {
	super();
 }
 private static Connection con=null;
 public static Connection getConnection()
 {
	try
	{
		ResourceBundle bundle = ResourceBundle.getBundle("com.bluestar.fms.resource.app");
		Class.forName(bundle.getString("Driver"));
		con = java.sql.DriverManager.getConnection(bundle.getString("fmsdb"), 
				bundle.getString("username"), bundle.getString("password"));
		System.out.println(" after connection");
		if (con != null) {
			System.out.println("Connection Pool Database Connection Success");
		}
	}
	catch(final ClassNotFoundException cfe)
	{
		
	}catch(final SQLException se)
	{
		System.out.println(se.getMessage());
		se.printStackTrace();
	}
	return con;
	}
 
 public static void main(String[] args) {
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
		con = com.eResorts.ConnectionPool.getConnection();
		
			stmt =  con.prepareStatement(" select 1 ");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}

